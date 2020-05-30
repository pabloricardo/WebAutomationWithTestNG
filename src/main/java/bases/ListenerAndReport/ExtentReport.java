package bases.ListenerAndReport;

import bases.DriverConfig;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReport {
//	dateLocal.format(dateTime);
	private static LocalDateTime dateLocal = LocalDateTime.now();
	private static DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private static DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm");
	private static String userDirectory = System.getProperty("user.dir");

	private static String reportName = "TestReport";
	private static String folderReports = "reports";
	private static String folderDateFormat = dateLocal.format(date);
	private static String folderReportDateTime = reportName + " " + dateLocal.format(dateTime);
	private static Path fullReportFilePath = Paths.get(folderReports, folderDateFormat, folderReportDateTime,
			reportName);

	private static ExtentReports extent = null;
	private static ExtentHtmlReporter htmlReporter = null;
	private static ExtentTest test = null;

	public static void createReport() {

		// Create folderReport in user directory case not exist
		File createFolderReport = new File(userDirectory, folderReports);
		if (!createFolderReport.exists()) {
			createFolderReport.mkdir();
		}
		// Create folderDate in folderReport case not exist
		File createFolderDate = new File(createFolderReport, folderDateFormat);
		if (!createFolderDate.exists()) {
			createFolderDate.mkdir();
		}
		// Create folderReportDateTime in folderDate case not exist
		File createFolderReportDateTime = new File(createFolderDate, folderReportDateTime);
		if (!createFolderReportDateTime.exists()) {
			createFolderReportDateTime.mkdir();
		}

		// Initialize the HtmlReporter
		htmlReporter = new ExtentHtmlReporter(fullReportFilePath + ".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	public static void setTestNameInReport(String name) {
		test = extent.createTest(name);
	}

	public static void pageBaseAddInfo(String text) {
		String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
		test.log(Status.INFO, methodName + " || " + text);
	}

	public static void addTestResult(String step) {
		test.info(step + " || " + test.getStatus().toString());
	}

	public static void closedTestSucess() {
		test.log(Status.PASS, test.getStatus().toString());
		extent.flush();
	}

	public static void closedTestFail(String description) throws IOException {
		test.log(Status.FAIL, description);
		// log with snapshot
		String base64String = ((TakesScreenshot) DriverConfig.DRIVER).getScreenshotAs(OutputType.BASE64);
		test.fail("ScreenCapture", MediaEntityBuilder.createScreenCaptureFromBase64String(base64String).build());		
		extent.flush();
	}

	public static void closeReport() {
		test.log(Status.FAIL, test.getStatus().toString());
		extent.flush();
	}

}
