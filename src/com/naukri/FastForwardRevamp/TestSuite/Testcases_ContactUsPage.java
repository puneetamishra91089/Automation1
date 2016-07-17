package com.naukri.FastForwardRevamp.TestSuite;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naukri.FastForwardRevamp.Code.ContactUsPage;
import com.naukri.FastForwardRevamp.Code.HomePage;
import com.naukri.FastForwardRevamp.Code.LocateBranchPage;
import com.naukri.FastForwardRevamp.Code.LoginLayer;
import com.naukri.FastForwardRevamp.ConfigDetails.ConfigDetails;
import com.naukri.FastForwardRevamp.ConfigDetails.URLProvider;
import com.naukri.GenericFunctionsPack.GenericFunctions;
import com.naukri.datatable.Xls_Reader;

public class Testcases_ContactUsPage extends ConfigDetails {
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
	public void TC_CU_001()
	{		
		driver.get(URLProvider.Return_ContactUsURL());
		generic.Click_Lnk(ContactUsPage.Naukri_Lnk);		
		String result = generic.GetElementText_WE(HomePage.HP_Image_WE);
		result = result.replace("\n", " ");
		Assert.assertEquals("Speed Up Your Career with our personalized services",result);	
	}

	@Test
	//To verify that on clicking Locate Branch link it lands locate branch service page
	public void TC_CU_002()
	{		
		driver.get(URLProvider.Return_ContactUsURL());
		generic.Click_Lnk(ContactUsPage.LocateBranch_Lnk);
		String result = generic.GetElementText(LocateBranchPage.BreadCrum_WE);
		Assert.assertEquals(result, "Naukri FastForward > Locate Branch");		
	}
	@DataProvider (name = "LeadForm")
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

	//To validate Lead form fields	
	@Test (dataProvider = "LeadForm")
	public void TC_CU_003(int rowno,String CaseType)
	{
		String SheetName = "LeadForm";
		Xls_Reader datatable = new Xls_Reader(TestDataSheetPath_LeadForm);
		driver.get(URLProvider.Return_ContactUsURL());
		generic.GoToSleep(3000);
		generic.Fill_Txt(ContactUsPage.Leadform_Name_Txt, datatable.getCellData(SheetName, "Name", rowno));
		generic.Fill_Txt(ContactUsPage.Leadform_Email_Txt, datatable.getCellData(SheetName, "Email", rowno));
		generic.Fill_Txt(ContactUsPage.Leadform_Mobile_Txt, datatable.getCellData(SheetName, "Mobile", rowno));
		generic.Fill_Txt(ContactUsPage.Leadform_Query_Txt, datatable.getCellData(SheetName, "Query", rowno));
		generic.Click_Btn(ContactUsPage.LeadformCallmeBack_Btn);
		generic.GoToSleep(2000);
		ContactUsPage ContactUs = new ContactUsPage(driver,generic);
		String Errors = ContactUs.CaptureErrors();
		String Expected =datatable.getCellData(SheetName, "Expected", rowno);
		if(Expected.equalsIgnoreCase("Submitted")) 
		{
			Assert.assertTrue(generic.isVisible(ContactUsPage.LeadformThankYouMsg_WE),"Failed Expected : Submitted Actual :NotSubmitted");
		}
		else 
		{
			Assert.assertEquals(Errors, datatable.getCellData(SheetName, "ExpectedErrorMessage", rowno));
		}
	}

	//To Validate Field level Validations in Lead Form Logged In State
	@Test
	public void TC_CU_004()
	{
		driver.get(URLProvider.Return_ContactUsURL());
		LoginLayer loginLayer = new LoginLayer(driver, generic);
		generic.Click_Lnk(LoginLayer.GNB_Login_Lnk);
		loginLayer.Fillform_Login("Email", Email, Password);
		Assert.assertEquals(generic.GetText_Txt(ContactUsPage.Leadform_Name_Txt), "Puneeta Mishra");
		Assert.assertEquals(generic.GetText_Txt(ContactUsPage.Leadform_Email_Txt), Email);
		Assert.assertEquals(generic.GetText_Txt(ContactUsPage.Leadform_Mobile_Txt), "1234567890");
	}
	@Test
	//To verify that Contact Us Static content is displayed or not
	public void TC_CU_005()
	{		
		driver.get(URLProvider.Return_ContactUsURL());
		String result = generic.GetElementText_WE(ContactUsPage.BreadCrum_WE);			
		Assert.assertTrue(result.equals("Naukri FastForward > Contact Us"),result);		

		//To verify that Talk to US heading is displayed or not	

		result = generic.GetElementText_WE(ContactUsPage.TalktoUs_WE);		
		Assert.assertTrue(result.equals("Talk to Us"),result);

		//To verify that Talk to US Content is displayed or not	

		result = generic.GetElementText_WE(ContactUsPage.TalktoUsContent_WE);
		result= result.replace("\n", " ");		
		Assert.assertTrue(result.equals("Talk to Us Call Us Toll Free: 1800­-102-5557 (9 AM to 9 PM IST) International Customer Call: +91-120-4049800 For Bulk queries call: +91-9899104326"),result);

		//To verify that Walk In Heading is displayed or not

		result = generic.GetElementText_WE(ContactUsPage.WalkIn_WE);		
		Assert.assertTrue(result.equals("Walk In"),result);

		//To verify that Walk In content is displayed or not

		result = generic.GetElementText_WE(ContactUsPage.WalkInContent_WE);
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("Walk In Walk in to the nearest branch Locate Branch"),result);
		//To verify that Chat With Us content is displayed or not

		result = generic.GetElementText(ContactUsPage.ChatWithContent_WE);
		result = result.replace("\n", " ");
		Assert.assertEquals(result, "Chat with Us Chat between (10 AM to 7 PM IST, Mon to Sun) Chat Now");

	}
}
