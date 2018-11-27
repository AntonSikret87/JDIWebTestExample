package org.mytests.tests;

import com.epam.jdi.uitests.web.settings.WebSettings;
import com.epam.web.matcher.testng.Assert;
import com.epam.web.matcher.verify.Verify;
import org.mytests.InitMyGmailTests;
import org.mytests.gmail.com.testDataEntities.NegativeData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.mytests.gmail.com.site.GmailSite.gmailLoginHomePage;


public class NegativeLoginTests extends InitMyGmailTests {

	@AfterMethod
	public void tearDown() {
		Verify.getFails();
		WebSettings.getDriver().quit();
	}

	@Test(dataProvider = "negativeEmailData", dataProviderClass = NegativeData.class)
	public void negativeLoginWithEmail(String userName) {
		gmailLoginHomePage.open();
		gmailLoginHomePage.emailField.sendKeys(userName);
		gmailLoginHomePage.emailNextBtn.click();
		Assert.isNotEmpty(gmailLoginHomePage.lblWrongEnteredValueError.getText());
		Assert.areEquals(gmailLoginHomePage.lblWrongEnteredValueError.getText(), "Введіть дійсні електронну адресу або номер телефону");
	}

	@Test(dataProvider = "negativePasswordData", dataProviderClass = NegativeData.class)
	public void negativeLoginWithPassword(String userName, String userPassword) {
		gmailLoginHomePage.open();
		gmailLoginHomePage.emailField.sendKeys(userName);
		gmailLoginHomePage.emailNextBtn.click();
		gmailLoginHomePage.passwordField.sendKeys(userPassword);
		gmailLoginHomePage.passwordNextBtn.click();
		Assert.isNotEmpty(gmailLoginHomePage.lblWrongEnteredValueError.getText());
		Assert.areEquals(gmailLoginHomePage.lblWrongEnteredValueError.getText(), "Неправильний пароль. Повторіть " +
		                                                                         "спробу або натисніть \"Не пам’ятаю пароль\", щоб скинути його.");
	}
}
