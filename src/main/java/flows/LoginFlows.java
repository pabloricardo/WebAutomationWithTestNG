package flows;

import org.testng.Assert;
import pages.LoginPage;

public class LoginFlows extends LoginPage {

    public void login(String url, String email, String password){
        navigateToUrl(url);
        setEmail(email);
        setPassword(password);
        clickLogin();
        Assert.assertTrue(messagemLoggedSuccess());
    }
}
