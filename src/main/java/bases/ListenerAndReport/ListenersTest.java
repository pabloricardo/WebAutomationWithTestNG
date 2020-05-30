package bases.ListenerAndReport;

import bases.ListenerAndReport.ExtentReport;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ListenersTest implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.setTestNameInReport(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReport.closedTestSucess();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            ExtentReport.closedTestFail(result.getThrowable().getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        ExtentReport.createReport();
    }

    @Override
    public void onFinish(ITestContext context) {
    }
}
