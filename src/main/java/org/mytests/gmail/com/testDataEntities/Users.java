package org.mytests.gmail.com.testDataEntities;

public class Users {

	public static User DEFAULT_USER = new User().set(user ->
	                                                 {
		                                                 user.userName = "testantonastound@gmail.com";
		                                                 user.userPassword = "12Test*34";
	                                                 });

	public static User FAILED_EMAIL_USER = new User().set(user ->
	                                                 {
		                                                 user.userName = "testantonastoun£d@gmail.com";
		                                                 user.userPassword = "12Test*34";
	                                                 });

	public static User FAILED_PASS_USER = new User().set(user ->
	                                                 {
		                                                 user.userName = "testantonastound@gmail.com";
		                                                 user.userPassword = "dszdzs£";
	                                                 });
}
