package pages;

import bases.Methods;
import org.openqa.selenium.By;

public class LoginPage extends Methods {

    private By email = By.id("email");
    private By password = By.id("password");
    private By btnLogin = By.xpath("//button[@type='submit']");
    //By btnLogin = By.cssSelector("button[type='submit']");
    private By linkResetPassword = By.linkText("https://blazedemo.com/password/reset");
    private By messageLogedSuccess = By.xpath("//div[contains(text(),'You are logged in!')]");

    public void navigateToUrl(String url){
        navigate(url);
    }

    public void setEmail(String value){
        sendKey(email, value);
    }

    public void setPassword(String value){
        sendKey(password, value);
    }

    public void clickLogin(){
        click(btnLogin);
    }

    public void clickResetPassword(){
        click(linkResetPassword);
    }

    public boolean messagemLoggedSuccess() {
        return isDisplayed(messageLogedSuccess);
    }
}
