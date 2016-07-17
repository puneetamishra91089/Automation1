package com.naukri.FastForwardRevamp.Code;


import org.openqa.selenium.WebDriver;

import com.naukri.GenericFunctionsPack.GenericFunctions;

public class PriorityApplicantPage {

	public WebDriver driver;
	GenericFunctions generic;

	public PriorityApplicantPage(WebDriver driver , GenericFunctions generic)
	{
		this.driver=driver;
		this.generic = generic;
	}


	//Bread Crumb
	public static final String BreadCrumb_Home_Lnk = "(//a[text()='Naukri FastForward '])";
	public static final String BreadCrumb_PriorityApplicant_WE = "//div[@class='wrap breadCrmb']";
	//Hero Line
	//public static final String Not_getting_calls_from_WE="//p[@class='bold font_20 txtWhite fadeInLeft mt35']";
	//public static final String Be_a_PriorityApplicant_WE="//h1[@class='heroLine fadeInLeft']";
	public static final String HerolineHeading_WE="//div[@class='wrap bannerPos']";
	//Why you might not be getting calls?
	public static final String Why_you_might_not_be_getting_calls_WE="(//h2[@class='contentHd'])[1]";
	public static final String YourApplicationMight_WE="(//h3[@class='othrServicCont'])[1]";
	public static final String YourApplicationMight_image_WE="//em[@class='manyCv']";
	public static final String You_might_have_applied_late_WE="(//h3[@class='othrServicCont'])[2]";
	public static final String You_might_have_applied_late_image_WE="//em[@class='manyAplcnt']";
	//Why become a Priority Applicant?
	public static final String Why_become_a_Priority_Applicant_WE="(//h2[@class='contentHd'])[2]";
	public static final String Receive_the_most_relevant_WE="//h3[text()='Receive the most relevant jobs via SMS/Mail within 30 min of them being posted on Naukri']";
	public static final String Receive_the_most_relevant_image_WE="(//span[@class='hexBluBig'])[1]";
	public static final String Apply_to_the_jobs_WE="//h3[text()='Apply to the jobs through SMS/website and get noticed as an early applicant']";
	public static final String Apply_to_the_jobs_image_WE="(//span[@class='hexBluBig'])[2]";
	public static final String Your_application_will_be_highlighted_WE="//h3[text()=\"Your application will be highlighted to catch Recruiters' attention\"]";
	public static final String Your_application_will_be_highlighted_image_WE="(//span[@class='hexBluBig'])[3]";
	//Subscription
	public static final String Buy_our_Priority_Applicant_subscription_WE="//p[@class='heroLine']";
	public static final String Subscription_WE="//span[@class='font_16 subsTxt']";
	public static final String Price_WE="//span[@id='cartPriorityApplicantPrc']";
	public static final String Rupee_Symbol_WE="//img[@alt='Rs']";
	//Subscription drop down
	public static final String Subscription_DD="//input[@class='sdTxt']";
	public static final String Subscriptionulli_DD="//div[@class='sDrop nScroll']/ul/li";
	public static final String SelectedSubscription_DD="//input[@id='mappedserviceHid']";
	//Add to cart button
	public static final String AddtoCart_Btn = "//a[@id='cartstatus']"; 
	//GotoTop icon section
	public static final String GotoTop_Btn = "//a[@id='goTop']";	
	public static final String RecommendedServiceHeading_WE = "(//h5[@class='contentHd'])";
	public static final String ResumeDisplayHeading_WE = "(//p[@class='othrServicHd'])[1]";
	public static final String ResumeDisplayContent_WE = "(//div[@class='oh']/div/div)[1]";
	public static final String GetHighlighted_Btn = "(//a[@class='blue_btnSmal mt35'])[1]";
	public static final String VisualResumeHeading_WE = "(//p[@class='othrServicHd'])[2]";
	public static final String VisualResumeContent_WE = "(//div[@class='oh']/div/div)[2]";
	public static final String VisualResume_Btn = "(//a[@class='blue_btnSmal mt35'])[2]";


}
