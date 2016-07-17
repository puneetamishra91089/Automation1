package com.naukri.FastForwardRevamp.TestSuite;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naukri.FastForwardRevamp.Code.RecommendedComboWidget;
import com.naukri.FastForwardRevamp.Code.VisualResumePage;
import com.naukri.FastForwardRevamp.ConfigDetails.ConfigDetails;
import com.naukri.FastForwardRevamp.ConfigDetails.URLProvider;
import com.naukri.GenericFunctionsPack.GenericFunctions;
import com.naukri.datatable.Xls_Reader;

public class TestCases_RecommendedComboWidget extends ConfigDetails {
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
	Xls_Reader datatable;
	

	@Test()
	//To verify Recommended Combo Static Content is displayed
	public void TC_RCW_001()
	{
		datatable = new Xls_Reader(TestDataSheetPath_RecommendedCombo);	
		driver.get(URLProvider.Return_VisualResume_MidLevelURL());
		String[] expectedOption = {"0-1 Years Experience", "1-3 Years Experience", "3-8 Years Experience", "8-24 Years Experience","24+ Years Experience",};
		generic.Scroll_The_Page(VisualResumePage.HowItWorks_WE);
		for (int i=0;i<expectedOption.length;i++)
		{
			generic.GoToSleep(1000);
			generic.Select_Experience_DD(RecommendedComboWidget.Experience_DD,RecommendedComboWidget.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(1000);
			String ComboHeading = generic.GetElementText_Btn(RecommendedComboWidget.RecommendedComboHeading_WE);
			Assert.assertEquals(datatable.getCellData("sheet1", "Combo Heading", i+2),ComboHeading);
			//To verify Recommended Combo visual Service is displayed

			String ComboVisualService = generic.GetElementText_Btn(RecommendedComboWidget.RecommendedVisualService_WE);
			Assert.assertEquals("Visual Resume",ComboVisualService);
			String ComboVisualSubContent = generic.GetElementText_Btn(RecommendedComboWidget.RecommendedVisualContent_WE);
			Assert.assertEquals("(Standard delivery 8 days)",ComboVisualSubContent);
			String ComboVisualResumePrice = generic.GetElementText_Btn(RecommendedComboWidget.RecommendedVisualPrice_WE);
			Assert.assertEquals(datatable.getCellData("sheet1", "Visual Resume Price", i+2),ComboVisualResumePrice);

			//To verify Recommended Combo Cover Letter Service is displayed

			String ComboCoverLetter = generic.GetElementText_Btn(RecommendedComboWidget.RecommendedCoverletter_WE);
			Assert.assertEquals("Cover Letter",ComboCoverLetter);
			String ComboCoverLetterSubContent = generic.GetElementText_Btn(RecommendedComboWidget.RecommendedCoverlettercontent_WE);
			Assert.assertEquals("FREE",ComboCoverLetterSubContent);


			//To verify Recommended Combo Resume Display is displayed

			String ComboResumeDisplay = generic.GetElementText_Btn(RecommendedComboWidget.RecommendedResumeDisplayservice_WE);
			Assert.assertEquals("Resume Display",ComboResumeDisplay);
			String ComboResumeDisplaySubContent = generic.GetElementText_Btn(RecommendedComboWidget.RecommendedResumeDisplayContent_WE);
			Assert.assertEquals("6 Months",ComboResumeDisplaySubContent);
			String ComboResumeDisplayPrice = generic.GetElementText_Btn(RecommendedComboWidget.RecommendedResumeDisplayPrice_WE);
			Assert.assertEquals(datatable.getCellData("sheet1", "Resume Display", i+2),ComboResumeDisplayPrice);

			//To verify Recommended Combo RecruiterConnection is displayed

			String ComboRconnectionService = generic.GetElementText_Btn(RecommendedComboWidget.RecommendedRecruiterConnectionService_WE);
			Assert.assertEquals("Recruiter Connection",ComboRconnectionService);
			String ComboRConnectionSubContent = generic.GetElementText_Btn(RecommendedComboWidget.RecommendedRecruiterConnectionContent_WE);
			Assert.assertEquals("10 credits",ComboRConnectionSubContent);
			String ComboRConnectionPrice = generic.GetElementText_Btn(RecommendedComboWidget.RecommendedRecruiterConnectionprice_WE);
			Assert.assertEquals(datatable.getCellData("sheet1", "RecruiterConnection", i+2),ComboRConnectionPrice);

			

			//To verify Recommended combo Prices
			String ComboPriceHeading = generic.GetElementText_Btn(RecommendedComboWidget.ComboPriceHeading_WE);
			Assert.assertEquals("Combo Price",ComboPriceHeading);
			String ComboOldPrice = generic.GetElementText_Btn(RecommendedComboWidget.ComboOriginalPrice_WE);
			Assert.assertEquals(datatable.getCellData("sheet1", "Old Price", i+2),ComboOldPrice);
			String ComboNewPrice = generic.GetElementText_Btn(RecommendedComboWidget.ComboNewPrice_WE);
			Assert.assertEquals(datatable.getCellData("sheet1", "New Price", i+2),ComboNewPrice);
			String ComboDiscount = generic.GetElementText_Btn(RecommendedComboWidget.ComboDiscount_WE);
			Assert.assertEquals(datatable.getCellData("sheet1", "Discount%", i+2),ComboDiscount);
			String ComboDiscountPrice = generic.GetElementText_Btn(RecommendedComboWidget.ComboSave_WE);
			Assert.assertEquals(datatable.getCellData("sheet1", "Discount Price", i+2),ComboDiscountPrice);
			//To verify Add to Cart is displayed for Recommended combo
			String ComboAddtoCart = generic.GetElementText_Btn(RecommendedComboWidget.ComboAddtoCart_Btn);
			Assert.assertEquals("Add to Cart",ComboAddtoCart);
			generic.GoToSleep(2000);
			if (expectedOption[i] =="24+ Years Experience")
				break;
				//To verify Recommended Combo Jobs4U is displayed

				String ComboJobs4UService = generic.GetElementText_Btn(RecommendedComboWidget.RecommendedJobs4UService_WE);
				Assert.assertEquals("Jobs4U",ComboJobs4UService);
				String ComboJobs4USubContent = generic.GetElementText_Btn(RecommendedComboWidget.RecommendedJobs4UContent_WE);
				Assert.assertEquals("6 Months",ComboJobs4USubContent);
				String ComboJobs4UPrice = generic.GetElementText_Btn(RecommendedComboWidget.RecommendedJobs4UPrice_WE);
				Assert.assertEquals(datatable.getCellData("sheet1", "Jobs4U", i+2),ComboJobs4UPrice);
			driver.get(URLProvider.Return_VisualResume_MidLevelURL());

		}
		
	}

	@Test
	//To verify Recommended combo Visual Tool tip
	public void TC_RCW_002()
	{
		datatable = new Xls_Reader(TestDataSheetPath_RecommendedCombo);	
		driver.get(URLProvider.Return_VisualResume_MidLevelURL());
		String[] expectedOption = {"0-1 Years Experience", "1-3 Years Experience", "3-8 Years Experience", "8-24 Years Experience", "24+ Years Experience"};
		for (int i=0;i<expectedOption.length;i++)
		{
			driver.get(URLProvider.Return_VisualResume_MidLevelURL());
			generic.GoToSleep(2000);
			generic.Scroll_The_Page(RecommendedComboWidget.HowitworksHeading_WE);
			generic.Select_Experience_DD(RecommendedComboWidget.Experience_DD,RecommendedComboWidget.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(3000);	
			generic.MouseHover(RecommendedComboWidget.RecommendedVisualService_WE);
			String ComboVisualToolTip = driver.findElement(By.xpath("(//div[@class='tooltipContainer'])")).getText();	
			Assert.assertTrue(ComboVisualToolTip.equals(datatable.getCellData("sheet1","Tool Tip",2)));	
		}
	}
	@Test
	//To verify Recommended combo Cover Letter Tool tip
	public void TC_RCW_003()
	{
		datatable = new Xls_Reader(TestDataSheetPath_RecommendedCombo);	
		driver.get(URLProvider.Return_VisualResume_MidLevelURL());
		String[] expectedOption = {"0-1 Years Experience", "1-3 Years Experience", "3-8 Years Experience", "8-24 Years Experience", "24+ Years Experience"};
		for (int i=0;i<expectedOption.length;i++)
		{
			driver.get(URLProvider.Return_VisualResume_MidLevelURL());
			generic.GoToSleep(2000);
			generic.Scroll_The_Page(RecommendedComboWidget.HowitworksHeading_WE);
			generic.Select_Experience_DD(RecommendedComboWidget.Experience_DD,RecommendedComboWidget.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(3000);	
			generic.MouseHover(RecommendedComboWidget.RecommendedCoverletter_WE);
			String ComboCoverLetterToolTip = driver.findElement(By.xpath("(//div[@class='tooltipContainer'])")).getText();	
			Assert.assertTrue(ComboCoverLetterToolTip.equals(datatable.getCellData("sheet1","Tool Tip",3)));	
		}
	}
	@Test
	//To verify Recommended Resume Display Tool tip
	public void TC_RCW_004()
	{
		datatable = new Xls_Reader(TestDataSheetPath_RecommendedCombo);	
		driver.get(URLProvider.Return_VisualResume_MidLevelURL());
		String[] expectedOption = {"0-1 Years Experience", "1-3 Years Experience", "3-8 Years Experience", "8-24 Years Experience", "24+ Years Experience"};
		for (int i=0;i<expectedOption.length;i++)
		{
			driver.get(URLProvider.Return_VisualResume_MidLevelURL());
			generic.GoToSleep(2000);
			generic.Scroll_The_Page(RecommendedComboWidget.HowitworksHeading_WE);
			generic.Select_Experience_DD(RecommendedComboWidget.Experience_DD,RecommendedComboWidget.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(3000);	
			generic.MouseHover(RecommendedComboWidget.RecommendedResumeDisplayservice_WE);
			String ComboResumeDisplayToolTip = driver.findElement(By.xpath("(//div[@class='tooltipContainer'])")).getText();	
			System.out.println(ComboResumeDisplayToolTip);
			Assert.assertTrue(ComboResumeDisplayToolTip.equals(datatable.getCellData("sheet1","Tool Tip",4)));
		}
	}
	@Test
	//To verify Recommended RecruiterConnection Tool tip
	public void TC_RCW_005()
	{
		datatable = new Xls_Reader(TestDataSheetPath_RecommendedCombo);
		driver.get(URLProvider.Return_VisualResume_MidLevelURL());
		String[] expectedOption = {"0-1 Years Experience", "1-3 Years Experience", "3-8 Years Experience", "8-24 Years Experience", "24+ Years Experience"};
		for (int i=0;i<expectedOption.length;i++)
		{
			driver.get(URLProvider.Return_VisualResume_MidLevelURL());
			generic.GoToSleep(2000);
			generic.Scroll_The_Page(RecommendedComboWidget.HowitworksHeading_WE);
			generic.Select_Experience_DD(RecommendedComboWidget.Experience_DD,RecommendedComboWidget.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(3000);	
			generic.MouseHover(RecommendedComboWidget.RecommendedRecruiterConnectionService_WE);
			String ComboRecruiterConnectionToolTip = driver.findElement(By.xpath("(//div[@class='tooltipContainer'])[1]")).getText();	
			Assert.assertEquals(ComboRecruiterConnectionToolTip,datatable.getCellData("sheet1","Tool Tip",5));
		}
	}
	@Test
	//To verify Recommended Jobs4U Tool tip
	public void TC_RCW_006()
	{
		datatable = new Xls_Reader(TestDataSheetPath_RecommendedCombo);	
		driver.get(URLProvider.Return_VisualResume_MidLevelURL());
		String[] expectedOption = {"0-1 Years Experience", "1-3 Years Experience", "3-8 Years Experience", "8-24 Years Experience"};
		for (int i=0;i<expectedOption.length;i++)
		{
			driver.get(URLProvider.Return_VisualResume_MidLevelURL());
			generic.GoToSleep(2000);
			generic.Scroll_The_Page(RecommendedComboWidget.HowitworksHeading_WE);
			generic.Select_Experience_DD(RecommendedComboWidget.Experience_DD,RecommendedComboWidget.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(3000);	
			generic.MouseHover(RecommendedComboWidget.RecommendedJobs4UService_WE);
			String ComboJobs4UToolTip = driver.findElement(By.xpath("(//div[@class='tooltipContainer'])")).getText();
			Assert.assertEquals(ComboJobs4UToolTip,datatable.getCellData("sheet1","Tool Tip",6));
		}
	}

}
