package com.naukri.FastForwardRevamp.TestSuite;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naukri.FastForwardRevamp.Code.HomePage;
import com.naukri.FastForwardRevamp.Code.Jobs4UPage;
import com.naukri.FastForwardRevamp.Code.RecruiterConnectionPage;
import com.naukri.FastForwardRevamp.Code.TextResumePage;
import com.naukri.FastForwardRevamp.ConfigDetails.ConfigDetails;
import com.naukri.FastForwardRevamp.ConfigDetails.URLProvider;
import com.naukri.GenericFunctionsPack.GenericFunctions;
import com.naukri.datatable.Xls_Reader;

public class TestCases_TextResumePage extends ConfigDetails {

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
	public void TC_TR_001()
	{
		driver.get (URLProvider.Return_TextResume_MidLevelURL());
		generic.Click_Lnk(TextResumePage.Naukri_Lnk);	
		String result = generic.GetElementText_WE(HomePage.HP_Image_WE);
		result = result.replace("\n", " ");
		Assert.assertEquals("Speed Up Your Career with our personalized services",result);	
	}
	@Test	
	//To verify that on clicking Text Resume Samples link it lands to Resume Samples page
	public void TC_TR_002()
	{
		driver.get (URLProvider.Return_TextResume_MidLevelURL());		
		generic.Click_Lnk(TextResumePage.SeeTextResumeSamples_Lnk);	
		String result = generic.GetElementText(TextResumePage.Breadcrum_WE);
		Assert.assertTrue(result.equals("Naukri FastForward > Resume Samples for Experienced Professionals"));	
	}

	@Test
	//To verify that on clicking Find Recruiters Button recruiter Connection page is displayed or not
	public void TC_TR_003()
	{	
		driver.get (URLProvider.Return_TextResume_MidLevelURL());	
		generic.Click_Lnk(TextResumePage.findRecruiters_Btn);	
		String result = generic.GetElementText(RecruiterConnectionPage.BreadCrum_WE);
		Assert.assertTrue(result.equals("Naukri FastForward > RecruiterConnection"),result);
	}

	@Test
	//To verify that on clicking Get Jobs on mail and SMS Button Jobs4U page is displayed or not
	public void TC_TR_004()
	{	
		driver.get (URLProvider.Return_TextResume_MidLevelURL());	
		generic.Click_Lnk(TextResumePage.GetJobsOnMailandSMS_Btn);		
		String result = generic.GetElementText(Jobs4UPage.Breadcrum_WE);
		Assert.assertTrue(result.equals("Naukri FastForward > Jobs4U"),result);
	}


	@Test
	//To verify the static content on Text Resume Page
	public void TC_TR_005()
	{
		driver.get (URLProvider.Return_TextResume_EntryLevelURL());		
		String result = generic.GetElementText_WE(TextResumePage.Breadcrum_WE);
		Assert.assertTrue(result.equals("Naukri FastForward > Resume Writing for Entry Level Professionals"),result);		
		//To verify that Hero line for entry level Text Resume is displayed or not
		result = generic.GetElementText_WE(TextResumePage.Heroline_WE);			
		Assert.assertTrue(result.equals("Get a Resume that reflects your Job readiness"),result);		
		//To verify that Text Resume Entry level features are displayed or not
		result = generic.GetElementText_WE(TextResumePage.Feature1_WE);			
		Assert.assertTrue(result.equals("In-house team of experts with over 10 years of experience"),result);	
		result = generic.GetElementText_WE(TextResumePage.Feature2_WE);			
		Assert.assertTrue(result.equals("Attractive and Recruiter friendly resume format"),result);
		result = generic.GetElementText_WE(TextResumePage.Feature3_WE);			
		Assert.assertTrue(result.equals("Over 95% satisfaction rate"),result);
		result = generic.GetElementText_WE(TextResumePage.Feature4_WE);			
		Assert.assertTrue(result.equals("Introduce yourself to prospective recruiters with an impactful and crisp Cover Letter*"),result);
		//To verify that Text Resume entry level Heading2 is displayed or not
		result = generic.GetElementText_WE(TextResumePage.TextResumeHeading_WE);	
		Assert.assertTrue(result.equals("Get a competitive edge with a resume that highlights your strengths"),result);
		//To verify that Text Resume entry level Heading2 content is displayed or not
		result = generic.GetElementText_WE(TextResumePage.TextResumeContent_WE);	
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("Get a competitive edge with a resume that highlights your strengths Get our experts to write your resume We use the right keywords to highlight your career goals and achievements in an effective structure and crisp formatting to make your resume stand out."),result);		
		//To verify that Entry Level Text Resume Tab is displayed or not
		result = generic.GetElementText_WE(TextResumePage.EntryLevel_Lnk);	
		result = result.replace("\n", "");
		Assert.assertTrue(result.equals("ENTRY-LEVEL(Exp: 0 to 3 years)"),result);	
		//To verify that Text Resume Sample Link is displayed for Entry level
		result = generic.GetElementText_WE(TextResumePage.SeeTextResumeSamples_Lnk);		
		Assert.assertTrue(result.equals("View Entry Level Resume Samples"),result);	
		//To verify that Mid Level Bread crumb is displayed or not
		driver.get (URLProvider.Return_TextResume_MidLevelURL());		
		generic.GoToSleep(1000);
		result = generic.GetElementText_WE(TextResumePage.Breadcrum_WE);
		System.out.println(result);
		Assert.assertTrue(result.equals("Naukri FastForward > Resume Writing for Mid Level Professionals"),result);		
		//To verify that Hero line for Mid level Text Resume is displayed or not
		result = generic.GetElementText_WE(TextResumePage.Heroline_WE);			
		Assert.assertTrue(result.equals("Tailor your Resume to reflect your experience"),result);
		//To verify that Mid Level Text Resume Tab is displayed or not
		result = generic.GetElementText_WE(TextResumePage.MidLevel_Lnk);	
		result = result.replace("\n", "");
		Assert.assertTrue(result.equals("MID-LEVEL(Exp: 3 to 8 years)"),result);	
		//To verify that Text Resume Mid level Heading2 is displayed or not
		result = generic.GetElementText_WE(TextResumePage.TextResumeHeading_WE);		
		Assert.assertTrue(result.equals("Showcase your experience and goals with a resume tailored for your profile"),result);		
		//To verify that Text Resume Mid level Heading2 content is displayed or not
		result = generic.GetElementText_WE(TextResumePage.TextResumeContent_WE);	
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("Showcase your experience and goals with a resume tailored for your profile Get our experts to write your resume We customise your resume to highlight your accomplishments and experience. Relevant keywords are included in an effective structure to help advance your job search."),result);		
		//To verify that Text Resume Mid level features are displayed or not
		result = generic.GetElementText_WE(TextResumePage.Feature1_WE);			
		Assert.assertTrue(result.equals("In-house team of experts with over 10 years of experience"),result);	
		result = generic.GetElementText_WE(TextResumePage.Feature2_WE);			
		Assert.assertTrue(result.equals("Attractive and Recruiter friendly resume format"),result);
		result = generic.GetElementText_WE(TextResumePage.Feature3_WE);			
		Assert.assertTrue(result.equals("Telephonic discussion with the Resume Writer to understand your goals and achievements"),result);
		result = generic.GetElementText_WE(TextResumePage.Feature4_WE);			
		Assert.assertTrue(result.equals("Iterations over email as needed, to deliver a resume right for your needs"),result);
		result = generic.GetElementText_WE(TextResumePage.Feature5_WE);			
		Assert.assertTrue(result.equals("Over 95% satisfaction rate"),result);
		result = generic.GetElementText_WE(TextResumePage.Feature6_WE);			
		Assert.assertTrue(result.equals("Highlight your accomplishments with a customised Cover Letter* to suit your profile"),result);
		//To verify that Text Resume Sample Link is displayed for Mid level
		result = generic.GetElementText_WE(TextResumePage.SeeTextResumeSamples_Lnk);		
		Assert.assertTrue(result.equals("View Resume Samples for Experienced"),result);	
		//To verify that Senior Level Bread crumb is displayed or not
		driver.get (URLProvider.Return_TextResume_SeniorLevelURL());		
		generic.GoToSleep(2000);
		result = generic.GetElementText_WE(TextResumePage.Breadcrum_WE);
		Assert.assertTrue(result.equals("Naukri FastForward > Resume Writing for Senior Level Professionals"),result);		
		//To verify that Hero line for Senior level Text Resume is displayed or not
		result = generic.GetElementText_WE(TextResumePage.Heroline_WE);			
		Assert.assertTrue(result.equals("Showcase your Experience & Success in your Resume"),result);
		//To verify that Senior Level Text Resume Tab is displayed or not
		result = generic.GetElementText_WE(TextResumePage.SeniorLevel_Lnk);	
		result = result.replace("\n", "");
		Assert.assertTrue(result.equals("SENIOR-LEVEL(Exp: 8 years and above)"),result);
		//To verify that Text Resume Senior level Heading2 is displayed or not
		result = generic.GetElementText_WE(TextResumePage.TextResumeHeading_WE);		
		Assert.assertTrue(result.equals("Use our expertise to correctly package your Competence, Experience and Expertise!"),result);		
		//To verify that Text Resume Senior level Heading2 content is displayed or not
		result = generic.GetElementText_WE(TextResumePage.TextResumeContent_WE);	
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("Use our expertise to correctly package your Competence, Experience and Expertise! Get our experts to write your resume You have the experience and skills, we have the expertise for its effective communication. Your expertise, managerial skills and acumen are portrayed in your resume by our experts to deliver a strong impact."),result);		
		//To verify that Text Resume Senior level features are displayed or not
		result = generic.GetElementText_WE(TextResumePage.Feature1_WE);			
		Assert.assertTrue(result.equals("In-house team of experts with over 10 years of experience"),result);	
		result = generic.GetElementText_WE(TextResumePage.Feature2_WE);			
		Assert.assertTrue(result.equals("Attractive and Recruiter friendly resume format"),result);
		result = generic.GetElementText_WE(TextResumePage.Feature3_WE);			
		Assert.assertTrue(result.equals("Telephonic discussion with the Resume Writer to understand your goals and achievements. Iterations over email as needed, to deliver a resume right for your need"),result);
		result = generic.GetElementText_WE(TextResumePage.Feature4_WE);			
		Assert.assertTrue(result.equals("Over 95% satisfaction rate"),result);
		result = generic.GetElementText_WE(TextResumePage.Feature5_WE);			
		Assert.assertTrue(result.equals("Summarise your expertise in a structured Cover Letter* that showcases your skills and acumen"),result);
		//To verify that Text Resume Sample Link is displayed for Senior level
		result = generic.GetElementText_WE(TextResumePage.SeeTextResumeSamples_Lnk);		
		Assert.assertTrue(result.equals("View Senior Level Resume Samples"),result);	
		//To verify that How it Works heading is displayed or not
		result = generic.GetElementText_WE(TextResumePage.HowItWorks_WE);		
		Assert.assertTrue(result.equals("How it works?"),result);		
		//To verify that Step1 details are displayed or not
		result = generic.GetElementText_WE(TextResumePage.Step1_WE);
		result = result.replace("\n\n", " ");
		System.out.println(result);
		Assert.assertTrue(result.equals("STEP 1 Resume writer gets assigned and calls you to discuss your expectations & asks for relevant details"),result);		
		//To verify that Step2 details are displayed or not
		result = generic.GetElementText_WE(TextResumePage.Step2_WE);
		result = result.replace("\n\n", " ");
		Assert.assertTrue(result.equals("STEP 2 You Receive the First Draft and give feedback to resume writer"),result);		
		//To verify that Step3 details are displayed or not
		result = generic.GetElementText_WE(TextResumePage.Step3_WE);		
		result = result.replace("\n\n", " ");
		Assert.assertTrue(result.equals("STEP 3 Resume writer sends you resume draft"),result);		
		//To verify that Step4 details are displayed or not
		result = generic.GetElementText_WE(TextResumePage.Step4_WE);
		result = result.replace("\n\n", " ");
		Assert.assertTrue(result.equals("STEP 4 You approve resume draft and your resume is sent for activation of other paid services if any."),result);
		//To verify that Recommended services for you Heading is displayed or not
		result = generic.GetElementText_WE(TextResumePage.RecommendedServiceHeading_WE);			
		Assert.assertTrue(result.equals("Recommended services for you"),result);
		//To verify that RecruiterConnection Heading is displayed or not
		result = generic.GetElementText_WE(TextResumePage.RecruiterConnectionHeading_WE);			
		Assert.assertTrue(result.equals("RecruiterConnection"),result);	
		//To verify that RecruiterConnection Content is displayed or not
		result = generic.GetElementText_WE(TextResumePage.RecruiterConnectionContent_WE);			
		result =result.replace("\n", " ");
		Assert.assertTrue(result.equals("Expand your reach amongst recruiters Search our database of recruiters and contact recruiters who hire in your domain/industry."),result);
		//To verify that Find Recruiters Button is displayed or not
		result = generic.GetElementText_WE(TextResumePage.findRecruiters_Btn);			
		Assert.assertTrue(result.equals("Find Recruiters"),result);
		//To verify that Jobs on mail and SMS Heading is displayed or not
		result = generic.GetElementText_WE(TextResumePage.JobsOnMailandSMSHeading_WE);			
		Assert.assertTrue(result.equals("Jobs on Mail and SMS"),result);
		//To verify that Jobs on mail and SMS Content is displayed or not
		result = generic.GetElementText_WE(TextResumePage.JobsOnMailandSMSContent_WE);
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("Know about job openings in real time and be an early applicant Let our experts send the best jobs for you on mail and sms. Be an early applicant and never miss out on any relevant job opening"),result);
		//To verify that Get Jobs on mail and SMS Button is displayed or not
		result = generic.GetElementText_WE(TextResumePage.GetJobsOnMailandSMS_Btn);			
		Assert.assertTrue(result.equals("Get Jobs on Mails and SMS"),result);	
		//To verify that Delivery Information Heading is displayed or not
		result = generic.GetElementText_WE(TextResumePage.DeliveryInformationHeading_WE);			
		Assert.assertTrue(result.equals("Delivery Information"),result);
		//To verify Delivery Information content is displayed or not
		result = generic.GetElementText_WE(TextResumePage.DeliveryInformationContent_WE);	
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("Delivery Information If not availed with resume writing, these services will be processed 8 working days after we receive your updated resume. However, if you avail these services with resume writing, these services will be processed within 8 working days after you approve your final resume."),result);

	}
}


