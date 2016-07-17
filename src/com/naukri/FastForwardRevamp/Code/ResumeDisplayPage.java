package com.naukri.FastForwardRevamp.Code;


import org.openqa.selenium.WebDriver;

import com.naukri.GenericFunctionsPack.GenericFunctions;

public class ResumeDisplayPage {

	public WebDriver driver;
	GenericFunctions generic;

	public ResumeDisplayPage(WebDriver driver , GenericFunctions generic)
	{
		this.driver=driver;
		this.generic = generic;
	}
	//ResumeDisplay Breadcrum
	public static final String Naukri_Lnk = "//div[@class='wrap breadCrmb']/a";
	public static final String Breadcrum_WE = "//div[@class='wrap breadCrmb']";

	//Resume Display page
	public static final String ResumeDisplayHeading_WE = "//h1[@class='heroLine fadeInLeft']";
	public static final String ResumeDisplayImage_WE = "//div[@class='wrap bannerPos']";
	public static final String WhyResumeDisplayHeading_WE = "//h2[@class='contentHd']";
	public static final String WhytResumeDisplayContent_WE = "//div[@class='servcWrap fadeInRight introTxt']";
	public static final String HighlightYourProfileHeading_WE = "(//h3[@class='catHead'])[1]";
	public static final String HighlightYourProfileContent_WE = "(//div[@class='jobSubCategory']/div)[1]";	
	public static final String RankHighInSearchResultsHeading_WE = "(//h3[@class='catHead'])[2]";	
	public static final String RankHighInSearchResultsContent_WE = "(//div[@class='jobSubCategory']/div)[2]";
	public static final String BeAccessibleToMoreRecruitersHeading_WE = "(//h3[@class='catHead'])[3]";
	public static final String BeAccessibleToMoreRecruitersContent_WE = "(//div[@class='jobSubCategory']/div)[3]";		
	public static final String Subscription_DD = "(//input[@class='sdTxt'])[1]";
	public static final String Experience_DD = "(//input[@class='sdTxt'])[1]";
	public static final String ExperienceULid_DD = "(//div[@class='sDrop nScroll']/ul)[1]/li";
	public static final String SelectedExperience_DD = "//input[@id='mappedserviceHid']";
	public static final String SubscriptionPrice_WE = "//div[@class='cartPriceTot']";
	public static final String AddtoCart_Btn = "//a[@class='red_btnBig']";
	public static final String GulfServicesHeading_WE = "//h5[@class='bluContntHd']";
	public static final String GulfServicesContent_WE = "//p[@class='gulfSubHd']";
	public static final String GulfServicesSubContent_WE = "//div[@class='jobsCategry gulf']";	
	public static final String RecommendedServiceHeading_WE = "(//h5[@class='contentHd'])";
	public static final String RecruiterConnectionHeading_WE = "(//p[@class='othrServicHd'])[1]";
	public static final String RecruiterConnectionContent_WE = "(//div[@class='oh']/div/div)[1]";
	public static final String findRecruiters_Btn = "(//a[@class='blue_btnSmal mt35'])[1]";
	public static final String JobsOnMailandSMSHeading_WE = "(//p[@class='othrServicHd'])[2]";
	public static final String JobsOnMailandSMSContent_WE = "(//div[@class='oh']/div/div)[2]";
	public static final String GetJobsOnMailandSMS_Btn = "(//a[@class='blue_btnSmal mt35'])[2]";

	//DeliveryInformation
	public static final String DeliveryInformationHeading_WE = "//p[@class='hd']";
	public static final String DeliveryInformationContent_WE = "(//div[@class='bgGray gryLesPd']/div)[1]";

	//GotoTop icon section
	public static final String GotoTop_Btn = "//a[@id='goTop']";	

	//Combo strip
	public static final String ElementID="recComboHead";
	public static final String ComboStrip_Btn="//a[@id='offer']";

}
