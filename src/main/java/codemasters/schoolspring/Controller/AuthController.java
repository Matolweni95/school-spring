package codemasters.schoolspring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import codemasters.schoolspring.Service.LoginService;

@CrossOrigin
@RestController

public class AuthController {
    @Autowired
    private LoginService AuthService;

    
}
