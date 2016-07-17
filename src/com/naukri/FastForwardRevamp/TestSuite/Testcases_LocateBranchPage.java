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

public class Testcases_LocateBranchPage extends ConfigDetails {
	Xls_Reader datatable;
	String SheetName = "LocateBranch";
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
	public void TC_LB_001()
	{		
		driver.get(URLProvider.Return_LocateBranchURL());
		generic.Click_Lnk(LocateBranchPage.Naukri_Lnk);		
		String result = generic.GetElementText_WE(HomePage.HP_Image_WE);
		result = result.replace("\n", " ");
		Assert.assertEquals("Speed Up Your Career with our personalized services",result);
	}

	@Test 
	//To verify that on clicking Rest of India Link Toll free number should be displayed
	public void TC_LB_002()
	{		
		driver.get(URLProvider.Return_LocateBranchURL());
		generic.Click_Lnk(LocateBranchPage.AnywhereElse_Lnk);
		String result = generic.GetElementText_WE(LocateBranchPage.TollFreeNo_WE);
		result = result.replace("\n", " ");
		Assert.assertTrue(result.equals("Call: 18001034705 9 AM to 9 PM IST"),result);
	}

	@Test
	//To verify that on selecting Delhi Contact person name,email,number is displayed or not
	public void TC_LB_003()
	{
		SheetName = "LocateBranch";
		Xls_Reader datatable = new Xls_Reader(TestDataSheetPath_LocateBranch);
		driver.get(URLProvider.Return_LocateBranchURL());
		generic.Click_Lnk(LocateBranchPage.Delhi_Lnk);
		generic.GoToSleep(2000);
		String Result1 = generic.GetElementText_WE(LocateBranchPage.ContactPlace_WE);
		Assert.assertEquals(Result1,datatable.getCellData(SheetName,"Contact Place",2));	
		String Result2 = generic.GetElementText_WE(LocateBranchPage.ContactName_WE);
		Assert.assertTrue(Result2.equals(datatable.getCellData(SheetName,"Name",2)),Result2);
		String Result3 = generic.GetElementText_WE(LocateBranchPage.ContactEmail_WE);
		Assert.assertTrue(Result3.equals(datatable.getCellData(SheetName,"Email",2)),Result3);
		String Result4 = generic.GetElementText_WE(LocateBranchPage.ContactNumber_WE);
		Assert.assertTrue(Result4.equals(datatable.getCellData(SheetName,"Number",2)),Result4);
	}
	@Test
	//To verify that on selecting Noida Contact person name,email,number is displayed or not
	public void TC_LB_004()
	{
		Xls_Reader datatable = new Xls_Reader(TestDataSheetPath_LocateBranch);
		driver.get(URLProvider.Return_LocateBranchURL());
		generic.Click_Lnk(LocateBranchPage.Noida_Lnk);
		String Result1 = generic.GetElementText_WE(LocateBranchPage.ContactPlace_WE);
		Assert.assertTrue(Result1.equals(datatable.getCellData(SheetName,"Contact Place",3)),Result1);	
		String Result2 = generic.GetElementText_WE(LocateBranchPage.ContactName_WE);
		Assert.assertTrue(Result2.equals(datatable.getCellData(SheetName,"Name",3)),Result2);
		String Result3 = generic.GetElementText_WE(LocateBranchPage.ContactEmail_WE);
		Assert.assertTrue(Result3.equals(datatable.getCellData(SheetName,"Email",3)),Result3);
		String Result4 = generic.GetElementText_WE(LocateBranchPage.ContactNumber_WE);
		Assert.assertTrue(Result4.equals(datatable.getCellData(SheetName,"Number",3)),Result4);
	}
	@Test
	//To verify that on selecting Bangalore Contact person name,email,number is displayed or not
	public void TC_LB_005()
	{
		Xls_Reader datatable = new Xls_Reader(TestDataSheetPath_LocateBranch);
		driver.get(URLProvider.Return_LocateBranchURL());
		generic.Click_Lnk(LocateBranchPage.Bangalore_Lnk);
		String Result1 = generic.GetElementText_WE(LocateBranchPage.ContactPlace_WE);
		Assert.assertTrue(Result1.equals(datatable.getCellData(SheetName,"Contact Place",4)),Result1);
		String Result2 = generic.GetElementText_WE(LocateBranchPage.ContactName_WE);
		Assert.assertTrue(Result2.equals(datatable.getCellData(SheetName,"Name",4)),Result2);
		String Result3 = generic.GetElementText_WE(LocateBranchPage.ContactEmail_WE);
		Assert.assertTrue(Result3.equals(datatable.getCellData(SheetName,"Email",4)),Result3);
		String Result4 = generic.GetElementText_WE(LocateBranchPage.ContactNumber_WE);
		Assert.assertTrue(Result4.equals(datatable.getCellData(SheetName,"Number",4)),Result4);
	}
	@Test
	//To verify that on selecting Hyderabad Contact person name,email,number is displayed or not
	public void TC_LB_006()
	{
		Xls_Reader datatable = new Xls_Reader(TestDataSheetPath_LocateBranch);
		driver.get(URLProvider.Return_LocateBranchURL());
		generic.Click_Lnk(LocateBranchPage.Hyderabad_Lnk);
		String Result1 = generic.GetElementText_WE(LocateBranchPage.ContactPlace_WE);
		Assert.assertTrue(Result1.equals(datatable.getCellData(SheetName,"Contact Place",5)),Result1);	
		String Result2 = generic.GetElementText_WE(LocateBranchPage.ContactName_WE);
		Assert.assertTrue(Result2.equals(datatable.getCellData(SheetName,"Name",5)),Result2);
		String Result3 = generic.GetElementText_WE(LocateBranchPage.ContactEmail_WE);
		Assert.assertTrue(Result3.equals(datatable.getCellData(SheetName,"Email",5)),Result3);
		String Result4 = generic.GetElementText_WE(LocateBranchPage.ContactNumber_WE);
		Assert.assertTrue(Result4.equals(datatable.getCellData(SheetName,"Number",5)),Result4);
	}
	@Test
	//To verify that on selecting Chennai Contact person name,email,number is displayed or not
	public void TC_LB_007()
	{
		Xls_Reader datatable = new Xls_Reader(TestDataSheetPath_LocateBranch);
		driver.get(URLProvider.Return_LocateBranchURL());
		generic.Click_Lnk(LocateBranchPage.Chennai_Lnk);
		String Result1 = generic.GetElementText_WE(LocateBranchPage.ContactPlace_WE);
		Assert.assertTrue(Result1.equals(datatable.getCellData(SheetName,"Contact Place",6)),Result1);	
		String Result2 = generic.GetElementText_WE(LocateBranchPage.ContactName_WE);
		Assert.assertTrue(Result2.equals(datatable.getCellData(SheetName,"Name",6)),Result2);
		String Result3 = generic.GetElementText_WE(LocateBranchPage.ContactEmail_WE);
		Assert.assertTrue(Result3.equals(datatable.getCellData(SheetName,"Email",6)),Result3);
		String Result4 = generic.GetElementText_WE(LocateBranchPage.ContactNumber_WE);
		Assert.assertTrue(Result4.equals(datatable.getCellData(SheetName,"Number",6)),Result4);
	}
	@Test
	//To verify that on selecting Mumbai Thane Contact person name,email,number is displayed or not
	public void TC_LB_008()
	{
		Xls_Reader datatable = new Xls_Reader(TestDataSheetPath_LocateBranch);
		driver.get(URLProvider.Return_LocateBranchURL());
		generic.Click_Lnk(LocateBranchPage.MumbaiThane_Lnk);
		String Result1 = generic.GetElementText_WE(LocateBranchPage.ContactPlace_WE);
		Assert.assertTrue(Result1.equals(datatable.getCellData(SheetName,"Contact Place",7)),Result1);	
		String Result2 = generic.GetElementText_WE(LocateBranchPage.ContactName_WE);
		Assert.assertTrue(Result2.equals(datatable.getCellData(SheetName,"Name",7)),Result2);
		String Result3 = generic.GetElementText_WE(LocateBranchPage.ContactEmail_WE);
		Assert.assertTrue(Result3.equals(datatable.getCellData(SheetName,"Email",7)),Result3);
		String Result4 = generic.GetElementText_WE(LocateBranchPage.ContactNumber_WE);
		Assert.assertTrue(Result4.equals(datatable.getCellData(SheetName,"Number",7)),Result4);
	}
	@Test
	//To verify that on selecting Mumbai Andheri Contact person name,email,number is displayed or not
	public void TC_LB_009()
	{
		Xls_Reader datatable = new Xls_Reader(TestDataSheetPath_LocateBranch);
		driver.get(URLProvider.Return_LocateBranchURL());
		generic.Click_Lnk(LocateBranchPage.MumbaiAndheri_Lnk);
		String Result1 = generic.GetElementText_WE(LocateBranchPage.ContactPlace_WE);
		Assert.assertTrue(Result1.equals(datatable.getCellData(SheetName,"Contact Place",8)),Result1);	
		String Result2 = generic.GetElementText_WE(LocateBranchPage.ContactName_WE);
		Assert.assertTrue(Result2.equals(datatable.getCellData(SheetName,"Name",8)),Result2);
		String Result3 = generic.GetElementText_WE(LocateBranchPage.ContactEmail_WE);
		Assert.assertTrue(Result3.equals(datatable.getCellData(SheetName,"Email",8)),Result3);
		String Result4 = generic.GetElementText_WE(LocateBranchPage.ContactNumber_WE);
		Assert.assertTrue(Result4.equals(datatable.getCellData(SheetName,"Number",8)),Result4);
	}
	@Test
	//To verify that on selecting Pune Contact person name,email,number is displayed or not
	public void TC_LB_010()
	{
		Xls_Reader datatable = new Xls_Reader(TestDataSheetPath_LocateBranch);

		driver.get(URLProvider.Return_LocateBranchURL());
		generic.Click_Lnk(LocateBranchPage.Pune_Lnk);
		String Result1 = generic.GetElementText_WE(LocateBranchPage.ContactPlace_WE);
		Assert.assertTrue(Result1.equals(datatable.getCellData(SheetName,"Contact Place",9)),Result1);	
		String Result2 = generic.GetElementText_WE(LocateBranchPage.ContactName_WE);
		Assert.assertTrue(Result2.equals(datatable.getCellData(SheetName,"Name",9)),Result2);
		String Result3 = generic.GetElementText_WE(LocateBranchPage.ContactEmail_WE);
		Assert.assertTrue(Result3.equals(datatable.getCellData(SheetName,"Email",9)),Result3);
		String Result4 = generic.GetElementText_WE(LocateBranchPage.ContactNumber_WE);
		Assert.assertTrue(Result4.equals(datatable.getCellData(SheetName,"Number",9)),Result4);
	}
	@Test
	//To verify that on selecting Kolkata Contact person name,email,number is displayed or not
	public void TC_LB_011()
	{
		Xls_Reader datatable = new Xls_Reader(TestDataSheetPath_LocateBranch);

		driver.get(URLProvider.Return_LocateBranchURL());
		generic.Click_Lnk(LocateBranchPage.Kolkata_Lnk);
		String Result1 = generic.GetElementText_WE(LocateBranchPage.ContactPlace_WE);
		Assert.assertTrue(Result1.equals(datatable.getCellData(SheetName,"Contact Place",10)),Result1);	
		String Result2 = generic.GetElementText_WE(LocateBranchPage.ContactName_WE);
		Assert.assertTrue(Result2.equals(datatable.getCellData(SheetName,"Name",10)),Result2);
		String Result3 = generic.GetElementText_WE(LocateBranchPage.ContactEmail_WE);
		Assert.assertTrue(Result3.equals(datatable.getCellData(SheetName,"Email",10)),Result3);
		String Result4 = generic.GetElementText_WE(LocateBranchPage.ContactNumber_WE);
		Assert.assertTrue(Result4.equals(datatable.getCellData(SheetName,"Number",10)),Result4);
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

	//To validate Lead form fields Not logged in state	
	@Test (dataProvider = "LeadForm")
	public void TC_LB_012(int rowno,String CaseType)
	{
		String SheetName = "LeadForm";
		Xls_Reader datatable = new Xls_Reader(TestDataSheetPath_LeadForm);
		driver.get(URLProvider.Return_LocateBranchURL());
		generic.GoToSleep(3000);
		generic.Fill_Txt(LocateBranchPage.Leadform_Name_Txt, datatable.getCellData(SheetName, "Name", rowno));
		generic.Fill_Txt(LocateBranchPage.Leadform_Email_Txt, datatable.getCellData(SheetName, "Email", rowno));
		generic.Fill_Txt(LocateBranchPage.Leadform_Mobile_Txt, datatable.getCellData(SheetName, "Mobile", rowno));
		generic.Fill_Txt(LocateBranchPage.Leadform_Query_Txt, datatable.getCellData(SheetName, "Query", rowno));
		generic.Click_Btn(LocateBranchPage.LeadformCallmeBack_Btn);
		generic.GoToSleep(2000);
		LocateBranchPage LocateBranch = new LocateBranchPage(driver,generic);
		String Errors = LocateBranch.CaptureErrors();
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
	public void TC_LB_013()
	{
		driver.get(URLProvider.Return_LocateBranchURL());
		LoginLayer loginLayer = new LoginLayer(driver, generic);
		generic.Click_Lnk(LoginLayer.GNB_Login_Lnk);
		loginLayer.Fillform_Login("Email", Email, Password);
		Assert.assertEquals(generic.GetText_Txt(LocateBranchPage.Leadform_Name_Txt), "Puneeta Mishra");
		Assert.assertEquals(generic.GetText_Txt(LocateBranchPage.Leadform_Email_Txt), Email);
		Assert.assertEquals(generic.GetText_Txt(LocateBranchPage.Leadform_Mobile_Txt), "1234567890");
	}
	@Test
	//To verify that Locate Branch static content is displayed or not
	public void TC_LB_014()
	{		
		driver.get(URLProvider.Return_LocateBranchURL());
		String result = generic.GetElementText_WE(LocateBranchPage.BreadCrum_WE);			
		Assert.assertTrue(result.equals("Naukri FastForward > Locate Branch"),result);		

		//To verify that Delhi Link is displayed or not

		result = generic.GetElementText_WE(LocateBranchPage.Delhi_Lnk);		
		Assert.assertTrue(result.equals("Delhi"),result);

		//To verify that Noida Link is displayed or not

		result = generic.GetElementText_WE(LocateBranchPage.Noida_Lnk);		
		Assert.assertTrue(result.equals("Noida"),result);

		//To verify that Bangalore Link is displayed or not

		result = generic.GetElementText_WE(LocateBranchPage.Bangalore_Lnk);		
		Assert.assertTrue(result.equals("Bangalore"),result);

		//To verify that Hyderabad Link is displayed or not

		result = generic.GetElementText_WE(LocateBranchPage.Hyderabad_Lnk);		
		Assert.assertTrue(result.equals("Hyderabad"),result);

		//To verify that Chennai Link is displayed or not

		result = generic.GetElementText_WE(LocateBranchPage.Chennai_Lnk);		
		Assert.assertTrue(result.equals("Chennai"),result);

		//To verify that Mumbai-Thane Link is displayed or not

		result = generic.GetElementText_WE(LocateBranchPage.MumbaiThane_Lnk);		
		Assert.assertTrue(result.equals("Mumbai-Thane"),result);

		//To verify that Mumbai-Andheri Link is displayed or not

		result = generic.GetElementText_WE(LocateBranchPage.MumbaiAndheri_Lnk);		
		Assert.assertTrue(result.equals("Mumbai-Andheri"),result);

		//To verify that Pune Link is displayed or not

		result = generic.GetElementText_WE(LocateBranchPage.Pune_Lnk);		
		Assert.assertTrue(result.equals("Pune"),result);

		//To verify that Kolkata Link is displayed or not

		result = generic.GetElementText_WE(LocateBranchPage.Kolkata_Lnk);		
		Assert.assertTrue(result.equals("Kolkata"),result);

		//To verify that Rest of India Link is displayed or not

		result = generic.GetElementText_WE(LocateBranchPage.AnywhereElse_Lnk);		
		Assert.assertTrue(result.equals("Rest of India"),result);
	}
}
