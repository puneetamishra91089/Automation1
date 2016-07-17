package com.naukri.FastForwardRevamp.TestSuite;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naukri.FastForwardRevamp.Code.CoverLetterSamplePage;
import com.naukri.FastForwardRevamp.Code.HomePage;
import com.naukri.FastForwardRevamp.ConfigDetails.ConfigDetails;
import com.naukri.FastForwardRevamp.ConfigDetails.URLProvider;
import com.naukri.GenericFunctionsPack.GenericFunctions;

public class Testcases_CoverLetterSamplePage extends ConfigDetails {

	@BeforeMethod
	public void Before(){
		generic = new GenericFunctions(driver);
		driver = generic.StartDriver(Driver_Type);
		driver.manage().window().maximize();
	}


	@Test
	//To verify that on clicking Naukri link in Bread crumb home page is displayed
	public void TC_CLS_001()
	{
		driver.get (URLProvider.Return_CoverLetterSampleURL());
		generic.Click_Lnk(CoverLetterSamplePage.Naukri_Lnk);
		String result = generic.GetElementText_WE(HomePage.HP_Image_WE);
		result = result.replace("\n", " ");
		Assert.assertEquals("Speed Up Your Career with our personalized services",result);
	}
	@Test
	//To verify that on clicking Production Tab Sample cover letter is displayed or not
	public void TC_CLS_002()
	{
		driver.get (URLProvider.Return_CoverLetterSampleURL());
		generic.Click_Lnk(CoverLetterSamplePage.Production_Btn);
		Assert.assertTrue(generic.isVisible(CoverLetterSamplePage.ProductionSample_WE),"Production Sample Resume not Visible!!");
	}

	@Test
	//To verify that on clicking Finance Tab Sample cover letter is displayed or not
	public void TC_CLS_003()
	{
		driver.get (URLProvider.Return_CoverLetterSampleURL());
		generic.Click_Lnk(CoverLetterSamplePage.Finance_Btn);
		Assert.assertTrue(generic.isVisible(CoverLetterSamplePage.FinanceSample_WE),"Finance Sample Resume not Visible!!");
	}

	@Test
	//To verify that on clicking Sales Tab Sample cover letter is displayed or not
	public void TC_CLS_004()
	{
		driver.get (URLProvider.Return_CoverLetterSampleURL());
		generic.Click_Lnk(CoverLetterSamplePage.Sales_Btn);
		Assert.assertTrue(generic.isVisible(CoverLetterSamplePage.SalesSample_WE),"Sales Sample Resume not Visible!!");
	}


	@Test
	//To verify that on clicking Buy now link it lands to Text Resume service page
	public void TC_CLS_005()
	{
		driver.get (URLProvider.Return_CoverLetterSampleURL());
		generic.Click_Lnk(CoverLetterSamplePage.BuyNow_Lnk);
		Assert.assertEquals(driver.getCurrentUrl(),URLProvider.Return_TextResume_MidLevelURL());	
	}



	@Test
	//To verify that on clicking Related Article1 it land to 7 Ways to Make your Cover Letter Recruiter Friendly Articles page
	public void TC_CLS_006()
	{
		driver.get (URLProvider.Return_CoverLetterSampleURL());
		String Result = generic.GetElementText_WE(CoverLetterSamplePage.Article1_Lnk);
		generic.Click_Lnk(CoverLetterSamplePage.Article1_Lnk);
		generic.SwitchtoNewWindow();
		Assert.assertTrue(generic.GetElementText_WE(CoverLetterSamplePage.ArticleBreadcrum_WE).contains(Result));
	}

	@Test
	//To verify that on clicking Related Article2 it land to Common Cover letter mistakes to avoid! Articles page
	public void TC_CLS_007()
	{
		driver.get (URLProvider.Return_CoverLetterSampleURL());
		String Result = generic.GetElementText_WE(CoverLetterSamplePage.Article2_Lnk);
		generic.Click_Lnk(CoverLetterSamplePage.Article2_Lnk);
		generic.SwitchtoNewWindow();
		Assert.assertTrue(generic.GetElementText_WE(CoverLetterSamplePage.ArticleBreadcrum_WE).contains(Result));
	}

	@Test
	//To verify that on clicking Related Article3 it land to Cover Letter Tips Articles page
	public void TC_CLS_008()
	{
		driver.get (URLProvider.Return_CoverLetterSampleURL());
		String Result = generic.GetElementText_WE(CoverLetterSamplePage.Article3_Lnk);
		generic.Click_Lnk(CoverLetterSamplePage.Article3_Lnk);
		generic.SwitchtoNewWindow();
		Assert.assertTrue(generic.GetElementText_WE(CoverLetterSamplePage.ArticleBreadcrum_WE).contains(Result));
	}

	@Test
	//To verify that on clicking View more on cover letter link it lands to cover letter page
	public void TC_CLS_009()
	{
		driver.get (URLProvider.Return_CoverLetterSampleURL());
		generic.Click_Lnk(CoverLetterSamplePage.Viewmoreoncoverletter_Lnk);
		generic.SwitchtoNewWindow();
		Assert.assertTrue(generic.isVisible(CoverLetterSamplePage.ArticleBreadcrum_WE));
	}


	@Test
	//To verify that Static content is displayed on Cover letter Sample page
	public void TC_CLS_010()
	{
		driver.get (URLProvider.Return_CoverLetterSampleURL());	
		String result = generic.GetElementText_WE(CoverLetterSamplePage.Breadcrum_WE);	
		Assert.assertTrue(result.equals("Naukri FastForward > Cover Letter Sample"),result);

		//To verify that Cover letter heading is displayed or not

		result = generic.GetElementText_WE(CoverLetterSamplePage.CoverLetterSampleHeading_WE);	
		Assert.assertTrue(result.equals("Cover Letter Samples"),result);

		//To verify that Cover letter content is displayed or not

		result = generic.GetElementText_WE(CoverLetterSamplePage.CoverLetterSampleContent_WE);	
		Assert.assertTrue(result.equals("Your cover letter is the first opportunity to engage with employers and show them just how perfect you are for the job. So it's worth spending a bit of time getting it right. The cover letter should complement and not repeat whatever you have on your resume. A cover letter accompanying a resume to the job you have applied for shows your seriousness as a jobseeker and is often the earliest written contact with your prospective employer. Effective cover letters are specific to the position you are applying for and highlights how your skills and experience match with those asked for in the job posting. See cover letter samples and cover letter writing tips below to draft an effective resume."),result);

		//To verify that Sample heading is displayed or not

		result = generic.GetElementText_WE(CoverLetterSamplePage.SampleHeading_WE);	
		Assert.assertTrue(result.equals("Sample Cover Letter for Production"),result);

		//To verify that Production tab is displayed or not

		result = generic.GetElementText_WE(CoverLetterSamplePage.Production_Btn);	
		Assert.assertTrue(result.equals("Production"),result);

		//To verify that Finance tab is displayed or not

		result = generic.GetElementText_WE(CoverLetterSamplePage.Finance_Btn);	
		Assert.assertTrue(result.equals("Finance"),result);

		//To verify that Sales tab is displayed or not

		result = generic.GetElementText_WE(CoverLetterSamplePage.Sales_Btn);	
		Assert.assertTrue(result.equals("Sales"),result);
		//To verify that 5 ways to make your first impression! is displayed or not

		result = generic.GetElementText_WE(CoverLetterSamplePage.WaysHeading_WE);	
		Assert.assertTrue(result.equals("5 ways to make your first impression!"),result);

		//To verify that Way1 heading and content is displayed or not

		result = generic.GetElementText_WE(CoverLetterSamplePage.Way1Heading_WE);	
		Assert.assertTrue(result.equals("Keep it short"),result);	
		String result1 = generic.GetElementText_WE(CoverLetterSamplePage.Way1Content_WE);	

		//To verify that Way2 heading and content is displayed or not

		result = generic.GetElementText_WE(CoverLetterSamplePage.Way2Heading_WE);	
		Assert.assertTrue(result.equals("Customize"),result);	
		result1 = generic.GetElementText_WE(CoverLetterSamplePage.Way2Content_WE);	
		Assert.assertTrue(result1.equals("Tailor your cover letter with small anecdotes relevant to the specific role; generic letters impress no one!"),result1);	

		//To verify that Way3 heading and content is displayed or not

		result = generic.GetElementText_WE(CoverLetterSamplePage.Way3Heading_WE);	
		Assert.assertTrue(result.equals("Personalize"),result);	
		result1 = generic.GetElementText_WE(CoverLetterSamplePage.Way3Content_WE);	
		Assert.assertTrue(result1.equals("Address your cover letter to the right person, quote the job title and also include your contact details"),result1);	

		//To verify that Way4 heading and content is displayed or not

		result = generic.GetElementText_WE(CoverLetterSamplePage.Way4Heading_WE);	
		Assert.assertTrue(result.equals("Closure"),result);	
		result1 = generic.GetElementText_WE(CoverLetterSamplePage.Way4Content_WE);	
		Assert.assertTrue(result1.equals("Reinstate how your skills meet and exceed the requirements of the open position. Also thank your reader for their consideration."),result1);	

		//To verify that Way5 heading and content is displayed or not

		result = generic.GetElementText_WE(CoverLetterSamplePage.Way5Heading_WE);	
		Assert.assertTrue(result.equals("Advertise your unique skills"),result);	
		result1 = generic.GetElementText_WE(CoverLetterSamplePage.Way5Content_WE);	
		Assert.assertTrue(result1.equals("Why you? Demonstrate the skills that make you perfect for the job"),result1);	

		//To verify that See cover letter Sample link is displayed or not

		result = generic.GetElementText_WE(CoverLetterSamplePage.SeecoverletterSample_Lnk);	
		Assert.assertTrue(result.equals("See Cover Letter Samples"),result);	

		//To verify that Want to improve heading is displayed or not

		result = generic.GetElementText_WE(CoverLetterSamplePage.WanttoImprove_WE);
		Assert.assertTrue(result.contains("I want to improve my Resume"),result);	


		result = generic.GetElementText_WE(CoverLetterSamplePage.BuyNow_Lnk);
		Assert.assertTrue(result.equals("Buy Now"),result);	
		//To verify that Related Articles is displayed or not

		result = generic.GetElementText_WE(CoverLetterSamplePage.RelatedArticles_WE);
		Assert.assertTrue(result.equals("Related Articles"),result);	

		//To verify that Related Article1 is displayed or not

		result = generic.GetElementText_WE(CoverLetterSamplePage.Article1_Lnk);
		Assert.assertTrue(result.equals("7 Ways to Make your Cover Letter Recruiter Friendly"),result);	

		//To verify that Related Article2 is displayed or not

		result = generic.GetElementText_WE(CoverLetterSamplePage.Article2_Lnk);
		Assert.assertTrue(result.equals("Common Cover letter mistakes to avoid!"),result);	

		//To verify that Related Article3 is displayed or not

		result = generic.GetElementText_WE(CoverLetterSamplePage.Article3_Lnk);
		Assert.assertTrue(result.equals("Cover Letter Tips"),result);	

		//To verify that View more on cover letter link is displayed or not

		result = generic.GetElementText_WE(CoverLetterSamplePage.Viewmoreoncoverletter_Lnk);
		Assert.assertTrue(result.equals("View more on Cover letter"),result);			
	}



	@AfterMethod
	public void After()
	{
		driver.quit();
	}	

}
