package com.naukri.FastForwardRevamp.Code;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naukri.GenericFunctionsPack.GenericFunctions;

public class ShoppingCart {
	public WebDriver driver;
	GenericFunctions generic;

	public ShoppingCart(WebDriver driver ,GenericFunctions generic)
	{
		this.driver = driver;
		this.generic = generic;		
	}
	public static final String Naukri_Lnk = "//a[@class='ffLogo fl']";
	public static final String OrderSummary_WE = "(//div[@class='catgry'])[1]";
	public static final String Login_WE = "(//div[@class='catgry'])[1]";
	public static final String PaymentMethods_WE = "//p[@class='catgry']";

	//Cart
	public static final String ServiceName_WE = "(//p[@class='hd pb10'])[1]";
	public static final String ServiceName2_WE = "(//span[@class='title'])[2]";
	public static final String ServicePrice1_WE = "//span[@class='txtPrc']";
	public static final String ServicePrice2_WE = "(//span[@class='txtPrc'])[2]";
	public static final String ServicePrice_WE = "//div[@class='hd grid3 grid']";
	public static final String Duration_WE = "//span[@class='onlDays']";
	public static final String Edit_Lnk = "//a[@class='blueLink mR editIt']";
	public static final String Remove_Lnk = "//a[@class='removeIt font_vsmall rem']";
	public static final String Subtotal_WE = "//span[@name='b4DisPrc']";
	public static final String DiscountApplied_WE = "(//p[@class='txtBrightRed font_16 mT10'])[1]";
	public static final String TotalPayableAmount_WE = "(//span[@name='totPrc'])[2]";
	public static final String Continue_Btn = "//a[@class='white_btn fl']";
	public static final String ProceedtoPayment_Btn = "//a[@id='proceed']";
	public static final String Deliverydays_WE = "//span[@class='onlDays']";
	public static final String InclusiveofallTaxes_WE = "//p[@class='font_medium mT10']";
	public static final String AdditionalInformation_WE = "//p[@id='forTop']";
	public static final String Update_Btn = "//a[@class='blueLink mR update']";
	public static final String Editoption1_Rdb = "(//div[@class='servcTime radioCol']/p/input)[1]";
	public static final String Editoption2_Rdb = "(//div[@class='servcTime radioCol']/p/input)[2]";
	public static final String Editoption3_Rdb = "(//div[@class='servcTime radioCol']/p/input)[3]";


	//Need Help Widget
	public static final String NeedHelp_WE = "//p[@class='hd']";
	public static final String CallUsfree_WE = "//div[@class='fl call font_medium']";
	public static final String BuySafeContent_WE = "//div[@class='fr pt30']";

	//Login Section Existing User

	public static final String Frame = "//iframe[@id='loginFrame']";
	public static final String ExistingNaukriUser_WE= "(//p[@class='font_14 pb15'])[1]";
	public static final String EmailId_WE = "(//form[@id='loginNaukri']//label)[1]";
	public static final String EmailOption_Rbn = "//input[@id='emailChk']";
	public static final String Username_WE = "(//form[@id='loginNaukri']//label)[2]";
	public static final String UsernameOption_Rdb = "//input[@id='usernameChk']";
	public static final String Email_Txt = "//input[@id='email_id']";
	public static final String Username_Txt = "//input[@id='userName']";
	public static final String Password_Txt = "//input[@id='password']";
	public static final String Continuetopay_Btn = "//input[@id='submitMembr']";
	public static final String Forgot_Lnk = "//a[text()='Forgot Login Details?']";
	public static final String SecurityInfo_WE = "//p[@class='sml']";
	public static final String ClickheretoLogin_Btn = "//a[@id='dspLoginPgBtn']";
	public static final String LoginErrorMessage_WE = "//div[@id='login_err']/small";

	//Login Section for new user

	public static final String NotRegisteredMember_WE = "(//p[@class='font_14 pb15'])[2]";
	public static final String CreateYourAccount_Btn = "//a[@id='regUsrBtn']";	 
	public static final String EmailId_Txt = "//input[@id='email_idN']";
	public static final String Mobile_Txt = "//input[@id='mobileN']";
	public static final String Pwd_Txt = "//input[@id='passwordN']";
	public static final String ConfirmPwd_Txt = "//input[@id='CnfirmPas']";
	public static final String NewAccountContinuetopay_Btn = "//input[@id='registerIt']";
	public static final String Login_NewUserErrorMessages_WE = "//form[@id='registerUser']//small[contains(@id,'_err')]";

	public static final String CreditCard_Btn = "(//ul[@class='tabs']/li)[1]";
	//	public static final String
	//	public static final String 
	//	public static final String
	//	public static final String
	//	public static final String
	//	public static final String
	//	public static final String
	//	public static final String
	public String CaptureErrors(){
		List<WebElement> WE = driver.findElements(By.xpath(Login_NewUserErrorMessages_WE));
		List<String> ErrorMessages = new ArrayList<String>();
		for (WebElement webElement : WE) {
			if(webElement.isDisplayed()){
				ErrorMessages.add(webElement.getText());
			}
		}

		String Errors = ErrorMessages.toString();
		Errors = Errors.replace("[", "");
		Errors = Errors.replace("]", "");

		System.out.println(Errors);
		return Errors;
	}
}
