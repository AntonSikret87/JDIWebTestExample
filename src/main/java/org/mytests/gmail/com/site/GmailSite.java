package org.mytests.gmail.com.site;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import org.mytests.gmail.com.pages.GmailLoggedInPage;
import org.mytests.gmail.com.pages.GmailLoginHomePage;

@JSite("https://accounts.google.com")
public class GmailSite extends WebSite {

    @JPage("https://accounts.google.com")
    public static GmailLoginHomePage gmailLoginHomePage;

     @JPage(url = "/?pli=1")
     public static GmailLoggedInPage gmailLoggedInPage;

}
