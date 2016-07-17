package com.naukri.FastForwardRevamp.Code;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naukri.FastForwardRevamp.ConfigDetails.ConfigDetails;
import com.naukri.GenericFunctionsPack.GenericFunctions;

public class HomePageTopLeadForm extends ConfigDetails {
	WebDriver driver;
	GenericFunctions generic;
	 
	//TopLead form (TL)
		public static final String TL_FormContent_WE = "//div[@class='fl leadFrmLabl']";
		public static final String TL_Name_Txt = "//input[@id='Hname']";
		public static final String TL_Email_Txt = "//input[@id='HemailId']";
		public static final String TL_Mobile_Txt = "//input[@id='Hmobile']";
		public static final String TL_CallmeBack_Btn = "//button[@id='submit1']";
		public static final String TL_Query_Txt = "//textarea [@id='qTxtA']";
		public static final String TL_NameError_WE = "//small[@id='Hname_err']";
		public static final String TL_EmailError_WE = "//small[@id='HemailId_err']";
		public static final String TL_MobileError_WE = "//small[@id='Hmobile_err']";
		public static final String TL_QueryError_WE = "//small[@id='qTxtA_err']";
		public static final String Submit_Btn = "//input[@id='submit2']";
		public static final String Close_Btn = "//a[@class='closeLead closeQuery']";
		public static final String CloseIcon_WE = "//p[@class='crossHome closeQuery']/em";
		public static final String MandatoryContent_WE = "";
		public static final String TL_ThankYou_Msg_WE = "(//div[@id='thankMsg'])[2]";
		
		public static final String ErrorMessages_WE = "//form[@id='homeLead']//small[@class='erLbl']";
		
		public HomePageTopLeadForm(WebDriver driver,GenericFunctions generic){
			this.driver = driver;
			this.generic = generic;
		}


		
		public String CaptureErrors(){
			List<WebElement> WE = driver.findElements(By.xpath(ErrorMessages_WE));
			List<String> ErrorMessages = new ArrayList<String>();
			for (WebElement webElement : WE) {
				if(webElement.isDisplayed()){
					ErrorMessages.add(webElement.getText());
				}
			}

			String Errors = ErrorMessages.toString();
			Errors = Errors.replace("[", "");
			Errors = Errors.replace("]", "");

			return Errors;
		}

}
