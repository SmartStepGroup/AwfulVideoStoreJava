package com.smartstepgroup.awfulvideostore;

import java.io.IOException;

public class LoginService {
    public void login(String userName, String password) throws IOException {
        if (userName == "admin" && password == "admin") {
            Session.add("LoggedUser", "admin");
        }
        if (userName == "user" && password == "user")
        {
            Session.add("LoggedUser", "user");
        }
    }

}
