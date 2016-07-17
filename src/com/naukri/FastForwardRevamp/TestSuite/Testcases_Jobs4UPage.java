package com.naukri.FastForwardRevamp.TestSuite;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naukri.FastForwardRevamp.Code.HomePage;
import com.naukri.FastForwardRevamp.Code.Jobs4UPage;
import com.naukri.FastForwardRevamp.Code.RecruiterConnectionPage;
import com.naukri.FastForwardRevamp.Code.ResumeDisplayPage;
import com.naukri.FastForwardRevamp.ConfigDetails.ConfigDetails;
import com.naukri.FastForwardRevamp.ConfigDetails.URLProvider;
import com.naukri.GenericFunctionsPack.GenericFunctions;
import com.naukri.datatable.Xls_Reader;

public class Testcases_Jobs4UPage extends ConfigDetails {
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
	//To verify that on clicking Naukri link in Bread crumb home page is displayed
	public void TC_Jobs4U_001()
	{
		driver.get(URLProvider.Return_Jobs4UURL());
		generic.Click_Lnk(Jobs4UPage.Naukri_Lnk);	
		String result = generic.GetElementText_WE(HomePage.HP_Image_WE);
		result = result.replace("\n", " ");
		Assert.assertEquals("Speed Up Your Career with our personalized services",result);	
	}
	@Test
	//To verify that on clicking GetHighlighted Button Resume Display page is displayed or not
	public void TC_Jobs4U_002()
	{
		driver.get(URLProvider.Return_Jobs4UURL());
		generic.Click_Lnk(Jobs4UPage.GetHighlighted_Btn);
		String result = generic.GetElementText(ResumeDisplayPage.Breadcrum_WE);
		Assert.assertTrue(result.equals("Naukri FastForward > Resume Display"),result);	
	}

	@Test
	//To verify that on clicking Find Recruiters Button Recruiter Connection page is displayed or not
	public void TC_Jobs4U_003()
	{
		driver.get(URLProvider.Return_Jobs4UURL());
		generic.Click_Lnk(Jobs4UPage.FindRecruiters_Btn);	
		String result = generic.GetElementText(RecruiterConnectionPage.BreadCrum_WE);
		Assert.assertTrue(result.equals("Naukri FastForward > RecruiterConnection"),result);	
	}
	@Test
	//To verify that Jobs4U static content is displayed or not
	public void TC_Jobs4U_004()
	{
		driver.get(URLProvider.Return_Jobs4UURL());
		String result = generic.GetElementText_WE(Jobs4UPage.Breadcrum_WE);
		Assert.assertTrue(result.equals("Naukri FastForward > Jobs4U"),result);

		//To verify that "Hero Line" content on Jobs4U Service page is displayed or not

		result = generic.GetElementText_WE(Jobs4UPage.HeroLine_WE);
		Assert.assertTrue(result.equals("Let our Experts help source the most relevant jobs for you. Receive job alerts instantly"), result);

		//To verify that "About Jobs for You " heading on Jobs4U Service page is displayed or not

		result = generic.GetElementText_WE(Jobs4UPage.AboutJobs4UHeading_WE);
		Assert.assertTrue(result.equals("About Jobs4U"),result);


		//To verify that "About Jobs for You " content on Jobs4U Service page is displayed or not

		result = generic.GetElementText_WE(Jobs4UPage.AboutJobs4UContent_WE);
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("About Jobs4U Not finding relevant jobs, you might have the wrong job preferences on Naukri? Talk to our Experts about your job preferences and set up the right job alerts. Receive real-time relevant jobs posted on naukri.com and other corporate websites via SMS and on your mailbox. Changed your mind about job preferences? Our service gives you the flexibility to change your preferences as needed."),result);

		//To verify that "Job Alerts on Mobile" heading on Jobs4U Service page is displayed or not

		result = generic.GetElementText_WE(Jobs4UPage.JobOnSmsHeading_WE);
		Assert.assertTrue(result.equals("Job Alerts on Mobile"),result);


		//To verify that "Job Alerts on Mobile" content on Jobs4U Service page is displayed or not

		result = generic.GetElementText_WE(Jobs4UPage.JobOnSmsContent_WE);
		//System.out.println(result);
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("Job Alerts on Mobile Get to know of new jobs within 30 minutes of being posted through SMS*. Apply# from anywhere through SMS and get the competitive edge of an early applicant."),result);

		//To verify that "Job Alerts on Email" heading on Jobs4U Service page is displayed or not
		result = generic.GetElementText_WE(Jobs4UPage.JobOnMailHeading_WE);
		Assert.assertTrue(result.equals("Job Alerts on Email"),result);

		//To verify that "Job Alerts on Email" content on Jobs4U Service page is displayed or not

		result = generic.GetElementText_WE(Jobs4UPage.JobOnMailContent_WE);
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("Job Alerts on Email Get relevant jobs in your mail box upto twice in a week."),result);

		//To verify that "Subdetails" content on Jobs4U Service page is displayed or not

		result = generic.GetElementText_WE(Jobs4UPage.SubDetails_WE);
		result = result.replace("\n", "");	
		Assert.assertTrue(result.equals("* Mobile data users can also view the full job description on their mobile and apply online.# For jobs posted on corporate websites, you need to login to Naukri for applying"),result);

		//To verify that Recommended services for you Heading is displayed or not

		result = generic.GetElementText_WE(Jobs4UPage.RecommendedServiceHeading_WE);			
		Assert.assertTrue(result.equals("Recommended services for you"),result);	

		//To verify that Resume Display Heading is displayed or not

		result = generic.GetElementText_WE(Jobs4UPage.ResumeDisplayHeading_WE);		
		Assert.assertTrue(result.equals("Resume Display"),result);	

		//To verify that Resume Display Content is displayed or not

		result = generic.GetElementText_WE(Jobs4UPage.ResumeDisplayContent_WE);			
		result =result.replace("\n", " ");
		Assert.assertTrue(result.equals("Gain More Visibility Among Recruiters Get your profile marked as 'Featured' and get a higher rank when recruiters search for resumes."),result);	

		//To verify that GetHighlighted Button is displayed or not
		result = generic.GetElementText_WE(Jobs4UPage.GetHighlighted_Btn);			
		Assert.assertTrue(result.equals("Get Highlighted"),result);	

		//To verify that RecruiterConnection Heading is displayed or not

		result = generic.GetElementText_WE(Jobs4UPage.RecruiterConnectionHeading_WE);			
		Assert.assertTrue(result.equals("RecruiterConnection"),result);	

		//To verify that RecruiterConnection Content is displayed or not

		result = generic.GetElementText_WE(Jobs4UPage.RecruiterConnectionContent_WE);			
		result =result.replace("\n", " ");
		Assert.assertTrue(result.equals("Expand your reach amongst recruiters Search our database of recruiters and contact recruiters who hire in your domain/industry."),result);	

		//To verify that Find Recruiters Button is displayed or not

		result = generic.GetElementText_WE(Jobs4UPage.FindRecruiters_Btn);			
		Assert.assertTrue(result.equals("Find Recruiters"),result);	

		//To verify that "Delivery Information" heading on Jobs4U Service page is displayed or not

		result = generic.GetElementText_WE(Jobs4UPage.DeliveryInformationHeading_WE);
		Assert.assertTrue(result.equals("Delivery Information"),result);

		//To verify that "Delivery Information" content on Jobs4U Service page is displayed or not

		result = generic.GetElementText_WE(Jobs4UPage.DeliveryInformationContent_WE);
		result = result.replace("\n", " ");		
		Assert.assertTrue(result.equals("Delivery Information If not availed with resume writing, these services will be processed 4 working days after we receive your updated resume. However, if you avail these services with resume writing, these services will be processed within 4 working days after you approve your final resume."),result);
	}	
}

