package org.mytests.tests;

import com.epam.web.matcher.testng.Assert;
import org.mytests.InitMyGmailTests;
import org.mytests.gmail.com.testDataEntities.User;
import org.testng.annotations.Test;

import static org.mytests.gmail.com.site.GmailSite.gmailLoggedInPage;
import static org.mytests.gmail.com.site.GmailSite.gmailLoginHomePage;


public class PositiveLoginTests extends InitMyGmailTests {
	User user = new User();

	@Test
	public void positiveLogin() {
		gmailLoginHomePage.open();
		gmailLoginHomePage.login(user);
		Assert.contains(() -> gmailLoggedInPage.getHeaderUserInfo(), user.userName);

	}
}
