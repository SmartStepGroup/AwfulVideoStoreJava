public class LoginService {
    public void login(String userName, String password) {
        if (userName == "admin" && password == "admin") {
            Session.Add("LoggedUser", "admin");
        }
        if (userName == "user" && password == "user")
        {
            Session.Add("LoggedUser", "user");
        }
    }
}
