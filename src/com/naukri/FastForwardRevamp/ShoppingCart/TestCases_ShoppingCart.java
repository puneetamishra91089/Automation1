package com.naukri.FastForwardRevamp.ShoppingCart;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naukri.FastForwardRevamp.Code.CertificateHighlighterPage;
import com.naukri.FastForwardRevamp.Code.HomePage;
import com.naukri.FastForwardRevamp.Code.Jobs4UPage;
import com.naukri.FastForwardRevamp.Code.PriorityApplicantPage;
import com.naukri.FastForwardRevamp.Code.RecruiterConnectionPage;
import com.naukri.FastForwardRevamp.Code.ResumeDisplayPage;
import com.naukri.FastForwardRevamp.Code.ShoppingCart;
import com.naukri.FastForwardRevamp.Code.TextResumePage;
import com.naukri.FastForwardRevamp.Code.VisualResumePage;
import com.naukri.FastForwardRevamp.ConfigDetails.ConfigDetails;
import com.naukri.FastForwardRevamp.ConfigDetails.URLProvider;
import com.naukri.GenericFunctionsPack.GenericFunctions;
import com.naukri.datatable.Xls_Reader;

public class TestCases_ShoppingCart extends ConfigDetails{
	Xls_Reader datatable; 
	@BeforeMethod ()
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
	//To verify that on Clicking Naukri Link it lands to Naukri Home page
	public void TC_Cart_001()
	{
		driver.get(URLProvider.Return_ResumeDisplayURL());
		generic.Click(ResumeDisplayPage.AddtoCart_Btn);
		generic.Click_Lnk(ShoppingCart.Naukri_Lnk);
		String result = generic.GetElementText_WE(HomePage.HP_Image_WE);
		result = result.replace("\n", " ");
		Assert.assertEquals("Speed Up Your Career with our personalized services",result);	
	}

	//@Test
	//To verify that on selecting Continue shopping link in Cart it should land to home page
	public void TC_Cart_002()
	{
		driver.get(URLProvider.Return_ResumeDisplayURL());
		generic.Click(ResumeDisplayPage.AddtoCart_Btn);
		generic.Click(ShoppingCart.Continue_Btn);
		String result = generic.GetElementText_WE(HomePage.HP_Image_WE);
		result = result.replace("\n", " ");
		Assert.assertEquals("Speed Up Your Career with our personalized services",result);	
	}
	@Test
	//To verify that on selecting Proceed to payment Login section opens for Not logged in User
	public void TC_Cart_003()
	{
		driver.get(URLProvider.Return_ResumeDisplayURL());
		generic.Click(ResumeDisplayPage.AddtoCart_Btn);
		//To verify that buy Safe content is displayed
		String Result =generic.GetElementText(ShoppingCart.BuySafeContent_WE);
		Result = Result.replace("\n", " ");
		Assert.assertEquals(Result, "Buy Safely with Naukri.com We support secure payment methods");
		//To verify that Need Help section is displayed
		Result =generic.GetElementText(ShoppingCart.NeedHelp_WE);
		Assert.assertEquals(Result, "Need Help?");
		Result =generic.GetElementText(ShoppingCart.CallUsfree_WE);
		Result = Result.replace("\n", " ");
		Assert.assertEquals(Result, "Call Us Toll Free 1800-3010-5557 (9 AM to 9 PM IST)");
		generic.Click(ShoppingCart.ProceedtoPayment_Btn);
		Assert.assertTrue(generic.isVisible(ShoppingCart.ExistingNaukriUser_WE),"Proceed to payment is not working");
	}


	@Test
	//To verify that Addition information for the resume dependent Service
	public void TC_Cart_004()
	{
		driver.get(URLProvider.Return_ResumeDisplayURL());
		generic.Click(ResumeDisplayPage.AddtoCart_Btn);
		String Result = generic.GetElementText(ShoppingCart.AdditionalInformation_WE);
		Assert.assertEquals(Result, "*The service will be processed after you send your updated resume");
		driver.get(URLProvider.Return_TextResume_EntryLevelURL());
		generic.Click(TextResumePage.Addtocart_Btn);
		String Result1 = generic.GetElementText(ShoppingCart.AdditionalInformation_WE);
		Assert.assertEquals(Result1, "*The service will be processed after you approve your final resume draft");

	}
	@Test
	//To verify that shopping cart edit and update functionality for text Resume Fresher Level
	public void TC_Cart_005()
	{
		datatable = new Xls_Reader(TestDataSheetPath_TextResumeWriting);
		driver.get(URLProvider.Return_TextResume_EntryLevelURL());
		generic.Select_Experience_DD(TextResumePage.Experience_DD,TextResumePage.ExperienceULid_DD,"0-1 Years");
		generic.Click(TextResumePage.Addtocart_Btn);	
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption1_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		String ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		String Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",2)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",2)));
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption2_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",3)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",3)));
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption3_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		generic.GoToSleep(3000);
		ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",11)));
		String SheetPrice=datatable.getCellData("sheet1","Service_price",11);
		Assert.assertEquals(SheetPrice, Price);
	}
	@Test
	//To verify that shopping cart edit and update functionality for text Resume Entry Level
	public void TC_Cart_006()
	{
		datatable = new Xls_Reader(TestDataSheetPath_TextResumeWriting);
		driver.get(URLProvider.Return_TextResume_EntryLevelURL());
		generic.Select_Experience_DD(TextResumePage.Experience_DD,TextResumePage.ExperienceULid_DD,"1-3 Years");
		generic.GoToSleep(1000);
		generic.Click(TextResumePage.Addtocart_Btn);	
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption1_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		String ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		String Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",4)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",4)));
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption2_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",5)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",5)));
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption3_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",12)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",12)));
	}
	@Test
	//To verify that shopping cart edit and update functionality for text Resume Mid Level
	public void TC_Cart_007()
	{
		datatable = new Xls_Reader(TestDataSheetPath_TextResumeWriting);
		driver.get(URLProvider.Return_TextResume_MidLevelURL());
		generic.Click(TextResumePage.Addtocart_Btn);	
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption1_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		String ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		String Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",6)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",6)));
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption2_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",7)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",7)));
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption3_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",13)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",13)));
	}
	@Test
	//To verify that shopping cart edit and update functionality for text Resume Senior Level
	public void TC_Cart_008()
	{
		datatable = new Xls_Reader(TestDataSheetPath_TextResumeWriting);
		driver.get(URLProvider.Return_TextResume_SeniorLevelURL());
		generic.Click(TextResumePage.Addtocart_Btn);	
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption1_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		String ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		String Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",8)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",8)));
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption2_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",9)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",9)));
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption3_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",14)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",14)));
	}
	@Test
	//To verify that shopping cart edit and update functionality for Visual Resume Fresher Level
	public void TC_Cart_009()
	{
		datatable = new Xls_Reader(TestDataSheetPath_VisualResumeWriting);
		driver.get(URLProvider.Return_VisualResume_EntryLevelURL());
		generic.Select_Experience_DD(TextResumePage.Experience_DD,TextResumePage.ExperienceULid_DD,"0-1 Years");
		generic.Click(VisualResumePage.Addtocart_Btn);	
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption1_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		String ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		String Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",2)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",2)));
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption2_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",3)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",3)));
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption3_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",10)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",10)));
	}
	@Test
	//To verify that shopping cart edit and update functionality for Visual Resume Entry Level
	public void TC_Cart_010()
	{
		datatable = new Xls_Reader(TestDataSheetPath_VisualResumeWriting);
		driver.get(URLProvider.Return_VisualResume_EntryLevelURL());
		generic.Select_Experience_DD(TextResumePage.Experience_DD,TextResumePage.ExperienceULid_DD,"1-3 Years");
		generic.Click(VisualResumePage.Addtocart_Btn);	
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption1_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		String ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		String Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",4)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",4)));
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption2_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",5)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",5)));
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption3_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",11)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",11)));
	}
	@Test
	//To verify that shopping cart edit and update functionality for Visual Resume Mid Level
	public void TC_Cart_011()
	{
		datatable = new Xls_Reader(TestDataSheetPath_VisualResumeWriting);
		driver.get(URLProvider.Return_VisualResume_MidLevelURL());
		generic.Click(VisualResumePage.Addtocart_Btn);	
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption1_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		String ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		String Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",6)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",6)));
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption2_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",7)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",7)));
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption3_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",12)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",12)));
	}
	@Test
	//To verify that shopping cart edit and update functionality for Visual Resume Senior Level
	public void TC_Cart_012()
	{
		datatable = new Xls_Reader(TestDataSheetPath_VisualResumeWriting);
		driver.get(URLProvider.Return_VisualResume_SeniorLevelURL());
		generic.Click(VisualResumePage.Addtocart_Btn);	
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption1_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		String ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		String Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",8)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",8)));
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption2_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",9)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",9)));
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption3_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",13)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",13)));
	}
	@Test
	//To verify that shopping cart edit and update functionality for Resume Display
	public void TC_Cart_013()
	{
		datatable = new Xls_Reader(TestDataSheetPath_ResumeDisplay);
		driver.get(URLProvider.Return_ResumeDisplayURL());
		generic.Select_Experience_DD(ResumeDisplayPage.Subscription_DD, ResumeDisplayPage.ExperienceULid_DD, "6 Months");
		generic.Click(ResumeDisplayPage.AddtoCart_Btn);	
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption1_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		String ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		String Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",2)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",2)));
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption2_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",3)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",3)));
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption1_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",2)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",2)));

	}
	@Test
	//To verify that shopping cart edit and update functionality for RecruiterConnection
	public void TC_Cart_014()
	{
		datatable = new Xls_Reader(TestDataSheetPath_RecruiterConnection);
		driver.get(URLProvider.Return_RecruiterConnectionURL());
		generic.Select_Experience_DD(ResumeDisplayPage.Subscription_DD, ResumeDisplayPage.ExperienceULid_DD, "5");
		generic.GoToSleep(1000);
		generic.Click(RecruiterConnectionPage.Addtocart_Btn);	
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption2_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		String ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		System.out.println(ServiceName);
		System.out.println(datatable.getCellData("sheet1","Service_name",3));
		String Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",3)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",3)));
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption3_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",2)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",2)));
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption1_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",4)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",4)));

	}
	@Test
	//To verify that shopping cart edit and update functionality for Jobs4U
	public void TC_Cart_015()
	{
		datatable = new Xls_Reader(TestDataSheetPath_Jobs4U);
		driver.get(URLProvider.Return_Jobs4UURL());
		generic.Select_Experience_DD(ResumeDisplayPage.Subscription_DD, ResumeDisplayPage.ExperienceULid_DD, "6 Months");
		generic.Click(Jobs4UPage.AddtoCart_Btn);	
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption1_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		String ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		String Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",2)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",2)));
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption2_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",3)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",3)));
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption1_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("sheet1","Service_name",2)));
		Assert.assertTrue(Price.equals(datatable.getCellData("sheet1","Service_price",2)));

	}
	@Test
	//To verify that shopping cart edit and update functionality for Priority Applicant
	public void TC_Cart_016()
	{
		datatable = new Xls_Reader(TestDataSheetPath_PriorityApplicant);
		driver.get(URLProvider.Return_PriorityApplicantURL());
		generic.Select_Experience_DD(ResumeDisplayPage.Subscription_DD, ResumeDisplayPage.ExperienceULid_DD, "3 Months");
		generic.Click(PriorityApplicantPage.AddtoCart_Btn);	
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption1_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(2000);
		String ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		String Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("Sheet1","Service_name",3)));
		Assert.assertTrue(Price.equals(datatable.getCellData("Sheet1","Service_price",3)));
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption2_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("Sheet1","Service_name",2)));
		Assert.assertTrue(Price.equals(datatable.getCellData("Sheet1","Service_price",2)));

	}
	@Test
	//To verify that shopping cart edit and update functionality for Certification Highlighter
	public void TC_Cart_017()
	{
		datatable = new Xls_Reader(TestDataSheetPath_CertificateHighlighter);
		driver.get(URLProvider.Return_CertificateHighlighterURL());
		generic.Select_Experience_DD(CertificateHighlighterPage.Subscription_DD, CertificateHighlighterPage.ExperienceULid_DD, "12 Months");
		generic.Click(CertificateHighlighterPage.AddtoCart_Btn);	
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption2_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		String ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		String Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		System.out.println(ServiceName);
		System.out.println(datatable.getCellData("Certificate Highlighter","Service_name",3)); 
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("Certificate Highlighter","Service_name",3)));
		Assert.assertTrue(Price.equals(datatable.getCellData("Certificate Highlighter","Service_price",3)));
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption3_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("Certificate Highlighter","Service_name",2)));
		Assert.assertTrue(Price.equals(datatable.getCellData("Certificate Highlighter","Service_price",2)));
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption1_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		System.out.println(Price);
		System.out.println(datatable.getCellData("Certificate Highlighter","Service_price",4)); 
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("Certificate Highlighter","Service_name",4)));
		Assert.assertTrue(Price.equals(datatable.getCellData("Certificate Highlighter","Service_price",4)));

	}
	@Test
	//To verify ConflictMessage and replacement of services in the cart
	public void TC_Cart_018()
	{
		datatable = new Xls_Reader(TestDataSheetPath_CertificateHighlighter);
		driver.get(URLProvider.Return_CertificateHighlighterURL());
		generic.Select_Experience_DD(CertificateHighlighterPage.Subscription_DD, CertificateHighlighterPage.ExperienceULid_DD, "12 Months");
		generic.Click(CertificateHighlighterPage.AddtoCart_Btn);	
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption2_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		String ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		String Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		System.out.println(ServiceName);
		System.out.println(datatable.getCellData("Certificate Highlighter","Service_name",3)); 
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("Certificate Highlighter","Service_name",3)));
		Assert.assertTrue(Price.equals(datatable.getCellData("Certificate Highlighter","Service_price",3)));
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption3_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("Certificate Highlighter","Service_name",2)));
		Assert.assertTrue(Price.equals(datatable.getCellData("Certificate Highlighter","Service_price",2)));
		generic.Click(ShoppingCart .Edit_Lnk);
		generic.Click(ShoppingCart.Editoption1_Rdb);
		generic.Click(ShoppingCart.Update_Btn);
		generic.GoToSleep(1000);
		Price = generic.GetElementText(ShoppingCart.ServicePrice1_WE);
		ServiceName = generic.GetElementText(ShoppingCart.ServiceName_WE);
		System.out.println(Price);
		System.out.println(datatable.getCellData("Certificate Highlighter","Service_price",4)); 
		Assert.assertTrue(ServiceName.equals(datatable.getCellData("Certificate Highlighter","Service_name",4)));
		Assert.assertTrue(Price.equals(datatable.getCellData("Certificate Highlighter","Service_price",4)));

	}
//	@Test 
//	//To verify Login Section Static Content
//	public void TC_Cart_019()
//	{
//		
//	}
//	@Test 
//	//To verify Login Validation for Existing User
//	public void TC_Cart_020()
//	{
//		
//	}
//	@Test 
//	//To verify forgot Password Link
//	public void TC_Cart_021()
//	{
//		
//	}
//	@Test 
//	//To verify Login Validation for New User
//	public void TC_Cart_022()
//	{
//		
//	}
//	@Test 
//	//To verify Payment Section Static Content
//	public void TC_Cart_023()
//	{
//		
//	}
//	@Test
//	// To verify on Adding Ecourse to the cart
//	public void TC_Cart_024()
//	{
//		
//	}
//	
	
//	@Test
//	//To verify that on Adding Profile High lighter value pack service name,price are  displayed or not
//	public void TC_VPP_025()
//	{
//		datatable = new Xls_Reader(TestDataSheetPath_ValuePack);
//		String[] expectedOption = {"0-1 Years", "1-3 Years", "3-8 Years", "8-24 Years"};
//		driver.get(URLProvider.Return_ValuePackURL());
//		for (int i=0;i<expectedOption.length;i++)
//		{
//			generic.Select_Experience_DD(ValuePackPage.GulfExperience_DD, ValuePackPage.ExperienceULid_DD,expectedOption[i]);
//			generic.GoToSleep(3000);
//			generic.Click_Lnk(ValuePackPage.ProfileHighlighterAddtocart_Btn);			
//			generic.GoToSleep(3000);
//			String result1 = generic.GetElementText_WE(ShoppingCart.ServiceName_WE);	
//			Assert.assertTrue(result1.equals(datatable.getCellData(SheetName,"Service_name",2)));
//			String result2 = generic.GetElementText_WE(ShoppingCart.ServicePrice_WE);						
//			Assert.assertTrue(result2.equals(datatable.getCellData(SheetName,"ProfileHighlighter-New",i+2)));
//			generic.Click_Lnk(ShoppingCart.Continue_Btn);
//			generic.GoToSleep(3000);
//			driver.get(URLProvider.Return_ValuePackURL());
//		}
//	}
//	@Test
//	//To verify that on Adding Featured value pack service name,price are  displayed or not
//	public void TC_VPP_026()
//	{datatable = new Xls_Reader(TestDataSheetPath_ValuePack);
//		String[] expectedOption = {"0-1 Years", "1-3 Years", "3-8 Years", "8-24 Years"};
//		driver.get(URLProvider.Return_ValuePackURL());
//		for (int i=0;i<expectedOption.length;i++)
//		{
//			generic.Select_Experience_DD(ValuePackPage.GulfExperience_DD, ValuePackPage.ExperienceULid_DD,expectedOption[i]);
//			generic.GoToSleep(3000);
//			generic.Click_Lnk(ValuePackPage.FeaturedAddtocart_Btn);			
//			generic.GoToSleep(3000);
//			String result1 = generic.GetElementText_WE(ShoppingCart.ServiceName_WE);			
//			Assert.assertTrue(result1.equals(datatable.getCellData(SheetName,"Service_name",3)));
//			String result2 = generic.GetElementText_WE(ShoppingCart.ServicePrice_WE);						
//			Assert.assertTrue(result2.equals(datatable.getCellData(SheetName,"Featured-new",i+2)));
//			generic.Click_Lnk(ShoppingCart.Continue_Btn);
//			generic.GoToSleep(3000);
//			driver.get(URLProvider.Return_ValuePackURL());
//		}
//	}
//	@Test
//	//To verify that on Adding Jobsearch value pack service name,price are displayed or not
//	public void TC_VPP_027()
//	{datatable = new Xls_Reader(TestDataSheetPath_ValuePack);
//		String[] expectedOption = {"0-1 Years", "1-3 Years", "3-8 Years", "8-24 Years"};		
//		driver.get(URLProvider.Return_ValuePackURL());
//		for (int i=0;i<expectedOption.length;i++)
//		{
//			generic.Select_Experience_DD(ValuePackPage.GulfExperience_DD, ValuePackPage.ExperienceULid_DD,expectedOption[i]);
//			generic.GoToSleep(3000);
//			generic.Click_Lnk(ValuePackPage.JobsearchAddtocart_Btn);			
//			generic.GoToSleep(3000);
//			String result1 = generic.GetElementText_WE(ShoppingCart.ServiceName_WE);			
//			Assert.assertTrue(result1.equals(datatable.getCellData(SheetName,"Service_name",4)));
//			String result2 = generic.GetElementText_WE(ShoppingCart.ServicePrice_WE);						
//			Assert.assertTrue(result2.equals(datatable.getCellData(SheetName,"Jobsearch-new",i+2)));
//			generic.Click_Lnk(ShoppingCart.Continue_Btn);
//			generic.GoToSleep(3000);
//			driver.get(URLProvider.Return_ValuePackURL());
//		}
//	}
//	@Test
//	// To verify that on adding Combo Widget
}