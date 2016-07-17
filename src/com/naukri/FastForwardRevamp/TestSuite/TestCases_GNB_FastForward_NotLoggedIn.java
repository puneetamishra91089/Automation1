package com.naukri.FastForwardRevamp.TestSuite;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naukri.FastForwardRevamp.Code.FastForwardGnb;
import com.naukri.FastForwardRevamp.Code.TextResumeSamplePage;
import com.naukri.FastForwardRevamp.ConfigDetails.ConfigDetails;
import com.naukri.FastForwardRevamp.ConfigDetails.URLProvider;
import com.naukri.GenericFunctionsPack.GenericFunctions;
import com.naukri.datatable.Xls_Reader;

public class TestCases_GNB_FastForward_NotLoggedIn extends ConfigDetails{
	Xls_Reader datatable;

	@BeforeMethod ()
	public void Before(){
		generic = new GenericFunctions(driver);
		driver = generic.StartDriver(Driver_Type);
		driver.manage().window().maximize();
	}


	@DataProvider(name = "GNB_Tabs")
	public Object[][] DataProvider_GNBTabs()
	{
		String SheetName = "Gnb_Tabs";
		datatable = new Xls_Reader(TestDataSheetPath_FastForward_Gnb);
		int rowcount = datatable.getRowCount(SheetName);
		Object result[][] =new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData(SheetName, "Expected_Links",i );
			result[i-2][0] = i;	
		}
		return result;
	}

	//To verify GNB tabs
	@Test (dataProvider = "GNB_Tabs")
	public void TC_NotLoggedIn_FFGNB_001(int row , String LinkName){
		String SheetName = "Gnb_Tabs";
		driver.get(URLProvider.Return_HomePageURL());
			String Xpath = "//div[@id='nav']//a[text()='" + LinkName + "']";
			generic.Click(Xpath);
			String ExpectedBreadCrum = datatable.getCellData(SheetName, "Expected_Breadcrum", row);
			Assert.assertEquals(generic.GetElementText_WE(FastForwardGnb.BreadCrumb_Common_WE), ExpectedBreadCrum);
	}

	@DataProvider(name = "Gnb_RecruitersReach")
	public Object[][] DataProvider_Gnb_RecruitersReach()
	{
		String SheetName = "Gnb_RecruitersReach";
		datatable = new Xls_Reader(TestDataSheetPath_FastForward_Gnb);
		int rowcount = datatable.getRowCount(SheetName);
		Object result[][] =new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData(SheetName, "Expected_Links",i );
			result[i-2][0] = i;	
		}
		return result;
	}	

	//To verify Recuiters Reach section in GNB
	@Test (dataProvider = "Gnb_RecruitersReach")
	public void TC_NotLoggedIn_FFGNB_002(int row , String LinkName){
		String SheetName = "Gnb_RecruitersReach";
		driver.get(URLProvider.Return_HomePageURL());
			generic.MouseHover(FastForwardGnb.RecruiterReach_WE);
			String Xpath = "//ul[@class='ffGnb']//a[text()='" + LinkName + "']";
			Assert.assertTrue(generic.isVisible(Xpath),"Fail Recruiters Reach Link : " + LinkName + " is not Visible!!");
			generic.Click(Xpath);
			String ExpectedBreadCrum = datatable.getCellData(SheetName, "Expected_Breadcrum", row);
			Assert.assertEquals(generic.GetElementText_WE(FastForwardGnb.BreadCrumb_Common_WE), ExpectedBreadCrum);
		}
	@DataProvider(name = "Gnb_eLearning")
	public Object[][] Learning()
	{
		String SheetName = "Gnb_eLearning";
		datatable = new Xls_Reader(TestDataSheetPath_FastForward_Gnb);
		int rowcount = datatable.getRowCount(SheetName);
		Object result[][] =new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData(SheetName, "Expected_Links",i );
			result[i-2][0] = i;     
		}
		return result;
	}     
	//To verify E-Learning section in GNB
	@Test(dataProvider="Gnb_eLearning") 
	public void TC_NotLoggedIn_FFGNB_003(int row,String Link){
		String SheetName = "Gnb_eLearning";
		driver.get(URLProvider.Return_HomePageURL());
		generic.MouseHover(FastForwardGnb.eLearning_Tab_WE);		
		String GenericXpath="//a[@title='"+Link+"']";		
		generic.Click(GenericXpath);
		String ActualBreadCrum = generic.GetElementText_WE(FastForwardGnb.ElearningBreadcrumbs);
		System.out.println(ActualBreadCrum);
		System.out.println(datatable.getCellData(SheetName, "Expected_Breadcrum", row));
		Assert.assertTrue(ActualBreadCrum.equalsIgnoreCase(datatable.getCellData(SheetName, "Expected_Breadcrum", row)));


	}

	//To verify Find jobs section in GNB
	@Test 
	public void TC_NotLoggedIn_FFGNB_004(){
		datatable =new Xls_Reader(TestDataSheetPath_FastForward_Gnb);
		String SheetName = "Gnb_FindJobs";
		driver.get(URLProvider.Return_HomePageURL());
		generic.MouseHover(FastForwardGnb.FindJobs_Tab_WE);
		String Result =generic.GetElementText_WE(FastForwardGnb.JobsonMail_Lnk);
		Assert.assertEquals(Result, "Jobs on Mail and SMS");
		generic.MouseHover(FastForwardGnb.FindJobs_Tab_WE);
		String Subtext = generic.GetElementText_Btn(FastForwardGnb.JobsonMail_Subtext);
		Assert.assertEquals(Subtext,"Let us search the best jobs for you across the web" );
		generic.MouseHover(FastForwardGnb.FindJobs_Tab_WE);
		generic.Click(FastForwardGnb.JobsonMail_Lnk);
		String ExpectedBreadCrum = generic.GetElementText_WE(FastForwardGnb.BreadCrumb_Common_WE);
		Assert.assertEquals(ExpectedBreadCrum, datatable.getCellData(SheetName, "Expected_Breadcrum", 2));
	}
	@DataProvider(name = "Gnb_Help")
	public Object[][] DataProvider_Gnb_Help()
	{
		String SheetName = "Gnb_Help";
		datatable = new Xls_Reader(TestDataSheetPath_FastForward_Gnb);
		int rowcount = datatable.getRowCount(SheetName);
		Object result[][] =new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData(SheetName, "Expected_Links",i );
			result[i-2][0] = i;	
		}
		return result;
	}	

	//To verify Help section in GNB
	@Test (dataProvider = "Gnb_Help")
	public void TC_NotLoggedIn_FFGNB_005(int row , String LinkName){
		String SheetName = "Gnb_Help";
		driver.get(URLProvider.Return_HomePageURL());	
		generic.MouseHover(FastForwardGnb.Help_WE);
		String Xpath = "//ul[@class='ffGnb']//a[text()='" + LinkName + "']";
		generic.Click(Xpath);
		String ExpectedBreadCrum = datatable.getCellData(SheetName, "Expected_Breadcrum", row);
		Assert.assertEquals(generic.GetElementText_WE(FastForwardGnb.Help_BreadCrumb_Common_WE), ExpectedBreadCrum);		
	}

	@DataProvider(name = "Gnb_resumeWriting")
	public Object[][] DataProvider_Gnb_resumeWriting()
	{
		String SheetName = "Gnb_ResumeWriting_NotLoggedIn";
		datatable = new Xls_Reader(TestDataSheetPath_FastForward_Gnb);
		int rowcount = datatable.getRowCount(SheetName);
		Object result[][] =new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData(SheetName, "Expected_Links",i );
			result[i-2][0] = i;	
		}
		return result;
	}	

	//To verify Resume Writing Section in Fastforward GNB
	@Test (dataProvider = "Gnb_Help")
	public void TC_NotLoggedIn_FFGNB_015(int row , String LinkName){
		String SheetName = "Gnb_ResumeWriting_NotLoggedIn";
		driver.get(URLProvider.Return_HomePageURL());	
		generic.MouseHover(FastForwardGnb.ResumeWriting_WE);
		String Xpath = "//ul[@class='ffGnb']//a[text()='" + LinkName + "']";
		generic.Click(Xpath);
		String ExpectedBreadCrum = datatable.getCellData(SheetName, "Expected_Breadcrum", row);
		Assert.assertEquals(generic.GetElementText_WE(FastForwardGnb.Help_BreadCrumb_Common_WE), ExpectedBreadCrum);		
	}
	
	//To verify Entry level link in Text Resume Section under Resume Writing
	@Test
	public void TC_NotLoggedIn_FFGNB_006(){
		driver.get(URLProvider.Return_HomePageURL());	
		generic.MouseHover(FastForwardGnb.ResumeWriting_WE);
		generic.Click(FastForwardGnb.TextResumeEntryLevel_Lnk);
		String result = driver.getCurrentUrl();
		Assert.assertEquals(result,URLProvider.Return_TextResume_EntryLevelURL());		
	}	
	//To verify Mid level link in Text Resume Section under Resume Writing
	@Test
	public void TC_NotLoggedIn_FFGNB_007(){
		driver.get(URLProvider.Return_HomePageURL());	
		generic.MouseHover(FastForwardGnb.ResumeWriting_WE);
		generic.Click(FastForwardGnb.TextResumeMidLevel_Lnk);
		String result = driver.getCurrentUrl();
		Assert.assertEquals(result,URLProvider.Return_TextResume_MidLevelURL());		
	}	
	//To verify Senior level link in Text Resume Section under Resume Writing
	@Test
	public void TC_NotLoggedIn_FFGNB_008(){
		driver.get(URLProvider.Return_HomePageURL());	
		generic.MouseHover(FastForwardGnb.ResumeWriting_WE);
		generic.Click(FastForwardGnb.TextResumeSeniorLevel_Lnk);
		String result = driver.getCurrentUrl();
		Assert.assertEquals(result,URLProvider.Return_TextResume_SeniorLevelURL());		
	}	

	//To verify Entry level link in Visual Resume Section under Resume Writing
	@Test
	public void TC_NotLoggedIn_FFGNB_009(){
		driver.get(URLProvider.Return_HomePageURL());	
		generic.MouseHover(FastForwardGnb.ResumeWriting_WE);
		generic.Click(FastForwardGnb.VisualResumeEntryLevel_Lnk);
		String result = driver.getCurrentUrl();
		Assert.assertEquals(result,URLProvider.Return_VisualResume_EntryLevelURL());		
	}	
	//To verify Mid level link in Visual Resume Section under Resume Writing
	@Test
	public void TC_NotLoggedIn_FFGNB_010(){
		driver.get(URLProvider.Return_HomePageURL());	
		generic.MouseHover(FastForwardGnb.ResumeWriting_WE);
		generic.Click(FastForwardGnb.VisualResumeMidLevel_Lnk);
		String result = driver.getCurrentUrl();
		Assert.assertEquals(result,URLProvider.Return_VisualResume_MidLevelURL());		
	}	
	//To verify Senior level link in Visual Resume Section under Resume Writing
	@Test
	public void TC_NotLoggedIn_FFGNB_011(){
		driver.get(URLProvider.Return_HomePageURL());	
		generic.MouseHover(FastForwardGnb.ResumeWriting_WE);
		generic.Click(FastForwardGnb.VisualResumeSeniorLevel_Lnk);
		String result = driver.getCurrentUrl();
		Assert.assertEquals(result,URLProvider.Return_VisualResume_SeniorLevelURL());		
	}	


	//To verify Entry level link in  ResumeSample Section under Resume Writing
	@Test
	public void TC_NotLoggedIn_FFGNB_012(){
		driver.get(URLProvider.Return_HomePageURL());	
		generic.MouseHover(FastForwardGnb.ResumeWriting_WE);
		generic.Click(FastForwardGnb.ResumeSampleEntryLevel_Lnk);
		String result = generic.GetElementText(TextResumeSamplePage.Breadcrumb_WE);
		Assert.assertEquals(result, "Naukri FastForward > Resume Samples for Freshers");		
	}	
	//To verify Mid level link in ResumeSample Section under Resume Writing
	@Test
	public void TC_NotLoggedIn_FFGNB_013(){
		driver.get(URLProvider.Return_HomePageURL());	
		generic.MouseHover(FastForwardGnb.ResumeWriting_WE);
		generic.Click(FastForwardGnb.ResumeSampleMidLevel_Lnk);
		String result = generic.GetElementText(TextResumeSamplePage.Breadcrumb_WE);
		Assert.assertEquals(result, "Naukri FastForward > Resume Samples for Experienced Professionals");		
	}	
	//To verify Senior level link in ResumeSample Section under Resume Writing
	@Test
	public void TC_NotLoggedIn_FFGNB_014(){
		driver.get(URLProvider.Return_HomePageURL());	
		generic.MouseHover(FastForwardGnb.ResumeWriting_WE);
		generic.Click(FastForwardGnb.ResumeSampleSeniorLevel_Lnk);
		String result = generic.GetElementText(TextResumeSamplePage.Breadcrumb_WE);
		Assert.assertEquals(result, "Naukri FastForward > Senior Level Resume Samples");		
	}	
	@AfterMethod()
	public void CloseDriver()
	{
		driver.quit();
	}
}
