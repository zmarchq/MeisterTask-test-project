package models;

import lombok.Data;

@Data
public class AuthBody {

    public AuthBody(String email, String password) {
        this.email = email;
        this.password = password;
    }
    private String email;
    private String password;
}
