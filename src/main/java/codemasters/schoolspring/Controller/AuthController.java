package codemasters.schoolspring.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import codemasters.schoolspring.Models.ERole;
import codemasters.schoolspring.Models.Role;
import codemasters.schoolspring.Models.User;
import codemasters.schoolspring.Payload.Request.LoginRequest;
import codemasters.schoolspring.Payload.Request.SignupRequest;
import codemasters.schoolspring.Payload.Response.LoginResponse;
import codemasters.schoolspring.Payload.Response.MessageResponse;
import codemasters.schoolspring.Repo.RoleRepository;
import codemasters.schoolspring.Repo.UserRepository;
import codemasters.schoolspring.Security.JWT.JwtUtils;
import codemasters.schoolspring.Service.UserDetailsImpl;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/login")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
      org.springframework.security.core.Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));

      SecurityContextHolder.getContext().setAuthentication(authentication);

      UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

      ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

      List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());

      return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION,"Bearer " + jwtCookie.toString()).body(new LoginResponse(userDetails.getId(), userDetails.getFirstName(),userDetails.getlastName() ,userDetails.getEmail(), roles, jwtCookie));
  }
  
  @PostMapping("/signout")
    public ResponseEntity<?> logoutUser(HttpServletResponse response) {
        // Revoke the JWT token by setting it to null or empty in the headers
        jwtUtils.revokeJwtToken(response);
        // You may also want to add additional logic, e.g., clear any user sessions or perform cleanup
        return ResponseEntity.ok().body(new MessageResponse("You've been signed out"));
    }
}
