package com.naukri.FastForwardRevamp.Code;

import org.openqa.selenium.WebDriver;

import com.naukri.GenericFunctionsPack.GenericFunctions;

public class ValuePackToolTip{
	WebDriver driver;
	GenericFunctions generic;

	public ValuePackToolTip(WebDriver driver, GenericFunctions generic)
	{
		this.driver = driver;
		this.generic = generic;
	}

	public static final String ProfileHighlighterHeading_WE = "(//div[@class='comboHd'])[1]";
	public static final String Experience_DD  = "//input[@class='sdTxt']";
	public static final String ExperienceULid_DD = "(//div[@class='nScroll']/ul/li)";
	
	public static final String ProfileHighlighterVisualService_WE = "(//a[@class='valToolTp'])[1]";
	public static final String ProfileHighlighterCoverService_WE = "(//a[@class='valToolTp'])[4]";
	public static final String ProfileHighlighterResumeDisplayService_WE ="(//ul[@class='servc']/li)[2]";
	public static final String ProfileHighlighterRJconnectionService_WE = "(//a[@class='valToolTp'])[3]";
	public static final String FeaturedVisualService_WE = "(//a[@class='valToolTp'])[5]";
	public static final String FeaturedCover_Service_WE= "(//a[@class='valToolTp'])[9]";
	public static final String FeaturedResumeDisplayService_WE = "(//a[@class='valToolTp'])[6]";
	public static final String FeaturedRJconnectionService_WE = "(//a[@class='valToolTp'])[7]";
	public static final String FeaturedJobs4UService_WE = "(//a[@class='valToolTp'])[8]";
	public static final String JobsearchResumeDisplayService_WE = "(//a[@class='valToolTp'])[10]";
	public static final String JobsearchRJconnectionService_WE = "(//a[@class='valToolTp'])[11]";
	public static final String JobsearchJobs4UService_WE = "(//a[@class='valToolTp'])[12]";
	
	public static final String GulfJobs_Lnk = "//a[@class='glfPack font_14']";
	public static final String GulfExperience_DD = "//input[@class='sdTxt']";	
	public static final String GulfVisualService_WE = "(//a[@class='valToolTp'])[1]";
	public static final String GulfCover_WE = "(//a[@class='valToolTp'])[4]";
	public static final String GulfResumeSpotlight_WE = "(//a[@class='valToolTp'])[2]";
	public static final String GulfResumeDisplay_WE = "(//a[@class='valToolTp'])[3]";
	
	

	
}
