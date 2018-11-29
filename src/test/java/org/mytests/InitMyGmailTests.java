package org.mytests;

import java.io.IOException;
import java.net.URI;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.settings.WebSettings;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import org.mytests.gmail.com.site.GmailSite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.commons.StringUtils.LINE_BREAK;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.jdi.uitests.web.selenium.driver.WebDriverUtils.killAllRunWebBrowsers;
import static com.epam.jdi.uitests.web.settings.WebSettings.useDriver;


public class InitMyGmailTests extends TestNGBase {

//	@BeforeSuite()
//	public static void setUp() throws Exception {
//		logger.setLogLevel(STEP);
//		WebSite.init(GmailSite.class);
//		//GmailSite.open();
//		logger.info("Run Tests");
//
//	}

//
//	@BeforeSuite()
//	public static void setUp() throws Exception {
//		WebSettings.useDriver(() -> {
//			DesiredCapabilities capabilities = new DesiredCapabilities();
//			// ChromeOptions chromeOptions = new ChromeOptions();
//			//capabilities.setBrowserName("chrome");
//			// capabilities.setPlatform(Platform.WIN10);
//			//capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//
//			RemoteWebDriver driver = null;
//			try {
//				driver = new RemoteWebDriver(
//						URI.create("http://192.168.65.1:5559/wd/hub").toURL(),
//						capabilities
//				);
//			} catch (MalformedURLException e) {
//				e.printStackTrace();
//			}
//
//			return driver;
//		});
//
//		WebSite.init(GmailSite.class);
//		//GmailSite.open();
//		logger.info("Run Tests");
//	}
public static ThreadLocal<WebDriver> driverContainer = new ThreadLocal<>();

	@BeforeSuite(description = "Создание драйвера и инициализация сайта")
	public static void setUpc() throws IOException {


		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		//capabilities.setBrowserName("chrome");
		//capabilities.setPlatform(Platform.WIN10);
		//capabilities.setVersion("62.0");
		System.out.println(System.getProperty("driver"));
		System.getProperty("driver");

		driverContainer.set(new RemoteWebDriver(
				URI.create("http://localhost:4444/wd/hub").toURL(),  //http://192.168.65.1:5558/wd/hub
				capabilities
		));

		WebSite.init(useDriver(()->driverContainer.get()),GmailSite.class);
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
