package org.mytests.gmail.com.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailLoggedInPage extends WebPage {

	@FindBy(css = ".gb_b.gb_fb") public WebElement headerIcon;

	public String getHeaderUserInfo(){
		return headerIcon.getAttribute("aria-label");
	}
}
