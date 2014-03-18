import java.io.IOException;

public class LoginService {
    public void login(String userName, String password) throws IOException {
        if (userName == "admin" && password == "admin") {
            Session.Add("LoggedUser", "admin");
        }
        if (userName == "user" && password == "user")
        {
            Session.Add("LoggedUser", "user");
        }
    }
}
