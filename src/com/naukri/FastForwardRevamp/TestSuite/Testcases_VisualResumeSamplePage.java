package com.naukri.FastForwardRevamp.TestSuite;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naukri.FastForwardRevamp.Code.ResumeQualityScorePage;
import com.naukri.FastForwardRevamp.Code.TextResumeSamplePage;
import com.naukri.FastForwardRevamp.Code.VisualResumePage;
import com.naukri.FastForwardRevamp.Code.VisualResumeSamplePage;
import com.naukri.FastForwardRevamp.ConfigDetails.ConfigDetails;
import com.naukri.FastForwardRevamp.ConfigDetails.URLProvider;
import com.naukri.GenericFunctionsPack.GenericFunctions;
import com.naukri.datatable.Xls_Reader;

public class Testcases_VisualResumeSamplePage extends ConfigDetails{
	@BeforeMethod
	public void Before(){
		generic = new GenericFunctions(driver);
		driver = generic.StartDriver(Driver_Type);
		driver.manage().window().maximize();
		driver.get(URLProvider.Return_VisualResumeSampleURL());	
	}

	@AfterMethod
	public void CloseDriver()
	{
		driver.quit();
	}
	Xls_Reader datatable;
	@Test
	//To verify that on clicking Naukri Link in Breadcrumb it lands to Home page
	public void TC_VRS_001()
	{
		generic.Click(VisualResumeSamplePage.Naukri_Link);
		String Result = driver.getCurrentUrl();
		Assert.assertEquals(Result,URLProvider.Return_HomePageURL());
	}

	@Test
	//To verify that Visual Resume Sample static content is displayed
	public void TC_VRS_002()
	{
		String Result = generic.GetElementText(VisualResumeSamplePage.Breadcrumb_WE);
		Assert.assertEquals(Result,"Naukri FastForward > Visual Resume Sample");

		//To verify that Visual Resume Sample Heading and content is displayed on Visual Resume Sample Page
		Result = generic.GetElementText(VisualResumeSamplePage.VisualResumeSampleHeading_WE);
		Assert.assertEquals(Result,"Visual Resume Sample");
		Result = generic.GetElementText(VisualResumeSamplePage.HeroLineContent_WE);
		Assert.assertEquals(Result,"A versatile, high-energy app developer worked on prestigious projects and nearly 5 years of experience in Software Development, Application Management & Support and Project Execution.");

		//To verify that Know where your Resume stands is displayed on Visual Resume Sample Page

		Result = generic.GetElementText(VisualResumeSamplePage.KnowWherYourResumeSatnds_WE);
		Assert.assertEquals(Result,"Know where your Resume stands");

		//To verify that Visual Resume Sample Heading and Samples are displayed on Visual Resume Sample Page

		generic.Click(VisualResumeSamplePage.EntryLevel_Lnk);
		Result = generic.GetElementText(VisualResumeSamplePage.SeeResumeSampleHeading_WE);
		Assert.assertEquals(Result,"Visual Resume for Freshers/Entry Level");
		Assert.assertTrue(generic.isPresent(VisualResumeSamplePage.ResumeImage_WE));
		generic.Click(VisualResumeSamplePage.MidLevel_Lnk);
		Result = generic.GetElementText(VisualResumeSamplePage.SeeResumeSampleHeading_WE);
		Assert.assertEquals(Result,"Visual Resume for Experienced Professionals");
		Assert.assertTrue(generic.isPresent(VisualResumeSamplePage.ResumeImage_WE));
		generic.Click(VisualResumeSamplePage.SeniorLevel_Lnk);
		Result = generic.GetElementText(VisualResumeSamplePage.SeeResumeSampleHeading_WE);
		Assert.assertEquals(Result,"Visual Resume for Senior Level Professionals");
		Assert.assertTrue(generic.isPresent(VisualResumeSamplePage.ResumeImage_WE));		

		//To verify that I want to improve my Resume heading is displayed on Visual Resume Display page

		Result = generic.GetElementText(VisualResumeSamplePage.IWantToImproverHeading_WE);
		Assert.assertEquals(Result,"I want to improve my Resume");


		//To verify that Text Resume Sample heading is displayed on Resume Sample Accordion Widget

		Result = generic.GetElementText(VisualResumeSamplePage.TextResumeSample_WE);
		Assert.assertEquals(Result, "Text Resume Sample");
	}

	@Test
	//To verify on clicking Check your CV Score it lands to Resume Quality Score page
	public void TC_VRS_003()
	{
		generic.Click(VisualResumeSamplePage.CheckYourCV_Lnk);
		generic.SwitchtoNewWindow();
		String Result = generic.GetElementText_WE(ResumeQualityScorePage.Breadcrum_WE);
		Assert.assertEquals(Result,"Naukri FastForward > Resume Quality Score");
	}
	@DataProvider(name="Visual Resume Writing price")
	public Object[][] Dataprovider_VisualResumeWriting()
	{
		datatable = new Xls_Reader(TestDataSheetPath_VisualResumeSample);
		int rowcount = datatable.getRowCount("Experience");
		Object[][] result = new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData("Experience", "Experience",i );
			result[i-2][0] = i;			
		}
		return result;
	}
	@Test(dataProvider = "Visual Resume Writing price")
	//To verify that on selecting Experience Visual Resume Writing Prices and Up selling Content and Hero Line Content are displayed
	public void TC_VRS_004(int Row, String Experience)
	{
		driver.get(URLProvider.Return_VisualResumeSampleURL());	
		datatable = new Xls_Reader(TestDataSheetPath_VisualResumeSample);
		generic.Click(VisualResumeSamplePage.Experience_DD);
		String xpath = "//div[@class='matchParent content']/ul/li[@id='"+Experience+"']";
		generic.Click(xpath);
		generic.GoToSleep(2000);
		String UpsellingContent = generic.GetElementText(VisualResumeSamplePage.IWantToImproverContent_WE);
		Assert.assertEquals(UpsellingContent,datatable.getCellData("Experience", "UpsellingContent", Row));
		String Price = generic.GetElementText(VisualResumeSamplePage.Price_WE);
		Assert.assertEquals(Price,datatable.getCellData("Experience", "Price", Row));
	}
	@Test(dataProvider = "Visual Resume Writing price")
	//To verify that on selecting Experience it lands to respective Visual resume writing page
	public void TC_VRS_005(int Row, String Experience)
	{
		driver.get(URLProvider.Return_VisualResumeSampleURL());
		datatable = new Xls_Reader(TestDataSheetPath_VisualResumeSample);
		generic.Click(VisualResumeSamplePage.Experience_DD);
		String xpath = "//div[@class='matchParent content']/ul/li[@id='"+Experience+"']";
		generic.Click(xpath);
		generic.Click(VisualResumeSamplePage.BuyNow_lnk);
		String Result = generic.GetElementText(VisualResumePage.Breadcrum_WE);
		Assert.assertEquals(Result,datatable.getCellData("Experience", "BreadCrumb", Row));
	}


	@DataProvider(name="Resume IT")
	public Object[][] Dataprovider_IT()
	{
		datatable = new Xls_Reader(TestDataSheetPath_VisualResumeSample);
		int rowcount = datatable.getRowCount("IT");
		Object[][] result = new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData("IT", "LinkName",i );
			result[i-2][0] = i;			
		}
		return result;
	}

	@Test(dataProvider = "Resume IT")
	//To verify that Accordion Widget IT Domains are displayed on resume sample Functional area page
	public void TC_VRS_006(int Row,String LinkName)
	{
		driver.get(URLProvider.Return_VisualResumeSampleURL());
		generic.Click(VisualResumeSamplePage.IT_FunctionalArea_WE);
		String xpath = "//a[@title='"+LinkName+" Resume Samples"+"']";
		generic.Click(xpath);
		String result = generic.GetElementText(TextResumeSamplePage.Breadcrumb_WE);
		Assert.assertEquals(result, datatable.getCellData("IT", "BreadCrumb", Row));
	}
	@DataProvider(name="Resume HR")
	public Object[][] Dataprovider_HR()
	{
		datatable = new Xls_Reader(TestDataSheetPath_VisualResumeSample);
		int rowcount = datatable.getRowCount("HR");
		Object[][] result = new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData("HR", "LinkName",i );
			result[i-2][0] = i;			
		}
		return result;
	}
	@Test(dataProvider = "Resume HR")
	//To verify that Accordion Widget HR Domains are displayed on resume sample Functional area page
	public void TC_VRS_007(int Row,String LinkName)
	{
		driver.get(URLProvider.Return_VisualResumeSampleURL());
		generic.Click(VisualResumeSamplePage.HR_FunctionalArea_WE);
		String xpath = "//a[@title='"+LinkName+" Resume Samples"+"']";
		generic.Click(xpath);
		String Result = generic.GetElementText(TextResumeSamplePage.Breadcrumb_WE);
		Assert.assertEquals(Result, datatable.getCellData("HR", "BreadCrumb", Row));
	}
	@DataProvider(name="Resume Banking and Finance")
	public Object[][] Dataprovider_BankingandFinance()
	{
		datatable = new Xls_Reader(TestDataSheetPath_VisualResumeSample);
		int rowcount = datatable.getRowCount("Banking and Finance");
		Object[][] result = new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData("Banking and Finance", "LinkName",i );
			result[i-2][0] = i;			
		}
		return result;
	}
	@Test(dataProvider = "Resume Banking and Finance")
	//To verify that Accordion Widget Banking and Finance Domains are displayed on resume sample Functional area page
	public void TC_VRS_008(int Row,String LinkName)
	{
		driver.get(URLProvider.Return_VisualResumeSampleURL());
		generic.Click(VisualResumeSamplePage.BankingFinance_FunctionalArea_WE);
		String xpath = "//a[@title='"+LinkName+" Resume Samples"+"']";
		generic.Click(xpath);
		String Result = generic.GetElementText(TextResumeSamplePage.Breadcrumb_WE);
		Assert.assertEquals(Result, datatable.getCellData("Banking and Finance", "BreadCrumb", Row));
	}
	@DataProvider(name="Resume Automobile")
	public Object[][] Dataprovider_Automobile()
	{
		datatable = new Xls_Reader(TestDataSheetPath_VisualResumeSample);
		int rowcount = datatable.getRowCount("Automobile");
		Object[][] result = new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData("Automobile", "LinkName",i );
			result[i-2][0] = i;			
		}
		return result;
	}
	@Test(dataProvider = "Resume Automobile")
	//To verify that Accordion Widget Automobile Domains are displayed on resume sample Functional area page
	public void TC_VRS_009(int Row,String LinkName)
	{
		driver.get(URLProvider.Return_VisualResumeSampleURL());
		generic.Click(VisualResumeSamplePage.Automobile_FunctionalArea_WE);
		String xpath = "//a[@title='"+LinkName+" Resume Samples"+"']";
		generic.Click(xpath);
		String Result = generic.GetElementText(TextResumeSamplePage.Breadcrumb_WE);
		Assert.assertEquals(Result, datatable.getCellData("Automobile", "BreadCrumb", Row));
	}
	@DataProvider(name="Resume Marketing")
	public Object[][] Dataprovider_Marketing()
	{
		datatable = new Xls_Reader(TestDataSheetPath_VisualResumeSample);
		int rowcount = datatable.getRowCount("Marketing");
		Object[][] result = new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData("Marketing", "LinkName",i );
			result[i-2][0] = i;			
		}
		return result;
	}
	@Test(dataProvider = "Resume Marketing")
	//To verify that Accordion Widget Marketing Domains are displayed on resume sample Functional area page
	public void TC_VRS_010(int Row,String LinkName)
	{
		driver.get(URLProvider.Return_VisualResumeSampleURL());
		generic.Click(VisualResumeSamplePage.Marketing_FunctionalArea_WE);
		String xpath = "//a[@title='"+LinkName+" Resume Samples"+"']";
		generic.Click(xpath);
		String Result = generic.GetElementText(TextResumeSamplePage.Breadcrumb_WE);
		Assert.assertEquals(Result, datatable.getCellData("Marketing", "BreadCrumb", Row));
	}
	@DataProvider(name="Resume Operations")
	public Object[][] Dataprovider_Operations()
	{
		datatable = new Xls_Reader(TestDataSheetPath_VisualResumeSample);
		int rowcount = datatable.getRowCount("Operations");
		Object[][] result = new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData("Operations", "LinkName",i );
			result[i-2][0] = i;			
		}
		return result;
	}
	@Test(dataProvider = "Resume Operations")
	//To verify that Accordion Widget Operation Domains are displayed on resume sample Functional area page
	public void TC_VRS_011(int Row,String LinkName)
	{
		driver.get(URLProvider.Return_VisualResumeSampleURL());
		generic.Click(VisualResumeSamplePage.Operations_FunctionalArea_WE);
		String xpath = "//a[@title='"+LinkName+" Resume Samples"+"']";
		generic.Click(xpath);
		String Result = generic.GetElementText(TextResumeSamplePage.Breadcrumb_WE);
		Assert.assertEquals(Result, datatable.getCellData("Operations", "BreadCrumb", Row));
	}
	@DataProvider(name="Resume Productions")
	public Object[][] Dataprovider_Productions()
	{
		datatable = new Xls_Reader(TestDataSheetPath_VisualResumeSample);
		int rowcount = datatable.getRowCount("Productions");
		Object[][] result = new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData("Productions", "LinkName",i );
			result[i-2][0] = i;			
		}
		return result;
	}
	@Test(dataProvider = "Resume Productions")
	//To verify that Accordion Widget Production Domains are displayed on resume sample Functional area page
	public void TC_VRS_012(int Row,String LinkName)
	{
		driver.get(URLProvider.Return_VisualResumeSampleURL());
		generic.Click(VisualResumeSamplePage.Production_FunctionalArea_WE);
		String xpath = "//a[@title='"+LinkName+" Resume Samples"+"']";
		generic.Click(xpath);
		String Result = generic.GetElementText(TextResumeSamplePage.Breadcrumb_WE);
		Assert.assertEquals(Result, datatable.getCellData("Productions", "BreadCrumb", Row));
	}
	@DataProvider(name="Resume Sales")
	public Object[][] Dataprovider_Sales()
	{
		datatable = new Xls_Reader(TestDataSheetPath_VisualResumeSample);
		int rowcount = datatable.getRowCount("Sales");
		Object[][] result = new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData("Sales", "LinkName",i );
			result[i-2][0] = i;			
		}
		return result;
	}
	@Test(dataProvider = "Resume Sales")
	//To verify that Accordion Widget Sales Domains are displayed on resume sample Functional area page
	public void TC_VRS_013(int Row,String LinkName)
	{
		driver.get(URLProvider.Return_VisualResumeSampleURL());
		generic.Click(VisualResumeSamplePage.Sales_FunctionalArea_WE);
		String xpath = "//a[@title='"+LinkName+" Resume Samples"+"']";
		generic.Click(xpath);
		String Result = generic.GetElementText(TextResumeSamplePage.Breadcrumb_WE);
		Assert.assertEquals(Result, datatable.getCellData("Sales", "BreadCrumb", Row));
	}
	@DataProvider(name="Resume OtherResume")
	public Object[][] Dataprovider_OtherResume()
	{
		datatable = new Xls_Reader(TestDataSheetPath_VisualResumeSample);
		int rowcount = datatable.getRowCount("Other Resumes");
		Object[][] result = new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData("Other Resumes", "LinkName",i );
			result[i-2][0] = i;			
		}
		return result;
	}
	@Test(dataProvider = "Resume OtherResume")
	//To verify that Accordion Widget Other Resume Domains are displayed on resume sample Functional area page
	public void TC_VRS_014(int Row,String LinkName)
	{
		driver.get(URLProvider.Return_VisualResumeSampleURL());
		generic.Click(VisualResumeSamplePage.OtherResume_FunctionalArea_WE);
		String xpath = "//a[@title='"+LinkName+" Resume Samples"+"']";
		generic.Click(xpath);
		String Result = generic.GetElementText(TextResumeSamplePage.Breadcrumb_WE);
		Assert.assertEquals(Result, datatable.getCellData("Other Resumes", "BreadCrumb", Row));
	}


}
