package com.naukri.FastForwardRevamp.NaukriGNB;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naukri.FastForwardRevamp.Code.NaukriGNB;
import com.naukri.FastForwardRevamp.ConfigDetails.ConfigDetails;
import com.naukri.FastForwardRevamp.ConfigDetails.URLProvider;
import com.naukri.GenericFunctionsPack.GenericFunctions;
import com.naukri.datatable.Xls_Reader;

public class TestCases_NaukriGNB_NotLoggedIn extends ConfigDetails{
	@BeforeTest
	public void Before(){
		generic = new GenericFunctions(driver);
		driver = generic.StartDriver(Driver_Type);
		driver.manage().window().maximize();
	}
	@AfterTest
	public void CloseDriver()
	{
		driver.quit();
	}

	Xls_Reader datatable;
	@DataProvider(name= "NaukriGNB_Jobs")
	public Object[][] DataProvider_NaukriGNB_Jobs()
	{
		datatable = new Xls_Reader(TestDataSheetPath_NaukriGNB);
		int rowcount = datatable.getRowCount("Jobs");
		Object result[][] =new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData("Jobs", "Links",i );
			result[i-2][0] = i;	
		}
		return result;
	}
	//To verify  Naukri GNB Jobs section and their landings
	@Test(dataProvider = "NaukriGNB_Jobs")
	public void TC_GNBNL_001(int row ,String ExpectedLinks)
	{
		driver.get(URLProvider.Return_HomePageURL());
		generic.MouseHover(NaukriGNB.Naukri_JobsTab_Lnk);		
		String Xpath = "//a[@title='"+ExpectedLinks+"']";
		generic.Click(Xpath);
		generic.GoToSleep(1000);
		generic.SwitchtoNewWindow();
		String Element = datatable.getCellData("Jobs", "Landing_xpath", row);
		Assert.assertTrue(generic.isVisible(Element));
		driver.close();
		generic.SwitchtoOriginalWindow();
		
	}
	@DataProvider(name= "NaukriGNB_Recruiter")
	public Object[][] DataProvider_NaukriGNBRecruiter()
	{
		datatable = new Xls_Reader(TestDataSheetPath_NaukriGNB);
		int rowcount = datatable.getRowCount("Recruiters");
		Object result[][] =new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData("Recruiters", "Links",i );
			result[i-2][0] = i;	
		}
		return result;
	}
	//To verify  Naukri GNB Recruiters section and their landings
	@Test(dataProvider = "NaukriGNB_Recruiter")
	public void TC_GNBNL_002(int row ,String ExpectedLinks)
	{
		driver.get(URLProvider.Return_HomePageURL());
		generic.MouseHover(NaukriGNB.Naukri_RecruitersTab_Lnk);		
		String Xpath = "//a[@title='"+ExpectedLinks+"']";
		generic.Click(Xpath);
		generic.GoToSleep(1000);
		generic.SwitchtoNewWindow();
		String Element = datatable.getCellData("Recruiters", "Landing_xpath", row);
		Assert.assertTrue(generic.isVisible(Element));	
		driver.close();
		generic.SwitchtoOriginalWindow();

	}
	@DataProvider(name= "NaukriGNB_Services")
	public Object[][] DataProvider_NaukriGNBServices()
	{
		datatable = new Xls_Reader(TestDataSheetPath_NaukriGNB);
		int rowcount = datatable.getRowCount("Services");
		Object result[][] =new Object[rowcount-1][3];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData("Services", "Links",i );
			result[i-2][0] = i;	
			result[i-2][2]= datatable.getCellData("Services", "Link_Type",i );		}
		return result;
	}

	//To verify  Naukri GNB Services Section and their landings in Logged In state
	@Test(dataProvider = "NaukriGNB_Services")
	public void TC_GNBNL_003(int row ,String ExpectedLinks, String Link_Type)
	{
		driver.get(URLProvider.Return_HomePageURL());
		if(Link_Type.equalsIgnoreCase("Static"))
		{
			generic.MouseHover(NaukriGNB.Naukri_ServicesTab_Lnk);
			String Xpath= "//div[@class='subMenu c3']//a[text()='"+ExpectedLinks+"']";
			String Result = generic.GetElementText(Xpath);
			Assert.assertEquals(Result, datatable.getCellData("Services", "Links", row));
		}
		else
			if(Link_Type.equalsIgnoreCase("ServicesLink"))
		{
			String Xpath = "//a[@title='"+ExpectedLinks+"']";
			generic.MouseHover(NaukriGNB.Naukri_ServicesTab_Lnk);
			generic.Click(Xpath);
			generic.GoToSleep(1000);
			generic.SwitchtoNewWindow();
			String ExpectedBreadcrumb = generic.GetElementText(NaukriGNB.Services_Breadcrumb_WE);
			driver.close();
			generic.SwitchtoOriginalWindow();
			Assert.assertEquals(ExpectedBreadcrumb, datatable.getCellData("Services", "Breadcrumb", row));
		}
//		else
//		{
//			String Xpath = "//a[@title='"+ExpectedLinks+"']";
//			generic.MouseHover(NaukriGNB.Naukri_ServicesTab_Lnk);
//			generic.Click(Xpath);
//			generic.GoToSleep(1000);
//			generic.SwitchtoNewWindow();
//			String ExpectedBreadcrumb = generic.GetElementText(NaukriGNB.ServicesOther_Breadcrumb_WE);
//			driver.close();
//			generic.SwitchtoOriginalWindow();
//			Assert.assertEquals(ExpectedBreadcrumb, datatable.getCellData("Services", "Breadcrumb", row));
//		}
	}

	@DataProvider(name= "NaukriGNB_More")
	public Object[][] DataProvider_NaukriGNBMore()
	{
		datatable = new Xls_Reader(TestDataSheetPath_NaukriGNB);
		int rowcount = datatable.getRowCount("More");
		Object result[][] =new Object[rowcount-1][3];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData("More", "Links",i );
			result[i-2][0] = i;	
			result[i-2][2]= datatable.getCellData("More", "Link_Type",i );		}
		return result;
	}
	//To verify  Naukri GNB More Section and their landings
	@Test(dataProvider = "NaukriGNB_More")
	public void TC_GNBNL_004(int row ,String ExpectedLinks, String Link_Type)
	{
		driver.get(URLProvider.Return_HomePageURL());
		if(Link_Type.equalsIgnoreCase("Static"))
		{
			generic.MouseHover(NaukriGNB.Naukri_MoreTab_Lnk);
			String Xpath= "(//div[@class='subMenu c3'])[2]//a[text()='"+ExpectedLinks+"']";
			String Result = generic.GetElementText(Xpath);
			Assert.assertEquals(Result, datatable.getCellData("More", "Links", row));
		}
		else
		{
			String Xpath = "//a[@title='"+ExpectedLinks+"']";
			generic.MouseHover(NaukriGNB.Naukri_MoreTab_Lnk);
			generic.Click(Xpath);
			generic.GoToSleep(1000);
			generic.SwitchtoNewWindow();
			String Element = datatable.getCellData("More", "Landing_xpath", row);
			Assert.assertTrue(generic.isVisible(Element));	
			driver.close();
			generic.SwitchtoOriginalWindow();
		}
	}

	@DataProvider(name= "NaukriGNBTabs")
	public Object[][] DataProvider_NaukriGNBTabs()
	{
		datatable = new Xls_Reader(TestDataSheetPath_NaukriGNB);
		int rowcount = datatable.getRowCount("Naukri GNB tabs");
		Object result[][] =new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData("Naukri GNB tabs", "Links",i );
			result[i-2][0] = i;}	
		return result;
	}
	//To verify  Naukri GNB tabs and their landings
	@Test(dataProvider = "NaukriGNBTabs")
	public void TC_GNBNL_005(int row ,String ExpectedLinks)
	{
		driver.get(URLProvider.Return_HomePageURL());
		String Xpath= "//div[@class='headGNBWrap']//div[text()='"+ExpectedLinks+"']";
		generic.Click(Xpath);
		generic.SwitchtoNewWindow();
		String Element = datatable.getCellData("Naukri GNB tabs", "Landing_xpath", row);
		Assert.assertTrue(generic.isVisible(Element));
		driver.close();
		generic.SwitchtoOriginalWindow();
	}
	
}
