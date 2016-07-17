package com.naukri.FastForwardRevamp.Code;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naukri.GenericFunctionsPack.GenericFunctions;

public class ContactUsLeadFormWidget {
	WebDriver driver;
	GenericFunctions generic;

	public ContactUsLeadFormWidget(WebDriver driver, GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}

	//Contact Us widget
	public static final String TollFreeNo_WE = "//li[@class='nopointr']";
	public static final String CallMeBack_Lnk = "//div[@class='widgtLi_2']/a";
	public static final String Name_Txt = "//input[@id='name']";
	public static final String Email_Txt = "//input[@id='emailId']";
	public static final String Mobile_Txt = "//input[@id='mobile']";
	public static final String Query_Txt = "//textarea[@id='query']";
	public static final String CallmeBack_Btn = "//input[@id='submitQuery']";
	public static final String ErrorMessages_WE = "//form[@id='contactUsWidget']//small[contains(@id,'_err')]";
	public static final String ThankyouMessages_WE = "(//div[@id='thankMsg'])[1]";

	public String CaptureErrors(){
		List<WebElement> WE = driver.findElements(By.xpath(ErrorMessages_WE));
		List<String> ErrorMessages = new ArrayList<String>();
		for (WebElement webElement : WE) {
			if(webElement.isDisplayed()){
				ErrorMessages.add(webElement.getText());
			}
		}

		String Errors = ErrorMessages.toString();
		Errors = Errors.replace("[", "");
		Errors = Errors.replace("]", "");

		System.out.println(Errors);
		return Errors;
	}

	public void Fillform_LeadForm(String Name,String Email,String Mobile,String Query){
		generic.Fill_Txt(Name_Txt, Name);
		generic.Fill_Txt(Email_Txt, Email);
		generic.Fill_Txt(Mobile_Txt, Mobile);
		generic.Fill_Txt(Query_Txt, Query);
		generic.Click_Btn(CallmeBack_Btn);
	}

}
