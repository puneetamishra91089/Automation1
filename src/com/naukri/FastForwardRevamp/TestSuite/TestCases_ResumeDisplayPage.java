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

public class TestCases_ResumeDisplayPage extends ConfigDetails {
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
	public void TC_RD_001()
	{		
		driver.get(URLProvider.Return_ResumeDisplayURL());
		generic.Click_Lnk(ResumeDisplayPage.Naukri_Lnk);
		String result = generic.GetElementText_WE(HomePage.HP_Image_WE);
		result = result.replace("\n", " ");
		Assert.assertEquals("Speed Up Your Career with our personalized services",result);	
	}



	@Test
	//To verify that on clicking Find Recruiters Button recruiter Connection page is displayed or not
	public void TC_RD_002()
	{		
		driver.get(URLProvider.Return_ResumeDisplayURL());
		generic.Click_Lnk(ResumeDisplayPage.findRecruiters_Btn);	
		String result = generic.GetElementText(RecruiterConnectionPage.BreadCrum_WE);
		Assert.assertTrue(result.equals("Naukri FastForward > RecruiterConnection"),result);	
	}

	@Test
	//To verify that on clicking Get Jobs on mail and SMS Button Jobs4U page is displayed or not
	public void TC_RD_003()
	{		
		driver.get(URLProvider.Return_ResumeDisplayURL());
		generic.Click_Lnk(ResumeDisplayPage.GetJobsOnMailandSMS_Btn);			
		String result = generic.GetElementText(Jobs4UPage.Breadcrum_WE);
		Assert.assertTrue(result.equals("Naukri FastForward > Jobs4U"),result);	
	}
	
	@Test
	//To verify that Static content for Resume Display is displayed or not
	public void TC_RD_004()
	{		
		driver.get(URLProvider.Return_ResumeDisplayURL());
		String result = generic.GetElementText_WE(ResumeDisplayPage.Breadcrum_WE);		
		Assert.assertTrue(result.equals("Naukri FastForward > Resume Display"),result);		

		//To verify that Resume Display Heroline is displayed or not

		result = generic.GetElementText_WE(ResumeDisplayPage.ResumeDisplayHeading_WE);
		result=result.replace("\n", " ");
		Assert.assertTrue(result.equals("Increase your profile views by 3 times"),result);	

		//To verify that Why Resume Display heading is displayed or not

		result = generic.GetElementText_WE(ResumeDisplayPage.WhyResumeDisplayHeading_WE);
		Assert.assertTrue(result.equals("Why Resume Display"),result);	

		//To verify that Why Resume Display content is displayed or not

		result = generic.GetElementText_WE(ResumeDisplayPage.WhytResumeDisplayContent_WE);
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("Why Resume Display Always be in the spotlight. Be higher up in the search when recruiters search for resumes in the Naukri database. Our Resume Display service highlights your profile with a featured tag which tells recruiters that you are actively looking for a job. Increase your profile views by up to 3 times with this unique service."),result);	

		//To verify that Highlight Your Profile Heading is displayed or not

		result = generic.GetElementText_WE(ResumeDisplayPage.HighlightYourProfileHeading_WE);
		Assert.assertTrue(result.equals("Highlight Your Profile"),result);	

		//To verify that Highlight Your Profile Content is displayed or not

		result = generic.GetElementText_WE(ResumeDisplayPage.HighlightYourProfileContent_WE);
		result = result.replace("\n", " ");
		//Assert.assertTrue(result.equals("Highlight Your Profile Your profile is marked as "Featured" to make you stand out in the Naukri Database as an active jobseeker."),result);	

		//To verify that Rank Higher In Search Results heading is displayed or not

		result = generic.GetElementText_WE(ResumeDisplayPage.RankHighInSearchResultsHeading_WE);
		Assert.assertTrue(result.equals("Rank Higher In Search Results"),result);	

		//To verify that Rank Higher In Search Results Content is displayed or not

		result = generic.GetElementText_WE(ResumeDisplayPage.RankHighInSearchResultsContent_WE);
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("Rank Higher In Search Results Your profile is given a higher rank when recruiters search CVs of active candidates in Naukri database."),result);	

		//To verify that Be Accessible To More Recruiters heading is displayed or not

		result = generic.GetElementText_WE(ResumeDisplayPage.BeAccessibleToMoreRecruitersHeading_WE);
		Assert.assertTrue(result.equals("Be Accessible To More Recruiters"),result);	

		//To verify that Be Accessible To More Recruiters Content is displayed or not

		result = generic.GetElementText_WE(ResumeDisplayPage.BeAccessibleToMoreRecruitersContent_WE);
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("Be Accessible To More Recruiters Your resume is searchable even by recruiters not registered with Naukri via \""+"Free CV Search\""),result);	

		
		//To verify that Recommended services for you Heading is displayed or not

		result = generic.GetElementText_WE(ResumeDisplayPage.RecommendedServiceHeading_WE);			
		Assert.assertTrue(result.equals("Recommended services for you"),result);	

		//To verify that RecruiterConnection Heading is displayed or not

		result = generic.GetElementText_WE(ResumeDisplayPage.RecruiterConnectionHeading_WE);			
		Assert.assertTrue(result.equals("RecruiterConnection"),result);	

		//To verify that RecruiterConnection Content is displayed or not

		result = generic.GetElementText_WE(ResumeDisplayPage.RecruiterConnectionContent_WE);			
		result =result.replace("\n", " ");
		Assert.assertTrue(result.equals("Expand your reach amongst recruiters Search our database of recruiters and contact recruiters who hire in your domain/industry."),result);	

		//To verify that Find Recruiters Button is displayed or not

		result = generic.GetElementText_WE(ResumeDisplayPage.findRecruiters_Btn);			
		Assert.assertTrue(result.equals("Find Recruiters"),result);	
		//To verify that Jobs on mail and SMS Heading is displayed or not
		result = generic.GetElementText_WE(ResumeDisplayPage.JobsOnMailandSMSHeading_WE);			
		Assert.assertTrue(result.equals("Jobs on Mail and SMS"),result);


		//To verify that Jobs on mail and SMS Content is displayed or not

		result = generic.GetElementText_WE(ResumeDisplayPage.JobsOnMailandSMSContent_WE);			
		result =result.replace("\n", " ");
		Assert.assertTrue(result.equals("Know about job openings in real time and be an early applicant Let our experts send the best jobs for you on mail and sms. Be an early applicant and never miss out on any relevant job opening"),result);	

		//To verify that Get Jobs on mail and SMS Button is displayed or not

		result = generic.GetElementText_WE(ResumeDisplayPage.GetJobsOnMailandSMS_Btn);			
		Assert.assertTrue(result.equals("Get Jobs on Mails and SMS"),result);	

		//To verify that Delivery Information Heading is displayed or not

		result = generic.GetElementText_WE(ResumeDisplayPage.DeliveryInformationHeading_WE);			
		Assert.assertTrue(result.equals("Delivery Information"),result);

		//To verify Delivery Information content is displayed or not

		result = generic.GetElementText_WE(ResumeDisplayPage.DeliveryInformationContent_WE);	
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("Delivery Information If not availed with resume writing, these services will be processed 4 working days after we receive your updated resume. However, if you avail these services with resume writing, these services will be processed within 4 working days after you approve your final resume."),result);
	}
}

