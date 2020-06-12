package bases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

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

    public static Properties setProperties() {
        Properties prop = new Properties();

        try{
            InputStream input = new FileInputStream("src/main/java/config/STANDARD.config.properties");
            prop.load(input);
        }catch (IOException e){
            throw new TestException(e.getMessage(), e.getCause());
        }

        return prop;
    }

}
