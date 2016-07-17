
package com.naukri.FastForwardRevamp.TestSuite;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naukri.FastForwardRevamp.Code.HomePage;
import com.naukri.FastForwardRevamp.Code.Jobs4UPage;
import com.naukri.FastForwardRevamp.Code.RecruiterConnectionPage;
import com.naukri.FastForwardRevamp.Code.VisualResumePage;
import com.naukri.FastForwardRevamp.ConfigDetails.ConfigDetails;
import com.naukri.FastForwardRevamp.ConfigDetails.URLProvider;
import com.naukri.GenericFunctionsPack.GenericFunctions;
import com.naukri.datatable.Xls_Reader;


public class TestCases_VisualResumePage extends ConfigDetails {
	Xls_Reader datatable;
	String SheetName = "sheet1";
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
	public void TC_VR_001()
	{
		driver.get (URLProvider.Return_VisualResume_MidLevelURL());
		generic.Click(VisualResumePage.Naukri_Lnk);
		String result = generic.GetElementText_WE(HomePage.HP_Image_WE);
		result = result.replace("\n", " ");
		Assert.assertEquals("Speed Up Your Career with our personalized services",result);	
	}

	@Test
	//To verify that on clicking Visual Resume Samples link it lands to Resume Samples page
	public void TC_VR_002()
	{
		driver.get (URLProvider.Return_VisualResume_MidLevelURL());		
		generic.Click_Lnk(VisualResumePage.SeeVisualResumeSamples_Lnk);		
		String result = driver.getCurrentUrl();
		Assert.assertTrue(result.equals(URLProvider.Return_VisualResumeSampleURL()),result);	
	}	

	@Test
	//To verify that on clicking Find Recruiters Button recruiter Connection page is displayed or not
	public void TC_VR_003()
	{
		driver.get (URLProvider.Return_VisualResume_MidLevelURL());	
		generic.Click_Lnk(VisualResumePage.findRecruiters_Btn);	
		String result = generic.GetElementText(RecruiterConnectionPage.BreadCrum_WE);
		Assert.assertTrue(result.equals("Naukri FastForward > RecruiterConnection"));	
	}

	@Test
	//To verify that on clicking Get Jobs on mail and SMS Button Jobs4U page is displayed or not
	public void TC_VR_004()
	{
		driver.get (URLProvider.Return_VisualResume_MidLevelURL());
		generic.Click_Lnk(VisualResumePage.GetJobsOnMailandSMS_Btn);
		String result = generic.GetElementText(Jobs4UPage.Breadcrum_WE);
		Assert.assertTrue(result.equals("Naukri FastForward > Jobs4U"));	
	}	
	@Test
	//To verify that Static content on Visual resume page
	public void TC_VR_005()
	{
		driver.get (URLProvider.Return_VisualResume_MidLevelURL());
		generic.Click_Lnk(VisualResumePage.EntryLevel_Lnk);		
		generic.GoToSleep(2000);
		String result = generic.GetElementText_WE(VisualResumePage.Breadcrum_WE);			
		Assert.assertTrue(result.equals("Naukri FastForward >Visual Resume Writing for Entry Level Professionals"),result);		
		//To verify that Visual Resume Entry level Hero line is displayed or not

		result = generic.GetElementText_WE(VisualResumePage.Heroline_WE);			
		Assert.assertTrue(result.equals("Switch to Visual Resume for Fresher’s"),result);
		//To verify that Mid Level Bread crumb is displayed or not

		generic.Click_Lnk(VisualResumePage.MidLevel_Lnk);
		generic.GoToSleep(2000);

		result = generic.GetElementText_WE(VisualResumePage.Breadcrum_WE);			
		Assert.assertTrue(result.equals("Naukri FastForward >Visual Resume Writing for Mid Level Professionals"),result);		
		//To verify that Visual Resume Mid level Hero line is displayed or not

		result = generic.GetElementText_WE(VisualResumePage.Heroline_WE);			
		Assert.assertTrue(result.equals("Switch to Visual Resume for Experienced"),result);
		//To verify that Senior Level Bread crumb is displayed or not

		generic.Click_Lnk(VisualResumePage.SeniorLevel_Lnk);	
		generic.GoToSleep(2000);
		result = generic.GetElementText_WE(VisualResumePage.Breadcrum_WE);			
		Assert.assertTrue(result.equals("Naukri FastForward >Visual Resume Writing for Senior Level Professionals"),result);				

		//To verify that Visual Resume Senior level Hero line is displayed or not

		result = generic.GetElementText_WE(VisualResumePage.Heroline_WE);			
		Assert.assertTrue(result.equals("Switch to Visual Resume for Senior Positions"),result);		

		//To verify that Entry Level Visual Resume Tab is displayed or not

		result = generic.GetElementText_WE(VisualResumePage.EntryLevel_Lnk);	
		result = result.replace("\n", "");
		Assert.assertTrue(result.equals("ENTRY-LEVEL(Exp: 0 to 3 years)"),result);		

		//To verify that Mid Level Visual Resume Tab is displayed or not

		result = generic.GetElementText_WE(VisualResumePage.MidLevel_Lnk);	
		result = result.replace("\n", "");
		Assert.assertTrue(result.equals("MID-LEVEL(Exp: 3 to 8 years)"),result);		

		//To verify that Senior Level Visual Resume Tab is displayed or not

		result = generic.GetElementText_WE(VisualResumePage.SeniorLevel_Lnk);	
		result = result.replace("\n", "");
		Assert.assertTrue(result.equals("SENIOR-LEVEL(Exp: 8 years and above)"),result);		

		//To verify that Visual Resume Entry level Heading and content is displayed or not

		generic.Click_Lnk(VisualResumePage.EntryLevel_Lnk);
		generic.GoToSleep(3000);
		result = generic.GetElementText_WE(VisualResumePage.VisualResumeSubcontent_WE);
		result = result.replace("\n"," ");
		Assert.assertTrue(result.equals("Deliver an elevator pitch in six seconds with a Visual Resume Get our experts to write your resume Enhance your text resume by adding visuals to highlight your strengths and achievements. Recruiters retain visuals more than text giving you a competitive advantage. Visuals also give increased authenticity to the profile"),result);		

		//To verify that Visual Resume Mid level Heading and content is displayed or not

		generic.Click_Lnk(VisualResumePage.MidLevel_Lnk);
		generic.GoToSleep(3000);
		result = generic.GetElementText_WE(VisualResumePage.VisualResumeSubcontent_WE);
		result = result.replace("\n"," ");
		Assert.assertTrue(result.equals("Use Visuals to enhance and highlight your experience Get our experts to write your Resume. Enhance your text resume by adding visuals to highlight your exposure and industry understanding. Recruiters retain visuals more than text giving you a competitive advantage. Visuals also give increased authenticity to the profile"),result);		

		//To verify that Visual Resume Senior level Heading and content is displayed or not

		generic.Click_Lnk(VisualResumePage.SeniorLevel_Lnk);
		generic.GoToSleep(3000);
		result = generic.GetElementText_WE(VisualResumePage.VisualResumeSubcontent_WE);
		result = result.replace("\n"," ");
		Assert.assertTrue(result.equals("Visuals showcase your competence better than words Get our experts to write your Resume. Communicate your skills, talent, competence and acumen by adding visuals to your text resume. Recruiters retain visuals more than text giving you a competitive advantage. Visuals also give increased authenticity to the profile"),result);		

		//To verify that Visual Resume Entry level features are displayed or not

		generic.Click_Lnk(VisualResumePage.EntryLevel_Lnk);
		generic.GoToSleep(3000);
		String result1 = generic.GetElementText_WE(VisualResumePage.Feature1_WE);			
		Assert.assertTrue(result1.equals("In-house team of experts with over 10 years of experience"),result1);	
		String result2 = generic.GetElementText_WE(VisualResumePage.Feature2_WE);			
		Assert.assertTrue(result2.equals("Visually appealing Resume format"),result2);
		String result3 = generic.GetElementText_WE(VisualResumePage.Feature3_WE);			
		Assert.assertTrue(result3.equals("Over 95% satisfaction rate"),result3);
		String result4 = generic.GetElementText_WE(VisualResumePage.Feature4_WE);			
		Assert.assertTrue(result4.equals("Multiple detailed telephonic consultations with Resume Writer"),result4);
		String result5 = generic.GetElementText_WE(VisualResumePage.Feature5_WE);			
		Assert.assertTrue(result5.equals("First draft in 8 working days"),result5);
		String result6 = generic.GetElementText_WE(VisualResumePage.Feature6_WE);			
		Assert.assertTrue(result6.equals("Free Cover Letter to introduce yourself to prospective recruiters in a impactful and crisp manner"),result6);

		//To verify that Visual Resume Mid level features are displayed or not

		generic.Click_Lnk(VisualResumePage.MidLevel_Lnk);
		generic.GoToSleep(3000);
		result1 = generic.GetElementText_WE(VisualResumePage.Feature1_WE);			
		Assert.assertTrue(result1.equals("In-house team of experts with over 10 years of experience"),result1);	
		result2 = generic.GetElementText_WE(VisualResumePage.Feature2_WE);			
		Assert.assertTrue(result2.equals("Visually appealing Resume format"),result2);
		result3 = generic.GetElementText_WE(VisualResumePage.Feature3_WE);			
		Assert.assertTrue(result3.equals("Over 95% satisfaction rate"),result3);
		result4 = generic.GetElementText_WE(VisualResumePage.Feature4_WE);			
		Assert.assertTrue(result4.equals("Multiple detailed telephonic consultations with Resume Writer"),result4);
		result5 = generic.GetElementText_WE(VisualResumePage.Feature5_WE);			
		Assert.assertTrue(result5.equals("First draft in 8 working days"),result5);
		result6 = generic.GetElementText_WE(VisualResumePage.Feature6_WE);			
		Assert.assertTrue(result6.equals("Free Cover Letter customised to highlight your accomplishments and suit your job search"),result6);

		//To verify that Visual Resume Senior level features are displayed or not

		generic.Click_Lnk(VisualResumePage.SeniorLevel_Lnk);
		generic.GoToSleep(3000);
		result1 = generic.GetElementText_WE(VisualResumePage.Feature1_WE);			
		Assert.assertTrue(result1.equals("In-house team of experts with over 10 years of experience"),result1);	
		result2 = generic.GetElementText_WE(VisualResumePage.Feature2_WE);			
		Assert.assertTrue(result2.equals("Visually appealing Resume format"),result2);
		result3 = generic.GetElementText_WE(VisualResumePage.Feature3_WE);			
		Assert.assertTrue(result3.equals("Over 95% satisfaction rate"),result3);
		result4 = generic.GetElementText_WE(VisualResumePage.Feature4_WE);			
		Assert.assertTrue(result4.equals("Multiple detailed telephonic consultations with Resume Writer"),result4);
		result5 = generic.GetElementText_WE(VisualResumePage.Feature5_WE);			
		Assert.assertTrue(result5.equals("First draft in 8 working days"),result5);
		result6 = generic.GetElementText_WE(VisualResumePage.Feature6_WE);			
		Assert.assertTrue(result6.equals("Free Cover Letter to summarise your expertise in a structured manner."),result6);

		//To verify that Visual Resume Sample Link is displayed or not

		result = generic.GetElementText_WE(VisualResumePage.SeeVisualResumeSamples_Lnk);		
		Assert.assertTrue(result.equals("See Visual Resume Samples"),result);
		//To verify that How it Works heading is displayed or not

		result = generic.GetElementText_WE(VisualResumePage.HowItWorks_WE);		
		Assert.assertTrue(result.equals("How it works?"),result);		

		//To verify that Step1 details are displayed or not

		result = generic.GetElementText_WE(VisualResumePage.Step1_WE);
		result = result.replace("\n\n", " ");
		Assert.assertTrue(result.equals("STEP 1 Resume writer gets assigned and calls you to discuss your expectations & asks for relevant visuals*"),result);		

		//To verify that Step2 details are displayed or not

		result = generic.GetElementText_WE(VisualResumePage.Step2_WE);
		result = result.replace("\n\n", " ");
		Assert.assertTrue(result.equals("STEP 2 You receive a mail asking for relevant visuals to be sent"),result);		

		//To verify that Step3 details are displayed or not

		result = generic.GetElementText_WE(VisualResumePage.Step3_WE);		
		result = result.replace("\n\n", " ");
		Assert.assertTrue(result.equals("STEP 3 You Receive the First Draft,give feedback and resume writer send you the updated resume"),result);		

		//To verify that Step4 details are displayed or not

		result = generic.GetElementText_WE(VisualResumePage.Step4_WE);
		result = result.replace("\n\n", " ");
		Assert.assertTrue(result.equals("STEP 4 You approve resume draft and Your resume is sent for activation of other paid services if any."),result);	

		//To verify that Recommended services for you Heading is displayed or not

		result = generic.GetElementText_WE(VisualResumePage.RecommendedServiceHeading_WE);			
		Assert.assertTrue(result.equals("Recommended services for you"),result);	

		//To verify that RecruiterConnection Heading is displayed or not

		result = generic.GetElementText_WE(VisualResumePage.RecruiterConnectionHeading_WE);			
		Assert.assertTrue(result.equals("RecruiterConnection"),result);	

		//To verify that RecruiterConnection Content is displayed or not

		result = generic.GetElementText_WE(VisualResumePage.RecruiterConnectionContent_WE);			
		result =result.replace("\n", " ");
		Assert.assertTrue(result.equals("Expand your reach amongst recruiters Search our database of recruiters and contact recruiters who hire in your domain/industry."),result);	

		//To verify that Find Recruiters Button is displayed or not

		result = generic.GetElementText_WE(VisualResumePage.findRecruiters_Btn);			
		Assert.assertTrue(result.equals("Find Recruiters"),result);	

		//To verify that Jobs on mail and SMS Heading is displayed or not

		result = generic.GetElementText_WE(VisualResumePage.JobsOnMailandSMSHeading_WE);			
		Assert.assertTrue(result.equals("Jobs on Mail and SMS"),result);	

		//To verify that Jobs on mail and SMS Content is displayed or not

		result = generic.GetElementText_WE(VisualResumePage.JobsOnMailandSMSContent_WE);
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("Know about job openings in real time and be an early applicant Let our experts send the best jobs for you on mail and sms. Be an early applicant and never miss out on any relevant job opening"),result);	

		//To verify that Get Jobs on mail and SMS Button is displayed or not

		result = generic.GetElementText_WE(VisualResumePage.GetJobsOnMailandSMS_Btn);			
		Assert.assertTrue(result.equals("Get Jobs on Mails and SMS"),result);	
		//To verify that Delivery Information Heading is displayed or not

		result = generic.GetElementText_WE(VisualResumePage.DeliveryInformationHeading_WE);			
		Assert.assertTrue(result.equals("Delivery Information"),result);

		//To verify Delivery Information content is displayed or not

		result = generic.GetElementText_WE(VisualResumePage.DeliveryInformationContent_WE);	
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("Delivery Information If not availed with resume writing, these services will be processed 8 working days after we receive your updated resume. However, if you avail these services with resume writing, these services will be processed within 8 working days after you approve your final resume."),result);

	}
}





