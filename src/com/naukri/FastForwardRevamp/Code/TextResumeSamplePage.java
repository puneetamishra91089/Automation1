package com.naukri.FastForwardRevamp.Code;

import org.openqa.selenium.WebDriver;

import com.naukri.GenericFunctionsPack.GenericFunctions;

public class TextResumeSamplePage {
	public WebDriver driver;
	GenericFunctions generic;
	public TextResumeSamplePage(WebDriver driver,GenericFunctions generic)
	{
		this.driver=driver;
		this.generic = generic;
	}	
	
	//Resume Sample Home page
	public static final String Breadcrumb_WE = "//div[@class='wrap breadCrmb']";
	public static final String Naukri_Link = "//div[@class='wrap breadCrmb']/a";
	public static final String ResumeSampleHeading_WE = "//h1[@class='heroLine fadeInLeft']";
	public static final String HeroLineContent_WE = "//p[@id='tBnrTxt']";
	public static final String KnowWherYourResumeSatnds_WE = "//div[@class='lGryBx']/div";
	public static final String CheckYourCV_Lnk = "//a[text()='Check your CV Score ']";
	public static final String SeeResumeSampleHeading_WE = "//h2[@class='contentHd fl']";
	public static final String IWantToImproverHeading_WE = "//h3[@class='font_40 txtDrkBlu']";
	public static final String IWantToImproverContent_WE = "//p[@id='upsellTxt']";
	public static final String Experience_DD = "//input[@class='sdTxt']";
	public static final String Price_WE = "//p[@id='price']";
	public static final String BuyNow_lnk = "//a[@id='buyTextResume']";
	public static final String VisualResumeSample_Lnk = "(//a[@title='Visual Resume Samples'])[1]";
	
	//Resume Sample Functional Area Page
	public static final String ResumeFormatHeading_WE = "//h1[@class='heroLine fadeInLeft']";
	public static final String ResumeFormatContent_WE = "//p[@class='font_16 txtWhite fadeInLeft']";
	public static final String CourseResumeSampleHeading_WE = "//h2[@class='contentHd fl']";
	public static final String ResumeImage_WE = "//img[@id='samplCV']";
	public static final String SeeMoreResume_WE = "//div[@class='font_26']";
	public static final String EntryLevel_Lnk = "//a[@id='entry']";
	public static final String MidLevel_Lnk = "//a[@id='mid']";
	public static final String SeniorLevel_Lnk = "//a[@id='senior']";
	public static final String IT_FunctionalArea_WE = "//div[@id='acordCvSmpl']/div/div[1]/div/div[1]";
	public static final String HR_FunctionalArea_WE = "//div[@id='acordCvSmpl']/div/div[1]/div/div[3]";
	public static final String BankingFinance_FunctionalArea_WE = "//div[@id='acordCvSmpl']/div/div[1]/div/div[5]";
	public static final String Automobile_FunctionalArea_WE = "//div[@id='acordCvSmpl']/div/div[1]/div/div[7]";
	public static final String Marketing_FunctionalArea_WE = "//div[@id='acordCvSmpl']/div/div[1]/div/div[9]";
	public static final String Operations_FunctionalArea_WE = "//div[@id='acordCvSmpl']/div/div[1]/div/div[11]";
	public static final String Production_FunctionalArea_WE = "//div[@id='acordCvSmpl']/div/div[1]/div/div[13]";
	public static final String Sales_FunctionalArea_WE = "//div[@id='acordCvSmpl']/div/div[1]/div/div[15]";
	public static final String OtherResume_FunctionalArea_WE = "//div[@id='acordCvSmpl']/div/div[1]/div/div[17]";	
}
