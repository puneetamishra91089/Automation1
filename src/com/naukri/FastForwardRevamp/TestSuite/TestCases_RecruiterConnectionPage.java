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

public class TestCases_RecruiterConnectionPage extends ConfigDetails {
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
	public void TC_RC_001()
	{
		driver.get(URLProvider.Return_RecruiterConnectionURL());
		generic.Click_Lnk(RecruiterConnectionPage.Naukri_Lnk);		
		String result = generic.GetElementText_WE(HomePage.HP_Image_WE);
		result = result.replace("\n", " ");
		Assert.assertEquals("Speed Up Your Career with our personalized services",result);	
	}

	@Test
	//To verify on clicking Search Recruiter link Recruiters page is displayed 
	public void TC_RC_002()
	{
		driver.get(URLProvider.Return_RecruiterConnectionURL());
		generic.Click_Lnk(RecruiterConnectionPage.SearchRecruiter_Lnk);
		String result = driver.getCurrentUrl();
		Assert.assertTrue(result.equals(URLProvider.Return_SearchRecuitersURL()),result);
	}	
	@Test
	//To verify that on clicking Search Now link it lands to Recruiters page
	public void TC_RC_003()
	{
		driver.get(URLProvider.Return_RecruiterConnectionURL());
		generic.Click_Lnk(RecruiterConnectionPage.SearchNow_Lnk);
		String result = driver.getCurrentUrl();
		Assert.assertTrue(result.equals(URLProvider.Return_SearchRecuitersURL()),result);	
	}
	@Test
	//To verify that on clicking Sample 1 Link Recruiter Page Sample is displayed
	public void TC_RC_004()
	{
		driver.get(URLProvider.Return_RecruiterConnectionURL());
		generic.Click_Lnk(RecruiterConnectionPage.Sample1_Lnk);		
		String result = generic.GetElementText_WE(RecruiterConnectionPage.SampleHeading_WE);
		Assert.assertTrue(result.equals("Recruiter's page"),result);	
	}
	@Test
	//To verify that on clicking Sample 2 Link Sample message is displayed
	public void TC_RC_005()
	{
		driver.get(URLProvider.Return_RecruiterConnectionURL());
		generic.Click_Lnk(RecruiterConnectionPage.Sample2_Lnk);
		String result = generic.GetElementText_WE(RecruiterConnectionPage.SampleHeading_WE);
		Assert.assertTrue(result.equals("Sample Message"),result);
	}
	@Test
	//To verify that on clicking Sample 3 Link Recruiter Responses Sample is displayed
	public void TC_RC_006()
	{
		driver.get(URLProvider.Return_RecruiterConnectionURL());
		generic.Click_Lnk(RecruiterConnectionPage.Sample3_Lnk);			
		String result = generic.GetElementText_WE(RecruiterConnectionPage.SampleHeading_WE);
		Assert.assertTrue(result.equals("Recruiter Responses"),result);	
	}

	@Test
	//To verify that on clicking Get Highlighted Link it lands to Resume Display page
	public void TC_RC_007()
	{
		driver.get(URLProvider.Return_RecruiterConnectionURL());
		generic.Click_Lnk(RecruiterConnectionPage.GetHighlighted_Btn);
		String result = generic.GetElementText(ResumeDisplayPage.Breadcrum_WE);
		Assert.assertTrue(result.equals("Naukri FastForward > Resume Display"),result);		
	}

	@Test
	//To verify that on clicking Get Jobs on Mails and SMS link Jobs4U page is displayed or not
	public void TC_RC_008()
	{
		driver.get(URLProvider.Return_RecruiterConnectionURL());
		generic.Click_Lnk(RecruiterConnectionPage.GetJobsOnMailandSMS_Btn);			
		String result = generic.GetElementText(Jobs4UPage.Breadcrum_WE);
		Assert.assertTrue(result.equals("Naukri FastForward > Jobs4U"),result);		
	} 

	
	@Test
	//To verify that static content of RecruiterConnection is displayed or not
	public void TC_RC_009()
	{
		driver.get(URLProvider.Return_RecruiterConnectionURL());
		String result = generic.GetElementText_WE(RecruiterConnectionPage.BreadCrum_WE);			
		Assert.assertTrue(result.equals("Naukri FastForward > RecruiterConnection"),result);		

		//To verify that Recruiter Connection Hero Line is displayed or not

		result = generic.GetElementText_WE(RecruiterConnectionPage.Heading1_WE);			
		Assert.assertTrue(result.equals("Take the initiative in your job search, Connect with the right Recruiters"),result);		

		//To verify that Why Recruiter Connection heading is displayed or not

		result = generic.GetElementText_WE(RecruiterConnectionPage.WhyRC_WE);			
		Assert.assertTrue(result.equals("Why RecruiterConnection?"),result);		

		//To verify that Why Recruiter Connection content is displayed or not

		result = generic.GetElementText_WE(RecruiterConnectionPage.Content_WE);	
		result = result.replace("\n", "");
		Assert.assertTrue(result.equals("Search our database of 80,000+ Recruiters and connect with them"),result);		

		//To verify that Search Recruiters link is displayed on Recruiter Connection page

		result = generic.GetElementText_WE(RecruiterConnectionPage.SearchRecruiter_Lnk);			
		Assert.assertTrue(result.equals("Search Recruiters"),result);


		//To verify that How it Works Heading is displayed on Recruiter Connection page 

		result = generic.GetElementText_WE(RecruiterConnectionPage.HowItWorksHeading_WE);			
		Assert.assertTrue(result.equals("How it works"),result);		

		//To verify that Step1 details are displayed or not

		result = generic.GetElementText_WE(RecruiterConnectionPage.Step1_WE);	
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("STEP 1 Search in Naukri Recruiter Database and shortlist recruiters on the basis of profile, location, or skills. Search Now"),result);		

		//To verify that Step2 details are displayed or not

		result = generic.GetElementText_WE(RecruiterConnectionPage.Step2_WE);	
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("STEP 2 Send a message to preferred recruiters. Your Naukri profile and resume will be attached with your message."),result);		

		//To verify that Step3 details are displayed or not

		result = generic.GetElementText_WE(RecruiterConnectionPage.Step3_WE);	
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("STEP 3 Recruiter will go through your profile and directly get in touch with you. If your message remains unread, you get your credit back*."),result);		

		//To verify that Search Now link is displayed or not

		result = generic.GetElementText_WE(RecruiterConnectionPage.SearchNow_Lnk);			
		Assert.assertTrue(result.equals("Search Now"),result);		

		//To verify that Buy Credits heading is displayed on Recruiter Connection page

		result = generic.GetElementText_WE(RecruiterConnectionPage.BuyCreditsHeading_WE);			
		Assert.assertTrue(result.equals("Buy credits to contact recruiters. Get started now!"),result);		

		//To verify that Points to note are displayed or not

		String result1 = generic.GetElementText_WE(RecruiterConnectionPage.CreditsPoints1_WE);			
		Assert.assertTrue(result1.equals("Messages can be sent only to recruiters who have opted in to receive them"),result1);				
		String result2 = generic.GetElementText_WE(RecruiterConnectionPage.CreditsPoints2_WE);			
		Assert.assertTrue(result2.equals("Once you have sent a message, you cannot send a message again to the same recruiter for 30 days"),result2);
		String result3 = generic.GetElementText_WE(RecruiterConnectionPage.CreditsPoints3_WE);			
		Assert.assertTrue(result3.equals("You can contact a maximum of 30 recruiters in a month"),result3);
		String result4 = generic.GetElementText_WE(RecruiterConnectionPage.CreditsPoints4_WE);	
		Assert.assertTrue(result4.equals("Credits once purchased will not be refunded and are valid for six months from the date of purchase"),result4);
		String result5 = generic.GetElementText_WE(RecruiterConnectionPage.CreditsPoints5_WE);			
		Assert.assertTrue(result5.equals("*One-time reuse of credits if recruiter does not view your request"),result5);

		//To verify that Recommended services for you Heading is displayed or not

		result = generic.GetElementText_WE(RecruiterConnectionPage.RecommendedServiceHeading_WE);			
		Assert.assertTrue(result.equals("Recommended services for you"),result);	

		//To verify that Resume Display Heading is displayed or not

		result = generic.GetElementText_WE(RecruiterConnectionPage.ResumeDisplayHeading_WE);			
		Assert.assertTrue(result.equals("Resume Display"),result);	

		//To verify that Resume Display Content is displayed or not

		result = generic.GetElementText_WE(RecruiterConnectionPage.ResumeDisplayContent_WE);			
		result =result.replace("\n", " ");
		Assert.assertTrue(result.equals("Gain More Visibility Among Recruiters Get your profile marked as 'Featured' and get a higher rank when recruiters search for resumes."),result);	

		//To verify that Get Highlighted Link is displayed or not

		result = generic.GetElementText_WE(RecruiterConnectionPage.GetHighlighted_Btn);			
		Assert.assertTrue(result.equals("Get Highlighted"),result);	


		//To verify that Jobs on Mail and SMS Heading is displayed or not

		result = generic.GetElementText_WE(RecruiterConnectionPage.JobsOnMailandSMSHeading_WE);			
		Assert.assertTrue(result.equals("Jobs on Mail and SMS"),result);	

		//To verify that Jobs on Mail and SMS Content is displayed or not

		result = generic.GetElementText_WE(RecruiterConnectionPage.JobsOnMailandSMSContent_WE);			
		result =result.replace("\n", " ");
		Assert.assertTrue(result.equals("Know about job openings in real time and be an early applicant Let our experts send the best jobs for you on mail and sms. Be an early applicant and never miss out on any relevant job opening"),result);	

		//To verify that Get Jobs on Mails and SMS Link is displayed or not

		result = generic.GetElementText_WE(RecruiterConnectionPage.GetJobsOnMailandSMS_Btn);			
		Assert.assertTrue(result.equals("Get Jobs on Mails and SMS"),result);	

	}
}
