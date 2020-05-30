package bases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverConfig {

    public static WebDriver DRIVER;
    public static WebDriverWait WAIT;
    public static Wait<WebDriver> FLUENT_WAIT;

    public static void createDriver() {
        //System.setProperty("webdriver.chrome.driver", "/drivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        DRIVER = new ChromeDriver();
    }

    public static void createWait() {
        WAIT = new WebDriverWait(DRIVER, 30);
        FLUENT_WAIT = new FluentWait<WebDriver>(DRIVER)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
    }

    public static void quitDriver(){
        DRIVER.quit();
        DRIVER = null;
    }

}
