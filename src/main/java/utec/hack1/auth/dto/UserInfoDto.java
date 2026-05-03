package utec.hack1.auth.dto;

public class UserInfoDto {
    private String username;

    public UserInfoDto(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
