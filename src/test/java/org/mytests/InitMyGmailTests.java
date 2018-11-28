package org.mytests;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.settings.WebSettings;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import org.mytests.gmail.com.site.GmailSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.commons.StringUtils.LINE_BREAK;
import static com.epam.jdi.uitests.core.logger.LogLevels.STEP;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.jdi.uitests.web.selenium.driver.WebDriverUtils.killAllRunWebBrowsers;


public class InitMyGmailTests extends TestNGBase {


	@BeforeSuite()
	public static void setUp() throws Exception {
		logger.setLogLevel(STEP);
		WebSite.init(GmailSite.class);
		//GmailSite.open();
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
		    killAllRunWebBrowsers();
	}
}
