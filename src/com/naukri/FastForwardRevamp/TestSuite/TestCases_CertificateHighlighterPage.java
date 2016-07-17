package com.naukri.FastForwardRevamp.TestSuite;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naukri.FastForwardRevamp.Code.CertificateHighlighterPage;
import com.naukri.FastForwardRevamp.Code.HomePage;
import com.naukri.FastForwardRevamp.ConfigDetails.ConfigDetails;
import com.naukri.FastForwardRevamp.ConfigDetails.URLProvider;
import com.naukri.GenericFunctionsPack.GenericFunctions;
import com.naukri.datatable.Xls_Reader;

public class TestCases_CertificateHighlighterPage extends ConfigDetails {

	Xls_Reader datatable;

	@BeforeMethod
	public void Before(){
		generic = new GenericFunctions(driver);
		driver = generic.StartDriver(Driver_Type);
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void After(){
		driver.quit();
	}

	@Test
	//To verify that on clicking Naukri link in Bread crumb home page is displayed
	public void TC_CH_001()
	{
		driver.get(URLProvider.Return_CertificateHighlighterURL());
		generic.Click_Lnk(CertificateHighlighterPage.Naukri_Lnk);	
		String result = generic.GetElementText_WE(HomePage.HP_Image_WE);
		result = result.replace("\n", " ");
		Assert.assertEquals("Speed Up Your Career with our personalized services",result);	
	}
	@Test
	//To verify that on clicking Sample image1 Resume Search Sample is displayed
	public void TC_CH_002()
	{
		driver.get(URLProvider.Return_CertificateHighlighterURL());
		generic.Click(CertificateHighlighterPage.ProfileSample1_WE);			
		Assert.assertTrue(generic.isVisible(CertificateHighlighterPage.ResumeSearchImage_WE));	
	}
	@Test
	//To verify that on clicking Sample image2 User Profile Sample is displayed
	public void TC_CH_003()
	{
		driver.get(URLProvider.Return_CertificateHighlighterURL());
		generic.Click(CertificateHighlighterPage.ProfileSample2_WE);			
		Assert.assertTrue(generic.isVisible(CertificateHighlighterPage.UserProfileImage_WE));	
	}

	@Test
	//To verify that Certificate Highlighter static content displayed or not
	public void TC_CH_004()
	{
		driver.get(URLProvider.Return_CertificateHighlighterURL());
		String result = generic.GetElementText_WE(CertificateHighlighterPage.BreadCrum_WE);			
		Assert.assertTrue(result.equals("Naukri FastForward > Certification Highlighter"),result);		

		//To verify that Certificate Highlighter Hero Line is displayed or not

		result = generic.GetElementText_WE(CertificateHighlighterPage.HeroLine_WE);	
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("Improve your chance of getting Shortlisted through Certification Highlighter"),result);		

		//To verify that 'Why you must take cerification highlighter?' heading is displayed or not

		result = generic.GetElementText_WE(CertificateHighlighterPage.WhyYouMustHeading_WE);	
		result = result.replace("\n", "");
		Assert.assertTrue(result.equals("Why you must take Certification Highlighter?Recruiters seek for certified candidates, Pro actively highlight your certificate on Naukri profileRecruiters look for authentic certificate to verify your qualification. Naukri will highlight your score and certificate on your profile when recruiters search your resume. Recruiter can also open and view your certificate. Impress recruiters with your Basic or Advanced certification and increase your chances of getting a call."),result);		

		//To verify that 'Buy our Certification Highlighter subscription' heading is displayed or not

		result = generic.GetElementText_WE(CertificateHighlighterPage.BuyCertificateHeading_WE);			
		Assert.assertTrue(result.equals("Buy our Certification Highlighter subscription"),result);		

		//To verify that 'Highlight Your Certifications on Naukri Profile' Section is displayed or not

		result = generic.GetElementText_WE(CertificateHighlighterPage.HighlightCertificateSection_WE);
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("Highlight Your Certifications on Naukri Profile Your profile is marked as "+"\""+ "Featured"+"\""+" to make you stand out in the Naukri Database as an active jobseeker."),result);		

		//To verify that 'Increase your chances to get shortlisted' Section is displayed or not

		result = generic.GetElementText_WE(CertificateHighlighterPage.IncreaseYourChancesSection_WE);			
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("Increase your chances to get shortlisted Recruiter can verify your skills and expertise by viewing your certificate before anyone else which increases your chances of getting a call."),result);		

		//To verify that 'How it will look like on your profile?' heading is displayed or not

		result = generic.GetElementText_WE(CertificateHighlighterPage.HowItWillLook_WE);			
		Assert.assertTrue(result.equals("How it will look like on your profile?"),result);		

		//To verify that How it Works Section is displayed on Recruiter Connection page 

		result = generic.GetElementText_WE(CertificateHighlighterPage.HowItWorks_WE);			
		Assert.assertTrue(result.equals("How it works"),result);		

		//To verify that Step1 details are displayed or not

		result = generic.GetElementText_WE(CertificateHighlighterPage.Step1_WE);	
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("STEP 1  Complete the course or certification"),result);		

		//To verify that Step2 details are displayed or not

		result = generic.GetElementText_WE(CertificateHighlighterPage.Step2_WE);	
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("STEP 2  Upload the certification softcopy along with details"),result);		

		//To verify that Step3 details are displayed or not

		result = generic.GetElementText_WE(CertificateHighlighterPage.Step3_WE);	
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("STEP 3  Naukri Expert will validate the expiry of the certification and upload"),result);		

		//To verify that Step4 details are displayed or not

		result = generic.GetElementText_WE(CertificateHighlighterPage.Step4_WE);	
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("STEP 4  Certification is highlighted on the learner’s profile in recruiter's search"),result);		


		//To verify that Sample Image1 Content is displayed on Certificte Highlighter Page

		result = generic.GetElementText(CertificateHighlighterPage.SampleImage1Content_WE);			
		Assert.assertEquals(result, "Recruiter will be able to view your skills and expertise when they search resume on Naukri.");	

		//To verify that Sample Image2 Content is displayed on Certificte Highlighter Page

		result = generic.GetElementText(CertificateHighlighterPage.SampleImage2Content_WE);			
		Assert.assertEquals(result, "Recruiter can view your skills and certificate and verify your expertise.");	
	}
}
