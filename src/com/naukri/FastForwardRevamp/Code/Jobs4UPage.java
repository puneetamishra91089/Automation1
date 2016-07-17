package com.naukri.FastForwardRevamp.Code;


import org.openqa.selenium.WebDriver;

import com.naukri.GenericFunctionsPack.GenericFunctions;

public class Jobs4UPage {

	public WebDriver driver;
	GenericFunctions generic;

	public Jobs4UPage(WebDriver driver , GenericFunctions generic)
	{
		this.driver=driver;
		this.generic = generic;
	}
	//Breadcrum
	public static final String Breadcrum_WE = "//div[@class='wrap breadCrmb']";
	public static final String Naukri_Lnk = "//div[@class='wrap breadCrmb']/a";

	//Hero line
	public static final String HeroLine_WE = "//p[@class='heroLine fadeInLeft']";

	//About Jobs4U section
	public static final String AboutJobs4UHeading_WE = "//h1[@class='contentHd']";
	public static final String AboutJobs4UContent_WE = "//div[@class='servcWrap fadeInRight introTxt']";

	//Child service description section
	public static final String JobOnSmsHeading_WE = "//h2[@class='catHead']";
	public static final String JobOnSmsContent_WE = "(//div[@class='jobSubCategory']/div)[1]";
	public static final String JobOnMailHeading_WE = "//h3[@class='catHead']";
	public static final String JobOnMailContent_WE = "(//div[@class='jobSubCategory']/div)[2]";
	public static final String SubDetails_WE = "//p[@class='subDetail']";



	//Recommended Services
	public static final String RecommendedServiceHeading_WE = "//h5[@class='contentHd']";
	public static final String ResumeDisplayHeading_WE = "(//p[@class='othrServicHd'])[1]";
	public static final String ResumeDisplayContent_WE = "(//div[@class='oh']/div/div)[1]";
	public static final String GetHighlighted_Btn = "(//a[@class='blue_btnSmal mt35'])[1]";
	public static final String RecruiterConnectionHeading_WE = "(//p[@class='othrServicHd'])[2]";
	public static final String RecruiterConnectionContent_WE = "(//div[@class='oh']/div/div)[2]";
	public static final String FindRecruiters_Btn = "(//a[@class='blue_btnSmal mt35'])[2]";

	//Delivery Information section
	public static final String DeliveryInformationHeading_WE = "//p[@class='hd']";
	public static final String DeliveryInformationContent_WE = "(//div[@class='bgGray gryLesPd']/div)[1]";



	//Add to cart widget
	public static final String Subscription_DD = "(//input[@class='sdTxt'])[1]";
	public static final String SubscriptionULid_DD = "(//div[@class='sDrop nScroll']/ul)[1]/li";
	public static final String SelectedSubscription_DD = "//input[@id='mappedserviceHid']";
	public static final String RupeeSymbol_WE = "//p[@class='cartPriceTot']/span/img";
	public static final String Price_WE = "//p[@class='cartPriceTot']";
	public static final String AddtoCart_Btn = "//a[@class='red_btnBig']";
	public static final String UpdateCart_Btn = "(//a[@class='btnRedCart'])[2]";

	//Contact Us widget
	public static final String TollFreeNo_WE = "//li[@class='nopointr']/p/span[1]";
	public static final String CallMeBack_Lnk = "//div[@class='widgtLi_2']/a";
	public static final String ChatWithUs_Lnk = "(//div[@class='widgtLi_3']/a)[1]";
	public static final String FindNearestBranch_Lnk = "(//div[@class='widgtLi_3'])[2]/a";

	//Lead form
	public static final String LeadFormHeader_WE = "//p[@class='formHd']";
	public static final String LeadFormClose_Btn = "//div[@class='greenCont p0']/a";
	public static final String LeadFormName_Txt = "//input[@id='name']";
	public static final String LeadFormNameError_WE = "//div[@class='txtWrap inputErr'][1]";
	public static final String LeadFormNameCorrect_WE = "//div[@class='txtWrap inputCorect'][1]";
	public static final String LeadFromEmail_Txt = "//input[@id='emailId']";
	public static final String LeadFormEmailError_WE = "//div[@class='txtWrap inputErr'][2]";
	public static final String LeadFormEmailCorrect_WE = "//div[@class='txtWrap inputCorect'][2]";
	public static final String LeadFromMobile_Txt = "//input[@id='mobile']";
	public static final String LeadFormMobileError_WE = "//div[@class='txtWrap inputErr'][3]";
	public static final String LeadFormMobileCorrect_WE = "//div[@class='txtWrap inputCorect'][3]";
	public static final String LeadFromQuery_Txt = "//textarea[@id='query']";
	public static final String LeadFromQueryError_WE = "//div[@class='txtWrap txtarea inputErr']";
	public static final String LeadFromQueryCorrect_WE = "//div[@class='txtWrap txtarea inputCorectr']";
	public static final String LeadFormSubmit_Btn = "//input[@id='submitQuery']";

	//Testimonial section
	public static final String TestimonialContent_WE = "//div[@class='testimnlTxt']/p";
	public static final String TestimonialNavigationPrevious_Btn = "//div[@class='bx-controls-direction']/a[1]";
	public static final String TestimonialNavigationNext_Btn = "//div[@class='bx-controls-direction']/a[2]";
	public static final String Testimonialimage_WE = "(//div[@class='testimonl']/img)[2]";

	//GotoTop icon section
	public static final String GotoTop_Btn = "//a[@id='goTop']";
	//Cart
	public static final String Service_WE = "//span[@id='cartJobs4uTitle']";
	public static final String ShoppingCartItems_WE = "//span[@id = 'inCartCount']";
	public static final String CloseShoppingCart_Btn = "//a[@id='lastaddCartInfo']";
	public static final String SuccessMessage_WE = "//span[@id='successMsg']";
	public static final String DeleteServiceIcon_Btn = "(//a[@class = 'trash1'])[1]";
	public static final String TotalAmount_WE = "//span[@id = 'cartTotal']";
	public static final String DiscountAmount_WE = "//span[@id = 'cartDiscounted']";
	public static final String PayableAmount_WE = "//span[@id = 'cartPayable']";
	public static final String ContinueShoppingWhenCartEmpty_Btn = "//div[@id='sessionCartEmpty']/div/button";
	public static final String ContinueShoppingWithService_Btn = "//div[@id='sessionCartWithService']/div[6]/p/button";
	public static final String ProceedToCheckout_Btn = "//div[@id='sessionCartWithService']/div[6]/a/button";

	//Combo strip
	public static final String ElementID="recComboHead";
	public static final String ComboStrip_Btn="//a[@id='offer']";

	
}





