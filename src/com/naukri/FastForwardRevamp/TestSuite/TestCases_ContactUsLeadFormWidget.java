package com.naukri.FastForwardRevamp.TestSuite;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naukri.FastForwardRevamp.Code.ContactUsLeadFormWidget;
import com.naukri.FastForwardRevamp.Code.LoginLayer;
import com.naukri.FastForwardRevamp.ConfigDetails.ConfigDetails;
import com.naukri.FastForwardRevamp.ConfigDetails.URLProvider;
import com.naukri.GenericFunctionsPack.GenericFunctions;
import com.naukri.datatable.Xls_Reader;

public class TestCases_ContactUsLeadFormWidget extends ConfigDetails{
	Xls_Reader datatable;

	@BeforeMethod
	public void Before(){
		generic = new GenericFunctions(driver);
		driver = generic.StartDriver(Driver_Type);
		driver.manage().window().maximize();
		datatable = new Xls_Reader(TestDataSheetPath_LeadForm);
	}


	@DataProvider (name = "LeadFormData")
	public Object[][] DataProvider() {
		String SheetName = "LeadForm";
		datatable = new Xls_Reader(TestDataSheetPath_LeadForm);
		int rowcount = datatable.getRowCount(SheetName);
		Object result[][] = new Object[rowcount-1][5];

		for(int i=2 ; i<= rowcount ; i++){
			String Name = datatable.getCellData(SheetName, "Name", i);
			String Email = datatable.getCellData(SheetName, "Email", i);
			String Mobile = datatable.getCellData(SheetName, "Mobile", i);
			String Query = datatable.getCellData(SheetName, "Query", i);

			result[i-2][0] = i;
			result[i-2][1] = Name;
			result[i-2][2] = Email;
			result[i-2][3] = Mobile;
			result[i-2][4] = Query;
		}

		return result;
	}

	//To Validate Field level Validations in Lead Form Not Logged In State
	@Test (dataProvider = "LeadFormData")
	public void TC_LeadForm_001(int RowNo,String Name, String Email, String Mobile, String Query)
	{
		String SheetName = "LeadForm";
		driver.get(URLProvider.Return_HomePageURL());
		generic.Click_Btn(ContactUsLeadFormWidget.CallMeBack_Lnk);
		generic.GoToSleep(1000);
		ContactUsLeadFormWidget leadForm = new ContactUsLeadFormWidget(driver, generic);
		leadForm.Fillform_LeadForm(Name, Email, Mobile, Query);
		String ErrorMessages = leadForm.CaptureErrors();
		String Expected = datatable.getCellData(SheetName, "Expected", RowNo);
		if(Expected.equalsIgnoreCase("Submitted")){
			Assert.assertTrue(generic.isVisible(ContactUsLeadFormWidget.ThankyouMessages_WE), "Failed to Submit Lead Form !! " + ErrorMessages);
		}
		else {
			Assert.assertEquals(ErrorMessages, datatable.getCellData(SheetName, "ExpectedErrorMessage", RowNo));
		}
	}


	//To Validate Field level Validations in Lead Form Logged In State
	@Test
	public void TC_LeadForm_002()
	{
		driver.get(URLProvider.Return_HomePageURL());
		LoginLayer loginLayer = new LoginLayer(driver, generic);
		generic.Click_Lnk(LoginLayer.GNB_Login_Lnk);
		loginLayer.Fillform_Login("Email", Email, Password);
		generic.Click_Btn(ContactUsLeadFormWidget.CallMeBack_Lnk); 
		generic.GoToSleep(1000);
		Assert.assertEquals(generic.GetText_Txt(ContactUsLeadFormWidget.Name_Txt), "Puneeta Mishra");
		Assert.assertEquals(generic.GetText_Txt(ContactUsLeadFormWidget.Email_Txt), Email);
		Assert.assertEquals(generic.GetText_Txt(ContactUsLeadFormWidget.Mobile_Txt), "1234567890");
		generic.GoToSleep(1000);
	}
	@Test
	//To verify that Contact US widget static content is displayed
	public void TC_LeadForm_003()
	{
		driver.get(URLProvider.Return_HomePageURL());
		String result = generic.GetElementText(ContactUsLeadFormWidget.TollFreeNo_WE);
		result = result.replace("\n", " ");
		Assert.assertEquals(result, "TALK TO US 1800-102-5557 Toll Free 9 AM to 9 PM IST");
		//To verify that Contact US widget Call me Back is displayed
		result = generic.GetElementText(ContactUsLeadFormWidget.CallMeBack_Lnk);
		Assert.assertEquals(result, "CALL ME BACK");
	}


	@AfterMethod
	public void After(){
		driver.quit();
	}
}