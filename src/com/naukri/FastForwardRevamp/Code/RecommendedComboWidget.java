package com.naukri.FastForwardRevamp.Code;

import org.openqa.selenium.WebDriver;

import com.naukri.GenericFunctionsPack.GenericFunctions;

public class RecommendedComboWidget {
	WebDriver driver;
	GenericFunctions generic;

	public RecommendedComboWidget(WebDriver driver, GenericFunctions generic)
	{
		this.driver = driver;
		this.generic = generic;
	}

	public static final String HowitworksHeading_WE = "(//h4[@class='contentHd'])[1]";
	public static final String RecommendedComboHeading_WE = "//h4[@id='recComboHead']";
	public static final String RecommendedVisualService_WE = "(//a[@class='toolTp'])[1]";
	public static final String RecommendedVisualContent_WE = "(//table[@class='tableFF']/thead/tr/th/span)[1]";
	public static final String RecommendedVisualPrice_WE = "(//table[@class='tableFF']/tbody/tr/td)[1]";
	public static final String RecommendedCoverletter_WE = "(//a[@class='toolTp'])[2]";
	public static final String RecommendedCoverlettercontent_WE = "(//table[@class='tableFF']/thead/tr/th/span)[2]";
	public static final String RecommendedResumeDisplayservice_WE = "(//a[@class='toolTp'])[3]";
	public static final String RecommendedResumeDisplayPrice_WE = "(//table[@class='tableFF']/tbody/tr/td)[3]";
	public static final String RecommendedResumeDisplayContent_WE = "(//table[@class='tableFF']/thead/tr/th/span)[3]";
	public static final String RecommendedRecruiterConnectionService_WE = "(//a[@class='toolTp'])[4]";
	public static final String RecommendedRecruiterConnectionContent_WE = "(//table[@class='tableFF']/thead/tr/th/span)[4]";
	public static final String RecommendedRecruiterConnectionprice_WE = "(//table[@class='tableFF']/tbody/tr/td)[4]";
	public static final String RecommendedJobs4UService_WE = "(//a[@class='toolTp'])[5]";
	public static final String RecommendedJobs4UContent_WE = "(//table[@class='tableFF']/thead/tr/th/span)[5]";
	public static final String RecommendedJobs4UPrice_WE = "(//table[@class='tableFF']/tbody/tr/td)[5]";
	public static final String ComboPriceHeading_WE = "//p[@class='dBlueHd']";
	public static final String ComboOriginalPrice_WE = "//span[@class='strike']";
	public static final String ComboNewPrice_WE ="//span[@id='d_prc']";
	public static final String ComboDiscount_WE = "(//span[@class='txtBlack'])[2]";
	public static final String ComboSave_WE = "//span[@id='s_prc']";
	public static final String ComboAddtoCart_Btn= "//a[@class='red_btnSmal']";
	public static final String Experience_DD = "(//input[@class='sdTxt'])[2]";
	public static final String ExperienceULid_DD = "(//div[@class='nScroll']/ul/li)";
	public static final String Login_lnk = "//a[@id='login_Layer']";

}
