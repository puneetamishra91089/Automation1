package com.naukri.FastForwardRevamp.Code;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naukri.GenericFunctionsPack.GenericFunctions;

public class ResumeQualityScorePage {
	public WebDriver driver;
	GenericFunctions generic;
	public ResumeQualityScorePage(WebDriver driver,GenericFunctions generic)
	{
		this.driver=driver;
		this.generic = generic;
	}
	//Breadcrumb
	public static final String Naukri_Lnk = "//div[@class='wrap breadCrmb']/a";
	public static final String Breadcrum_WE = "//div[@class='wrap breadCrmb']";

	//Resume Quality Score page
	public static final String HeroLine_WE = "//h1[@class='heroLine fadeInLeft']";
	public static final String RQScoreContent_WE = "//h2[@class='bluContntHd fadeInRight']";
	public static final String UploadyourResume_WE = "//h3[@class='contentHd cvupldHd']";
	public static final String FetchResume_Lnk = "//a[@class='blue_btnBig']";
	public static final String UploadResume_Btn = "//a[@id='openUploadLbx']";
	public static final String Upload_Btn = "//input[@id='infile']";
	public static final String HowItWorksHeading_WE = "//h4[@class='contentHd']";
	public static final String Step1Content_WE = "(//ul[@class='grid-3col']/li)[1]";
	public static final String Step2Content_WE = "(//ul[@class='grid-3col']/li)[2]";
	public static final String Step3Content_WE = "(//ul[@class='grid-3col']/li)[3]";

	//Report page 
	public static final String RQScore_Lnk = "(//div[@class='wrap breadCrmb']/a)[2]";
	public static final String Score_WE = "//div[@class='fl rprtHeroLine']/span";
	public static final String ScoreContent_WE  = "//div[@class='reprtTitle fadeInUp']";
	public static final String Percentile_WE = "//p[@class='result']";
	public static final String PercentileBox = "";
	public static final String DetailedHeading_WE = "(//p[@class='contentHd mb10'])[1]";
	public static final String Format_WE = "(//p[@class='hd'])[1]";
	public static final String Formatpoint_WE = "(//div[@class='report']/ul/li)[1]";
	public static final String Content_WE = "(//p[@class='hd'])[2]";
	public static final String Contentpoints_WE = "(//div[@class='report spaceTop']/ul/li)[1]";
	public static final String NeedtoImprove_WE = "//p[@class='contentHd']";
	public static final String Mobile_Txt = "//input[@id='cvMobile']";
	public static final String Query_Txt = "//textarea[@id='cvQuery']";
	public static final String SendMsg_Btn = "//button[@id='subReportMesag']";
	public static final String Clickhere_Lnk = "//div[@class='fl knwMore']/p/a";	
	public static final String ThankYouMsg_WE = "//div[@id='contactUsSuces']";
	public static final String ErrorMessages_WE = "//small[@class='erLbl']";
	//Captcha
	public static final String Choosefile_Btn = "//input[@id='infile']";	
	//GotoTop icon section
	public static final String GotoTop_Btn = "//a[@id='goTop']";
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

		System.out.println(Errors);
		return Errors;
	}

	public void Fillform_LeadForm(String Mobile,String Query){
		generic.Fill_Txt(Mobile_Txt, Mobile);
		generic.Fill_Txt(Query_Txt, Query);
		generic.Click_Btn(SendMsg_Btn);
	}
}
