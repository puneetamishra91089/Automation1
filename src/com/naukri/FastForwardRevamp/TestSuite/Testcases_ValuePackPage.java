package com.naukri.FastForwardRevamp.TestSuite;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naukri.FastForwardRevamp.Code.ShoppingCart;
import com.naukri.FastForwardRevamp.Code.ValuePackPage;
import com.naukri.FastForwardRevamp.ConfigDetails.ConfigDetails;
import com.naukri.FastForwardRevamp.ConfigDetails.URLProvider;
import com.naukri.GenericFunctionsPack.GenericFunctions;
import com.naukri.datatable.Xls_Reader;

public class Testcases_ValuePackPage extends ConfigDetails {
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
	//To verify that Combo Bread crumb is displayed or not
	public void TC_VPP_001()
	{		
		driver.get(URLProvider.Return_ValuePackURL());
		String result = generic.GetElementText_WE(ValuePackPage.ValuePack_Breadcrum_WE);		
		Assert.assertTrue(result.equals("Naukri FastForward > Value Pack"),result);
	}
	@Test
	//To verify that on clicking fast forward link in Bread crumb it lands to home page
	public void TC_VPP_002()
	{		
		driver.get(URLProvider.Return_ValuePackURL());
		generic.Click_Lnk(ValuePackPage.Naukri_Lnk);
		String result = driver.getCurrentUrl();
		Assert.assertTrue(result.equals(URLProvider.Return_HomePageURL()),result);
	}
	@Test
	//To verify that content of hero line content is displayed on combo page or not
	public void TC_VPP_003()
	{		
		driver.get(URLProvider.Return_ValuePackURL());
		String result = generic.GetElementText_WE(ValuePackPage.Heroline_WE);		
		Assert.assertTrue(result.equals("Value Packs for Job Seekers"), result);
	}
	@Test
	//To verify that choose experience option is there or not
	public void TC_VPP_004()
	{		
		driver.get(URLProvider.Return_ValuePackURL());
		String result = generic.GetElementText_WE(ValuePackPage.ChooseExp_WE);
		Assert.assertTrue(result.equals("Choose Experience:"),result);
	}

	@Test
	//To verify that for all experience value packs heading are displayed or not
	public void TC_VPP_005()
	{		
		driver.get(URLProvider.Return_ValuePackURL());
		String[] expectedOption = {"0-1 Years", "1-3 Years", "3-8 Years", "8-24 Years"}; 
		for (int i=0;i<expectedOption.length;i++)
		{
			generic.GoToSleep(5000);
			generic.Select_Experience_DD(ValuePackPage.Experience_DD, ValuePackPage.ExperienceULid_DD, expectedOption[i]);
			String result1 = generic.GetElementText_WE(ValuePackPage.ProfileHighlighterHeading_WE);
			Assert.assertTrue(result1.equals("Profile Highlighter Value Pack"));
			String result2 = generic.GetElementText_WE(ValuePackPage.FeaturedHeading_WE);
			result2 =result2.replace("\n", " ");
			Assert.assertTrue(result2.equals("Featured Value pack BEST VALUE"));
			String result3 = generic.GetElementText_WE(ValuePackPage.JobsearchHeading_WE);
			Assert.assertTrue(result3.equals("Job Search Value Pack"));
		}
		generic.Select_Experience_DD(ValuePackPage.Experience_DD, ValuePackPage.ExperienceULid_DD,"24+ Years");		
		String result = generic.GetElementText_WE(ValuePackPage.ProfileHighlighterHeading_WE);
		Assert.assertTrue(result.equals("Profile Highlighter Value Pack"));
	}

	@Test
	//To verify that for Profile Highlighter content is displayed for all experience level
	public void TC_VPP_006()
	{
		driver.get(URLProvider.Return_ValuePackURL());
		String[] expectedOption = {"0-1 Years", "1-3 Years", "3-8 Years", "8-24 Years"}; 
		for (int i=0;i<expectedOption.length;i++)
		{
			generic.GoToSleep(5000);
			generic.Select_Experience_DD(ValuePackPage.Experience_DD, ValuePackPage.ExperienceULid_DD, expectedOption[i]);
			String result = generic.GetElementText_WE(ValuePackPage.ProfileHighlighterContent_WE);
			Assert.assertTrue(result.equals("Increase your chances of getting your preferred job by having your resume written by trained experts and expanding your reach amongst recruiters who hire in your industry"));
			result = generic.GetElementText_WE(ValuePackPage.FeaturedContent_WE);
			Assert.assertTrue(result.equals("End to end services to boost your job search starting from resume development by trained experts to reaching out to relevant recruiters to getting real time jobs on mail and sms"));
			result = generic.GetElementText_WE(ValuePackPage.JobsearchContent_WE);
			Assert.assertTrue(result.equals("Best pack for your job search if you already have a good resume. These services will help you to increase your reach among recruiters and get real time jobs on mail and sms"));
		
		}
		generic.Select_Experience_DD(ValuePackPage.Experience_DD, ValuePackPage.ExperienceULid_DD,"24+ Years");		
		String result = generic.GetElementText_WE(ValuePackPage.ProfileHighlighterContent_WE);
		Assert.assertTrue(result.equals("Increase your chances of getting your preferred job by having your resume written by trained experts and expanding your reach amongst recruiters who hire in your industry"));

	}	
	@Test
	//To verify that message is displayed for non active Featured value packs for 24+yrs experience
	public void TC_VPP_007()
	{
		driver.get(URLProvider.Return_ValuePackURL());
		generic.Select_Experience_DD(ValuePackPage.Experience_DD, ValuePackPage.ExperienceULid_DD,"24+ Years");
		generic.GoToSleep(3000);
		String result = generic.GetElementText_WE(ValuePackPage.FeaturedInactive_WE);
		Assert.assertTrue(result.equals("This Package is not available for your Experience Level"),result);
		String result1 = generic.GetElementText_WE(ValuePackPage.JobsearchInactive_WE);
		Assert.assertTrue(result1.equals("This Package is not available for your Experience Level"),result1);

	}
	@Test
	//To verify services are displayed for Profile Highlighter value pack
	public void TC_VPP_008()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ValuePack);
		driver.get(URLProvider.Return_ValuePackURL());
		String[] expectedOption = {"0-1 Years", "1-3 Years", "3-8 Years", "8-24 Years"}; 
		for (int i=0;i<expectedOption.length;i++)
		{
			generic.Select_Experience_DD(ValuePackPage.Experience_DD, ValuePackPage.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(5000);
			String result1 = generic.GetElementText_WE(ValuePackPage.ProfileHighlighterSubServices_WE);
			Assert.assertTrue(result1.equals(datatable.getCellData(SheetName, "ProfileHighlighterSub_Services", i+2 )));
		}
		generic.Select_Experience_DD(ValuePackPage.Experience_DD, ValuePackPage.ExperienceULid_DD,"24+ Years");
		generic.GoToSleep(2000);
		String result2 = generic.GetElementText_WE(ValuePackPage.FeaturedSubServices_WE);
		Assert.assertTrue(result2.equals(datatable.getCellData(SheetName, "ProfileHighlighterSub_Services", 5 )));
	}
	@Test
	//To verify services are displayed for Featured value pack
	public void TC_VPP_009()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ValuePack);
		driver.get(URLProvider.Return_ValuePackURL());
		String[] expectedOption = {"0-1 Years", "1-3 Years", "3-8 Years", "8-24 Years"}; 
		for (int i=0;i<expectedOption.length;i++)
		{
			generic.Select_Experience_DD(ValuePackPage.Experience_DD, ValuePackPage.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(5000);
			String result1 = generic.GetElementText_WE(ValuePackPage.FeaturedSubServices_WE);
			Assert.assertTrue(result1.equals(datatable.getCellData(SheetName, "FeaturedSub_Services", i+2 )));
		}
	}
	@Test
	//To verify services are displayed for JobSearch value pack
	public void TC_VPP_010()
	{datatable = new Xls_Reader(TestDataSheetPath_ValuePack);
	driver.get(URLProvider.Return_ValuePackURL());
	String[] expectedOption = {"0-1 Years", "1-3 Years", "3-8 Years", "8-24 Years"}; 
	for (int i=0;i<expectedOption.length;i++)
	{
		generic.Select_Experience_DD(ValuePackPage.Experience_DD, ValuePackPage.ExperienceULid_DD,expectedOption[i]);
		generic.GoToSleep(5000);
		String result1 = generic.GetElementText_WE(ValuePackPage.JobsearchSubServices_WE);
		Assert.assertTrue(result1.equals(datatable.getCellData(SheetName, "JobsearchSub_Services", i+2 )));
	}
	}
	@Test	
	//To verify that old prices ,new prices and discount are displayed for Profile Highlighter Value Pack
	public void TC_VPP_011()
	{	
		datatable = new Xls_Reader(TestDataSheetPath_ValuePack);
		driver.get(URLProvider.Return_ValuePackURL());
		String[] expectedOption = {"0-1 Years", "1-3 Years", "3-8 Years", "8-24 Years"}; 
		for (int i=0;i<expectedOption.length;i++)
		{
			generic.Select_Experience_DD(ValuePackPage.Experience_DD, ValuePackPage.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(3000);
			String result1 = generic.GetElementText_WE(ValuePackPage.ProfileHighlighterOldprice_WE);
			System.out.println(result1);
			System.out.println(datatable.getCellData(SheetName, "ProfileHighlighter-Old", i+2));
			Assert.assertTrue(result1.equals(datatable.getCellData(SheetName, "ProfileHighlighter-Old", i+2)));
			String result2 = generic.GetElementText_WE(ValuePackPage.ProfileHighlighterNewprice_WE);
			Assert.assertTrue(result2.equals(datatable.getCellData(SheetName, "ProfileHighlighter-New", i+2)));
			String Discount1 = generic.GetElementText_WE(ValuePackPage.ProfileHighlighterDiscount_WE);
			Assert.assertTrue(Discount1.equals(datatable.getCellData(SheetName, "ProfileHighlighter-Discount", i+2)));
		}				
	}
	@Test	
	//To verify that old prices and new prices are displayed for Featured Value Pack
	public void TC_VPP_012()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ValuePack);
		driver.get(URLProvider.Return_ValuePackURL());
		String[] expectedOption = {"0-1 Years", "1-3 Years", "3-8 Years", "8-24 Years"}; 
		for (int i=0;i<expectedOption.length;i++)
		{
			generic.Select_Experience_DD(ValuePackPage.Experience_DD, ValuePackPage.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(3000);
			String result1 = generic.GetElementText_WE(ValuePackPage.FeaturedOldprice_WE);
			Assert.assertTrue(result1.equals(datatable.getCellData(SheetName, "Featured-old", i+2)));
			String result2 = generic.GetElementText_WE(ValuePackPage.FeaturedNewprice_WE);
			Assert.assertTrue(result2.equals(datatable.getCellData(SheetName, "Featured-new", i+2)));
			String Discount1 = generic.GetElementText_WE(ValuePackPage.FeaturedDiscount_WE);
			Assert.assertTrue(Discount1.equals(datatable.getCellData(SheetName, "Featured-Discount", i+2)));
		}			
	}
	@Test
	//To verify that old prices and new prices are displayed for Jobsearch value Pack
	public void TC_VPP_013()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ValuePack);
		driver.get(URLProvider.Return_ValuePackURL());
		String[] expectedOption = {"0-1 Years", "1-3 Years", "3-8 Years", "8-24 Years"}; 
		for (int i=0;i<expectedOption.length;i++)
		{
			generic.Select_Experience_DD(ValuePackPage.Experience_DD, ValuePackPage.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(3000);
			String result1 = generic.GetElementText_WE(ValuePackPage.JobsearchOldprice_WE);
			Assert.assertTrue(result1.equals(datatable.getCellData(SheetName, "Jobsearch-Old", i+2)));
			String result2 = generic.GetElementText_WE(ValuePackPage.JobsearchNewprice_WE);
			Assert.assertTrue(result2.equals(datatable.getCellData(SheetName, "Jobsearch-new", i+2)));
			String Discount1 = generic.GetElementText_WE(ValuePackPage.JobsearchDiscount_WE);
			Assert.assertTrue(Discount1.equals(datatable.getCellData(SheetName, "Jobsearch-Discount", i+2)));
		}
	}
	@Test
	//To verify that "Delivery Information" heading on Combo Service page is displayed or not	
	public void TC_VPP_014()
	{	
		driver.get(URLProvider.Return_ValuePackURL());
		String result = generic.GetElementText_WE(ValuePackPage.DeliveryInformationHeading_WE);
		Assert.assertTrue(result.equals("Delivery Information"),result);		
	}
	@Test
	//To verify that "Delivery Information" content on combo Service page is displayed or not	
	public void TC_VPP_015()
	{	
		driver.get(URLProvider.Return_ValuePackURL());
		String result = generic.GetElementText_WE(ValuePackPage.DeliveryInformationContent_WE);
		result = result.replace("\n", " ");			
		Assert.assertTrue(result.equals("Delivery Information If you are purchasing a value pack that does not contain Visual Resume, the services will be processed within 8 working days after we receive your updated resume. However, if you avail value pack with Visual Resume, these services will be processed within 8 working days after you approve your final resume."),result);
	}

	@Test
	//To verify that Gulf link is displayed or not
	public void TC_VPP_016()
	{		
		driver.get(URLProvider.Return_ValuePackURL());
		String result = generic.GetElementText_WE(ValuePackPage.GulfJobs_Lnk);	
		Assert.assertTrue(result.equals("View Gulf Packs"),result);
	}
	@Test
	//To verify that Gulf link is working or not
	public void TC_VPP_017()
	{		
		driver.get(URLProvider.Return_ValuePackURL());
		generic.Click_Lnk(ValuePackPage.GulfJobs_Lnk);	
		String result = driver.getCurrentUrl();
		Assert.assertTrue(result.equals(URLProvider.Return_GulfValuePackURL()),result);
	}

	@Test
	//To verify that message is displayed for inactive Value pack of gulf 
	public void TC_VPP_018()
	{
		String[] expectedOption = {"0-3 Years", "3-8 Years", "8+ Years"};		
		driver.get(URLProvider.Return_ValuePackURL());
		generic.Click_Lnk(ValuePackPage.GulfJobs_Lnk);
		for (int i=0;i<expectedOption.length;i++)
		{
			generic.Select_Experience_DD(ValuePackPage.GulfExperience_DD, ValuePackPage.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(3000);			
			String result1 = generic.GetElementText_WE(ValuePackPage.GulfInactive_L_WE);		
			Assert.assertTrue(result1.equals("This Package is not available for Gulf Countries"),result1);
			String result2 = generic.GetElementText_WE(ValuePackPage.GulfInactive_R_WE);	
			Assert.assertTrue(result2.equals("This Package is not available for Gulf Countries"),result2);
		}
	}
	@Test
	//To verify that Gulf value pack Heading and content is displayed or not
	public void TC_VPP_019()
	{
		{String[] expectedOption = {"0-3 Years", "3-8 Years", "8+ Years"};
		driver.get(URLProvider.Return_ValuePackURL());
		generic.Click_Lnk(ValuePackPage.GulfJobs_Lnk);
		for (int i=0;i<expectedOption.length;i++)
		{
			generic.Select_Experience_DD(ValuePackPage.GulfExperience_DD, ValuePackPage.ExperienceULid_DD,expectedOption[i]);
			String result = generic.GetElementText_WE(ValuePackPage.GulfValuePackHeading_WE);			
			Assert.assertTrue(result.equals("Gulf value pack"),result);
			String result1 = generic.GetElementText_WE(ValuePackPage.GulfValuePackContent_WE);
			Assert.assertTrue(result1.equals("Service pack if you are looking for a job in the gulf countries. Get your resume written by experts and highlight your profile amongst gulf recruiters"),result1);
		}
		}
	}
	@Test
	//To verify that Call back option is displayed for gulf 
	public void TC_VPP_020()
	{
		String[] expectedOption = {"0-3 Years", "3-8 Years", "8+ Years"};
		driver.get(URLProvider.Return_ValuePackURL());
		generic.Click_Lnk(ValuePackPage.GulfJobs_Lnk);
		for (int i=0;i<expectedOption.length;i++)
		{
			generic.Select_Experience_DD(ValuePackPage.GulfExperience_DD, ValuePackPage.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(3000);		
			String result = generic.GetElementText_WE(ValuePackPage.GulfCallBack_WE);
			result = result.replace("\n", " ");
			Assert.assertTrue(result.equals("Call Us to Buy this Pack 0091120-4021100"),result);
		}
	}
	@Test
	//To verify that Service are displayed for Gulf pack 
	public void TC_VPP_021()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ValuePack);
		driver.get(URLProvider.Return_GulfValuePackURL());
		String[] expectedOption = {"0-3 Years", "3-8 Years", "8+ Years"};
		for (int i=0;i<expectedOption.length;i++)
		{
			generic.Select_Experience_DD(ValuePackPage.GulfExperience_DD, ValuePackPage.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(3000);
			String result1 = generic.GetElementText_WE(ValuePackPage.GulfService_WE);
			Assert.assertTrue(result1.equals(datatable.getCellData(SheetName, "GulfSub_Services", i+2 )));
		}
	}
	@Test
	//To verify that old price,new price,Discount is displayed for gulf packs
	public void TC_VPP_022()
	{	
		datatable = new Xls_Reader(TestDataSheetPath_ValuePack);
		driver.get(URLProvider.Return_GulfValuePackURL());
		String[] expectedOption = {"0-3 Years", "3-8 Years", "8+ Years"};
		for (int i=0;i<expectedOption.length;i++)
		{
			generic.Select_Experience_DD(ValuePackPage.GulfExperience_DD, ValuePackPage.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(3000);
			String GulfOld = generic.GetElementText_WE(ValuePackPage.GulfOldprice_WE);
			Assert.assertTrue(GulfOld.equals(datatable.getCellData(SheetName, "Gulf Old", i+2 )));
			String GulfNew = generic.GetElementText_WE(ValuePackPage.GulfNewprice_WE);
			Assert.assertTrue(GulfNew.equals(datatable.getCellData(SheetName, "Gulf New", i+2 )));
			String GulfDiscount = generic.GetElementText_WE(ValuePackPage.GulfDiscount_WE);
			Assert.assertTrue(GulfDiscount.equals(datatable.getCellData(SheetName, "Gulf Discount", i+2 )));

		}	
	}
	@Test
	//To verify that on Adding Profile High lighter value pack service name,price are  displayed or not
	public void TC_VPP_023()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ValuePack);
		String[] expectedOption = {"0-1 Years", "1-3 Years", "3-8 Years", "8-24 Years"};
		driver.get(URLProvider.Return_ValuePackURL());
		for (int i=0;i<expectedOption.length;i++)
		{
			generic.Select_Experience_DD(ValuePackPage.GulfExperience_DD, ValuePackPage.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(3000);
			generic.Click_Lnk(ValuePackPage.ProfileHighlighterAddtocart_Btn);			
			generic.GoToSleep(3000);
			String result1 = generic.GetElementText_WE(ShoppingCart.ServiceName_WE);	
			Assert.assertTrue(result1.equals(datatable.getCellData(SheetName,"Service_name",2)));
			String result2 = generic.GetElementText_WE(ShoppingCart.ServicePrice_WE);						
			Assert.assertTrue(result2.equals(datatable.getCellData(SheetName,"ProfileHighlighter-New",i+2)));
			generic.Click_Lnk(ShoppingCart.Continue_Btn);
			generic.GoToSleep(3000);
			driver.get(URLProvider.Return_ValuePackURL());
		}
	}
	@Test
	//To verify that on Adding Featured value pack service name,price are  displayed or not
	public void TC_VPP_024()
	{datatable = new Xls_Reader(TestDataSheetPath_ValuePack);
		String[] expectedOption = {"0-1 Years", "1-3 Years", "3-8 Years", "8-24 Years"};
		driver.get(URLProvider.Return_ValuePackURL());
		for (int i=0;i<expectedOption.length;i++)
		{
			generic.Select_Experience_DD(ValuePackPage.GulfExperience_DD, ValuePackPage.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(3000);
			generic.Click_Lnk(ValuePackPage.FeaturedAddtocart_Btn);			
			generic.GoToSleep(3000);
			String result1 = generic.GetElementText_WE(ShoppingCart.ServiceName_WE);			
			Assert.assertTrue(result1.equals(datatable.getCellData(SheetName,"Service_name",3)));
			String result2 = generic.GetElementText_WE(ShoppingCart.ServicePrice_WE);						
			Assert.assertTrue(result2.equals(datatable.getCellData(SheetName,"Featured-new",i+2)));
			generic.Click_Lnk(ShoppingCart.Continue_Btn);
			generic.GoToSleep(3000);
			driver.get(URLProvider.Return_ValuePackURL());
		}
	}
	@Test
	//To verify that on Adding Jobsearch value pack service name,price are displayed or not
	public void TC_VPP_025()
	{datatable = new Xls_Reader(TestDataSheetPath_ValuePack);
		String[] expectedOption = {"0-1 Years", "1-3 Years", "3-8 Years", "8-24 Years"};		
		driver.get(URLProvider.Return_ValuePackURL());
		for (int i=0;i<expectedOption.length;i++)
		{
			generic.Select_Experience_DD(ValuePackPage.GulfExperience_DD, ValuePackPage.ExperienceULid_DD,expectedOption[i]);
			generic.GoToSleep(3000);
			generic.Click_Lnk(ValuePackPage.JobsearchAddtocart_Btn);			
			generic.GoToSleep(3000);
			String result1 = generic.GetElementText_WE(ShoppingCart.ServiceName_WE);			
			Assert.assertTrue(result1.equals(datatable.getCellData(SheetName,"Service_name",4)));
			String result2 = generic.GetElementText_WE(ShoppingCart.ServicePrice_WE);						
			Assert.assertTrue(result2.equals(datatable.getCellData(SheetName,"Jobsearch-new",i+2)));
			generic.Click_Lnk(ShoppingCart.Continue_Btn);
			generic.GoToSleep(3000);
			driver.get(URLProvider.Return_ValuePackURL());
		}
	}

}