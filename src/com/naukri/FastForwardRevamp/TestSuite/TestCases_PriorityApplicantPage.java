package com.naukri.FastForwardRevamp.TestSuite;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naukri.FastForwardRevamp.Code.PriorityApplicantPage;
import com.naukri.FastForwardRevamp.Code.ResumeDisplayPage;
import com.naukri.FastForwardRevamp.Code.VisualResumePage;
import com.naukri.FastForwardRevamp.ConfigDetails.ConfigDetails;
import com.naukri.FastForwardRevamp.ConfigDetails.URLProvider;
import com.naukri.GenericFunctionsPack.GenericFunctions;
import com.naukri.datatable.Xls_Reader;

public class TestCases_PriorityApplicantPage extends ConfigDetails {
	Xls_Reader datatable;
	String SheetName ="Sheet1";
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
	//To verify that on clicking 'Naukri Fast Forward' link displayed in bread crumb on Priority Applicant Service page, it redirects to FF home page
	public void TC_PA_001()
	{		
		driver.get(URLProvider.Return_PriorityApplicantURL());
		generic.Click_Lnk(PriorityApplicantPage.BreadCrumb_Home_Lnk);
		String result =driver.getCurrentUrl();
		Assert.assertTrue(result.equals(URLProvider.Return_HomePageURL()));
	}

	//To verify that static content of Priority Applicant is displayed
	@Test
	public void TC_PA_002()
	{		
		driver.get(URLProvider.Return_PriorityApplicantURL());
		String result= generic.GetElementText_WE(PriorityApplicantPage.BreadCrumb_PriorityApplicant_WE);		
		Assert.assertTrue(result.equals("Naukri FastForward > Priority Applicant"));

		//To verify that Priority Applicant Hero Line is displayed

		result= generic.GetElementText_WE(PriorityApplicantPage.HerolineHeading_WE);		
		result = result.replace("\n", " ");

		//To verify 'Why you might not be getting calls from Recruiters?' Text is displayed on Priority Applicant Service Page

		result= generic.GetElementText_WE(PriorityApplicantPage.Why_you_might_not_be_getting_calls_WE);
		result= result.replace("\n", " ");			
		Assert.assertTrue(result.equals("Why you might not be getting calls from Recruiters?"));

		//To verify 'Your application might be getting lost. Thousands of other applicants also apply to the same job.' Text is displayed under 'Why you might not be getting calls?' heading on Priority Applicant Service Page

		result= generic.GetElementText_WE(PriorityApplicantPage.YourApplicationMight_WE);		
		result= result.replace("\n", " ");			
		Assert.assertTrue(result.equals("Your application might be getting lost. Thousands of other applicants also apply to the same job."));

		//To verify 'Your application might be getting lost' Image is displayed under 'Why you might not be getting calls?' heading on Priority Applicant Service Page

		Assert.assertTrue(generic.isVisible(PriorityApplicantPage.YourApplicationMight_image_WE));

		//To verify 'You might have applied late!The first 20% applicants are 4 times more likely to be shortlisted.' Text is displayed under 'Why you might not be getting calls?' heading on Priority Applicant Service Page

		result= generic.GetElementText_WE(PriorityApplicantPage.You_might_have_applied_late_WE);		
		result= result.replace("\n", " ");			

		//To verify 'You might have applied late' Image is displayed under 'Why you might not be getting calls?' heading on Priority Applicant Service Page

		Assert.assertTrue(generic.isVisible(PriorityApplicantPage.You_might_have_applied_late_image_WE));

		//To verify 'Why become a Priority Applicant?' Text is displayed on Priority Applicant Service Page

		result= generic.GetElementText_WE(PriorityApplicantPage.Why_become_a_Priority_Applicant_WE);
		result= result.replace("\n", " ");			
		Assert.assertTrue(result.equals("Why become a Priority Applicant?"));

		//To verify 'Receive the most relevant jobs via SMS/Mail within 30 min of them being posted on Naukri' Text is displayed under 'Why become a Priority Applicant?' heading on Priority Applicant Service Page

		result= generic.GetElementText_WE(PriorityApplicantPage.Receive_the_most_relevant_WE);

		result= result.replace("\n", " ");			
		Assert.assertTrue(result.equals("Receive the most relevant jobs via SMS/Mail within 30 min of them being posted on Naukri"));

		//To verify 'Receive the most relevant' Image is displayed under 'Why become a Priority Applicant?' heading on Priority Applicant Service Page

		Assert.assertTrue(generic.isVisible(PriorityApplicantPage.Receive_the_most_relevant_image_WE));

		//To verify 'Apply to the jobs through SMS/website and get noticed as an early applicant' Text is displayed under 'Why become a Priority Applicant?' heading on Priority Applicant Service Page

		result= generic.GetElementText_WE(PriorityApplicantPage.Apply_to_the_jobs_WE);		
		result= result.replace("\n", " ");			
		Assert.assertTrue(result.equals("Apply to the jobs through SMS/website and get noticed as an early applicant"));

		//To verify 'Apply to the jobs' Image is displayed under 'Why become a Priority Applicant?' heading on Priority Applicant Service Page

		Assert.assertTrue(generic.isVisible(PriorityApplicantPage.Apply_to_the_jobs_image_WE));

		//To verify "Your application will be highlighted to catch Recruiters' attention" Text is displayed under 'Why become a Priority Applicant?' heading on Priority Applicant Service Page

		result= generic.GetElementText_WE(PriorityApplicantPage.Your_application_will_be_highlighted_WE);
		result= result.replace("\n", " ");			
		Assert.assertTrue(result.equals("Your application will be highlighted to catch Recruiters' attention"));

		//To verify 'Your application will be highlighted' Image is displayed under 'Why become a Priority Applicant?' heading on Priority Applicant Service Page

		Assert.assertTrue(generic.isVisible(PriorityApplicantPage.Your_application_will_be_highlighted_image_WE));

		//To verify 'Buy our Priority Applicant subscription' Text heading on Priority Applicant Service Page

		result= generic.GetElementText_WE(PriorityApplicantPage.Buy_our_Priority_Applicant_subscription_WE);
		result= result.replace("\n", " ");			

		//To verify 'Subscription' Text is displayed under 'Buy our Priority Applicant subscription' heading on Priority Applicant Service Page

		result= generic.GetElementText_WE(PriorityApplicantPage.Subscription_WE);

		result= result.replace("\n", " ");			
		Assert.assertTrue(result.equals("Subscription:"));
		//To verify that Recommended services section
		result= generic.GetElementText_WE(PriorityApplicantPage.RecommendedServiceHeading_WE);
		Assert.assertEquals(result, "Job seeker who buy Priority Applicant also buy");
		result= generic.GetElementText_WE(PriorityApplicantPage.ResumeDisplayHeading_WE);
		Assert.assertEquals(result, "Resume Display");
		result= generic.GetElementText_WE(PriorityApplicantPage.ResumeDisplayContent_WE);
		result= result.replace("\n", " ");			
		Assert.assertEquals(result, "Increase your profile views by 3 times Your profile is marked as 'Featured' to make you stand out in the Naukri Database as an active jobseeker Be Accessible To More Recruiters");
		result= generic.GetElementText_WE(PriorityApplicantPage.VisualResumeHeading_WE);
		Assert.assertEquals(result, "Visual Resume");
		result= generic.GetElementText_WE(PriorityApplicantPage.VisualResumeContent_WE);
		result = result.replace("\n", " ");
		Assert.assertEquals(result, "Use Visuals to enhance and highlight your experience Get our experts to write your Resume Over 95% satisfaction rate of Resumes created by Naukri Experts");
	}
	@Test
	//To verify that on clicking Get Highligted Link it lands to Resume Display page
	public void TC_PA_003()
	{		
		driver.get(URLProvider.Return_PriorityApplicantURL());
		generic.Click_Lnk(PriorityApplicantPage.GetHighlighted_Btn);
		String result = generic.GetElementText(ResumeDisplayPage.Breadcrum_WE);
		Assert.assertTrue(result.equals("Naukri FastForward > Resume Display"));
	}
	@Test
	//To verify that on clicking Visual Resume Link it lands to Visual Resume page
	public void TC_PA_004()
	{		
		driver.get(URLProvider.Return_PriorityApplicantURL());
		generic.Click_Lnk(PriorityApplicantPage.VisualResume_Btn);
		String result = generic.GetElementText(VisualResumePage.Breadcrum_WE);
		Assert.assertTrue(result.equals("Naukri FastForward >Visual Resume Writing for Mid Level Professionals"));
	}
}
