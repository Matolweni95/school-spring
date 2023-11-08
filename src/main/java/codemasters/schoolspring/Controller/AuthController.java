package codemasters.schoolspring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import codemasters.schoolspring.Service.LoginService;

@CrossOrigin
@RestController

public class AuthController {
    @Autowired
    private LoginService AuthService;

    @PostMapping("/api/")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse response = AuthService.authenticateUser(loginRequest);

        if(response.isSuccessful()) {
            response.setMessage("login sucess");
            return ResponseEntity.ok(response);
        }else {
            response.setMessage("login fail");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }




    
}
