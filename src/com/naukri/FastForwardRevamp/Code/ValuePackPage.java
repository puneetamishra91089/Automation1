package com.naukri.FastForwardRevamp.Code;


import org.openqa.selenium.WebDriver;

import com.naukri.GenericFunctionsPack.GenericFunctions;

public class ValuePackPage {

	public WebDriver driver;
	GenericFunctions generic;

	public ValuePackPage(WebDriver driver , GenericFunctions generic)
	{
		this.driver=driver;
		this.generic = generic;
	}
	//value packs Breadcrum
	public static final String ValuePack_Breadcrum_WE = "//div[@class='wrap breadCrmb']";
	public static final String Naukri_Lnk = "//div[@class='wrap breadCrmb']/a";
	//Hero line 
	public static final String Heroline_WE = "//h1[@class='heroLine fadeInLeft']";

	//Experience
	public static final String ChooseExp_WE = "//span[@class='subsTxt']";
	public static final String Experience_DD  = "//input[@class='sdTxt']";
	public static final String ExperienceULid_DD = "(//div[@class='nScroll']/ul/li)";
	public static final String SelectedExperience_DD = "//input[@id='mappedserviceHid']";

	//ProfileHighlighter Value Pack
	public static final String ProfileHighlighterHeading_WE = "(//div[@class='comboHd'])[1]";
	public static final String ProfileHighlighterContent_WE = "(//p[@class='detail'])[1]";
	public static final String ProfileHighlighterSubServices_WE = "(//ul[@class='servc'])[1]";	
	public static final String ProfileHighlighterOldprice_WE = "(//span[@class='txtStrike'])[1]";
	public static final String ProfileHighlighterNewprice_WE = "(//span[@class='cntrPrice'])[1]";
	public static final String ProfileHighlighterDiscount_WE = "(//span[@class='off'])[1]";
	public static final String ProfileHighlighterAddtocart_Btn = "(//a[@class='red_btnBig'])[1]";

	//Featured Value pack
	public static final String FeaturedHeading_WE = "(//div[@class='comboHd'])[2]";
	public static final String FeaturedContent_WE = "(//p[@class='detail'])[2]";
	public static final String FeaturedSubServices_WE = "(//ul[@class='servc'])[2]";
	public static final String FeaturedOldprice_WE = "(//span[@class='txtStrike'])[2]";
	public static final String FeaturedNewprice_WE = "(//span[@class='cntrPrice'])[2]";
	public static final String FeaturedAddtocart_Btn = "(//a[@class='red_btnBig'])[2]";
	public static final String FeaturedDiscount_WE = "(//span[@class='off'])[2]";
	public static final String FeaturedInactive_WE = "(//div[@class='noGlf'])[1]";
	public static final String FeaturedBestValue_WE= "//p[@class='bestVal']";

	//JobSearch Value Pack
	public static final String JobsearchHeading_WE = "(//div[@class='comboHd'])[3]";
	public static final String JobsearchContent_WE = "(//p[@class='detail'])[3]";	
	public static final String JobsearchSubServices_WE = "(//ul[@class='servc'])[3]";
	public static final String JobsearchOldprice_WE = "(//span[@class='txtStrike'])[3]";
	public static final String JobsearchNewprice_WE = "(//span[@class='cntrPrice'])[3]";
	public static final String JobsearchAddtocart_Btn = "(//a[@class='red_btnBig'])[3]";
	public static final String JobsearchDiscount_WE = "(//span[@class='off'])[3]";
	public static final String JobsearchInactive_WE = "(//div[@class='noGlf'])[3]";

	//Gulf value packs
	public static final String GulfJobs_Lnk = "//a[@class='glfPack font_14']";
	public static final String GulfExperience_DD = "//input[@class='sdTxt']";
	public static final String GulfInactive_L_WE = "(//div[@class='noGlf'])[1]";
	public static final String GulfInactive_R_WE = "(//div[@class='noGlf'])[3]";
	public static final String GulfValuePackHeading_WE = "(//div[@class='comboHd'])[2]";
	public static final String GulfValuePackContent_WE = "(//p[@class='detail'])[2]";
	public static final String GulfService_WE = "(//ul[@class='servc'])[2]";
	public static final String GulfCover_WE = "(//ul[@class='servc']/li)[3]";
	public static final String GulfResumeSpotlight_WE = "(//ul[@class='servc']/li)[2]";
	public static final String GulfResumeDisplay_WE = "(//ul[@class='servc']/li)[1]";
	public static final String GulfOldprice_WE = "(//span[@class='txtStrike'])[2]";
	public static final String GulfNewprice_WE = "(//span[@class='cntrPrice'])[2]";
	public static final String GulfCallBack_WE = "(//div[@class='numbr'])[2]";
	public static final String GulfDiscount_WE = "(//span[@class='off'])[2]";	

	//Delivery Information section
	public static final String DeliveryInformationHeading_WE = "//h3[@class='hd']";
	public static final String DeliveryInformationContent_WE = "html/body/div[6]/div";


	//GotoTop icon section
	public static final String GotoTop_Btn = "//a[@id='goTop']";

}


