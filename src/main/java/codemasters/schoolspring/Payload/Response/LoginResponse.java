package codemasters.schoolspring.Payload.Response;

import java.util.List;

import org.springframework.http.ResponseCookie;

public class LoginResponse  {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<String> roles;
    private ResponseCookie jwtCookie;

public LoginResponse(Long id, String firstName, String lastName, String email, List<String> roles, ResponseCookie jwtCookie) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.roles = roles;
    this.jwtCookie = jwtCookie;
    }

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getFirstName() {
    return firstName;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}

public void setRoles(List<String> roles) {
    this.roles = roles;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public ResponseCookie getJwtCookie() {
    return jwtCookie;
}

public void setJwtCookie(ResponseCookie jwtCookie) {
    this.jwtCookie = jwtCookie;
}

public List<String> getRoles() {
    return roles;
}

}