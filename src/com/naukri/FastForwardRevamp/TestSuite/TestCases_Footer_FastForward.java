package com.naukri.FastForwardRevamp.TestSuite;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naukri.FastForwardRevamp.Code.Footer;
import com.naukri.FastForwardRevamp.ConfigDetails.ConfigDetails;
import com.naukri.FastForwardRevamp.ConfigDetails.URLProvider;
import com.naukri.GenericFunctionsPack.GenericFunctions;
import com.naukri.datatable.Xls_Reader;

public class TestCases_Footer_FastForward extends ConfigDetails{
	Xls_Reader datatable;
	String SheetName = "Footer";

	@BeforeMethod
	public void Before(){
		generic = new GenericFunctions(driver);
		driver = generic.StartDriver(Driver_Type);
		driver.manage().window().maximize();
		datatable = new Xls_Reader(TestDataSheetPath_Footer);
	}
	@DataProvider(name="Footer")
	public Object[][] FetchFooter_Links()
	{
		datatable = new Xls_Reader(TestDataSheetPath_Footer);
		int rowcount = datatable.getRowCount(SheetName);
		Object[][] result = new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData(SheetName, "Expected_Links",i );
			result[i-2][0] = i;			
		}
		return result;
	}
	//To verify footer links landings 
	@Test (dataProvider = "Footer")
	public void TC_Footer_001(int row , String LinkName){
		driver.get(URLProvider.Return_HomePageURL());

		if(datatable.getCellData(SheetName, "Link_Type", row).equalsIgnoreCase("Static")){
			String Xpath = "//footer[@class='bgBlack']//p[text()='" + LinkName + "']";
			Assert.assertTrue(generic.isVisible(Xpath),"Fail Static Footer Text : " + LinkName + " is not Visible!!");
		}

		else {
			String Xpath = "//footer[@class='bgBlack']//a[text()='" + LinkName + "']";
			Assert.assertTrue(generic.isVisible(Xpath),"Fail Footer Link : " + LinkName + " is not Visible!!");
			generic.Click(Xpath);
			String ExpectedBreadCrum = datatable.getCellData(SheetName, "Expected_Breadcrum", row);
			if(LinkName.equalsIgnoreCase("Provide your feedback"))
				Assert.assertEquals(generic.GetElementText_WE(Footer.BreadCrumb_Feedback_WE), ExpectedBreadCrum);
			else
				Assert.assertEquals(generic.GetElementText_WE(Footer.BreadCrumb_Common_WE), ExpectedBreadCrum);
		}
	}

	//To verify Twitter Link in footer
	@Test
	public void TC_Footer_002(){
		driver.get(URLProvider.Return_HomePageURL());
		Assert.assertTrue(generic.isVisible(Footer.Footer_TwitterLink_Lnk),"Fail Twitter Link and Image in Footer not Visible!!");
		generic.Click(Footer.Footer_TwitterLink_Lnk);
		generic.SwitchtoNewWindow();
		Assert.assertTrue(generic.isVisible(Footer.Validate_TwitterLinkLanding_WE),"Clicking Twitter link landing Improper!!");

	}

	@AfterMethod
	public void After(){
		driver.quit();
	}

}
