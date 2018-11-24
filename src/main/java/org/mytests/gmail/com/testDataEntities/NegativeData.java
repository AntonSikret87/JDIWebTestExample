package org.mytests.gmail.com.testDataEntities;

import org.testng.annotations.DataProvider;

public class NegativeData {

	@DataProvider(name = "negativeEmailData")
	private Object[][] negativeEmailData() {
		User user = new User();
		return new Object[][]{
				{user.userName = "sdssd£"},
				{user.userName = "232323£"},
//				{user.userName = "sdssd£dd%"},
//				{user.userName = "sdewedw32ssd£%"},
				};
	}


	@DataProvider(name = "negativePasswordData")
	private Object[][] negativePasswordData() {
		User user = new User();
		//create guerillamail generator
		return new Object[][]{
				{user.userPassword = "sdssd£"},
				{user.userPassword = "232323£"},
//				{user.userPassword = "sdssd£dd%"},
//				{user.userPassword = "sdewedw32ssd£%"},
				};
	}
}
