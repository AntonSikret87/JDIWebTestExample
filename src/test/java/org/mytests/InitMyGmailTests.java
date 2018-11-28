package org.mytests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.epam.jdi.uitests.web.selenium.driver.WebDriverUtils;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.settings.WebSettings;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import org.mytests.gmail.com.site.GmailSite;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.commons.StringUtils.LINE_BREAK;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;



public class InitMyGmailTests extends TestNGBase {
	WebDriver driver;

//	@BeforeSuite()
//	public static void setUp() throws Exception {
//		logger.setLogLevel(STEP);
//		WebSite.init(GmailSite.class);
//		//GmailSite.open();
//		logger.info("Run Tests");
//	}



	@BeforeSuite
	public void setUp() throws MalformedURLException {
		String nodeURL = "http://AKARABEINIKOV-NB.astound.local:4445";
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setBrowserName("chrome");
		capability.setPlatform(Platform.WIN10);
		driver = new RemoteWebDriver(new URL(nodeURL), capability);
		WebSite.init(GmailSite.class);
		logger.info("Run Tests");
	}



	@AfterSuite()
	public static void jdiTearDown() throws IOException {
		LocalDateTime date = Instant.ofEpochMilli(21 * 3600000 + getTestRunTime())
		                            .atZone(ZoneId.systemDefault())
		                            .toLocalDateTime();
		String formattedTime = DateTimeFormatter.ofPattern("HH:mm:ss.S").format(date);

		logger.info("Test run finished. " + LINE_BREAK + "Total test run time: " + formattedTime);

		if (WebSettings.killBrowser.toLowerCase().contains("after"))
			WebSettings.getDriver().close();
		    WebDriverUtils.killAllRunWebBrowsers();
	}
}
