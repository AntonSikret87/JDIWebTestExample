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
		//gmailLoginHomePage.clearCache();

	}

//public static ThreadLocal<WebDriver> driverContainer = new ThreadLocal<>();
////static RemoteWebDriver driver = null;
//	@BeforeSuite()
//	public static void setUp() throws Exception {
//		//System.setProperty("webdriver.chrome.driver","D:\\AutoMy\\Drivers\\chromedriver.exe");
//		//useDriver(() -> {
//
//
//			DesiredCapabilities capabilities = new DesiredCapabilities();
//			ChromeOptions chromeOptions = new ChromeOptions();
//			//chromeOptions.addArguments("--headless");
//			//capabilities.setBrowserName("chrome");
//			//chromeOptions.addArguments("chrome.switches","--disable-extensions");
//			capabilities.setPlatform(Platform.WIN10);
//			//capabilities.setVersion("69.0.3497.0");
//			//capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
////		chromeOptions.setBinary("D:\\AutoMy\\Drivers\\chromedriver.exe");
////		chromeOptions.addArguments("--disable-gpu");
////		chromeOptions.addArguments("--no-sandbox");
////		chromeOptions.addArguments("--ignore-certificate-errors");
////		chromeOptions.addArguments("headless");
////		chromeOptions.addArguments("--disable-extensions");
////		chromeOptions.addArguments("window-size=1200x600");
//		chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("load-extension"));
//		//System.setProperty("webdriver.chrome.driver","D:\\AutoMy\\JenkinsAndSelenServ\\chromedriver.exe");
//			capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//
//
//		//	try {
//
//				driverContainer.set(new RemoteWebDriver(
//						URI.create("http://192.168.65.1:4444/wd/hub").toURL(),//http://192.168.65.1:4444/wd/hub
//						capabilities));
////				));
////			} catch (MalformedURLException e) {
////				e.printStackTrace();
////			}
////
////			return driverContainer.get();
////		});
//		//driverContainer.get().get("https://mail.google.com");
//		logger.info("віві " + System.getProperty("webdriver.chrome.driver","D:\\AutoMy\\JenkinsAndSelenServ\\chromedriver.exe"));
//		WebSite.init(GmailSite.class);
//		//GmailSite.open();
//		//GmailSite.open();
//		logger.info("Run Tests");
//	}



//public static ThreadLocal<WebDriver> driverContainer = new ThreadLocal<>();
//
//	@BeforeSuite(description = "Создание драйвера и инициализация сайта")
//	public static void setUpc() throws IOException {
//
//
//		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//		//capabilities.setBrowserName("chrome");
//		capabilities.setPlatform(Platform.WIN10);
//		//capabilities.setVersion("62.0");
//		System.out.println(System.getProperty("driver"));
//		System.getProperty("driver");
//
//		driverContainer.set(new RemoteWebDriver(
//				URI.create("http://192.168.65.1:4444/wd/hub").toURL(),  //http://192.168.65.1:5558/wd/hub
//				capabilities
//		));
//
//		WebSite.init(useDriver(()->driverContainer.get()),GmailSite.class);
//	}



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
