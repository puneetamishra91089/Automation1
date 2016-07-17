package com.naukri.FastForwardRevamp.Code;

import org.openqa.selenium.WebDriver;

import com.naukri.GenericFunctionsPack.GenericFunctions;

public class TextResumePage {
	public WebDriver driver;
	GenericFunctions generic;
	public TextResumePage(WebDriver driver, GenericFunctions generic)
	{
		this.driver = driver;
		this.generic = generic;
	}
	//Breadcrumb
	public static final String Naukri_Lnk = "//div[@class='wrap breadCrmb']/a";
	public static final String Breadcrum_WE = "//div[@class='wrap breadCrmb']";
	//Text Resume Service page
	public static final String Heroline_WE = "//h1[@id='heading']";
	public static final String EntryLevel_Lnk = "//a[@id='entryTab']";
	public static final String MidLevel_Lnk = "//a[@id='midTab']";
	public static final String SeniorLevel_Lnk = "//a[@id='seniorTab']";
	public static final String TextResumeHeading_WE = "//div[@id='shortDesc']/h2";
	public static final String TextResumeContent_WE = "//div[@class='srvcIntro servcWrap fadeInRight']";
	public static final String Feature1_WE = "(//div[@class='jobsCategry']/ul/li/h3)[1]";	
	public static final String Feature2_WE = "(//div[@class='jobsCategry']/ul/li/h3)[2]";
	public static final String Feature3_WE = "(//div[@class='jobsCategry']/ul/li/h3)[3]";
	public static final String Feature4_WE = "(//div[@class='jobsCategry']/ul/li/h3)[4]";
	public static final String Feature5_WE = "(//div[@class='jobsCategry']/ul/li/h3)[5]";
	public static final String Feature6_WE = "(//div[@class='jobsCategry']/ul/li/h3)[6]";
	public static final String SeeTextResumeSamples_Lnk = "//a[@class='whiteLabl font_medium']";
	public static final String Offer_Lnk = "//a[@class='offer bold dspB']";
	public static final String HowItWorks_WE = "(//h4[@class='contentHd'])[1]";
	public static final String Step1_WE = "(//ul[@class='grid-4col']/li)[1]";
	public static final String Step2_WE = "(//ul[@class='grid-4col']/li)[2]";
	public static final String Step3_WE = "(//ul[@class='grid-4col']/li)[3]";
	public static final String Step4_WE = "(//ul[@class='grid-4col']/li)[4]";	
	public static final String RecommendedServiceHeading_WE = "(//h5[@class='contentHd'])";
	public static final String RecruiterConnectionHeading_WE = "(//p[@class='othrServicHd'])[1]";
	public static final String RecruiterConnectionContent_WE = "(//div[@class='oh']/div/div)[1]";
	public static final String findRecruiters_Btn = "(//a[@class='blue_btnSmal mt35'])[1]";
	public static final String JobsOnMailandSMSHeading_WE = "(//p[@class='othrServicHd'])[2]";
	public static final String JobsOnMailandSMSContent_WE = "(//div[@class='oh']/div/div)[2]";
	public static final String GetJobsOnMailandSMS_Btn = "(//a[@class='blue_btnSmal mt35'])[2]";
	public static final String Experience_DD ="//input[@class='sdTxt']";
	public static final String ExperienceULid_DD = "(//div[@class='nScroll']/ul/li)";
	public static final String SelectedExperience_DD = "//input[@id='mappedserviceHid']";	
	public static final String Price_WE ="//div[@class='cartPriceTot']";
	public static final String Addtocart_Btn= "//a[@class='red_btnBig']";
	public static final String IncludeCoverLetter_Chk = "//input[@id='coverletter']";
	public static final String Deliveryoption1_Btn = "(//input[@type='radio'])[1]";
	public static final String Deliveryoption2_Btn = "(//input[@type='radio'])[2]";
	public static final String Deliveryoption3_Btn = "(//input[@type='radio'])[3]";
	//DeliveryInformation
	public static final String DeliveryInformationHeading_WE = "//p[@class='hd']";
	public static final String DeliveryInformationContent_WE = "(//div[@class='bgGray gryLesPd']/div)[1]";

	//GotoTop icon section
	public static final String GotoTop_Btn = "//a[@id='goTop']";	

	}
