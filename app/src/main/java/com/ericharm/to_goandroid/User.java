package com.ericharm.to_goandroid;

import java.util.Date;

public class User {
    Date created_at;
    Date updated_at;
    String email;
    String auth_token;

    public String getAuthToken() {
        return this.auth_token;
    }

    public String getEmail() {
        return this.email;
    }
}
