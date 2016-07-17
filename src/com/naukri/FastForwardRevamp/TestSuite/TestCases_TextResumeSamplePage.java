package com.naukri.FastForwardRevamp.TestSuite;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naukri.FastForwardRevamp.Code.ResumeQualityScorePage;
import com.naukri.FastForwardRevamp.Code.TextResumePage;
import com.naukri.FastForwardRevamp.Code.TextResumeSamplePage;
import com.naukri.FastForwardRevamp.ConfigDetails.ConfigDetails;
import com.naukri.FastForwardRevamp.ConfigDetails.URLProvider;
import com.naukri.GenericFunctionsPack.GenericFunctions;
import com.naukri.datatable.Xls_Reader;

public class TestCases_TextResumeSamplePage extends ConfigDetails{
	@BeforeMethod
	public void Before(){
		generic = new GenericFunctions(driver);
		driver = generic.StartDriver(Driver_Type);
		driver.manage().window().maximize();
		driver.get(URLProvider.Return_ResumeSampleURL());	
	}

	@AfterMethod
	public void CloseDriver()
	{
		driver.quit();
	}
	Xls_Reader datatable;


	@Test
	//To verify that on clicking Naukri Link in Breadcrumb it lands to Home page
	public void TC_TRS_001()
	{
		generic.Click(TextResumeSamplePage.Naukri_Link);
		String Result = driver.getCurrentUrl();
		Assert.assertEquals(Result,URLProvider.Return_HomePageURL());
	}

	@Test
	//To verify on clicking Check your CV Score it lands to Resume Quality Score page
	public void TC_TRS_002()
	{
		generic.Click(TextResumeSamplePage.CheckYourCV_Lnk);
		generic.SwitchtoNewWindow();
		String Result = generic.GetElementText_WE(ResumeQualityScorePage.Breadcrum_WE);
		Assert.assertEquals(Result,"Naukri FastForward > Resume Quality Score");
	}

	@DataProvider(name="Resume Writing price")
	public Object[][] Dataprovider_ResumeWriting()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ResumeSample);
		int rowcount = datatable.getRowCount("Experience");
		Object[][] result = new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData("Experience", "Experience",i );
			result[i-2][0] = i;			
		}
		return result;
	}
	@Test(dataProvider = "Resume Writing price")
	//To verify that on selecting Experience Resume Writing Prices and Up selling Content and Hero Line Content are displayed
	public void TC_TRS_003(int Row, String Experience)
	{
		datatable = new Xls_Reader(TestDataSheetPath_ResumeSample);
		generic.Click(TextResumeSamplePage.Experience_DD);
		String xpath = "//div[@class='nScroll']/ul/li[@id='"+Experience+"']";
		generic.Click(xpath);
		String UpsellingContent = generic.GetElementText(TextResumeSamplePage.IWantToImproverContent_WE);
		System.out.println("1");
		Assert.assertEquals(UpsellingContent,datatable.getCellData("Experience", "UpsellingContent", Row));
		String Price = generic.GetElementText(TextResumeSamplePage.Price_WE);
		Assert.assertEquals(Price,datatable.getCellData("Experience", "Price", Row));
		String HeroLineContent = generic.GetElementText(TextResumeSamplePage.HeroLineContent_WE);
		Assert.assertEquals(HeroLineContent,datatable.getCellData("Experience", "HeroLineContent", Row));
	}
	@Test(dataProvider = "Resume Writing price")
	//To verify that on selecting Experience it lands to respective resume writing page
	public void TC_TRS_004(int Row, String Experience)
	{
		datatable = new Xls_Reader(TestDataSheetPath_ResumeSample);
		generic.Click(TextResumeSamplePage.Experience_DD);
		String xpath = "//div[@class='nScroll']/ul/li[@id='"+Experience+"']";
		generic.Click(xpath);
		generic.Click(TextResumeSamplePage.BuyNow_lnk);
		String Result = generic.GetElementText(TextResumePage.Breadcrum_WE);
		Assert.assertEquals(Result,datatable.getCellData("Experience", "BreadCrumb", Row));

	}
	@DataProvider(name="Resume IT")
	public Object[][] Dataprovider_IT()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ResumeSample);
		int rowcount = datatable.getRowCount("IT");
		Object[][] result = new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData("IT", "LinkName",i );
			result[i-2][0] = i;			
		}
		return result;
	}
	@Test(dataProvider = "Resume IT")
	//To verify the Bread crumbs and landings of IT Domains on Resume Sample Page
	public void TC_TRS_005(int Row,String LinkName)
	{
		String Xpath = "//a[text()='" + LinkName +" Resume"+ "']";
		generic.Click(Xpath);
		String BreadCrumb = generic.GetElementText_WE(TextResumeSamplePage.Breadcrumb_WE);
		System.out.println(BreadCrumb);
		String ResumeSampleHeading = generic.GetElementText(TextResumeSamplePage.CourseResumeSampleHeading_WE);
		Assert.assertEquals(ResumeSampleHeading,LinkName + " Resume Samples");
		Assert.assertEquals(datatable.getCellData("IT", "BreadCrumb", Row), BreadCrumb);
	}	
	@DataProvider(name="Resume HR")
	public Object[][] Dataprovider_HR()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ResumeSample);
		int rowcount = datatable.getRowCount("HR");
		Object[][] result = new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData("HR", "LinkName",i );
			result[i-2][0] = i;			
		}
		return result;
	}
	@Test(dataProvider = "Resume HR")
	//To verify the Bread crumbs and landings of HR Domains on Resume Sample Page
	public void TC_TRS_006(int Row,String LinkName)
	{
		String Xpath = "//a[text()='" + LinkName +" Resume"+ "']";;
		generic.Click(Xpath);
		String BreadCrumb = generic.GetElementText_WE(TextResumeSamplePage.Breadcrumb_WE);
		String ResumeSampleHeading = generic.GetElementText(TextResumeSamplePage.CourseResumeSampleHeading_WE);
		Assert.assertEquals(ResumeSampleHeading,LinkName + " Resume Samples");
		Assert.assertEquals(datatable.getCellData("HR", "BreadCrumb", Row), BreadCrumb);

	}
	@DataProvider(name="Resume Banking and Finance")
	public Object[][] Dataprovider_BankingandFinance()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ResumeSample);
		int rowcount = datatable.getRowCount("Banking and Finance");
		Object[][] result = new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData("Banking and Finance", "LinkName",i );
			result[i-2][0] = i;			
		}
		return result;
	}
	@Test(dataProvider = "Resume Banking and Finance")
	//To verify the Bread crumbs and landings of Banking and Finance Domains on Resume Sample Page
	public void TC_TRS_007(int Row,String LinkName)
	{
		String Xpath = "//a[text()='" + LinkName +" Resume"+ "']";;
		generic.Click(Xpath);
		String BreadCrumb = generic.GetElementText_WE(TextResumeSamplePage.Breadcrumb_WE);
		String ResumeSampleHeading = generic.GetElementText(TextResumeSamplePage.CourseResumeSampleHeading_WE);
		Assert.assertEquals(ResumeSampleHeading,LinkName + " Resume Samples");
		Assert.assertEquals(datatable.getCellData("Banking and Finance", "BreadCrumb", Row), BreadCrumb);
	}	
	@DataProvider(name="Resume Automobile")
	public Object[][] Dataprovider_Automobile()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ResumeSample);
		int rowcount = datatable.getRowCount("Automobile");
		Object[][] result = new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData("Automobile", "LinkName",i );
			result[i-2][0] = i;			
		}
		return result;
	}
	@Test(dataProvider = "Resume Automobile")
	//To verify the Bread crumbs and landings of Automobile Domains on Resume Sample Page
	public void TC_TRS_008(int Row,String LinkName)
	{
		String Xpath = "//a[text()='" + LinkName +" Resume"+ "']";;
		generic.Click(Xpath);
		String BreadCrumb = generic.GetElementText_WE(TextResumeSamplePage.Breadcrumb_WE);
		String ResumeSampleHeading = generic.GetElementText(TextResumeSamplePage.CourseResumeSampleHeading_WE);
		Assert.assertEquals(ResumeSampleHeading,LinkName + " Resume Samples");
		Assert.assertEquals(datatable.getCellData("Automobile", "BreadCrumb", Row), BreadCrumb);
	}
	@DataProvider(name="Resume Marketing")
	public Object[][] Dataprovider_Marketing()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ResumeSample);
		int rowcount = datatable.getRowCount("Marketing");
		Object[][] result = new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData("Marketing", "LinkName",i );
			result[i-2][0] = i;			
		}
		return result;
	}
	@Test(dataProvider = "Resume Marketing")
	//To verify the Bread crumbs and landings of Marketing Domains on Resume Sample Page
	public void TC_TRS_009(int Row,String LinkName)
	{
		String Xpath = "//a[text()='" + LinkName +" Resume"+ "']";;
		generic.Click(Xpath);
		String BreadCrumb = generic.GetElementText_WE(TextResumeSamplePage.Breadcrumb_WE);
		String ResumeSampleHeading = generic.GetElementText(TextResumeSamplePage.CourseResumeSampleHeading_WE);
		Assert.assertEquals(ResumeSampleHeading,LinkName + " Resume Samples");
		Assert.assertEquals(datatable.getCellData("Marketing", "BreadCrumb", Row), BreadCrumb);
	}
	@DataProvider(name="Resume Operations")
	public Object[][] Dataprovider_Operations()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ResumeSample);
		int rowcount = datatable.getRowCount("Operations");
		Object[][] result = new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData("Operations", "LinkName",i );
			result[i-2][0] = i;			
		}
		return result;
	}
	@Test(dataProvider = "Resume Operations")
	//To verify the Bread crumbs and landings of Operations Domains on Resume Sample Page
	public void TC_TRS_010(int Row,String LinkName)
	{
		String Xpath = "//a[text()='" + LinkName +" Resume"+ "']";;
		generic.Click(Xpath);
		String BreadCrumb = generic.GetElementText_WE(TextResumeSamplePage.Breadcrumb_WE);
		String ResumeSampleHeading = generic.GetElementText(TextResumeSamplePage.CourseResumeSampleHeading_WE);
		Assert.assertEquals(ResumeSampleHeading,LinkName + " Resume Samples");
		Assert.assertEquals(datatable.getCellData("Operations", "BreadCrumb", Row), BreadCrumb);
	}
	@DataProvider(name="Resume Productions")
	public Object[][] Dataprovider_Productions()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ResumeSample);
		int rowcount = datatable.getRowCount("Productions");
		Object[][] result = new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData("Productions", "LinkName",i );
			result[i-2][0] = i;			
		}
		return result;
	}
	@Test(dataProvider = "Resume Productions")
	//To verify the Bread crumbs and landings Productions Domains on Resume Sample Page
	public void TC_TRS_011(int Row,String LinkName)
	{
		String Xpath = "//a[text()='" + LinkName +" Resume"+ "']";;
		generic.Click(Xpath);
		String BreadCrumb = generic.GetElementText_WE(TextResumeSamplePage.Breadcrumb_WE);
		String ResumeSampleHeading = generic.GetElementText(TextResumeSamplePage.CourseResumeSampleHeading_WE);
		Assert.assertEquals(ResumeSampleHeading,LinkName + " Resume Samples");
		Assert.assertEquals(datatable.getCellData("Productions", "BreadCrumb", Row), BreadCrumb);
	}
	@DataProvider(name="Resume Sales")
	public Object[][] Dataprovider_Sales()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ResumeSample);
		int rowcount = datatable.getRowCount("Sales");
		Object[][] result = new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData("Sales", "LinkName",i );
			result[i-2][0] = i;			
		}
		return result;
	}
	@Test(dataProvider = "Resume Sales")
	//To verify the Bread crumbs and landings of Sales Domains on Resume Sample Page
	public void TC_TRS_012(int Row,String LinkName)
	{
		String Xpath = "//a[text()='" + LinkName +" Resume"+ "']";
		generic.Click(Xpath);
		String BreadCrumb = generic.GetElementText_WE(TextResumeSamplePage.Breadcrumb_WE);
		String ResumeSampleHeading = generic.GetElementText(TextResumeSamplePage.CourseResumeSampleHeading_WE);
		Assert.assertEquals(ResumeSampleHeading,LinkName + " Resume Samples");
		Assert.assertEquals(datatable.getCellData("Sales", "BreadCrumb", Row), BreadCrumb);
	}
	@DataProvider(name="Resume OtherResume")
	public Object[][] Dataprovider_OtherResume()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ResumeSample);
		int rowcount = datatable.getRowCount("Other Resumes");
		Object[][] result = new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData("Other Resumes", "LinkName",i );
			result[i-2][0] = i;			
		}
		return result;
	}
	@Test(dataProvider = "Resume OtherResume")
	//To verify the Bread crumbs and landings of Other Resume Domains on Resume Sample Page
	public void TC_TRS_013(int Row,String LinkName)
	{
		String Xpath = "//a[text()='" + LinkName +" Resume"+ "']";
		generic.Click(Xpath);
		String BreadCrumb = generic.GetElementText_WE(TextResumeSamplePage.Breadcrumb_WE);
		String ResumeSampleHeading = generic.GetElementText(TextResumeSamplePage.CourseResumeSampleHeading_WE);
		Assert.assertEquals(ResumeSampleHeading,LinkName + " Resume Samples");
		Assert.assertEquals(datatable.getCellData("Other Resumes", "BreadCrumb", Row), BreadCrumb);
	}

	@Test(dataProvider = "Resume IT")
	//To verify that Resume Sample image for IT
	public void TC_TRS_014(int Row,String LinkName)
	{
		String Xpath = "//a[text()='" + LinkName +" Resume"+ "']";
		generic.Click(Xpath);
		if(generic.isVisible(TextResumeSamplePage.EntryLevel_Lnk))
		{
			generic.Click(TextResumeSamplePage.EntryLevel_Lnk);
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
			generic.Click(TextResumeSamplePage.MidLevel_Lnk);
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
			generic.Click(TextResumeSamplePage.SeniorLevel_Lnk);
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
		}
		else
		{
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
		}			
	}
	@Test(dataProvider = "Resume HR")
	//To verify that Resume Sample image for HR
	public void TC_TRS_015(int Row,String LinkName)
	{
		String Xpath = "//a[text()='" + LinkName +" Resume"+ "']";
		generic.Click(Xpath);
		if(generic.isVisible(TextResumeSamplePage.EntryLevel_Lnk))
		{
			generic.Click(TextResumeSamplePage.EntryLevel_Lnk);
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
			generic.Click(TextResumeSamplePage.MidLevel_Lnk);
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
			generic.Click(TextResumeSamplePage.SeniorLevel_Lnk);
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
		}
		else
		{
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
		}			
	}
	@Test(dataProvider = "Resume Banking and Finance")
	//To verify that Resume Sample image for Banking and Finance
	public void TC_TRS_016(int Row,String LinkName)
	{
		String Xpath = "//a[text()='" + LinkName +" Resume"+ "']";
		generic.Click(Xpath);
		if(generic.isVisible(TextResumeSamplePage.EntryLevel_Lnk))
		{
			generic.Click(TextResumeSamplePage.EntryLevel_Lnk);
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
			generic.Click(TextResumeSamplePage.MidLevel_Lnk);
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
			generic.Click(TextResumeSamplePage.SeniorLevel_Lnk);
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
		}
		else
		{
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
		}			
	}
	@Test(dataProvider = "Resume Automobile")
	//To verify that Resume Sample image for Automobile
	public void TC_TRS_017(int Row,String LinkName)
	{
		String Xpath = "//a[text()='" + LinkName +" Resume"+ "']";
		generic.Click(Xpath);
		if(generic.isVisible(TextResumeSamplePage.EntryLevel_Lnk))
		{
			generic.Click(TextResumeSamplePage.EntryLevel_Lnk);
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
			generic.Click(TextResumeSamplePage.MidLevel_Lnk);
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
			generic.Click(TextResumeSamplePage.SeniorLevel_Lnk);
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
		}
		else
		{
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
		}			
	}
	@Test(dataProvider = "Resume Marketing")
	//To verify that Resume Sample image for Marketing
	public void TC_TRS_018(int Row,String LinkName)
	{
		String Xpath = "//a[text()='" + LinkName +" Resume"+ "']";
		generic.Click(Xpath);
		if(generic.isVisible(TextResumeSamplePage.EntryLevel_Lnk))
		{
			generic.Click(TextResumeSamplePage.EntryLevel_Lnk);
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
			generic.Click(TextResumeSamplePage.MidLevel_Lnk);
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
			generic.Click(TextResumeSamplePage.SeniorLevel_Lnk);
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
		}
		else
		{
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
		}			
	}
	@Test(dataProvider = "Resume Operations")
	//To verify that Resume Sample image for Operations
	public void TC_TRS_019(int Row,String LinkName)
	{
		String Xpath = "//a[text()='" + LinkName +" Resume"+ "']";
		generic.Click(Xpath);
		if(generic.isVisible(TextResumeSamplePage.EntryLevel_Lnk))
		{
			generic.Click(TextResumeSamplePage.EntryLevel_Lnk);
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
			generic.Click(TextResumeSamplePage.MidLevel_Lnk);
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
			generic.Click(TextResumeSamplePage.SeniorLevel_Lnk);
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
		}
		else
		{
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
		}			
	}
	@Test(dataProvider = "Resume Productions")
	//To verify that Resume Sample image for Productions
	public void TC_TRS_020(int Row,String LinkName)
	{
		String Xpath = "//a[text()='" + LinkName +" Resume"+ "']";
		generic.Click(Xpath);
		if(generic.isVisible(TextResumeSamplePage.EntryLevel_Lnk))
		{
			generic.Click(TextResumeSamplePage.EntryLevel_Lnk);
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
			generic.Click(TextResumeSamplePage.MidLevel_Lnk);
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
			generic.Click(TextResumeSamplePage.SeniorLevel_Lnk);
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
		}
		else
		{
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
		}			
	}
	@Test(dataProvider = "Resume Sales")
	//To verify that Resume Sample image for Sales 
	public void TC_TRS_021(int Row,String LinkName)
	{
		String Xpath = "//a[text()='" + LinkName +" Resume"+ "']";
		generic.Click(Xpath);
		if(generic.isVisible(TextResumeSamplePage.EntryLevel_Lnk))
		{
			generic.Click(TextResumeSamplePage.EntryLevel_Lnk);
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
			generic.Click(TextResumeSamplePage.MidLevel_Lnk);
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
			generic.Click(TextResumeSamplePage.SeniorLevel_Lnk);
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
		}
		else
		{
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
		}			
	}
	@Test(dataProvider = "Resume OtherResume")
	//To verify that Resume Sample image for Other Resume
	public void TC_TRS_022(int Row,String LinkName)
	{
		String Xpath = "//a[text()='" + LinkName +" Resume"+ "']";
		generic.Click(Xpath);
		if(generic.isVisible(TextResumeSamplePage.EntryLevel_Lnk))
		{
			generic.Click(TextResumeSamplePage.EntryLevel_Lnk);
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
			generic.Click(TextResumeSamplePage.MidLevel_Lnk);
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
			generic.Click(TextResumeSamplePage.SeniorLevel_Lnk);
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
		}
		else
		{
			Assert.assertTrue(generic.isPresent(TextResumeSamplePage.ResumeImage_WE));
		}			
	}
	@Test
	//To verify that See More Resume heading is displayed on Resume Sample Functional Area page
	public void TC_TRS_023()
	{
		driver.get("http://resume.naukri.com/sample-resume-for-hr-human-resource");
		String Result = generic.GetElementText(TextResumeSamplePage.SeeMoreResume_WE);
		Assert.assertEquals(Result, "See more Resume");
	}
	@Test(dataProvider = "Resume IT")
	//To verify that Accordion Widget IT Domains are displayed on resume sample Functional area page
	public void TC_TRS_024(int Row,String LinkName)
	{
		driver.get("http://resume.naukri.com/sample-resume-for-hr-human-resource");
		generic.Click(TextResumeSamplePage.IT_FunctionalArea_WE);
		String xpath = "//a[@title='"+LinkName+" Resume Samples"+"']";
		generic.Click(xpath);		
		String Result = generic.GetElementText(TextResumeSamplePage.ResumeFormatContent_WE);
		String Sampleheading =generic.GetElementText(TextResumeSamplePage.ResumeFormatHeading_WE);
		Assert.assertEquals(Sampleheading,"Resume Format for "+LinkName);
		datatable.setCellData("IT", "Content", Row, Result);
		Assert.assertEquals(Result, datatable.getCellData("IT", "Content", Row));
	}
	@Test(dataProvider = "Resume HR")
	//To verify that Accordion Widget HR Domains are displayed on resume sample Functional area page
	public void TC_TRS_025(int Row,String LinkName)
	{
		driver.get("http://resume.naukri.com/sample-resume-for-it-information-technology");
		generic.Click(TextResumeSamplePage.HR_FunctionalArea_WE);
		String xpath = "//a[@title='"+LinkName+" Resume Samples"+"']";
		generic.Click(xpath);		
		String Sampleheading =generic.GetElementText(TextResumeSamplePage.ResumeFormatHeading_WE);
		Assert.assertEquals(Sampleheading,"Resume Format for "+LinkName);
		String Result = generic.GetElementText(TextResumeSamplePage.ResumeFormatContent_WE);
		Assert.assertEquals(Result, datatable.getCellData("HR", "Content", Row));
	}
	@Test(dataProvider = "Resume Banking and Finance")
	//To verify that Accordion Widget Banking and Finance Domains are displayed on resume sample Functional area page
	public void TC_TRS_026(int Row,String LinkName)
	{
		driver.get("http://resume.naukri.com/sample-resume-for-hr-human-resource");
		generic.Click(TextResumeSamplePage.BankingFinance_FunctionalArea_WE);
		String xpath = "//a[@title='"+LinkName+" Resume Samples"+"']";
		generic.Click(xpath);
		String Sampleheading =generic.GetElementText(TextResumeSamplePage.ResumeFormatHeading_WE);
		Assert.assertEquals(Sampleheading,"Resume Format for "+LinkName);
		String Result = generic.GetElementText(TextResumeSamplePage.ResumeFormatContent_WE);
		Assert.assertEquals(Result, datatable.getCellData("Banking and Finance", "Content", Row));
	}
	@Test(dataProvider = "Resume Automobile")
	//To verify that Accordion Widget Automobile Domains are displayed on resume sample Functional area page
	public void TC_TRS_027(int Row,String LinkName)
	{
		driver.get("http://resume.naukri.com/sample-resume-for-hr-human-resource");
		generic.Click(TextResumeSamplePage.Automobile_FunctionalArea_WE);
		String xpath = "//a[@title='"+LinkName+" Resume Samples"+"']";
		generic.Click(xpath);	
		String Sampleheading =generic.GetElementText(TextResumeSamplePage.ResumeFormatHeading_WE);
		Assert.assertEquals(Sampleheading,"Resume Format for "+LinkName);
		String Result = generic.GetElementText(TextResumeSamplePage.ResumeFormatContent_WE);
		Assert.assertEquals(Result, datatable.getCellData("Automobile", "Content", Row));
	}
	@Test(dataProvider = "Resume Marketing")
	//To verify that Accordion Widget Marketing Domains are displayed on resume sample Functional area page
	public void TC_TRS_028(int Row,String LinkName)
	{
		driver.get("http://resume.naukri.com/sample-resume-for-hr-human-resource");
		generic.Click(TextResumeSamplePage.Marketing_FunctionalArea_WE);
		String xpath = "//a[@title='"+LinkName+" Resume Samples"+"']";
		generic.Click(xpath);		
		String Sampleheading =generic.GetElementText(TextResumeSamplePage.ResumeFormatHeading_WE);
		Assert.assertEquals(Sampleheading,"Resume Format for "+LinkName);
		String Result = generic.GetElementText(TextResumeSamplePage.ResumeFormatContent_WE);
		Assert.assertEquals(Result, datatable.getCellData("Marketing", "Content", Row));
	}
	@Test(dataProvider = "Resume Operations")
	//To verify that Accordion Widget Operation Domains are displayed on resume sample Functional area page
	public void TC_TRS_029(int Row,String LinkName)
	{
		driver.get("http://resume.naukri.com/sample-resume-for-hr-human-resource");
		generic.Click(TextResumeSamplePage.Operations_FunctionalArea_WE);
		String xpath = "//a[@title='"+LinkName+" Resume Samples"+"']";
		generic.Click(xpath);		
		String Sampleheading =generic.GetElementText(TextResumeSamplePage.ResumeFormatHeading_WE);
		Assert.assertEquals(Sampleheading,"Resume Format for "+LinkName);
		String Result = generic.GetElementText(TextResumeSamplePage.ResumeFormatContent_WE);
		Assert.assertEquals(Result, datatable.getCellData("Operations", "Content", Row));
	}
	@Test(dataProvider = "Resume Productions")
	//To verify that Accordion Widget Production Domains are displayed on resume sample Functional area page
	public void TC_TRS_030(int Row,String LinkName)
	{
		driver.get("http://resume.naukri.com/sample-resume-for-hr-human-resource");
		generic.Click(TextResumeSamplePage.Production_FunctionalArea_WE);
		String xpath = "//a[@title='"+LinkName+" Resume Samples"+"']";
		generic.Click(xpath);		
		String Result = generic.GetElementText(TextResumeSamplePage.ResumeFormatContent_WE);
		String Sampleheading =generic.GetElementText(TextResumeSamplePage.ResumeFormatHeading_WE);
		Assert.assertEquals(Sampleheading,"Resume Format for "+LinkName);
		Assert.assertEquals(Result, datatable.getCellData("Productions", "Content", Row));
	}
	@Test(dataProvider = "Resume Sales")
	//To verify that Accordion Widget Sales Domains are displayed on resume sample Functional area page
	public void TC_TRS_031(int Row,String LinkName)
	{
		driver.get("http://resume.naukri.com/sample-resume-for-hr-human-resource");
		generic.Click(TextResumeSamplePage.Sales_FunctionalArea_WE);
		String xpath = "//a[@title='"+LinkName+" Resume Samples"+"']";
		generic.Click(xpath);
		String Sampleheading =generic.GetElementText(TextResumeSamplePage.ResumeFormatHeading_WE);
		Assert.assertEquals(Sampleheading,"Resume Format for "+LinkName);
		String Result = generic.GetElementText(TextResumeSamplePage.ResumeFormatContent_WE);
		Assert.assertEquals(Result, datatable.getCellData("Sales", "Content", Row));
	}
	@Test(dataProvider = "Resume OtherResume")
	//To verify that Accordion Widget Other Resume Domains are displayed on resume sample Functional area page
	public void TC_TRS_032(int Row,String LinkName)
	{
		driver.get("http://resume.naukri.com/sample-resume-for-hr-human-resource");
		generic.Click(TextResumeSamplePage.OtherResume_FunctionalArea_WE);
		String xpath = "//a[@title='"+LinkName+" Resume Samples"+"']";
		generic.Click(xpath);	
		String Sampleheading =generic.GetElementText(TextResumeSamplePage.ResumeFormatHeading_WE);
		Assert.assertEquals(Sampleheading,"Resume Format for "+LinkName);
		String Result = generic.GetElementText(TextResumeSamplePage.ResumeFormatContent_WE);
		Assert.assertEquals(Result, datatable.getCellData("Other Resumes", "Content", Row));
	}
	@Test
	//To verify that Resume Sample BreadCrumb is displayed on Resume Sample Page
	public void TC_TRS_033()
	{
		String Result = generic.GetElementText(TextResumeSamplePage.Breadcrumb_WE);
		Assert.assertEquals(Result,"Naukri FastForward > Resume Samples");

		//To verify that Resume Sample Heading is displayed on Resume Sample Page

		Result = generic.GetElementText(TextResumeSamplePage.ResumeSampleHeading_WE);
		Assert.assertEquals(Result,"Resume Samples");

		//To verify that Know where your Resume stands is displayed on Resume Sample Page
		Result = generic.GetElementText(TextResumeSamplePage.KnowWherYourResumeSatnds_WE);
		Assert.assertEquals(Result,"Know where your Resume stands");

		//To verify that See the Resume Sample Heading is displayed on Resume Sample page

		Result = generic.GetElementText(TextResumeSamplePage.SeeResumeSampleHeading_WE);
		Assert.assertEquals(Result,"See the Resume Samples from your Domain");

		//To verify that I want to improve my Resume heading is displayed on Resume Display page
		Result = generic.GetElementText(TextResumeSamplePage.IWantToImproverHeading_WE);
		Assert.assertEquals(Result,"I want to improve my Resume");
	}
}
