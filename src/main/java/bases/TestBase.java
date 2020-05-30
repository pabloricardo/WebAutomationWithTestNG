package bases;

import bases.ListenerAndReport.ExtentReport;
import bases.ListenerAndReport.ListenersTest;
import org.testng.annotations.*;

@Listeners(ListenersTest.class)
public class TestBase {


    @BeforeMethod
    public void setUp() {
        DriverConfig.createDriver();
        DriverConfig.DRIVER.manage().window().maximize();
        DriverConfig.createWait();
    }

    @AfterMethod
    public void tearDown(){
        DriverConfig.quitDriver();
    }

}
