package com.naukri.FastForwardRevamp.Code;


import org.openqa.selenium.WebDriver;

import com.naukri.GenericFunctionsPack.GenericFunctions;

public class CoverLetterSamplePage {

	public WebDriver driver;
	GenericFunctions generic;

	public CoverLetterSamplePage(WebDriver driver , GenericFunctions generic)
	{
		this.driver=driver;
		this.generic = generic;
	}
	//Bread crumb
	public static final String Naukri_Lnk = "//div[@class='wrap breadCrmb']/a";
	public static final String Breadcrum_WE = "//div[@class='wrap breadCrmb']";
	public static final String ArticleBreadcrum_WE = "//div[@class='wrapper pT10']";
	public static final String CoverLetterSampleHeading_WE = "//h1[@class='contentHd pt30']";
	public static final String CoverLetterSampleContent_WE = "//p[@class='gryHd cvrLtrIntro']";
	public static final String SampleHeading_WE = "//h2[@class='bgGreen font_26']";
	public static final String Production_Btn = "//li[text()='Production']";
	public static final String Finance_Btn = "//li[text()='Finance']";
	public static final String Sales_Btn = "//li[text()='Sales']";
	
	public static final String ProductionSample_WE = "(//div[@id='tabs']//img)[1]";
	public static final String FinanceSample_WE = "(//div[@id='tabs']//img)[2]";
	public static final String SalesSample_WE = "(//div[@id='tabs']//img)[3]";
	
	public static final String WaysHeading_WE = "//h3[@class='contentHd padCL']";
	public static final String Way1Heading_WE = "(//p[@class='gryHd'])[1]";
	public static final String Way2Heading_WE = "(//p[@class='gryHd'])[2]";
	public static final String Way3Heading_WE = "(//p[@class='gryHd'])[3]";
	public static final String Way4Heading_WE = "(//p[@class='gryHd'])[4]";
	public static final String Way5Heading_WE = "(//p[@class='gryHd'])[5]";
	public static final String Way1Content_WE = "(//ul[@class='grid-2col']/li/div/p)[2]";
	public static final String Way2Content_WE = "(//ul[@class='grid-2col']/li/div/p)[4]";
	public static final String Way3Content_WE = "(//ul[@class='grid-2col']/li/div/p)[6]";
	public static final String Way4Content_WE = "(//ul[@class='grid-2col']/li/div/p)[8]";
	public static final String Way5Content_WE = "(//ul[@class='grid-2col']/li/div/p)[10]";
	public static final String SeecoverletterSample_Lnk = "//a[@id='smplLnk']";
	public static final String WanttoImprove_WE = "//div[@class='lftTxt']";
	public static final String BuyNow_Lnk = "//a[@class='red_btnBig']";
	public static final String RelatedArticles_WE = "//h4[@class='contentHd']";
	public static final String Article1_Lnk = "//a[@title='7 Ways to Make your Cover Letter Recruiter Friendly']";
	public static final String Article2_Lnk = "//a[@title='Common Cover letter mistakes to avoid!']";
	public static final String Article3_Lnk = "//a[@title='Cover Letter Tips']";
	public static final String Viewmoreoncoverletter_Lnk = "//a[@class='rightLink']";
	public static final String GotoTop_Btn = "//a[@id='goTop']";	

	
}
