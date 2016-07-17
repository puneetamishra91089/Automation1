package com.naukri.FastForwardRevamp.Code;

import org.openqa.selenium.WebDriver;

import com.naukri.GenericFunctionsPack.GenericFunctions;

public class CertificateHighlighterPage {
	public WebDriver driver;
	GenericFunctions generic;

	public CertificateHighlighterPage(WebDriver driver , GenericFunctions generic)
	{
		this.driver=driver;
		this.generic = generic;
	}
	//Bread crumb
	public static final String BreadCrum_WE = "//div[@class='wrap breadCrmb']";
	public static final String Naukri_Lnk = "//div[@class='wrap breadCrmb']/a";

	public static final String HeroLine_WE = "//p[@class='heroLine fadeInLeft']";
	public static final String WhyYouMustHeading_WE = "//div[@class='servcWrap fadeInRight']";
	public static final String BuyCertificateHeading_WE = "//h2[@class='heroLine']";
	public static final String HighlightCertificateSection_WE = "//div[@class='jobSubCategory']/div";
	public static final String IncreaseYourChancesSection_WE = "//div[@class='jobSubCategory pb10']/div";
	public static final String HowItWillLook_WE = "(//h2[@class='contentHd'])[1]";
	public static final String ProfileSample1_WE = "(//img[@class='thumbnail'])[1]";
	public static final String ProfileSample2_WE = "(//img[@class='thumbnail'])[2]";
	public static final String ResumeSearchImage_WE = "//img[@id='lboxImg']";
	public static final String UserProfileImage_WE = "//img[@id='lboxImg']";
	public static final String SampleImage1Content_WE = "(//li[@class='othrServicCont'])[1]";
	public static final String SampleImage2Content_WE = "(//li[@class='othrServicCont'])[2]";
	public static final String HowItWorks_WE = "(//h2[@class='contentHd'])[2]";
	public static final String Step1_WE = "(//ul[@class='grid-4col']/li)[1]";
	public static final String Step2_WE = "(//ul[@class='grid-4col']/li)[2]";
	public static final String Step3_WE = "(//ul[@class='grid-4col']/li)[3]";
	public static final String Step4_WE = "(//ul[@class='grid-4col']/li)[4]";

	//Subscription drop down
	public static final String Subscription_DD = "(//input[@class='sdTxt'])[1]";
	public static final String Experience_DD = "(//input[@class='sdTxt'])[1]";
	public static final String ExperienceULid_DD = "(//div[@class='sDrop nScroll']/ul)[1]/li";
	public static final String SelectedExperience_DD = "//input[@id='mappedserviceHid']";

	//Add to cart button
	public static final String AddtoCart_Btn = "//a[@id='cartstatus']"; 
	//GotoTop icon section
	public static final String GotoTop_Btn = "//a[@id='goTop']";	
}

