package org.mytests.tests;

import com.epam.jdi.uitests.web.settings.WebSettings;
import com.epam.web.matcher.testng.Assert;
import org.mytests.InitMyGmailTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.mytests.gmail.com.site.GmailSite.gmailLoggedInPage;
import static org.mytests.gmail.com.site.GmailSite.gmailLoginHomePage;
import static org.mytests.gmail.com.testDataEntities.Users.DEFAULT_USER;


public class PositiveLoginTests extends InitMyGmailTests {

	@AfterMethod
	public void tearDown() {
		WebSettings.getDriver().quit();
	}

	@Test
	public void positiveLogin() {
		gmailLoginHomePage.open();
		gmailLoginHomePage.login(DEFAULT_USER);
		Assert.contains(() -> gmailLoggedInPage.getHeaderUserInfo(), DEFAULT_USER.userName);
	}
}
