package com.naukri.FastForwardRevamp.Code;

import org.openqa.selenium.WebDriver;

import com.naukri.GenericFunctionsPack.GenericFunctions;

public class FastForwardGnb {
	WebDriver driver;
	GenericFunctions generic;

	public static final String Login_Btn = "//a[@id='login_Layer']";
	public static final String BreadCrumb_Common_WE = "//div[@class='wrap breadCrmb']";
	public static final String Help_BreadCrumb_Common_WE = "//div[@class='wrapper pT10']";
	public static final String ElearningBreadcrumbs = "//div[@class='wrap breadCrmb brdSp']";
	public static final String Tabs = "//ul[@class='ffGnb']/li";
	public static final String RecruiterReach_WE = "(//a[@class='no_pointer'])[2]";
	public static final String ResumeWriting_WE = "//div[@id='nav']//a[text()='Resume Writing']"; 
	public static final String eLearning_Tab_WE = "(//a[@class='no_pointer'])[3]";
	public static final String Elearning_Lnk = "//a[@title='Online Courses & Certifcations']";
	public static final String Elearning_Subtext = "(//ul[@class='subNav w270']/li/p)[5]";
	public static final String FindJobs_Tab_WE = "(//a[@class='no_pointer'])[4]";
	public static final String JobsonMail_Lnk = "//a[@title='Job Alert']";
	public static final String JobsonMail_Subtext = "(//ul[@class='subNav w212'])/li/p";
	public static final String Help_WE = "(//a[@class='no_pointer'])[5]";
	public static final String Myservices_Tab_Lnk = "(//li[@class='nosub ']/a)[1]";
	public static final String Myservices_Breadcrumb_WE = "//ul[@id='breadCrumb']";
	public static final String PriorityApplicantSubcontent_WE  = "(//ul[@class='subNav w212']/li/p)[3]";
	public static final String RecruiterConnectionSubcontent_WE = "(//ul[@class='subNav w212']/li/p)[2]";
	public static final String ResumeDisplaySubContent_WE = "(//ul[@class='subNav w212']/li/p)[1]";
	public static final String CoverLetterSamplesSubContent_WE = "(//ul[@class='subNav w394']/li/p)[4]";
	public static final String ResumeSamplesSubContent_WE = "(//ul[@class='subNav w394']/li/p)[3]";
	public static final String ResumeQualityScoreSubContent_WE = "(//ul[@class='subNav w394']/li/p)[2]";
	public static final String VisualResumeSubContent = "(//ul[@class='subNav w394']/li/p)[1]";
	public static final String TextResumeEntryLevel_Lnk = "(//div[@class='levels']/div/a)[1]";
	public static final String TextResumeMidLevel_Lnk = "(//div[@class='levels']/div/a)[2]";
	public static final String TextResumeSeniorLevel_Lnk = "(//div[@class='levels']/div/a)[3]";
	public static final String VisualResumeEntryLevel_Lnk = "(//div[@class='levels']/div/a)[4]";
	public static final String VisualResumeMidLevel_Lnk = "(//div[@class='levels']/div/a)[5]";
	public static final String VisualResumeSeniorLevel_Lnk = "(//div[@class='levels']/div/a)[6]";
	public static final String ResumeSampleEntryLevel_Lnk = "(//div[@class='levels']/div/a)[7]";
	public static final String ResumeSampleMidLevel_Lnk = "(//div[@class='levels']/div/a)[8]";
	public static final String ResumeSampleSeniorLevel_Lnk = "(//div[@class='levels']/div/a)[9]";

	
	public FastForwardGnb(WebDriver driver,GenericFunctions generic) {
		this.generic = generic;
		this.driver = driver;
	}



}
