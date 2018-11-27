package org.mytests.gmail.com.pages;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.ById;
import org.mytests.gmail.com.testDataEntities.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Roman_Iovlev on 10/22/2015.
 */
public class GmailLoginHomePage extends WebPage {

	@FindBy(css = "input[type='email']") public ITextField emailField;

	@FindBy(css = "input[type='password']") public ITextField passwordField;

	@ById("identifierNext") public IButton emailNextBtn;

	@ById("passwordNext") public IButton passwordNextBtn;

	@FindBy(css = ".IYewr .dEOOab") public WebElement lblWrongEnteredValueError;


	public void enterEmail(String email){
		emailField.sendKeys(email);
	}

	public void enterPass(String pass){
		passwordField.sendKeys(pass);
	}

	public void login(User user){
	    enterEmail(user.userName);
		emailNextBtn.click();
		enterPass(user.userPassword);
		passwordNextBtn.click();
	}
}
