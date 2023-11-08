package codemasters.schoolspring.Controller;

public class LoginRequest {
    private String email;
    private String password;
    private Integer user_id;


    public LoginRequest(String email, String password, Integer user_id) {
        this.email = email;
        this.password = password;
        this.user_id = user_id;
    }


    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUser_id() {
        return this.user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    
}
