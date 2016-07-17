package com.naukri.FastForwardRevamp.Code;


import org.openqa.selenium.WebDriver;

import com.naukri.GenericFunctionsPack.GenericFunctions;

public class RecruiterConnectionPage {

	public WebDriver driver;
	GenericFunctions generic;

	public RecruiterConnectionPage(WebDriver driver , GenericFunctions generic)
	{
		this.driver=driver;
		this.generic = generic;
	}
	//Bread crumb
	public static final String BreadCrum_WE = "//div[@class='wrap breadCrmb']";
	public static final String Naukri_Lnk = "//div[@class='wrap breadCrmb']/a";

	//RecruiterConnection page
	public static final String Heading1_WE = "//h1[@class='heroLine fadeInLeft']";
	public static final String WhyRC_WE = "//h2[@class='contentHd']";	
	public static final String Content_WE = "//p[@class='introTxt mT10']";
	public static final String SearchRecruiter_Lnk = "(//a[@class='white_btn'])[1]";	
	public static final String HowItWorksHeading_WE = "(//h3[@class='contentHd'])[1]";
	public static final String Step1_WE = "(//ul[@class='grid-3col detailCol']/li)[1]";
	public static final String Step2_WE = "(//ul[@class='grid-3col detailCol']/li)[2]";
	public static final String Step3_WE = "(//ul[@class='grid-3col detailCol']/li)[3]";
	public static final String Sample1_Lnk = "(//div[@class='openRjLb'])[1]";
	public static final String Sample1Content_WE = "(//ul[@class='grid-3col detailCol wrap']/li)[1]";	
	public static final String Sample2_Lnk = "(//div[@class='openRjLb'])[2]";	
	public static final String Sample2Content_WE = "(//ul[@class='grid-3col detailCol wrap']/li)[2]";
	public static final String Sample3_Lnk = "(//div[@class='openRjLb'])[3]";
	public static final String Sample3Content_WE = "(//ul[@class='grid-3col detailCol wrap']/li)[3]";
	public static final String SearchNow_Lnk = "//ul[@class='grid-3col detailCol']/li/a";
	public static final String Sampleimage_WE = "//p[@class='lightbxHd']";
	public static final String SampleHeading_WE = "//span[@id='lboxHead']";
	public static final String BuyCreditsHeading_WE = "//h4[@class='heroLine']";
	public static final String CreditsPoints1_WE = "(//ul[@class='whiteArwLst']/li)[1]";
	public static final String CreditsPoints2_WE = "((//ul[@class='whiteArwLst']/li)[2])";
	public static final String CreditsPoints3_WE = "((//ul[@class='whiteArwLst']/li)[3])";
	public static final String CreditsPoints4_WE = "((//ul[@class='whiteArwLst']/li/p)[4])";
	public static final String CreditsPoints5_WE = "((//ul[@class='whiteArwLst']/li)[5])";
	public static final String Credits_DD = "(//input[@class='sdTxt'])[1]";
	public static final String CreditsULid_DD = "(//div[@class='sDrop nScroll']/ul)[1]/li";
	public static final String SelectedCredits_DD = "//input[@id='mappedserviceHid']";
	public static final String Price_WE = "//div[@class='cartPriceTot']";
	public static final String Addtocart_Btn = "//a[@class='red_btnBig']";

	public static final String RecommendedServiceHeading_WE = "(//h5[@class='contentHd'])";
	public static final String ResumeDisplayHeading_WE = "(//p[@class='othrServicHd'])[1]";
	public static final String ResumeDisplayContent_WE = "(//div[@class='oh']/div/div)[1]";
	public static final String GetHighlighted_Btn = "(//a[@class='blue_btnSmal mt35'])[1]";
	public static final String JobsOnMailandSMSHeading_WE = "(//p[@class='othrServicHd'])[2]";
	public static final String JobsOnMailandSMSContent_WE = "(//div[@class='oh']/div/div)[2]";
	public static final String GetJobsOnMailandSMS_Btn = "(//a[@class='blue_btnSmal mt35'])[2]";

	//GotoTop icon section
	public static final String GotoTop_Btn = "//a[@id='goTop']";	

	//Combo strip
	public static final String ElementID="recComboHead";
	public static final String ComboStrip_Btn="//a[@id='offer']";

}