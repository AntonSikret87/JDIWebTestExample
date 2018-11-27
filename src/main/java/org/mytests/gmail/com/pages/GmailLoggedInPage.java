package org.mytests.gmail.com.pages;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.ByName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailLoggedInPage extends WebPage {

	@FindBy(css = ".gb_b.gb_fb") public WebElement headerIcon;

	@FindBy(css = ".J-J5-Ji.T-I-KE") public WebElement createNewEmail;

	@ByName("to") public ITextField emailField;

	@ByName("subjectbox") public ITextField subjectField;

	@FindBy(css = ".editable.LW-avf") public ITextField messageBodyField;

	@FindBy(css = ".J-J5-Ji.aoO") public IButton btnSend;



	public String getHeaderUserInfo(){
		return headerIcon.getAttribute("aria-label");
	}

	public void createAnEmail(String emailAddress, String subject,String messageText){
		createNewEmail.click();
		emailField.sendKeys(emailAddress);
		subjectField.sendKeys(subject);
		messageBodyField.focus();
		messageBodyField.sendKeys(messageText);
		btnSend.click();

	}
}
