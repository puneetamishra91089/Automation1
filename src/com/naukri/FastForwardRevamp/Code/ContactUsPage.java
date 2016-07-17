package com.naukri.FastForwardRevamp.Code;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naukri.GenericFunctionsPack.GenericFunctions;
public class ContactUsPage {
	public WebDriver driver;
	GenericFunctions generic;
	public ContactUsPage(WebDriver driver,GenericFunctions generic)
	{
		this.driver=driver;
		this.generic = generic;
	}
	//Contact Us Breadcrumb
	public static final String BreadCrum_WE = "//div[@class='wrap breadCrmb']";
	public static final String Naukri_Lnk = "//div[@class='wrap breadCrmb']/a";

	//Contact Us page
	public static final String TalktoUs_WE = "//h1[@class='catHead bold']";
	public static final String TalktoUsContent_WE ="(//div[@class='jobSubCategory ']/div)[1]";
	public static final String WalkIn_WE = "(//h3[@class='catHead bold'])[2]";
	public static final String WalkInContent_WE = "(//div[@class='jobSubCategory last']/div)";
	public static final String ChatWithUs_WE = "(//h3[@class='catHead bold'])[1]";
	public static final String ChatWithContent_WE = "(//div[@class='jobSubCategory ']/div)[2]";
	public static final String ChattingWindow_WE = "//input[@id='___$_47__submit']";
	public static final String LocateBranch_Lnk = "(//a[@class='transprnt_btn mT10'])[2]";
	public static final String ChatNow_Lnk = "(//a[@class='transprnt_btn mT10'])[1]";


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
	public static final String ErrorMessages_WE = "//small[contains(@id,'_err')]";

	//GotoTop icon section
	public static final String GotoTop_Btn = "//a[@id='goTop']";	

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
