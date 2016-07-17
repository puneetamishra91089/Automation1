package com.naukri.FastForwardRevamp.Code;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.naukri.GenericFunctionsPack.GenericFunctions;
import com.naukri.datatable.Xls_Reader;

public class LoginLayer {
	WebDriver driver;
	GenericFunctions generic;

	public static final String Email_Txt = "//input[@id='eLogin']";
	public static final String UserName_Txt = "//input[@id='uLogin']";
	public static final String Password_Txt = "//input[@id='pLogin']";
	public static final String EmailID_Rd = "//a[@id='eSel']";
	public static final String UserName_Rd = "//a[@id='uSel']";
	public static final String ForgotPassword_Lnk = "//a[text()='Forgot Password?']";
	public static final String Login_Btn = "//button[@value='Login']";
	public static final String RegisterNow_Lnk = "//a[text()='Register Now']";
	public static final String GNB_Login_Lnk = "//a[@id='login_Layer']";

	public static final String ErrorMsg_WE = "//i[contains(@id,'_err')]";
	

	public LoginLayer(WebDriver driver,GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}



	public int sleepTime=1000;


	public  void Fill_Email_Txt(String inputdata){

		if(inputdata.trim().length()==0)return;
		try{
			driver.findElement(By.xpath(Email_Txt)).clear();
			driver.findElement(By.xpath(Email_Txt)).sendKeys(inputdata);
		}catch(Exception e){
			generic.GoToSleep(sleepTime);
			driver.findElement(By.xpath(Email_Txt)).clear();
			driver.findElement(By.xpath(Email_Txt)).sendKeys(inputdata);
		}
	}

	public  void Clear_Email_Txt(){
		try{
			driver.findElement(By.xpath(Email_Txt)).clear();
		}catch(Exception e){
			generic.GoToSleep(sleepTime);
			driver.findElement(By.xpath(Email_Txt)).clear();
		}
	}

	public  void Click_Email_Txt(){
		try{
			driver.findElement(By.xpath(Email_Txt)).click();
		}catch(Exception e){
			generic.GoToSleep(sleepTime);
			driver.findElement(By.xpath(Email_Txt)).click();
		}

	}

	public String GetText_Email_Txt(){
		try{
			return driver.findElement(By.xpath(Email_Txt)).getAttribute("value");
		}catch(Exception e){
			generic.GoToSleep(sleepTime);
			return driver.findElement(By.xpath(Email_Txt)).getAttribute("value");
		}
	}

	public  void Fill_UserName_Txt(String inputdata){

		if(inputdata.trim().length()==0)return;
		try{
			driver.findElement(By.xpath(UserName_Txt)).clear();
			driver.findElement(By.xpath(UserName_Txt)).sendKeys(inputdata);
		}catch(Exception e){
			generic.GoToSleep(sleepTime);
			driver.findElement(By.xpath(UserName_Txt)).clear();
			driver.findElement(By.xpath(UserName_Txt)).sendKeys(inputdata);
		}
	}

	public  void Clear_UserName_Txt(){
		try{
			driver.findElement(By.xpath(UserName_Txt)).clear();
		}catch(Exception e){
			generic.GoToSleep(sleepTime);
			driver.findElement(By.xpath(UserName_Txt)).clear();
		}
	}

	public  void Click_UserName_Txt(){
		try{
			driver.findElement(By.xpath(UserName_Txt)).click();
		}catch(Exception e){
			generic.GoToSleep(sleepTime);
			driver.findElement(By.xpath(UserName_Txt)).click();
		}

	}

	public String GetText_UserName_Txt(){
		try{
			return driver.findElement(By.xpath(UserName_Txt)).getAttribute("value");
		}catch(Exception e){
			generic.GoToSleep(sleepTime);
			return driver.findElement(By.xpath(UserName_Txt)).getAttribute("value");
		}
	}

	public  void Fill_Password_Txt(String inputdata){

		if(inputdata.trim().length()==0)return;
		try{
			driver.findElement(By.xpath(Password_Txt)).clear();
			driver.findElement(By.xpath(Password_Txt)).sendKeys(inputdata);
		}catch(Exception e){
			generic.GoToSleep(sleepTime);
			driver.findElement(By.xpath(Password_Txt)).clear();
			driver.findElement(By.xpath(Password_Txt)).sendKeys(inputdata);
		}
	}

	public  void Clear_Password_Txt(){
		try{
			driver.findElement(By.xpath(Password_Txt)).clear();
		}catch(Exception e){
			generic.GoToSleep(sleepTime);
			driver.findElement(By.xpath(Password_Txt)).clear();
		}
	}

	public  void Click_Password_Txt(){
		try{
			driver.findElement(By.xpath(Password_Txt)).click();
		}catch(Exception e){
			generic.GoToSleep(sleepTime);
			driver.findElement(By.xpath(Password_Txt)).click();
		}

	}

	public String GetText_Password_Txt(){
		try{
			return driver.findElement(By.xpath(Password_Txt)).getAttribute("value");
		}catch(Exception e){
			generic.GoToSleep(sleepTime);
			return driver.findElement(By.xpath(Password_Txt)).getAttribute("value");
		}
	}

	public void Select_EmailID_Rd(){
		try{
			driver.findElement(By.xpath(EmailID_Rd)).click();
		}catch(Exception e){
			generic.GoToSleep(sleepTime);
			driver.findElement(By.xpath(EmailID_Rd)).click();

		}
	}

	public boolean IsChecked_EmailID_Rd(){
		try{
			return driver.findElement(By.xpath(EmailID_Rd)).isSelected();
		}catch(Exception e){
			generic.GoToSleep(sleepTime);
			return driver.findElement(By.xpath(EmailID_Rd)).isSelected();

		}
	}

	public void Select_UserName_Rd(){
		try{
			driver.findElement(By.xpath(UserName_Rd)).click();
		}catch(Exception e){
			generic.GoToSleep(sleepTime);
			driver.findElement(By.xpath(UserName_Rd)).click();

		}
	}

	public boolean IsChecked_UserName_Rd(){
		try{
			return driver.findElement(By.xpath(UserName_Rd)).isSelected();
		}catch(Exception e){
			generic.GoToSleep(sleepTime);
			return driver.findElement(By.xpath(UserName_Rd)).isSelected();

		}
	}

	public void Click_ForgotPassword_Lnk(){
		try{
			driver.findElement(By.xpath(ForgotPassword_Lnk)).click();
		}catch(Exception e){
			generic.GoToSleep(sleepTime);
			driver.findElement(By.xpath(ForgotPassword_Lnk)).click();

		}
	}

	public String GetLinkText_ForgotPassword_Lnk(){
		try{
			return driver.findElement(By.xpath(ForgotPassword_Lnk)).getText();
		}catch(Exception e){
			generic.GoToSleep(sleepTime);
			return driver.findElement(By.xpath(ForgotPassword_Lnk)).getText();

		}
	}

	public void Click_Login_Btn(){
		try{
			driver.findElement(By.xpath(Login_Btn)).click();
		}catch(Exception e){
			generic.GoToSleep(sleepTime);
			driver.findElement(By.xpath(Login_Btn)).click();

		}
	}

	public void Click_RegisterNow_Lnk(){
		try{
			driver.findElement(By.xpath(RegisterNow_Lnk)).click();
		}catch(Exception e){
			generic.GoToSleep(sleepTime);
			driver.findElement(By.xpath(RegisterNow_Lnk)).click();

		}
	}

	public String GetLinkText_RegisterNow_Lnk(){
		try{
			return driver.findElement(By.xpath(RegisterNow_Lnk)).getText();
		}catch(Exception e){
			generic.GoToSleep(sleepTime);
			return driver.findElement(By.xpath(RegisterNow_Lnk)).getText();

		}
	}

	public void Click_ErrorMsg_WE(){
		try{
			driver.findElement(By.xpath(ErrorMsg_WE)).click();
		}catch(Exception e){
			generic.GoToSleep(sleepTime);
			driver.findElement(By.xpath(ErrorMsg_WE)).click();

		}
	}

	public String GetElementText_ErrorMsg_WE(){
		try{
			return driver.findElement(By.xpath(ErrorMsg_WE)).getText();
		}catch(Exception e){
			generic.GoToSleep(sleepTime);
			return driver.findElement(By.xpath(ErrorMsg_WE)).getText();

		}
	}


	public String Capture_Errors(){
		String total_errors=" ";
		if(driver.findElements(By.xpath(ErrorMsg_WE)).size()> 0 ){
			List<WebElement> errors= driver.findElements(By.xpath(ErrorMsg_WE));
			for(int i=0; i<errors.size(); i++){
				if(errors.get(i).isDisplayed()){
					total_errors= total_errors+", "+errors.get(i).getText();
				}
			}
		}
		return total_errors;
	}



	public void Fillform_Login(Xls_Reader datatable, String sheetname, int i){

		String EmailID_td=datatable.getCellData(sheetname, "EmailID", i);
		if(EmailID_td.equalsIgnoreCase("yes")){Select_EmailID_Rd();}

		String UserName_td=datatable.getCellData(sheetname, "UserName", i);
		if(UserName_td.equalsIgnoreCase("yes")){Select_UserName_Rd();}

		Fill_Email_Txt(datatable.getCellData(sheetname, "Email", i));

		Fill_UserName_Txt(datatable.getCellData(sheetname, "UserName", i));

		Fill_Password_Txt(datatable.getCellData(sheetname, "Password", i));

		Click_Login_Btn();
	}


	public void Fillform_Login(String SelectEmailorUserName , String Username, String Password ){

		if(SelectEmailorUserName.equalsIgnoreCase("Email"))
		{	
			Select_EmailID_Rd();
			Fill_Email_Txt(Username);
		}
		else{
			Select_UserName_Rd();
			Fill_UserName_Txt(Username);
		}

		Fill_Password_Txt(Password);

		Click_Login_Btn();

		generic.GoToSleep(5000);
		
		Assert.assertTrue(!generic.isVisible(Email_Txt),"Login Failed!!!");

	}








}
