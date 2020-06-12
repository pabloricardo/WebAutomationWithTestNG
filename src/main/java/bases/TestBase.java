package bases;

import bases.ListenerAndReport.ListenersTest;
import org.testng.annotations.*;

import java.util.Properties;

@Listeners(ListenersTest.class)
public class TestBase {

    public static Properties PROP;

    @BeforeMethod
    public void setUp() {
        DriverConfig.createDriver();
        DriverConfig.DRIVER.manage().window().maximize();
        DriverConfig.createWait();
        PROP = DriverConfig.setProperties();
    }

    @AfterMethod
    public void tearDown(){
        DriverConfig.quitDriver();
    }

}
