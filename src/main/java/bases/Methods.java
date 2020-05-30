package bases;

import bases.ListenerAndReport.ExtentReport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Methods {

    protected void navigate(String url){
        DriverConfig.DRIVER.navigate().to(url);
        ExtentReport.pageBaseAddInfo("PARAMETER: "+url);
    }

    protected void sendKey(By locator, String value){
        DriverConfig.WAIT.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element = DriverConfig.DRIVER.findElement(locator);
        element.clear();
        element.sendKeys(value);
        ExtentReport.pageBaseAddInfo("PARAMETER: "+ value);
    }

    protected void click(By locator){
        DriverConfig.FLUENT_WAIT.until(ExpectedConditions.elementToBeClickable(locator));
        DriverConfig.DRIVER.findElement(locator).click();
        ExtentReport.pageBaseAddInfo("Click: "+ locator.toString());
    }

    protected boolean isDisplayed(By locator) {
        return DriverConfig.FLUENT_WAIT.until(d -> DriverConfig.DRIVER.findElement(locator).isDisplayed());
    }

}
