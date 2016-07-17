package com.naukri.FastForwardRevamp.Code;

import org.openqa.selenium.WebDriver;

import com.naukri.GenericFunctionsPack.GenericFunctions;

public class NaukriLogin {
	WebDriver driver;
	GenericFunctions generic;
	
	public NaukriLogin(WebDriver driver, GenericFunctions generic)
	{
		this.driver = driver;
		this.generic = generic;
	}
	//Login
	public static final String Email_Txt = "(//input[@id='emailTxt'])[2]";
	public static final String passwor_Txt = "//input[@id='pwd1']";
	public static final String Login_Btn = "(//input[@id='sbtLog'])[2]";
	
	
			
}
