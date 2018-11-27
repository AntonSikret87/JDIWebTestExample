package org.mytests.gmail.com.testDataEntities;


import org.testng.annotations.DataProvider;

import static org.mytests.gmail.com.testDataEntities.Users.FAILED_EMAIL_USER;
import static org.mytests.gmail.com.testDataEntities.Users.FAILED_PASS_USER;

public class NegativeData {

	@DataProvider(name = "negativeEmailData")
	private Object[][] negativeEmailData() {
		//User user = new User();
		return new Object[][]{
				{FAILED_EMAIL_USER.userName},
				//{FAILED_EMAIL_USER.userName = "232323£"},
		};
	}


	@DataProvider(name = "negativePasswordData")
	private Object[][] negativePasswordData() {
		//	User user = new User();
		return new Object[][]{
				{FAILED_PASS_USER.userName, FAILED_PASS_USER.userPassword},
				//{FAILED_PASS_USER.userPassword = "232323£"},
		};
	}
}
