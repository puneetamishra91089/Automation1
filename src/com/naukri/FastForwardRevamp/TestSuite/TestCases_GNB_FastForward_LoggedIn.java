package com.naukri.FastForwardRevamp.TestSuite;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naukri.FastForwardRevamp.Code.FastForwardGnb;
import com.naukri.FastForwardRevamp.Code.LoginLayer;
import com.naukri.FastForwardRevamp.ConfigDetails.ConfigDetails;
import com.naukri.FastForwardRevamp.ConfigDetails.URLProvider;
import com.naukri.GenericFunctionsPack.GenericFunctions;
import com.naukri.datatable.Xls_Reader;

public class TestCases_GNB_FastForward_LoggedIn extends ConfigDetails{
	Xls_Reader datatable;

	@BeforeMethod
	public void Before(){
		generic = new GenericFunctions(driver);
		driver = generic.StartDriver(Driver_Type);
		driver.manage().window().maximize();
		driver.get(URLProvider.Return_HomePageURL());
		LoginLayer loginLayer = new LoginLayer(driver, generic);
		generic.Click_Lnk(LoginLayer.GNB_Login_Lnk);
		loginLayer.Fillform_Login("Email", Email, Password);
	}


	@Test
	//To verify My services Link in Breadcrumb
	public void TC_FFGNBLoggedIn_001()
	{
		generic.GoToSleep(1000);
		String result = generic.GetElementText(FastForwardGnb.Myservices_Tab_Lnk);
		Assert.assertEquals(result, "My Services");
		generic.Click_Lnk(FastForwardGnb.Myservices_Tab_Lnk);
		String result1 = generic.GetElementText(FastForwardGnb.Myservices_Breadcrumb_WE);
		result1 =result1.replace("\n", "");
		Assert.assertEquals(result1, "Naukri FastForward > My Services");

	}


	@DataProvider(name = "Gnb_ResumeWriting")
	public Object[][] DataProvider_Gnb_ResumeWriting()
	{
		String SheetName = "Gnb_ResumeWriting_LoggedIn";
		datatable = new Xls_Reader(TestDataSheetPath_FastForward_Gnb);
		int rowcount = datatable.getRowCount(SheetName);
		Object result[][] =new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData(SheetName, "Expected_Links",i );
			result[i-2][0] = i;	
		}
		return result;
	}

	//To verify Resume Writing Section in GNB
	@Test (dataProvider = "Gnb_ResumeWriting")
	public void TC_FFGNBLoggedIn_002(int row , String LinkName){
		String SheetName = "Gnb_ResumeWriting_LoggedIn";
		generic.MouseHover(FastForwardGnb.ResumeWriting_WE);
		String Xpath = "//div[@id='nav']//a[text()='" + LinkName + "']";
		generic.GoToSleep(1000);
		generic.Click(Xpath);
		String ExpectedBreadCrum = datatable.getCellData(SheetName, "Expected_Breadcrum", row);
		Assert.assertEquals(generic.GetElementText_WE(FastForwardGnb.BreadCrumb_Common_WE), ExpectedBreadCrum);
	}
	
	@AfterMethod
	public void After(){
		driver.quit();
	}
}
