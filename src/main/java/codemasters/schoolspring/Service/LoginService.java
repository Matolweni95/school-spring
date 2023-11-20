package codemasters.schoolspring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import codemasters.schoolspring.Controller.LoginRequest;
import codemasters.schoolspring.Controller.LoginResponse;
import codemasters.schoolspring.Entity.User;
import codemasters.schoolspring.Repo.UserRepository;

@Service

public class LoginService {

    @Autowired
    private UserRepository repo;

    public LoginResponse authenticateUser(LoginRequest loginRequest) {
        User user = repo.findByEmail(loginRequest.getEmail());
        
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            LoginResponse response = new LoginResponse(true, null, null, null, null);
            response.setUserId(user.getUser_id());
            response.setName(user.getName());
             response.setType(user.getType());
            return response;
        } else {
            return new LoginResponse(false, null, null, null, null);
        }
    }
}
