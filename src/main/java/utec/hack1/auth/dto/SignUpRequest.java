package utec.hack1.auth.dto;

public class SignUpRequest {
    private String username;
    private String branch;
    private String email;
    private String password;

    public SignUpRequest() {
    }

    public SignUpRequest(String username, String branch, String email, String password) {
        this.username = username;
        this.branch = branch;
        this.email = email;
        this.password = password;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
