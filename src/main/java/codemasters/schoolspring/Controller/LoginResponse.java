package codemasters.schoolspring.Controller;

public class LoginResponse  {
    private boolean successful;
    private String message; 
    private Integer userId;
    private String name;


    public LoginResponse(boolean successful, String message, Integer userId, String name) {
        this.successful = successful;
        this.message = message;
        this.userId = userId;
        this.name = name;
    }

    public boolean isSuccessful() {
        return this.successful;
    }

    public boolean getSuccessful() {
        return this.successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}