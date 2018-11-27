//package org.mytests.tests;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import org.apache.commons.lang3.RandomStringUtils;
//import org.mytests.InitMyGmailTests;
//import org.mytests.gmail.com.site.email.EMail;
//import org.mytests.gmail.com.site.email.GuerrillaMail;
//import org.mytests.gmail.com.testDataEntities.User;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import static org.mytests.gmail.com.site.GmailSite.gmailLoggedInPage;
//import static org.mytests.gmail.com.site.GmailSite.gmailLoginHomePage;
//
//public class EmailSendTests extends InitMyGmailTests {
//
//	User user = new User();
//	private GuerrillaMail mailer;
//	private ArrayList<EMail> emails;
//
//	String subject = "My subject " + RandomStringUtils.randomAlphabetic(7);
//	String textBody = "My text in body " + RandomStringUtils.randomAlphabetic(12);
//
//
//	@Test
//	public void successEmailSend() throws Exception {
//		mailer = new GuerrillaMail();
//
//		System.out.println(mailer.getEmailAddress());
//		emails = mailer.getEmailList();
//		System.out.println("Before sent " + emails.size());
//
//		gmailLoginHomePage.open();
//		gmailLoginHomePage.login(user);
//		gmailLoggedInPage.createAnEmail(mailer.getEmailAddress(),subject,textBody);
//
//
//		List<EMail> eMails =mailer.checkEmail();
////
////
////		System.out.println("After sent " + eMails.size());
//
//		try {
//			Thread.sleep(60000);
//		} catch (InterruptedException e) {
//			throw new RuntimeException(e);
//		}
//		System.out.println("email.getSubject()11111 " + eMails.get(0).getSubject() +", " + eMails.get(0).getDate() + " " + eMails.get(0).getContentType());
//	//	System.out.println("email.getSubject()222222 " + emails.get(1).getSubject() +", " + emails.get(1).getDate());
//		if(eMails.size()>=1){
//			printEMails(eMails);
//		}
//
//	//	EMail email = emails.stream().filter(it->it.getSubject().contains(subject)).findFirst().orElse(null);
//
//		verifyEmailReceived(emails,subject);
//		//list.stream().forEach(it->it.getSubject().contains(subject));
//
//	}
//
//
//
//	static void verifyEmailReceived(ArrayList<EMail> list, String expectedSubject) {
//		try {
//			Thread.sleep(60000);
//		} catch (InterruptedException e) {
//			throw new RuntimeException(e);
//		}
//
//		printEMails(list);
//
//
//		System.out.println(list);
//		System.out.println(list.size());
//		Assert.assertTrue(list.contains(expectedSubject));
//	}
//
//	static void printEMails(List<EMail> emails){
//		Iterator<EMail> iterator = emails.iterator();
//		EMail email;
//		while(iterator.hasNext()){
//			email = iterator.next();
//			System.out.println("dsdsdsd " + email);
//		}
//	}
//}
