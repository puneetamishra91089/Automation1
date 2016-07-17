package com.naukri.FastForwardRevamp.Code;

import org.openqa.selenium.WebDriver;

import com.naukri.FastForwardRevamp.ConfigDetails.URLProvider;
import com.naukri.GenericFunctionsPack.GenericFunctions;

public class EmptyCartPage {
	public WebDriver driver;
	GenericFunctions generic;
	public EmptyCartPage(WebDriver driver,GenericFunctions generic)
	{
		this.driver=driver;
		this.generic = generic;
	}
	public static final String NoItemHeading_WE = "//div[@class='bglightGray txtCentr bdrB']/p";
	public static final String ContinueShopping_Lnk = "//div[@class='bglightGray txtCentr bdrB']/a";
	public static final String TakeaLook_WE = "//p[@class='gryHd pb10']";
	public static final String Breadcrumb_WE = "//div[@class='wrap breadCrmb']";	
	
	public void EmptyCart()
	{
		driver.get(URLProvider.Return_ResumeDisplayURL());
		generic.Click(ResumeDisplayPage.AddtoCart_Btn);
		generic.Click(ShoppingCart.Remove_Lnk);
	}
}
