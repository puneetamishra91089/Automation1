package com.naukri.FastForwardRevamp.TestSuite;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naukri.FastForwardRevamp.Code.CoverLetterSamplePage;
import com.naukri.FastForwardRevamp.Code.ElearningPage;
import com.naukri.FastForwardRevamp.Code.HomePage;
import com.naukri.FastForwardRevamp.Code.HomePageTopLeadForm;
import com.naukri.FastForwardRevamp.Code.Jobs4UPage;
import com.naukri.FastForwardRevamp.Code.LoginLayer;
import com.naukri.FastForwardRevamp.Code.RecruiterConnectionPage;
import com.naukri.FastForwardRevamp.Code.ResumeDisplayPage;
import com.naukri.FastForwardRevamp.Code.ResumeQualityScorePage;
import com.naukri.FastForwardRevamp.Code.TextResumePage;
import com.naukri.FastForwardRevamp.Code.TextResumeSamplePage;
import com.naukri.FastForwardRevamp.Code.VisualResumePage;
import com.naukri.FastForwardRevamp.Code.VisualResumeSamplePage;
import com.naukri.FastForwardRevamp.ConfigDetails.ConfigDetails;
import com.naukri.FastForwardRevamp.ConfigDetails.URLProvider;
import com.naukri.GenericFunctionsPack.GenericFunctions;
import com.naukri.datatable.Xls_Reader;

public class Testcases_HomePage extends ConfigDetails {

	@BeforeMethod
	public void Before(){
		generic = new GenericFunctions(driver);
		driver = generic.StartDriver(Driver_Type);
		driver.manage().window().maximize();
	}

	@Test
	//To verify that Home Page Static content is displayed or not	
	public void TC_Home_001()
	{
		driver.get(URLProvider.Return_HomePageURL());		
		String result = generic.GetElementText_WE(HomePage.HP_Image_WE);
		result = result.replace("\n", " ");
		Assert.assertEquals("Speed Up Your Career with our personalized services",result);		

		//To verify that Home page Resume heading is displayed or not
		result =generic.GetElementText_WE(HomePage.HP_ResumeHeading_WE);
		Assert.assertTrue(result.equals("I need an impressive resume"));

		//To verify that Text Resume image is displayed or not
		Assert.assertTrue(generic.isVisible(HomePage.HP_TextResumeImage_Lnk), "");		

		//To verify that Visual Resume image is displayed or not

		Assert.assertTrue(generic.isVisible(HomePage.HP_VisualResumeImage_Lnk), "");		

		//To verify that Text resume heading is displayed or not

		result = generic.GetLinkText_Lnk(HomePage.HP_TextResumeHeading_Lnk);
		Assert.assertTrue(result.equals("Text Resume"),result);		

		//To verify that Visual resume heading is displayed or not

		result = generic.GetLinkText_Lnk(HomePage.HP_VisualResumeHeading_Lnk);
		Assert.assertTrue(result.equals("Visual Resume"),result);		

		//To verify that Text resume content is displayed or not 

		result = generic.GetElementText_WE(HomePage.HP_TextResumeContent_WE);
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("Get your customised resume crafted by Naukri experts"),result);		

		//To verify that Text resume Sub content is displayed or not 

		result = generic.GetElementText_WE(HomePage.HP_TextResumeSubContent_WE);
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("Showcase your career goals and achievements with the right keywords to make your resume stand out at the first glance."),result);		


		//To verify that Visual resume content is displayed or not 

		result = generic.GetElementText_WE(HomePage.HP_VisualResumeContent_WE);
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("Showcase your career milestones in 6 seconds with Visuals"),result);		

		//To verify that Visual resume Sub content is displayed or not 

		result = generic.GetElementText_WE(HomePage.HP_VisualResumeSubContent_WE);
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("Create a lasting impression on recruiters by adding relevant visuals to the key highlights of your experience."),result);		

		//To verify that Text resume Link is displayed or not 

		result = generic.GetLinkText_Lnk(HomePage.HP_GetTextResume_Lnk);			
		Assert.assertTrue(result.equals("Get Text Resume"),result);

		//To verify that Visual resume Link is displayed or not 

		result = generic.GetLinkText_Lnk(HomePage.HP_GetVisualResume_Lnk);			
		Assert.assertTrue(result.equals("Get Visual Resume"),result);
		//To verify that resume Quality Report heading is displayed or not

		result = generic.GetLinkText_Lnk(HomePage.Hp_ResumeQualityScoreHeading_WE);		
		Assert.assertTrue(result.equals("Resume Quality Report"),result);		

		//To verify that resume Quality Report content is displayed or not

		result = generic.GetLinkText_Lnk(HomePage.HP_ResumeQualityScoreContent_WE);		
		Assert.assertTrue(result.equals("Know where your resume quality stands amongst others for FREE"),result);		

		//To verify that resume Quality Report link is displayed or not

		result = generic.GetLinkText_Lnk(HomePage.HP_ResumeQualityGetReport_Lnk);			
		Assert.assertTrue(result.equals("Get Report"),result);

		//To verify that Resume Sample heading is displayed or not

		result = generic.GetLinkText_Lnk(HomePage.HP_ResumeSampleHeading_WE);			
		Assert.assertTrue(result.equals("Resume Samples"),result);		

		//To verify that Resume Samples content is displayed or not

		result = generic.GetElementText_WE(HomePage.HP_ResumeSampleContent_WE);
		Assert.assertTrue(result.equals("View select text and visual resume samples across industries"),result);		

		//To verify that Text Resume Sample link is displayed or not

		result = generic.GetLinkText_Lnk(HomePage.HP_TextResumeSample_Lnk);			
		Assert.assertTrue(result.equals("Text Resume"),result);


		//To verify that Visual Resume Sample Link is displayed or not

		result = generic.GetLinkText_Lnk(HomePage.HP_VisualResumeSample_Lnk);			
		Assert.assertTrue(result.equals("Visual Resume"),result);	



		//To verify that Cover letter heading is displayed or not

		result = generic.GetLinkText_Lnk(HomePage.HP_Coverletter_Heading);			
		Assert.assertTrue(result.equals("Cover letter Samples"),result);

		//To verify that Cover letter content is displayed or not

		result = generic.GetElementText_WE(HomePage.HP_Coverletter_Content);			
		Assert.assertTrue(result.equals("View select cover letter samples across industries"),result);


		//To verify that Cover letter link is displayed or not

		result = generic.GetLinkText_Lnk(HomePage.HP_Coverletter_Lnk);			
		Assert.assertTrue(result.equals("Cover Letters"),result);

		//To verify that Recruiters reach heading is displayed or not

		result = generic.GetElementText_WE(HomePage.HP_RecruitersHeading_WE);
		Assert.assertTrue(result.equals("I want my profile to reach more recruiters"),result);		

		//To verify that RecruiterConnection Image is displayed or not

		Assert.assertTrue(generic.isVisible(HomePage.HP_RecruiterConnectionImage_Lnk), "");		

		//To verify that Resume Display Image is displayed or not

		Assert.assertTrue(generic.isVisible(HomePage.HP_ResumeDisplayImage_Lnk), "");		

		//To verify that RecruiterConnection heading is displayed or not

		result = generic.GetLinkText_Lnk(HomePage.HP_RecruiterConnectionHeading_Lnk);			
		Assert.assertTrue(result.equals("RecruiterConnection"),result);		


		//To verify that RecruiterConnection content is displayed or not

		result = generic.GetElementText_WE(HomePage.HP_RecruiterConnectionContent_WE);
		Assert.assertTrue(result.equals("Connect with recruiters in your field"),result);		

		//To verify that RecruiterConnection Sub content is displayed or not

		result = generic.GetElementText_WE(HomePage.HP_RecruiterConnectionSubContent_WE);
		//result = result.replace("\n", " ");	
		Assert.assertTrue(result.equals("Search our database of 50,000+ recruiters and connect with the right recruiters through personalised messages. Follow them to stay updated about relevant job opportunities."),result);		

		//To verify that Find Recruiters link for RecruiterConnection is displayed or not

		result = generic.GetLinkText_Lnk(HomePage.HP_FindRecriuters_Lnk);			
		Assert.assertTrue(result.equals("Find Recruiters"),result);

		//To verify that Resume Display heading is displayed or not

		result = generic.GetLinkText_Lnk(HomePage.HP_ResumeDisplayHeading_Lnk);			
		Assert.assertTrue(result.equals("Resume Display"),result);		

		//To verify that Resume Display content is displayed or not

		result = generic.GetElementText_WE(HomePage.HP_ResumeDisplayContent_WE);
		Assert.assertTrue(result.equals("Get featured and increase your profile views by 3X"),result);		

		//To verify that Resume Display Sub content is displayed or not

		result = generic.GetElementText_WE(HomePage.HP_ResumeDisplaySubContent_WE);
		Assert.assertTrue(result.equals("Get your profile marked as ‘Featured’ and rank higher when recruiters search for jobseeker profiles in the Naukri database."),result);		

		//To verify that Get Highlighted link for Resume Display is displayed or not

		result = generic.GetElementText_WE(HomePage.HP_GetHighlighted_Lnk);			
		Assert.assertTrue(result.equals("Get Highlighted"),result);

		//To verify that E-learning Heading is displayed or not

		result = generic.GetElementText_WE(HomePage.HP_ProfileHeading_WE);			
		Assert.assertTrue(result.equals("I want to upgrade my skills"),result);		

		//To verify that E-courses and Certifications Image is displayed or not

		Assert.assertTrue(generic.isVisible(HomePage.HP_ECourseImage_Lnk), "");		

		//To verify that e-Courses and Certifications heading is displayed or not

		result = generic.GetElementText_WE(HomePage.HP_EcoursesHeading_Lnk);			
		Assert.assertTrue(result.equals("e-Learning and Certifications"),result);		

		//To verify that e-Courses and Certifications content is displayed or not

		result = generic.GetElementText_WE(HomePage.HP_EcoursesContent_WE);
		Assert.assertTrue(result.equals("Upskill with Naukri e-Learning to boost your professional growth"),result);		

		//To verify that e-Courses and Certifications Sub content is displayed or not

		result = generic.GetElementText_WE(HomePage.HP_EcoursesSubContent_WE);
		Assert.assertTrue(result.equals("Choose from a wide variety of Industry recognised courses taught by some of the world's best instructors. Acquire the knowledge you need to enhance your employability."),result);		

		//To verify that Browse Courses link for e-Courses and Certifications is displayed or not

		result = generic.GetElementText_WE(HomePage.HP_BrowseCourses_Lnk);			
		Assert.assertTrue(result.equals("Browse Courses"),result);

		//To verify that Jobs Heading is displayed or not

		result = generic.GetElementText_WE(HomePage.HP_JobsHeading_WE);
		Assert.assertTrue(result.equals("I want experts to help me find the right job"),result);

		//To verify that Jobs on Mail and SMS image is displayed or not

		Assert.assertTrue(generic.isVisible(HomePage.HP_JobsOnMailandSmsImage_Lnk), "");		

		//To verify that Jobs on Mail and SMS heading is displayed or not

		result = generic.GetElementText_WE(HomePage.HP_JobsOnMailandSmsHeading_Lnk);
		Assert.assertTrue(result.equals("Jobs on Mail and SMS"),result);

		//To verify that Jobs on Mail and SMS content is displayed or not

		result = generic.GetElementText_WE(HomePage.HP_JobsOnMailandSmsContent_WE);
		Assert.assertTrue(result.equals("Get Jobs matching your profile from Naukri experts, on mail and sms"),result);		

		//To verify that Jobs on Mail and SMS Sub content is displayed or not

		result = generic.GetElementText_WE(HomePage.HP_JobsOnMailandSmsSubContent_WE);
		Assert.assertTrue(result.equals("Our Experts understand your job preferences and forward jobs suitable to your needs on mail and instantly on sms. Never miss out on the right job opening. Apply to the jobs through the website or sms."),result);		

		//To verify that Get Jobs on Mails and SMS link for Jobs on Mail and SMS is displayed or not

		result = generic.GetElementText_WE(HomePage.HP_GetJobsonMailsandSMS_Lnk);			
		Assert.assertTrue(result.equals("Get Jobs on Mails and SMS"),result);

		//To verify that Disclaimer section is displayed on Home page

		result = generic.GetElementText(HomePage.Disclaimer_WE);
		result =result.replace("\n", " ");
		Assert.assertEquals(result , "Disclaimer While Naukri FastForward services have helped many customers over the years, we do not guarantee any interview calls or assure any job offers with any of our services. The services associated with NaukriFastforward are only provided through the website Naukri.com. You are advised to be cautious of calls/emails asking for payment from other web sites that claim to offer similar services under the name of Naukri.com. We have no associates/agents other than the partner sites that have been specifically named on the homepage of the website Naukri.com. We also recommend that you visit Security Guidelines and Terms and Conditions");
		
	}
@Test
	//To verify that on clicking Text Resume Link it lands to text resume page or not
	public void TC_Home_002()
	{
		driver.get(URLProvider.Return_HomePageURL());				
		generic.Click_Lnk(HomePage.HP_GetTextResume_Lnk);	
		String result= generic.GetElementText(TextResumePage.Breadcrum_WE);
		Assert.assertEquals(result, "Naukri FastForward > Resume Writing for Mid Level Professionals");			
	}



	@Test
	//To verify that on clicking button for Visual Resume it lands to Visual resume page or not
	public void TC_Home_003()
	{
		driver.get(URLProvider.Return_HomePageURL());				
		generic.Click_Lnk(HomePage.HP_GetVisualResume_Lnk);	
		String result= generic.GetElementText(VisualResumePage.Breadcrum_WE);
		Assert.assertEquals(result, "Naukri FastForward >Visual Resume Writing for Mid Level Professionals");		
	}

	@Test
	//To verify that on clicking resume Quality Report link it lands to Resume Quality Score page
	public void TC_Home_004()
	{
		driver.get(URLProvider.Return_HomePageURL());			
		generic.Click_Lnk(HomePage.HP_ResumeQualityGetReport_Lnk);
		String result= generic.GetElementText(ResumeQualityScorePage.Breadcrum_WE);
		Assert.assertEquals(result, "Naukri FastForward > Resume Quality Score");		
	}

	//To verify that on clicking Text Resume Sample link it lands to Text Resume Sample page
	public void TC_Home_005()
	{
		driver.get(URLProvider.Return_HomePageURL());				
		generic.Click_Lnk(HomePage.HP_TextResumeSample_Lnk);	
		String result = generic.GetElementText(TextResumeSamplePage.Breadcrumb_WE);
		Assert.assertEquals(result, "Naukri FastForward > Resume Samples");
	}
	@Test
	//To verify that on clicking Visual Resume Sample link it lands to Visual Resume Sample page
	public void TC_Home_006()
	{
		driver.get(URLProvider.Return_HomePageURL());						
		generic.Click_Lnk(HomePage.HP_VisualResumeSample_Lnk);			
		String result = generic.GetElementText(VisualResumeSamplePage.Breadcrumb_WE);
		Assert.assertEquals(result, "Naukri FastForward > Visual Resume Sample");		
	}


	@Test
	//To verify that on clicking Cover letter link it lands to Cover letter page
	public void TC_Home_007()
	{
		driver.get(URLProvider.Return_HomePageURL());				
		generic.Click_Lnk(HomePage.HP_Coverletter_Lnk);	
		String result = generic.GetElementText(CoverLetterSamplePage.Breadcrum_WE);
		Assert.assertEquals(result, "Naukri FastForward > Cover Letter Sample");	
	}




	@Test
	//To verify that on clicking Find Recruiters link RecruiterConnection it lands to RecruiterConnection page
	public void TC_Home_008()
	{
		driver.get(URLProvider.Return_HomePageURL());
		generic.Click_Lnk(HomePage.HP_FindRecriuters_Lnk);		
		String result = generic.GetElementText(RecruiterConnectionPage.BreadCrum_WE);
		Assert.assertEquals(result, "Naukri FastForward > RecruiterConnection");	
	}

	@Test
	//To verify that on clicking Get Highlighted link Resume Display it lands to Resume Display page
	public void TC_Home_009()
	{
		driver.get(URLProvider.Return_HomePageURL());	
		generic.Click_Lnk(HomePage.HP_GetHighlighted_Lnk);	
		String result = generic.GetElementText(ResumeDisplayPage.Breadcrum_WE);
		Assert.assertEquals(result, "Naukri FastForward > Resume Display");	
	}

	@Test
	//To verify that on clicking Browse Courses link for e-Courses and Certifications it lands to e-Courses and Certifications page
	public void TC_Home_010()
	{
		driver.get(URLProvider.Return_HomePageURL());	
		generic.Click_Lnk(HomePage.HP_BrowseCourses_Lnk);	
		String result = generic.GetElementText(ElearningPage.Breadcrumb_WE);
		Assert.assertEquals(result, "Naukri FastForward > Learning");	
	}

	@Test
	//To verify that on clicking Get Jobs on Mails and SMS  link Jobs on Mail and SMS it lands to Jobs on Mail and SMS page
	public void TC_Home_011()
	{
		driver.get(URLProvider.Return_HomePageURL());
		generic.Click_Lnk(HomePage.HP_GetJobsonMailsandSMS_Lnk);	
		String result = generic.GetElementText(Jobs4UPage .Breadcrum_WE);
		Assert.assertEquals(result, "Naukri FastForward > Jobs4U");
	}
	@Test
	//To verify that Career Advice heading in Career Advice section is displayed or not
	public void TC_Home_012()
	{		
		driver.get(URLProvider.Return_HomePageURL());
		String result = generic.GetElementText_WE(HomePage.CareerAdviceHeading_WE);		
		Assert.assertTrue(result.equals("Career Advice"),result);
	}
	@Test
	//To verify that Most viewed Articles in Career Advice section is displayed or not
	public void TC_Home_013()
	{
		driver.get(URLProvider.Return_HomePageURL());
		String result1 = generic.GetElementText_WE(HomePage.MostViewedArticles_WE);		
		Assert.assertTrue(result1.equals("Most Viewed Articles"),result1);
		generic.Click_Lnk(HomePage.MostViewedArticles_WE);
		String result2 = generic.GetElementText_WE(HomePage.ArticlesBreadcrumb_WE);
		Assert.assertTrue(result2.equals("Naukri FastForward > Career Advice > Most Viewed Articles"),result2);
	}

	@Test
	//To verify that Category 1 Article1 is displayed or not
	public void TC_Home_014()
	{
		driver.get(URLProvider.Return_HomePageURL());
		String result1 = generic.GetElementText_WE(HomePage.Cat1Article1_Lnk);
		generic.Click(HomePage.Cat1Article1_Lnk);	
		generic.SwitchtoNewWindow();
		generic.GoToSleep(3000);
		String result2 = generic.GetElementText_WE(HomePage.ArticleTitle_WE);
		Assert.assertTrue(result2.contains(result1),result1);
		generic.SwitchtoOriginalWindow();
	}
	@Test
	//To verify that Category 1 Article2 is displayed or not
	public void TC_Home_015()
	{
		driver.get(URLProvider.Return_HomePageURL());
		String result1 = generic.GetElementText_WE(HomePage.Cat1Article2_Lnk);
		generic.Click(HomePage.Cat1Article2_Lnk);	

		generic.SwitchtoNewWindow();
		generic.GoToSleep(3000);
		String result2 = generic.GetElementText_WE(HomePage.ArticleTitle_WE);
		Assert.assertTrue(result2.contains(result1),result1);
		generic.SwitchtoOriginalWindow();
	}
	
	
	@Test
	//To verify that Category 1 Article3 is displayed or not
	public void TC_Home_016()
	{
		driver.get(URLProvider.Return_HomePageURL());
		String result1 = generic.GetElementText_WE(HomePage.Cat1Article3_Lnk);
		generic.Click(HomePage.Cat1Article3_Lnk);	

		generic.SwitchtoNewWindow();
		generic.GoToSleep(3000);
		String result2 = generic.GetElementText_WE(HomePage.ArticleTitle_WE);
		Assert.assertTrue(result2.contains(result1),result1);
		generic.SwitchtoOriginalWindow();
	}
	@Test
	//To verify that Category 2 Article1 is displayed or not
	public void TC_Home_017()
	{
		driver.get(URLProvider.Return_HomePageURL());
		String result1 = generic.GetElementText_WE(HomePage.Cat2Article1_Lnk);
		generic.Click(HomePage.Cat2Article1_Lnk);	

		generic.SwitchtoNewWindow();
		String result2 = generic.GetElementText_WE(HomePage.ArticleTitle_WE);
		Assert.assertTrue(result2.contains(result1),result1);
		generic.SwitchtoOriginalWindow();
	}
	@Test
	//To verify that Category 2 Article2 is displayed or not
	public void TC_Home_018()
	{
		driver.get(URLProvider.Return_HomePageURL());
		String result1 = generic.GetElementText_WE(HomePage.Cat2Article2_Lnk);
		generic.Click(HomePage.Cat2Article2_Lnk);	

		generic.SwitchtoNewWindow();
		String result2 = generic.GetElementText_WE(HomePage.ArticleTitle_WE);
		Assert.assertTrue(result2.contains(result1),result1);
		generic.SwitchtoOriginalWindow();
	}
	@Test
	//To verify that Category 3 Article1 is displayed or not
	public void TC_Home_019()
	{
		driver.get(URLProvider.Return_HomePageURL());
		String result1 = generic.GetElementText_WE(HomePage.Cat3Article1_Lnk);
		generic.Click(HomePage.Cat3Article1_Lnk);	
		generic.SwitchtoNewWindow();
		String result2 = generic.GetElementText_WE(HomePage.ArticleTitle_WE);
		Assert.assertTrue(result2.contains(result1),result1);
		generic.SwitchtoOriginalWindow();
	}
	@Test
	//To verify that Category 3 Article2 is displayed or not
	public void TC_Home_020()
	{
		driver.get(URLProvider.Return_HomePageURL());
		String result1 = generic.GetElementText_WE(HomePage.Cat3Article2_Lnk);
		generic.Click(HomePage.Cat3Article2_Lnk);	
		generic.SwitchtoNewWindow();
		String result2 = generic.GetElementText_WE(HomePage.ArticleTitle_WE);
		Assert.assertTrue(result2.contains(result1),result1);
		generic.SwitchtoOriginalWindow();
	}
	@Test
	//To verify that Category 4 Article1 is displayed or not
	public void TC_Home_021()
	{
		driver.get(URLProvider.Return_HomePageURL());
		String result1 = generic.GetElementText_WE(HomePage.Cat4Article1_Lnk);
		generic.Click(HomePage.Cat4Article1_Lnk);	
		generic.SwitchtoNewWindow();
		generic.GoToSleep(3000);
		String result2 = generic.GetElementText_WE(HomePage.ArticleTitle_WE);
		Assert.assertTrue(result2.contains(result1),result1);
		generic.SwitchtoOriginalWindow();
	}
	@Test
	//To verify that Category 4 Article2 is displayed or not
	public void TC_Home_022()
	{
		driver.get(URLProvider.Return_HomePageURL());
		String result1 = generic.GetElementText_WE(HomePage.Cat4Article2_Lnk);
		generic.Click(HomePage.Cat4Article2_Lnk);	
		generic.SwitchtoNewWindow();
		generic.GoToSleep(3000);
		String result2 = generic.GetElementText_WE(HomePage.ArticleTitle_WE);
		Assert.assertTrue(result2.contains(result1),result1);
		generic.SwitchtoOriginalWindow();
	}
	@Test
	//To verify that Category 5 Article1 is displayed or not
	public void TC_Home_023()
	{
		driver.get(URLProvider.Return_HomePageURL());
		String result1 = generic.GetElementText_WE(HomePage.Cat5Article1_Lnk);
		generic.Click(HomePage.Cat5Article1_Lnk);	
		generic.SwitchtoNewWindow();		
		generic.GoToSleep(3000);
		String result2 = generic.GetElementText_WE(HomePage.ArticleTitle_WE);
		Assert.assertTrue(result2.contains(result1),result1);
		generic.SwitchtoOriginalWindow();
	}
	@Test
	//To verify that View more Career Advice link in Career Advice Section is displayed or not
	public void TC_Home_024()
	{
		driver.get(URLProvider.Return_HomePageURL());
		String result = generic.GetElementText_WE(HomePage.Viewmore_lnk);		
		Assert.assertTrue(result.equals("View more Career Advice"),result);	}
	@Test
	//To verify that on clicking View more Career Advice link it lands to articles page 
	public void TC_Home_025()
	{		
		driver.get(URLProvider.Return_HomePageURL());		
		generic.Click(HomePage.Viewmore_lnk);	
		generic.SwitchtoNewWindow();
		String result2 = generic.GetElementText_WE(HomePage.ArticlesBreadcrumb_WE);
		Assert.assertTrue(result2.contains("Naukri FastForward > Career Advice"),result2);
		generic.SwitchtoOriginalWindow();

	}


	@Test
	//To verify that on clicking Goto top icon page scrolls up and icon disappears
	public void TC_Home_026()
	{
		driver.get(URLProvider.Return_HomePageURL());
		generic.Scroll_The_Page(HomePage.HP_ResumeHeading_WE);
		generic.Click_Btn(HomePage.GotoTop_Btn);
		Assert.assertTrue(generic.isVisible(HomePage.HP_Image_WE));	
	}

	@Test
	//To verify that Top lead form content is displayed or not
	public void TC_Home_027()
	{
		driver.get(URLProvider.Return_HomePageURL());	
		generic.Scroll_The_Page(HomePage.HP_RecruiterConnectionContent_WE);
		String result = generic.GetElementText_WE(HomePage.TL_FormContent_WE);
		Assert.assertTrue(result.equals("I'm interested,Tell me more"),result);
	}

	@Test
	//To verify that on Clicking Text Resume Image it lands to Text resume page
	public void TC_Home_028()
	{
		driver.get(URLProvider.Return_HomePageURL());	
		generic.Click_Lnk(HomePage.HP_TextResumeImage_Lnk);
		String result= generic.GetElementText(TextResumePage.Breadcrum_WE);
		Assert.assertEquals(result, "Naukri FastForward > Resume Writing for Mid Level Professionals");	
	}
	@Test
	//To verify that on Clicking Visual Resume Image it lands to Visual resume page
	public void TC_Home_029()
	{
		driver.get(URLProvider.Return_HomePageURL());
		generic.Click_Lnk(HomePage.HP_VisualResumeImage_Lnk);
		String result= generic.GetElementText(VisualResumePage.Breadcrum_WE);
		Assert.assertEquals(result, "Naukri FastForward >Visual Resume Writing for Mid Level Professionals");	
	}
	@Test
	//To verify that on Clicking Text Resume heading it lands to Text resume page
	public void TC_Home_030()
	{
		driver.get(URLProvider.Return_HomePageURL());	
		generic.Click_Lnk(HomePage.HP_TextResumeHeading_Lnk);
		String result= generic.GetElementText(TextResumePage.Breadcrum_WE);
		Assert.assertEquals(result, "Naukri FastForward > Resume Writing for Mid Level Professionals");	
	}
	@Test
	//To verify that on Clicking Visual Resume heading it lands to Visual resume page
	public void TC_Home_031()
	{
		driver.get(URLProvider.Return_HomePageURL());	
		generic.Click_Lnk(HomePage.HP_VisualResumeHeading_Lnk);
		String result= generic.GetElementText(VisualResumePage.Breadcrum_WE);
		Assert.assertEquals(result, "Naukri FastForward > Resume Writing for Mid Level Professionals");	
	}
	@Test
	//To verify that on Clicking Recruiter Connection Image it lands to Recruiter Connection page
	public void TC_Home_032()
	{
		driver.get(URLProvider.Return_HomePageURL());
		generic.Click_Lnk(HomePage.HP_RecruiterConnectionImage_Lnk);
		String result= generic.GetElementText(RecruiterConnectionPage.BreadCrum_WE);
		Assert.assertEquals(result, "Naukri FastForward > RecruiterConnection");
	}
	@Test
	//To verify that on Clicking Resume Display Image it lands to Resume Display page
	public void TC_Home_033()
	{
		driver.get(URLProvider.Return_HomePageURL());	
		generic.Click_Lnk(HomePage.HP_ResumeDisplayImage_Lnk);
		String result= generic.GetElementText(ResumeDisplayPage.Breadcrum_WE);
		Assert.assertEquals(result, "Naukri FastForward > Resume Display");	
	}
	@Test
	//To verify that on Clicking Recruiter Connection heading it lands to Recruiter Connection page
	public void TC_Home_034()
	{
		driver.get(URLProvider.Return_HomePageURL());	
		generic.Click_Lnk(HomePage.HP_RecruiterConnectionHeading_Lnk);
		String result= generic.GetElementText(RecruiterConnectionPage.BreadCrum_WE);
		Assert.assertEquals(result, "Naukri FastForward > RecruiterConnection");	
	}
	@Test
	//To verify that on Clicking Resume Display heading it lands to Resume Display page
	public void TC_Home_035()
	{
		driver.get(URLProvider.Return_HomePageURL());
		generic.Click_Lnk(HomePage.HP_ResumeDisplayHeading_Lnk);
		String result= generic.GetElementText(ResumeDisplayPage.Breadcrum_WE);
		Assert.assertEquals(result, "Naukri FastForward > Resume Display");	
	}
	@Test
	//To verify that on Clicking E-courses Image it lands to E-courses page
	public void TC_Home_036()
	{
		driver.get(URLProvider.Return_HomePageURL());
		generic.Click_Lnk(HomePage.HP_EcoursesHeading_Lnk);
		String result= generic.GetElementText(ElearningPage.Breadcrumb_WE);
		Assert.assertEquals(result, "Naukri FastForward > Learning");	
	}
	@Test
	//To verify that on Clicking E-courses heading it lands to E-courses page
	public void TC_Home_037()
	{
		driver.get(URLProvider.Return_HomePageURL());	
		generic.Click_Lnk(HomePage.HP_EcoursesHeading_Lnk);
		String result= generic.GetElementText(ElearningPage.Breadcrumb_WE);
		Assert.assertEquals(result, "Naukri FastForward > Learning");	
	}
	@Test
	//To verify that on Clicking Jobs4U Image it lands to Jobs4U page
	public void TC_Home_038()
	{
		driver.get(URLProvider.Return_HomePageURL());
		generic.Click_Lnk(HomePage.HP_JobsOnMailandSmsImage_Lnk);
		String result= generic.GetElementText(Jobs4UPage.Breadcrum_WE);
		Assert.assertEquals(result, "Naukri FastForward > Jobs4U");		
	}
	@Test
	//To verify that on Clicking Jobs4U heading it lands to Jobs4U page
	public void TC_Home_039()
	{
		driver.get(URLProvider.Return_HomePageURL());
		generic.Click_Lnk(HomePage.HP_JobsOnMailandSmsHeading_Lnk);
		String result= generic.GetElementText(Jobs4UPage.Breadcrum_WE);
		Assert.assertEquals(result, "Naukri FastForward > Jobs4U");	
	}

	@Test
	//To validate Top lead form field validation for Logged in State
	public void TC_Home_040()
	{
		driver.get(URLProvider.Return_HomePageURL());
		LoginLayer loginLayer = new LoginLayer(driver, generic);
		generic.Click_Lnk(LoginLayer.GNB_Login_Lnk);
		loginLayer.Fillform_Login("Email", Email, Password);
		generic.Scroll_The_Page(HomePage.HP_FindRecriuters_Lnk);
		Assert.assertEquals(generic.GetText_Txt(HomePage.TL_Name_Txt), "Puneeta Mishra");
		Assert.assertEquals(generic.GetText_Txt(HomePage.TL_Email_Txt), Email);
		Assert.assertEquals(generic.GetText_Txt(HomePage.TL_Mobile_Txt), "1234567890");

	}

	@DataProvider (name = "TopLead")
	public Object[][] DataProvider()
	{
		String SheetName = "LeadForm";
		Xls_Reader datatable = new Xls_Reader(TestDataSheetPath_LeadForm);
		int rowcount = datatable.getRowCount(SheetName);
		Object result[][] = new Object[rowcount-1][2];
		for(int i=2;i<=rowcount;i++)
		{
			result[i-2][0] = i;
			String CaseType = datatable.getCellData(SheetName, "Case_Type", i);
			result[i-2][1] = CaseType;
		}

		return result;
	}

	//To validate Top Lead form fields	
	@Test (dataProvider = "TopLead")
	public void TC_Home_041(int rowno,String CaseType)
	{
		String SheetName = "LeadForm";
		Xls_Reader datatable = new Xls_Reader(TestDataSheetPath_LeadForm);
		driver.get(URLProvider.Return_HomePageURL());
		generic.Scroll_The_Page(HomePage.HP_FindRecriuters_Lnk);
		generic.Click_Btn(HomePageTopLeadForm.TL_CallmeBack_Btn);
		generic.GoToSleep(3000);
		generic.Fill_Txt(HomePageTopLeadForm.TL_Name_Txt, datatable.getCellData(SheetName, "Name", rowno));
		generic.Fill_Txt(HomePageTopLeadForm.TL_Email_Txt, datatable.getCellData(SheetName, "Email", rowno));
		generic.Fill_Txt(HomePageTopLeadForm.TL_Mobile_Txt, datatable.getCellData(SheetName, "Mobile", rowno));
		generic.Fill_Txt(HomePageTopLeadForm.TL_Query_Txt, datatable.getCellData(SheetName, "Query", rowno));
		generic.Click_Btn(HomePageTopLeadForm.Submit_Btn);
		generic.GoToSleep(2000);
		HomePageTopLeadForm homePageTopLeadForm = new HomePageTopLeadForm(driver,generic);
		String Errors = homePageTopLeadForm.CaptureErrors();
		String Expected =datatable.getCellData(SheetName, "Expected", rowno);
		if(Expected.equalsIgnoreCase("Submitted")) 
		{
			//Assert.assertEquals(generic.GetElementText_WE(HomePageTopLeadForm.TL_ThankYou_Msg_WE),"Thank You, We will get in touch with you soon");

			Assert.assertTrue(generic.isVisible(HomePageTopLeadForm.TL_ThankYou_Msg_WE),"Failed Expected : Submitted Actual :NotSubmitted");
		}
		else 
		{
			Assert.assertEquals(Errors, datatable.getCellData(SheetName, "ExpectedErrorMessage", rowno));
		}
	}



	@Test
	//To verify landing of Security guide lines link in Disclaimer section
	public void TC_Home_042()
	{
		driver.get(URLProvider.Return_HomePageURL());
		generic.Click(HomePage.Security_Guidelines_Lnk);
		generic.SwitchtoNewWindow();
		String result = driver.getCurrentUrl();
		Assert.assertEquals(result, "http://my.naukri.com/faq/faq.php?pgid=9");
	}
	@Test
	//To verify landing of Terms and conditions link in Disclaimer section
	public void TC_Home_043()
	{
		driver.get(URLProvider.Return_HomePageURL());
		generic.Click(HomePage.TermsandConditions_Lnk);
		generic.SwitchtoNewWindow();
		String result = generic.GetElementText(HomePage.TermsandCondition_WE);
		Assert.assertEquals(result, "Terms and Condition");
	}
	@AfterMethod
	public void CloseDriver()
	{
		driver.quit();
	}	
}


