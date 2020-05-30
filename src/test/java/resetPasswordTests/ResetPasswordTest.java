package resetPasswordTests;

import bases.TestBase;
import flows.LoginFlows;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class ResetPasswordTest extends TestBase {

    private LoginPage loginPage;
    private String url = "http://blazedemo.com/login";

    public ResetPasswordTest(){
        loginPage = new LoginPage();
    }

    @Test
    public void resetPassword(){
        loginPage.navigateToUrl(url);
        Assert.assertTrue(false, "Falhou");
    }
}
