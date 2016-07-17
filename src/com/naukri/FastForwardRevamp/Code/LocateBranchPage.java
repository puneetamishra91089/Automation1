package com.naukri.FastForwardRevamp.Code;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naukri.GenericFunctionsPack.GenericFunctions;

public class LocateBranchPage {

	public WebDriver driver;
	GenericFunctions generic;

	public LocateBranchPage(WebDriver driver , GenericFunctions generic)
	{
		this.driver=driver;
		this.generic = generic;
	}
	//Locate Branch Breadcrumb
	public static final String BreadCrum_WE = "//div[@class='wrap breadCrmb']";
	public static final String Naukri_Lnk = "//div[@class='wrap breadCrmb']/a";
	//Locations
	public static final String Delhi_Lnk = "//a[@class='curr']";
	public static final String Delhi_WE = "//div[@class='prsnInfo oh']/p";
	public static final String Noida_Lnk = "(//ul[@class='wrap fadeInRight']/li)[2]/a";
	public static final String Noida_WE = "//p[@class='contentHd']";
	public static final String Bangalore_Lnk = "(//ul[@class='wrap fadeInRight']/li)[3]/a";
	public static final String Bangalore_WE = "//p[@class='contentHd']";
	public static final String Hyderabad_Lnk = "(//ul[@class='wrap fadeInRight']/li)[4]/a";
	public static final String Hyderabad_WE = "//p[@class='contentHd']";
	public static final String Chennai_Lnk = "(//ul[@class='wrap fadeInRight']/li)[5]/a";
	public static final String Chennai_WE = "//p[@class='contentHd']";
	public static final String MumbaiThane_Lnk = "(//ul[@class='wrap fadeInRight']/li)[6]/a";
	public static final String MumbaiThane_WE = "//p[@class='contentHd']";
	public static final String MumbaiAndheri_Lnk = "(//ul[@class='wrap fadeInRight']/li)[7]/a";
	public static final String MumbaiAndheri_WE = "//p[@class='contentHd']";
	public static final String Pune_Lnk = "(//ul[@class='wrap fadeInRight']/li)[8]/a";
	public static final String Pune_WE = "//p[@class='contentHd']";
	public static final String Kolkata_Lnk = "(//ul[@class='wrap fadeInRight']/li)[9]/a";
	public static final String Kolkata_WE = "//p[@class='contentHd']";
	public static final String AnywhereElse_Lnk = "//li[@class='last']/a";
	public static final String ContactPlace_WE = "//p[@class='contentHd']";
	public static final String ContactName_WE = "(//div[@class='grid contctPrsn']/p/span)[1]";
	public static final String ContactEmail_WE = "(//div[@class='grid contctPrsn']/p/span)[2]";
	public static final String ContactNumber_WE = "(//div[@class='grid contctPrsn']/p/span)[3]";
	//Anywhere else page
	public static final String TollFreeNo_WE = "//div[@class='font_20 fl']";

	//Lead form
	public static final String LeadformHeading_WE = "//p[@class='blkContntHd p0']";
	public static final String Leadform_Name_Txt = "//input[@id='username']";
	public static final String Leadform_Email_Txt = "//input[@id='useremailId']";
	public static final String Leadform_Mobile_Txt = "//input[@id='usermobile']";
	public static final String Leadform_PreferedTime1_DD = "//select[@id='prefTim1']";
	public static final String Leadform_PreferedTime2_DD = "//select[@id='prefTim2']";
	public static final String Leadform_Query_Txt = "//textarea[@id='userquery']";
	public static final String LeadformCallmeBack_Btn = "//input[@id='contactPgQuery']";
	public static final String Leadform_NameErrorMsg_WE = "//small[@id='username_err']";
	public static final String Leadform_MobileErrorMsg_WE = "//small[@id='usermobile_err']";
	public static final String Leadform_EmailErrorMsg_WE = "//small[@id='useremailId_err']";
	public static final String Leadform_QueryErrorMsg_WE = "//small[@id='userquery_err']";
	public static final String LeadformThankYouMsg_WE = "//div[@class='contactUsSuces']";

	
	//GotoTop icon section
	public static final String GotoTop_Btn = "//a[@id='goTop']";
	public static final String ErrorMessages_WE = "//small[contains(@id,'_err')]";

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

		return Errors;
	}

}
