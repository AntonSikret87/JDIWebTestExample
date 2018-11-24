package org.mytests.tests;

import com.epam.web.matcher.testng.Assert;
import org.mytests.InitMyGmailTests;
import org.mytests.gmail.com.testDataEntities.NegativeData;
import org.mytests.gmail.com.testDataEntities.User;
import org.testng.annotations.Test;

import static org.mytests.gmail.com.site.GmailSite.gmailLoginHomePage;


public class NegativeLoginTests extends InitMyGmailTests {
	User user = new User();

	@Test(dataProvider = "negativeEmailData", dataProviderClass = NegativeData.class)
	public void negativeLoginWithEmail(String userName) {
		gmailLoginHomePage.open();
		gmailLoginHomePage.emailField.sendKeys(userName);
		gmailLoginHomePage.emailNextBtn.click();
		Assert.isNotEmpty(gmailLoginHomePage.lblWrongEnteredValueError.getText());
		Assert.areEquals(gmailLoginHomePage.lblWrongEnteredValueError.getText(), "Введіть дійсні електронну адресу або номер телефону");
	}

	@Test(dataProvider = "negativePasswordData", dataProviderClass = NegativeData.class)
	public void negativeLoginWithPassword(String userPassword) {
		gmailLoginHomePage.open();
		gmailLoginHomePage.emailField.sendKeys(user.userName);
		gmailLoginHomePage.emailNextBtn.click();
		gmailLoginHomePage.passwordField.sendKeys(userPassword);
		gmailLoginHomePage.passwordNextBtn.click();
		Assert.isNotEmpty(gmailLoginHomePage.lblWrongEnteredValueError.getText());
		Assert.areEquals(gmailLoginHomePage.lblWrongEnteredValueError.getText(), "Неправильний пароль. Повторіть " +
		                                                                         "спробу або натисніть \"Не пам’ятаю пароль\", щоб скинути його.");
	}
}
