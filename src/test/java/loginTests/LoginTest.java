package loginTests;

import bases.TestBase;
import flows.LoginFlows;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;



public class LoginTest extends TestBase {

    private LoginPage loginPage;
    private LoginFlows loginFlows;

    public LoginTest(){
        loginPage = new LoginPage();
        loginFlows = new LoginFlows();
    }

    @Test
    public void loginStepByStep(){
        loginPage.navigateToUrl(PROP.getProperty("url"));
        loginPage.setEmail(PROP.getProperty("email"));
        loginPage.setPassword(PROP.getProperty("password"));
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.messagemLoggedSuccess());
    }

    @Test
    public void login(){
        loginFlows.login(PROP.getProperty("url"), PROP.getProperty("email"), PROP.getProperty("password"));
    }

}
