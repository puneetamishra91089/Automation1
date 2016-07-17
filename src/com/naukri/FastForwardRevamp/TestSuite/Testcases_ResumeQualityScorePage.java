package com.naukri.FastForwardRevamp.TestSuite;

import java.io.File;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naukri.FastForwardRevamp.Code.HomePage;
import com.naukri.FastForwardRevamp.Code.LoginLayer;
import com.naukri.FastForwardRevamp.Code.ResumeQualityScorePage;
import com.naukri.FastForwardRevamp.ConfigDetails.ConfigDetails;
import com.naukri.FastForwardRevamp.ConfigDetails.URLProvider;
import com.naukri.GenericFunctionsPack.GenericFunctions;
import com.naukri.datatable.Xls_Reader;

public class Testcases_ResumeQualityScorePage extends ConfigDetails {
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

	@Test
	//To verify that on clicking Naukri link in Bredcrum home page is displayed
	public void TC_RQS_001()
	{		
		driver.get(URLProvider.Return_ResumeQualityScoreURL());
		generic.Click_Lnk(ResumeQualityScorePage.Naukri_Lnk);
		String result = generic.GetElementText_WE(HomePage.HP_Image_WE);
		result = result.replace("\n", " ");
		Assert.assertEquals("Speed Up Your Career with our personalized services",result);	
	}

	@Test
	//To verify that on clicking Fetch Your Resume Link report is displayed or not
	public void TC_RQS_002()
	{		
		datatable = new Xls_Reader(TestDataSheetPath_NaukriLogin);	
		driver.get(URLProvider.Return_ResumeQualityScoreURL());
		generic.Click_Lnk(ResumeQualityScorePage.FetchResume_Lnk);
		LoginLayer loginLayer = new LoginLayer(driver, generic);
		loginLayer.Fillform_Login("Email", Email, Password);
		generic.GoToSleep(2000);
		String result = generic.GetElementText_WE(ResumeQualityScorePage.Breadcrum_WE);
		Assert.assertTrue(result.equals("Naukri FastForward > Resume Quality Score > Resume Quality Report"),result);	
	}

	@Test
	//To verify that on clicking Upload Your Resume Button report is displayed or not
	public void TC_RQS_003()
	{		
		datatable = new Xls_Reader(TestDataSheetPath_NaukriLogin);
		driver.get(URLProvider.Return_ResumeQualityScoreURL());
		LoginLayer loginLayer = new LoginLayer(driver, generic);
		generic.Click_Lnk(LoginLayer.GNB_Login_Lnk);
		loginLayer.Fillform_Login("Email", Email, Password);
		File file = new File(ResumePath);
		driver.findElement(By.xpath(ResumeQualityScorePage.Upload_Btn)).sendKeys(file.getAbsolutePath());
		generic.GoToSleep(3000);
		String result = generic.GetElementText_WE(ResumeQualityScorePage.Breadcrum_WE);
		Assert.assertTrue(result.equals("Naukri FastForward > Resume Quality Score > Resume Quality Report"),result);
	}


	@Test
	//To verify that on clicking Resume Quality Score link in Bread crumb Resume Quality Score page is displayed
	public void TC_RQS_004()
	{
		driver.get(URLProvider.Return_ResumeQualityScoreURL());
		datatable = new Xls_Reader(TestDataSheetPath_NaukriLogin);
		generic.Click_Lnk(ResumeQualityScorePage.FetchResume_Lnk);
		LoginLayer loginLayer = new LoginLayer(driver, generic);
		loginLayer.Fillform_Login("Email", Email, Password);
		generic.Click_Lnk(ResumeQualityScorePage.RQScore_Lnk);		
		String result = generic.GetElementText(ResumeQualityScorePage.Breadcrum_WE);
		Assert.assertEquals(result, "Naukri FastForward > Resume Quality Score");
	}

	@Test
	//To verify that on clicking Click here link Resume Samples page is displayed or not
	public void TC_RQS_005()
	{	
		datatable = new Xls_Reader(TestDataSheetPath_NaukriLogin);
		driver.get(URLProvider.Return_ResumeQualityScoreURL());
		generic.Click_Lnk(ResumeQualityScorePage.FetchResume_Lnk);
		LoginLayer loginLayer = new LoginLayer(driver, generic);
		loginLayer.Fillform_Login("Email", Email, Password);			
		generic.Click_Lnk(ResumeQualityScorePage.Clickhere_Lnk);		
		String result = driver.getCurrentUrl();
		Assert.assertTrue(result.contains(URLProvider.Return_TextResume_MidLevelURL()),result);
	}		

	@DataProvider (name = "LeadFormData")
	public Object[][] DataProvider() {
		String SheetName = "LeadForm";
		datatable = new Xls_Reader(TestDataSheetPath_ResumeQuailityScore);
		int rowcount = datatable.getRowCount(SheetName);
		Object result[][] = new Object[rowcount-1][3];

		for(int i=2 ; i<= rowcount ; i++){
			String Mobile = datatable.getCellData(SheetName, "Mobile", i);
			String Query = datatable.getCellData(SheetName, "Query", i);
			result[i-2][0] = i;
			result[i-2][1] = Mobile;
			result[i-2][2] = Query;
		}

		return result;
	}


	@Test(dataProvider = "LeadFormData")
	//To verify the Report page lead form
	public void TC_RQS_006(int RowNo, String Mobile, String Query)
	{		
		driver.get(URLProvider.Return_ResumeQualityScoreURL());		
		datatable = new Xls_Reader(TestDataSheetPath_ResumeQuailityScore);
		String SheetName = "LeadForm";
		LoginLayer loginLayer = new LoginLayer(driver, generic);
		generic.Click_Lnk(LoginLayer.GNB_Login_Lnk);
		loginLayer.Fillform_Login("Email", Email, Password);
		generic.Click(ResumeQualityScorePage.FetchResume_Lnk);
		generic.Clear_Txt(ResumeQualityScorePage.Mobile_Txt);
		ResumeQualityScorePage leadForm = new ResumeQualityScorePage(driver, generic);
		leadForm.Fillform_LeadForm(Mobile, Query);
		String ErrorMessages = leadForm.CaptureErrors();
		String Expected = datatable.getCellData(SheetName, "Expected", RowNo);
		if(Expected.equalsIgnoreCase("Submitted")){
			Assert.assertTrue(generic.isVisible(ResumeQualityScorePage.ThankYouMsg_WE), "Failed to Submit Lead Form !! " + ErrorMessages);
		}
		else {
			Assert.assertEquals(ErrorMessages, datatable.getCellData(SheetName, "ExpectedErrorMessage", RowNo));
		}
	}
	@Test
	//To verify that static content on Resume Quality Score page
	public void TC_RQS_007()
	{		
		driver.get(URLProvider.Return_ResumeQualityScoreURL());
		String result = generic.GetElementText_WE(ResumeQualityScorePage.Breadcrum_WE);		
		Assert.assertTrue(result.equals("Naukri FastForward > Resume Quality Score"),result);		

		//To verify that on Hero Line is displayed or not

		result = generic.GetElementText_WE(ResumeQualityScorePage.HeroLine_WE);
		Assert.assertTrue(result.equals("Know where your resume quality stands amongst others for FREE"),result);

		//To verify that Resume Quality Content is displayed or not

		result = generic.GetElementText_WE(ResumeQualityScorePage.RQScoreContent_WE);
		Assert.assertTrue(result.equals("Get our free resume feedback report and know what to improve in your resume within 30 seconds"),result);

		//To verify that Upload Your Resume content is displayed

		result = generic.GetElementText_WE(ResumeQualityScorePage.UploadyourResume_WE);
		Assert.assertTrue(result.equals("Upload your resume to evaluate your score"),result);

		//To verify that Fetch Your Resume Link is displayed or not

		result = generic.GetElementText_WE(ResumeQualityScorePage.FetchResume_Lnk);
		Assert.assertTrue(result.equals("Fetch resume from Naukri"),result);

		//To verify that Upload Your Resume Button is displayed or not

		result = generic.GetElementText_WE(ResumeQualityScorePage.UploadResume_Btn);	
		Assert.assertTrue(result.equals("Upload your latest Resume"),result);

		//To verify that How it Works is displayed or not

		result = generic.GetElementText_WE(ResumeQualityScorePage.HowItWorksHeading_WE);
		Assert.assertTrue(result.equals("How it works"),result);

		//To verify that Step1 Content is displayed or not

		result = generic.GetElementText_WE(ResumeQualityScorePage.Step1Content_WE);		
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("STEP 1 Upload your resume or fetch from naukri database Yes, thats all that is needed. Upload your resume no matter what state it is in."),result);

		//To verify that Step2 Content is displayed or not

		result = generic.GetElementText_WE(ResumeQualityScorePage.Step2Content_WE);		
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("STEP 2 Our algorithm scores your resume Our algorithm scores your resume on the basis of 25+ parameters & benchmarks against other job seekers."),result);

		//To verify that Step3 Content is displayed or not

		result = generic.GetElementText_WE(ResumeQualityScorePage.Step3Content_WE);		
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("STEP 3 Get instant Feedback on your existing resume You will get a detailed feedback report. If your resume scores high, great! If your resume scores low, now you know you need to fix it before applying to another job."),result);

	}
	@Test
	//To verify that Static content on Report page
	public void TC_RQS_008()
	{
		datatable = new Xls_Reader(TestDataSheetPath_NaukriLogin);
		driver.get(URLProvider.Return_ResumeQualityScoreURL());
		generic.Click_Lnk(ResumeQualityScorePage.FetchResume_Lnk);
		LoginLayer loginLayer = new LoginLayer(driver, generic);
		loginLayer.Fillform_Login("Email", Email, Password);
		String result = generic.GetElementText_WE(ResumeQualityScorePage.Score_WE);
		Assert.assertTrue(result.equals("Your resume Score is"),result);

		//To verify that Score description is displayed on Report page

		result = generic.GetElementText_WE(ResumeQualityScorePage.ScoreContent_WE);
		Assert.assertTrue(result.equals("Your resume score is average. There are many improvement areas in your resume, which are mentioned below."),result);

		//To verify that percentile is displayed or not

		result = generic.GetElementText_WE(ResumeQualityScorePage.Percentile_WE);
		Assert.assertTrue(result.equals("50% resumes in Naukri are better than your resume"),result);

		//To verify that Detailed Heading is displayed or not

		result = generic.GetElementText_WE(ResumeQualityScorePage.DetailedHeading_WE);
		Assert.assertTrue(result.equals("Detailed Resume Quality Report"),result);

		//To verify that Format and Score is displayed or not

		result = generic.GetElementText_WE(ResumeQualityScorePage.Format_WE);
		result=result.replace("\n", " ");
		Assert.assertTrue(result.equals("SCORE : 10/40 Format"),result);

		//To verify that Content and Score is displayed or not

		result = generic.GetElementText_WE(ResumeQualityScorePage.Content_WE);
		result=result.replace("\n", " ");
		Assert.assertTrue(result.equals("SCORE : 43/60 Content"),result);

		//To verify that Need help content is displayed or not

		result = generic.GetElementText_WE(ResumeQualityScorePage.NeedtoImprove_WE);
		Assert.assertTrue(result.equals("Need help to improve your resume through our paid services?"),result);

		//To verify that Click here link is displayed or not

		result = generic.GetElementText_WE(ResumeQualityScorePage.Clickhere_Lnk);
		Assert.assertTrue(result.equals("Click here"),result);
	}
}

