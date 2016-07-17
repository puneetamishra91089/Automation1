package com.naukri.FastForwardRevamp.TestSuite;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naukri.FastForwardRevamp.Code.ValuePackToolTip;
import com.naukri.FastForwardRevamp.ConfigDetails.ConfigDetails;
import com.naukri.FastForwardRevamp.ConfigDetails.URLProvider;
import com.naukri.GenericFunctionsPack.GenericFunctions;
import com.naukri.datatable.Xls_Reader;

public class TestCases_ValuePackToolTip extends ConfigDetails{
	Xls_Reader datatable;
	@BeforeMethod()
	public void Before(){
		generic = new GenericFunctions(driver);
		driver = generic.StartDriver(Driver_Type);
		driver.manage().window().maximize();
	}

	@AfterMethod()
	public void CloseDriver()
	{
		driver.quit();
	}	
	@Test
	//To verify that Profile Highlighter Visual Resume Service Tool Tip
	public void TC_VPT_001()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ValuePackToolTip);
		String[] expectedOption = {"0-1 Years", "1-3 Years", "3-8 Years", "8-24 Years"};		
		for (int i=0;i<expectedOption.length;i++)
		{
			driver.get(URLProvider.Return_ValuePackURL());
			generic.Scroll_The_Page(ValuePackToolTip.ProfileHighlighterHeading_WE);
			generic.Select_Experience_DD(ValuePackToolTip.Experience_DD,ValuePackToolTip.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(3000);	
			generic.MouseHover(ValuePackToolTip.ProfileHighlighterVisualService_WE);
			String VisualResumeToolTip = driver.findElement(By.xpath("(//div[@class='tooltipContainer comboTTip'])")).getText();
			Assert.assertTrue(VisualResumeToolTip.equals(datatable.getCellData("sheet1","VisualResume",i+2)));		

		}

	}
	@Test
	//To verify that Profile Highlighter Resume Display service Tool Tip is displayed
	public void TC_VPT_002()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ValuePackToolTip);
		driver.get(URLProvider.Return_ValuePackURL());
		String[] expectedOption = {"0-1 Years", "1-3 Years", "3-8 Years", "8-24 Years"};			
		for (int i=0;i<expectedOption.length;i++)
		{
			driver.get(URLProvider.Return_ValuePackURL());
			generic.Scroll_The_Page(ValuePackToolTip.ProfileHighlighterHeading_WE);
			generic.Select_Experience_DD(ValuePackToolTip.Experience_DD,ValuePackToolTip.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(3000);	
			generic.MouseHover(ValuePackToolTip.ProfileHighlighterResumeDisplayService_WE);
			String ResumeDisplayToolTip = driver.findElement(By.xpath("(//div[@class='tooltipContainer comboTTip'])")).getText();
			Assert.assertTrue(ResumeDisplayToolTip.equals(datatable.getCellData("sheet1","ResumeDisplay-6months",2)));		

		}
	}
	@Test
	//To verify that Profile Highlighter RecruiterConnection service Tool Tip is displayed
	public void TC_VPT_003()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ValuePackToolTip);			
		driver.get(URLProvider.Return_ValuePackURL());
		String[] expectedOption = {"0-1 Years", "1-3 Years", "3-8 Years", "8-24 Years"};			
		for (int i=0;i<expectedOption.length;i++)
		{
			driver.get(URLProvider.Return_ValuePackURL());
			generic.Scroll_The_Page(ValuePackToolTip.ProfileHighlighterHeading_WE);
			generic.Select_Experience_DD(ValuePackToolTip.Experience_DD,ValuePackToolTip.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(3000);	
			generic.MouseHover(ValuePackToolTip.ProfileHighlighterRJconnectionService_WE);
			String RConnectionToolTip = driver.findElement(By.xpath("(//div[@class='tooltipContainer comboTTip'])")).getText();				
			Assert.assertTrue(RConnectionToolTip.equals(datatable.getCellData("sheet1","RecruiterConnection-10 Credits",2)));		

		}
	}
	@Test
	//To verify that Profile Highlighter Cover Letter service Tool Tip is displayed
	public void TC_VPT_004()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ValuePackToolTip);			
		driver.get(URLProvider.Return_ValuePackURL());
		String[] expectedOption = {"0-1 Years", "1-3 Years", "3-8 Years", "8-24 Years"};			
		for (int i=0;i<expectedOption.length;i++)
		{
			driver.get(URLProvider.Return_ValuePackURL());
			generic.Scroll_The_Page(ValuePackToolTip.ProfileHighlighterHeading_WE);
			generic.Select_Experience_DD(ValuePackToolTip.Experience_DD,ValuePackToolTip.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(3000);	
			generic.MouseHover(ValuePackToolTip.ProfileHighlighterCoverService_WE);
			String CoverLetterToolTip = driver.findElement(By.xpath("(//div[@class='tooltipContainer comboTTip'])")).getText();
			Assert.assertTrue(CoverLetterToolTip.equals(datatable.getCellData("sheet1","CoverLetter",2)));		

		}
	}
	@Test
	//To verify that Featured Visual Resume service Tool Tip is displayed
	public void TC_VPT_005()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ValuePackToolTip);			
		driver.get(URLProvider.Return_ValuePackURL());
		String[] expectedOption = {"0-1 Years", "1-3 Years", "3-8 Years", "8-24 Years"};			
		for (int i=0;i<expectedOption.length;i++)
		{
			driver.get(URLProvider.Return_ValuePackURL());
			generic.GoToSleep(3000);
			generic.Scroll_The_Page(ValuePackToolTip.ProfileHighlighterHeading_WE);
			generic.Select_Experience_DD(ValuePackToolTip.Experience_DD,ValuePackToolTip.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(3000);	
			generic.MouseHover(ValuePackToolTip.FeaturedVisualService_WE);
			String FeaturedVisual = driver.findElement(By.xpath("(//div[@class='tooltipContainer comboTTip'])")).getText();
			Assert.assertTrue(FeaturedVisual.equals(datatable.getCellData("sheet1","VisualResume",i+2)));		

		}
	}
	@Test
	//To verify that Featured Resume Display service Tool Tip is displayed
	public void TC_VPT_006()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ValuePackToolTip);
		driver.get(URLProvider.Return_ValuePackURL());
		String[] expectedOption = {"0-1 Years", "1-3 Years", "3-8 Years", "8-24 Years"};			
		for (int i=0;i<expectedOption.length;i++)
		{
			driver.get(URLProvider.Return_ValuePackURL());
			generic.GoToSleep(3000);	
			generic.Scroll_The_Page(ValuePackToolTip.ProfileHighlighterHeading_WE);
			generic.Select_Experience_DD(ValuePackToolTip.Experience_DD,ValuePackToolTip.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(3000);		
			generic.MouseHover(ValuePackToolTip.FeaturedResumeDisplayService_WE);
			String FeaturedResumeDisplay = driver.findElement(By.xpath("(//div[@class='tooltipContainer comboTTip'])")).getText();
			Assert.assertTrue(FeaturedResumeDisplay.equals(datatable.getCellData("sheet1","ResumeDisplay-6months",2)));		

		}
	}
	@Test
	//To verify that Featured RecruiterConnection service Tool Tip is displayed
	public void TC_VPT_007()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ValuePackToolTip);			
		driver.get(URLProvider.Return_ValuePackURL());
		String[] expectedOption = {"0-1 Years", "1-3 Years", "3-8 Years", "8-24 Years"};			
		for (int i=0;i<expectedOption.length;i++)
		{
			driver.get(URLProvider.Return_ValuePackURL());
			generic.GoToSleep(3000);
			generic.Scroll_The_Page(ValuePackToolTip.ProfileHighlighterHeading_WE);
			generic.Select_Experience_DD(ValuePackToolTip.Experience_DD,ValuePackToolTip.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(3000);	
			generic.MouseHover(ValuePackToolTip.FeaturedRJconnectionService_WE);
			String FeaturedRecruiterConnection = driver.findElement(By.xpath("(//div[@class='tooltipContainer comboTTip'])")).getText();
			Assert.assertTrue(FeaturedRecruiterConnection.equals(datatable.getCellData("sheet1","RecruiterConnection-10 Credits",2)));		

		}
	}
	@Test
	//To verify that Featured Jobs4U service Tool Tip is displayed
	public void TC_VPT_008()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ValuePackToolTip);			
		driver.get(URLProvider.Return_ValuePackURL());
		String[] expectedOption = {"0-1 Years", "1-3 Years", "3-8 Years", "8-24 Years"};			
		for (int i=0;i<expectedOption.length;i++)
		{
			driver.get(URLProvider.Return_ValuePackURL());
			generic.GoToSleep(3000);	
			generic.Scroll_The_Page(ValuePackToolTip.ProfileHighlighterHeading_WE);
			generic.Select_Experience_DD(ValuePackToolTip.Experience_DD,ValuePackToolTip.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(3000);	
			generic.MouseHover(ValuePackToolTip.FeaturedJobs4UService_WE);
			String FeaturedJobs4U = driver.findElement(By.xpath("(//div[@class='tooltipContainer comboTTip'])")).getText();
			Assert.assertTrue(FeaturedJobs4U.equals(datatable.getCellData("sheet1","Jobs4U",2)));		

		}
	}
	@Test
	//To verify that Featured Cover Letter service Tool Tip is displayed
	public void TC_VPT_009()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ValuePackToolTip);			
		driver.get(URLProvider.Return_ValuePackURL());
		String[] expectedOption = {"0-1 Years", "1-3 Years", "3-8 Years", "8-24 Years"};			
		for (int i=0;i<expectedOption.length;i++)
		{
			driver.get(URLProvider.Return_ValuePackURL());
			generic.GoToSleep(3000);	
			generic.Scroll_The_Page(ValuePackToolTip.ProfileHighlighterHeading_WE);
			generic.Select_Experience_DD(ValuePackToolTip.Experience_DD,ValuePackToolTip.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(3000);		
			generic.MouseHover(ValuePackToolTip.FeaturedCover_Service_WE);
			String FeaturedCoverLetter = driver.findElement(By.xpath("(//div[@class='tooltipContainer comboTTip'])")).getText();
			Assert.assertTrue(FeaturedCoverLetter.equals(datatable.getCellData("sheet1","CoverLetter",2)));		

		}
	}
	@Test
	//To verify that JobSearch Resume Display service Tool Tip is displayed
	public void TC_VPT_010()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ValuePackToolTip);			
		driver.get(URLProvider.Return_ValuePackURL());
		String[] expectedOption = {"0-1 Years", "1-3 Years", "3-8 Years", "8-24 Years"};			
		for (int i=0;i<expectedOption.length;i++)
		{
			driver.get(URLProvider.Return_ValuePackURL());
			generic.GoToSleep(3000);	
			generic.Scroll_The_Page(ValuePackToolTip.ProfileHighlighterHeading_WE);
			generic.Select_Experience_DD(ValuePackToolTip.Experience_DD,ValuePackToolTip.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(3000);		
			generic.MouseHover(ValuePackToolTip.JobsearchResumeDisplayService_WE);
			String JobsSearchResumeDisplay = driver.findElement(By.xpath("(//div[@class='tooltipContainer comboTTip'])")).getText();
			Assert.assertTrue(JobsSearchResumeDisplay.equals(datatable.getCellData("sheet1","ResumeDisplay-6months",2)));		

		}
	}
	@Test
	//To verify that JobSearch RecruiterConnection service Tool Tip is displayed
	public void TC_VPT_011()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ValuePackToolTip);			
		driver.get(URLProvider.Return_ValuePackURL());
		String[] expectedOption = {"0-1 Years", "1-3 Years", "3-8 Years", "8-24 Years"};			
		for (int i=0;i<expectedOption.length;i++)
		{
			driver.get(URLProvider.Return_ValuePackURL());
			generic.GoToSleep(3000);
			generic.Scroll_The_Page(ValuePackToolTip.ProfileHighlighterHeading_WE);
			generic.Select_Experience_DD(ValuePackToolTip.Experience_DD,ValuePackToolTip.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(3000);	
			generic.MouseHover(ValuePackToolTip.JobsearchRJconnectionService_WE);
			String JobsSearchRecruiterCOnnection = driver.findElement(By.xpath("(//div[@class='tooltipContainer comboTTip'])")).getText();
			Assert.assertTrue(JobsSearchRecruiterCOnnection.equals(datatable.getCellData("sheet1","RecruiterConnection-20 Credits",2)));		

		}
	}
	@Test
	//To verify that JobSearch Jobs4U service Tool Tip is displayed
	public void TC_VPT_012()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ValuePackToolTip);			
		driver.get(URLProvider.Return_ValuePackURL());
		String[] expectedOption = {"0-1 Years", "1-3 Years", "3-8 Years", "8-24 Years"};			
		for (int i=0;i<expectedOption.length;i++)
		{
			driver.get(URLProvider.Return_ValuePackURL());
			generic.GoToSleep(3000);	
			generic.Scroll_The_Page(ValuePackToolTip.ProfileHighlighterHeading_WE);
			generic.Select_Experience_DD(ValuePackToolTip.Experience_DD,ValuePackToolTip.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(3000);	
			generic.MouseHover(ValuePackToolTip.JobsearchJobs4UService_WE);
			String JobsSearchJobs4U = driver.findElement(By.xpath("(//div[@class='tooltipContainer comboTTip'])")).getText();
			Assert.assertTrue(JobsSearchJobs4U.equals(datatable.getCellData("sheet1","Jobs4U",2)));		

		}
	}
	@Test
	//To verify Visual Resume tool tip for Gulf Value Pack
	public void TC_VPT_013()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ValuePackToolTip);			
		driver.get(URLProvider.Return_ValuePackURL());
		String[] expectedOption = {"0-3 Years", "3-8 Years", "8+ Years"};			
		for (int i=0;i<expectedOption.length;i++)
		{
			driver.get(URLProvider.Return_ValuePackURL());
			generic.Click_Lnk(ValuePackToolTip.GulfJobs_Lnk);
			generic.GoToSleep(5000);	
			generic.Scroll_The_Page(ValuePackToolTip.GulfExperience_DD);
			generic.Select_Experience_DD(ValuePackToolTip.Experience_DD,ValuePackToolTip.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(5000);	
			generic.MouseHover(ValuePackToolTip.GulfVisualService_WE);
			String GulfVisual = driver.findElement(By.xpath("(//div[@class='tooltipContainer comboTTip'])")).getText();
			Assert.assertTrue(GulfVisual.equals(datatable.getCellData("sheet1","GulfVisual",i+2)));		

		}
	}  
	@Test
	//To verify Resume Spotlight tool tip for Gulf Value Pack
	public void TC_VPT_014()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ValuePackToolTip);			
		driver.get(URLProvider.Return_ValuePackURL());
		String[] expectedOption = {"0-3 Years", "3-8 Years", "8+ Years"};			
		for (int i=0;i<expectedOption.length;i++)
		{
			driver.get(URLProvider.Return_ValuePackURL());
			generic.Click_Lnk(ValuePackToolTip.GulfJobs_Lnk);
			generic.GoToSleep(5000);	
			generic.Scroll_The_Page(ValuePackToolTip.GulfExperience_DD);
			generic.Select_Experience_DD(ValuePackToolTip.Experience_DD,ValuePackToolTip.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(5000);	
			generic.MouseHover(ValuePackToolTip.GulfResumeSpotlight_WE);
			String GulfSpotlight = driver.findElement(By.xpath("(//div[@class='tooltipContainer comboTTip'])")).getText();
			Assert.assertTrue(GulfSpotlight.equals(datatable.getCellData("sheet1","ResumeSpotlight",2)));		

		}
	}  
	@Test
	//To verify Resume Display tool tip for Gulf Value Pack
	public void TC_VPT_015()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ValuePackToolTip);			
		driver.get(URLProvider.Return_ValuePackURL());
		String[] expectedOption = {"0-3 Years", "3-8 Years", "8+ Years"};			
		for (int i=0;i<expectedOption.length;i++)
		{
			driver.get(URLProvider.Return_ValuePackURL());
			generic.Click_Lnk(ValuePackToolTip.GulfJobs_Lnk);
			generic.GoToSleep(5000);	
			generic.Scroll_The_Page(ValuePackToolTip.GulfExperience_DD);
			generic.Select_Experience_DD(ValuePackToolTip.Experience_DD,ValuePackToolTip.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(5000);	
			generic.MouseHover(ValuePackToolTip.GulfResumeDisplay_WE);
			String GulfresumeDIsplay = driver.findElement(By.xpath("(//div[@class='tooltipContainer comboTTip'])")).getText();
			Assert.assertTrue(GulfresumeDIsplay.equals(datatable.getCellData("sheet1","ResumeDisplay-6months",2)));		

		}
	}  
	@Test
	//To verify Cover Letter tool tip for Gulf Value Pack
	public void TC_VPT_016()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ValuePackToolTip);			
		driver.get(URLProvider.Return_ValuePackURL());
		String[] expectedOption = {"0-3 Years", "3-8 Years", "8+ Years"};			
		for (int i=0;i<expectedOption.length;i++)
		{
			driver.get(URLProvider.Return_ValuePackURL());
			generic.Click_Lnk(ValuePackToolTip.GulfJobs_Lnk);
			generic.GoToSleep(5000);	
			generic.Scroll_The_Page(ValuePackToolTip.GulfExperience_DD);
			generic.Select_Experience_DD(ValuePackToolTip.Experience_DD,ValuePackToolTip.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(5000);	
			generic.MouseHover(ValuePackToolTip.GulfCover_WE);
			String GulfCoverLetter = driver.findElement(By.xpath("(//div[@class='tooltipContainer comboTTip'])")).getText();
			Assert.assertTrue(GulfCoverLetter.equals(datatable.getCellData("sheet1","Gulf CoverLetter",2)));		

		}
	} 
	@Test
	//To verify Tool tip for 24+ years value pack
	public void TC_VPT_017()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ValuePackToolTip);			
		driver.get(URLProvider.Return_ValuePackURL());
		generic.Select_Experience_DD(ValuePackToolTip.Experience_DD,ValuePackToolTip.ExperienceULid_DD,"24+ Years");
		generic.Scroll_The_Page(ValuePackToolTip.ProfileHighlighterHeading_WE);
		generic.GoToSleep(3000);	
		generic.MouseHover(ValuePackToolTip.FeaturedResumeDisplayService_WE);
		String ResumeDisplay = driver.findElement(By.xpath("(//div[@class='tooltipContainer comboTTip'])")).getText();
		Assert.assertTrue(ResumeDisplay.equals(datatable.getCellData("sheet1","ResumeDisplay-6months",2)));
		driver.get(URLProvider.Return_ValuePackURL());
		generic.Select_Experience_DD(ValuePackToolTip.Experience_DD,ValuePackToolTip.ExperienceULid_DD,"24+ Years");
		generic.Scroll_The_Page(ValuePackToolTip.ProfileHighlighterHeading_WE);
		generic.GoToSleep(3000);
		generic.MouseHover(ValuePackToolTip.FeaturedRJconnectionService_WE);
		String RecruiterConnection = driver.findElement(By.xpath("(//div[@class='tooltipContainer comboTTip'])")).getText();
		Assert.assertTrue(RecruiterConnection.equals(datatable.getCellData("sheet1","RecruiterConnection-10 Credits",2)));
		driver.get(URLProvider.Return_ValuePackURL());
		generic.Select_Experience_DD(ValuePackToolTip.Experience_DD,ValuePackToolTip.ExperienceULid_DD,"24+ Years");
		generic.GoToSleep(3000);
		generic.Scroll_The_Page(ValuePackToolTip.ProfileHighlighterHeading_WE);				
		generic.MouseHover(ValuePackToolTip.FeaturedJobs4UService_WE);
		String CoverLetter = driver.findElement(By.xpath("(//div[@class='tooltipContainer comboTTip'])")).getText();
		Assert.assertTrue(CoverLetter.equals(datatable.getCellData("sheet1","CoverLetter",2)));
	}

}
