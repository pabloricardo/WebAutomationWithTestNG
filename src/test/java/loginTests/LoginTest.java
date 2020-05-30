package loginTests;

import bases.TestBase;
import flows.LoginFlows;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;



public class LoginTest extends TestBase {

    private LoginPage loginPage;
    private LoginFlows loginFlows;
    private String url = "http://blazedemo.com/login";
    private String email = "teste@teste";
    private String password = "123456";

    public LoginTest(){
        loginPage = new LoginPage();
        loginFlows = new LoginFlows();
    }

    @Test
    public void loginStepByStep(){
        loginPage.navigateToUrl(url);
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.messagemLoggedSuccess());
    }

    @Test
    public void login(){
        loginFlows.login(url, email, password);
    }

}
