package com.naukri.FastForwardRevamp.TestSuite;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naukri.FastForwardRevamp.Code.EmptyCartPage;
import com.naukri.FastForwardRevamp.Code.HomePage;
import com.naukri.FastForwardRevamp.ConfigDetails.ConfigDetails;
import com.naukri.GenericFunctionsPack.GenericFunctions;
import com.naukri.datatable.Xls_Reader;

public class TestCases_EmptyCartPage extends ConfigDetails {
	Xls_Reader datatable;
	@BeforeMethod
	public void Before(){
		generic = new GenericFunctions(driver);
		driver = generic.StartDriver(Driver_Type);
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void CloseDriver()
	{
		driver.quit();
	}

	@DataProvider(name = "EmpCart_Services")
	public Object[][] DataProvider_EmpCart_Services()
	{
		datatable = new Xls_Reader(TestDataSheetPath_EmptyCart);
		int rowcount = datatable.getRowCount("sheet1");
		Object result[][] =new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData("sheet1", "Services",i );
			result[i-2][0] = i;	
		}
		return result;
	}
	//To verify service links visibility and landing on Empty cart page
	@Test (dataProvider = "EmpCart_Services")
	public void TC_EmptyCart_001(int row , String Services){
		EmptyCartPage Empty = new EmptyCartPage(driver, generic) ;
		Empty.EmptyCart();
		generic.GoToSleep(3000);
		String Xpath = "//div[@class='lstWrap']//a[text()='" + Services + "']";
		Assert.assertTrue(generic.isVisible(Xpath),"Fail Services Text : " + Services + " is not Visible!!");
		generic.Click(Xpath);
		generic.SwitchtoNewWindow();
		String result = generic.GetElementText(EmptyCartPage.Breadcrumb_WE);
		Assert.assertEquals(result, datatable.getCellData("sheet1", "Breadcrumb", row));
	}
	//To verify that on clicking Continue Shopping link it lands to Home page
	@Test
	public void TC_EmptyCart_002()
	{		
		EmptyCartPage Empty = new EmptyCartPage(driver, generic) ;
		Empty.EmptyCart();
		generic.GoToSleep(1000);
		generic.Click_Lnk(EmptyCartPage.ContinueShopping_Lnk);
		String result = generic.GetElementText_WE(HomePage.HP_Image_WE);
		result = result.replace("\n", " ");
		Assert.assertEquals("Speed Up Your Career with our personalized services",result);
	}
	//To verify that static content of empty cart page
	@Test
	public void TC_EmptyCart_003()
	{		
		EmptyCartPage Empty = new EmptyCartPage(driver, generic) ;
		Empty.EmptyCart();
		generic.GoToSleep(1000);
		String result = generic.GetElementText(EmptyCartPage.NoItemHeading_WE);
		Assert.assertEquals(result,"There are no items in this cart");

		//To verify that Continue Shopping link is displayed on Empty  Cart page

		result = generic.GetElementText(EmptyCartPage.ContinueShopping_Lnk);
		Assert.assertEquals(result,"Continue Shopping");

		//To verify that Take a look heading is displayed on Empty cart page

		result =generic.GetElementText(EmptyCartPage.TakeaLook_WE);
		Assert.assertEquals(result,"Take a look of our wide range of services");
	}

}
