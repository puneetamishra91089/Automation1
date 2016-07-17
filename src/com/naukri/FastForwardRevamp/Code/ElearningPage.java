package com.naukri.FastForwardRevamp.Code;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naukri.GenericFunctionsPack.GenericFunctions;

public class ElearningPage {
	public WebDriver driver;
	GenericFunctions generic;
	public ElearningPage(WebDriver driver ,GenericFunctions generic)
	{
		this.driver=driver;
		this.generic = generic;
	}

	//E-learning Home page
	public static final String Breadcrumb_WE = "//div[@class='wrap breadCrmb']";
	public static final String CourseBreadcrumb_WE = "//div[@class='wrap breadCrmb brdSp']";
	public static final String Naukri_Lnk = "//div[@class='wrap breadCrmb']/a";
	public static final String HeroLine_WE = "//h1[@class='font_37']";
	public static final String HeroSubHeading_WE = "//p[@class='font_22']";
	public static final String PreparatoryHeading_WE = "(//h3[@class='catHead'])[1]";
	public static final String PreparatoryContent_WE = "//div[@class='ecSubCategory oh']/div/p";
	public static final String UpskillingHeading_WE = "(//h3[@class='catHead'])[2]";
	public static final String UpskillingContent_WE = "//div[@class='ecSubCategory clr']/div/p";
	public static final String SearchField_Txt = "//input[@id='srch_fld2']";
	public static final String Search_Btn = "//button[@id='srch_btn2']";
	public static final String ExploreHeading_WE = "//h2[@id='forTop']";
	public static final String ITSkills_Lnk = "//a[@id='tab1']";
	public static final String Operations_Lnk = "//a[@id='tab2']";
	public static final String Design_Lnk = "//a[@id='tab3']";
	public static final String Finance_Lnk = "//a[@id='tab4']";
	public static final String ViewAll_Lnk = "//a[@id='tab5']";
	public static final String TopCourse_Lnk = "(//span[@class='typeHd'])[1]";
	public static final String CourseType_WE = "//span[@class='sideTxt']";
	public static final String All_Lnk = "//a[@id='all']";
	public static final String Preparatory_Lnk = "//a[@id='prep']";
	public static final String Upskilling_Lnk = "//a[@id='upskill']";
	public static final String ServiceName1_Lnk = "(//span[@class='typeHd'])[1]";
	public static final String CourseCount1_Lnk = "(//span[@class='lGryTxt'])[1]";
	public static final String ViewAll1_Lnk = "(//a[@class='pipe'])[1]";
	public static final String ServiceName2_Lnk = "(//span[@class='typeHd'])[2]";
	public static final String CourseCount2_Lnk = "(//span[@class='lGryTxt'])[2]";
	public static final String ViewAll2_Lnk = "(//a[@class='pipe'])[2]";
	public static final String ServiceName3_Lnk = "(//span[@class='typeHd'])[3]";
	public static final String CourseCount3_Lnk = "(//span[@class='lGryTxt'])[3]";
	public static final String ViewAll3_Lnk = "(//a[@class='pipe'])[3]";
	public static final String ServiceName4_Lnk = "(//span[@class='typeHd'])[4]";
	public static final String CourseCount4_Lnk = "(//span[@class='lGryTxt'])[4]";
	public static final String ViewAll4_Lnk = "(//a[@class='pipe'])[4]";
	public static final String Service1course1_Lnk = "(//a[@class='modAchr'])[1]";
	public static final String Service1course2_Lnk = "(//a[@class='modAchr'])[2]";
	public static final String Service1course3_Lnk = "(//a[@class='modAchr'])[3]";
	public static final String Service2course1_Lnk = "(//a[@class='modAchr'])[4]";
	public static final String Service2course2_Lnk = "(//a[@class='modAchr'])[5]";
	public static final String Service2course3_Lnk = "(//a[@class='modAchr'])[6]";
	public static final String Service3course1_Lnk = "(//a[@class='modAchr'])[7]";
	public static final String Service3course2_Lnk = "(//a[@class='modAchr'])[8]";
	public static final String Service3course3_Lnk = "(//a[@class='modAchr'])[9]";
	public static final String Service4course1_Lnk = "(//a[@class='modAchr'])[10]";
	public static final String Service4course2_Lnk = "(//a[@class='modAchr'])[11]";
	public static final String Service4course3_Lnk = "(//a[@class='modAchr'])[12]";
	public static final String FreeApti_Lnk = "//a[@title='Free Online Aptitude Test']";

	//Top Search 
	public static final String BrowseCatagory_Lnk = "html/body/div[5]/div/div/a/em";
	public static final String SearchBox_Txt = "//input[@id='srch_fld1']";
	public static final String Search2_Btn = ".//*[@id='srch_btn2']";
	public static final String CourseSearch_WE = "//p[@class='contentHd clr']";
	public static final String CourseError_WE = ".//*[@id='forTop']/div/div/p";
	public static final String SearchBox2_Txt =".//*[@id='srch_fld1']";
	public static final String Search1_Btn =".//*[@id='srch_btn1']";
	public static final String BrowseIT = "(//div[@class='fl browse']/ul/li/a)[1]";
	public static final String BrowseOperation = "(//div[@class='fl browse']/ul/li/a)[2]";
	public static final String BrowseDesign = "(//div[@class='fl browse']/ul/li/a)[3]";
	public static final String BrowseFinance = "(//div[@class='fl browse']/ul/li/a)[4]";
	public static final String BrowseAll = "(//div[@class='fl browse']/ul/li/a)[5]";

	//IT Course page
	public static final String Ecourses_Lnk = "(//div[@class='wrap breadCrmb brdSp']/a)";	
	public static final String CoursesHeading_WE = "//h1[@class='contentHd clr']";
	public static final String ITViewAll_Lnk = "(//a[@title='Online IT Skills Courses'])[2]";
	public static final String OfficeTools_Lnk = "//a[@title='Online Office Tools Courses']";
	public static final String Programming_Lnk = "//a[@title='Online Programming Courses']";
	public static final String ERP_Lnk = "//a[@title='Online ERP Courses']";
	public static final String Database_Lnk = "//a[@title='Online Database Courses']";
	public static final String Analytics_Lnk = "//a[@title='Online Analytics Courses']";
	public static final String Networking_Lnk = "//a[@title='Online Networking Courses']";
	public static final String SuperAdvanceLevel_Lnk = "(//ul[@class='wrap']/li)[3]";
	public static final String CoursesType_WE = "//span[@class='sideTxt']";
	//	public static final String All_Lnk = "(//ul[@class='typeTab']/li/a)[1]";
	public static final String Prep_Lnk = "(//ul[@class='typeTab']/li/a)[2]";
	public static final String UpSkilling_Lnk = "(//ul[@class='typeTab']/li/a)[3]";
	public static final String Course1_Lnk = "(//a[@class='modAchr'])[1]";
	public static final String Course2_Lnk = "(//a[@class='modAchr'])[2]";
	public static final String Course3_Lnk = "(//a[@class='modAchr'])[3]";
	public static final String Course4_Lnk = "(//a[@class='modAchr'])[4]";
	public static final String Course5_Lnk = "(//a[@class='modAchr'])[5]";
	public static final String Course6_Lnk = "(//a[@class='modAchr'])[6]";
	public static final String Course7_Lnk = "(//a[@class='modAchr'])[7]";
	public static final String Course8_Lnk = "(//a[@class='modAchr'])[8]";

	//Operations courses
	public static final String OP_ViewAll = "//a[@title='Online Operations Skills Courses']";
	public static final String OP_ProjectMgmt = "//a[@title='Online Project Management Courses']";	
	public static final String OP_Logistics = "//a[@title='Online Logistics Courses']";	

	//Design Courses
	public static final String Design_ViewAll = "//a[@title='Online Design Skills Courses']";
	public static final String Design_DesignTools = "//a[@title='Online Design Tools Courses']";
	public static final String Design_WebDesign = "//a[@title='Online Web Design Courses']";
	public static final String Design_MobileDesign = "//a[@title='Online Mobile Design Courses']";

	//Finance courses
	public static final String Finance_ViewAll = "//a[@title='Online Finance Skills Courses']";
	public static final String Finance_Accounting = "//a[@title='Online Accounting Courses']";
	public static final String Finance_CorporateFinance = "//a[@title='Online Corporate Finance Courses']";



	public static final String Courses = "//div[@class='oh mt44']/ul/li/a";
	public static final String CourseName = "//h1[@class='bluContntHd']";
	public static final String CoursePrice = "//p[@class='cPrice']";
	public static final String CoursePrice1 = "//p[@class='priceTxt']";

	public static final String CourseImageUrl_WE="//div[@class='vidSnap']/img";
	public static final String VideoXpath_WE="//div[@class='jwdownloadlogo']";

	public static final String ElearniongCourse_Lnk = "(//a[@class='modAchr'])[40]";

	public static final String TakeThiscores_Btn = "//a[@class='red_btnBig']";

	//Vskills
	public static final String CourseProvider_WE ="//ul[@class='module']/li";
	public static final String DownloadCourseDetail_Lnk = "//span[@class='font_medium fl']";
	public static final String FAQHeading_WE = "//h4[@class='contentHd']";
	public static final String Ques1_WE = "(//p[@class='ques'])[1]";
	public static final String Ans1_WE = "(//p[@class='ans'])[1]";
	public static final String Ques2_WE = "(//p[@class='ques'])[2]";
	public static final String Ans2_WE = "(//p[@class='ans'])[2]";
	public static final String Ques3_WE = "(//p[@class='ques'])[3]";
	public static final String Ans3_WE = "(//p[@class='ans'])[3]";
	public static final String Ques4_WE = "(//p[@class='ques'])[4]";
	public static final String Ans4_WE = "(//p[@class='ans'])[4]";
	public static final String Ques5_WE = "(//p[@class='ques'])[5]";
	public static final String Ans5_WE = "(//p[@class='ans'])[5]";
	public static final String Ques6_WE = "(//p[@class='ques'])[6]";
	public static final String Ans6_WE = "(//p[@class='ans'])[6]";
	public static final String Ques7_WE = "(//p[@class='ques'])[7]";
	public static final String Ans7_WE = "(//p[@class='ans'])[7]";
	public static final String Ques8_WE = "(//p[@class='ques'])[8]";
	public static final String Ans8_WE = "(//p[@class='ans'])[8]";
	public static final String Ques9_WE = "(//p[@class='ques'])[9]";
	public static final String Ans9_WE = "(//p[@class='ans'])[9]";
	public static final String Ques10_WE = "(//p[@class='ques'])[10]";
	public static final String Ans10_WE = "(//p[@class='ans'])[10]";
	public static final String Ques11_WE = "(//p[@class='ques'])[11]";
	public static final String Ans11_WE = "(//p[@class='ans'])[11]";
	public static final String Examdate_Lnk = "(//a[@rel='nofollow'])[1]";
	public static final String ExamCenter_Lnk = "(//a[@rel='nofollow'])[2]";
	public static final String Online_Lnk = "(//a[@rel='nofollow'])[3]";
	public static final String practiceTest_Lnk = "(//a[@rel='nofollow'])[4]";
	public static final String FAQ_lnk = "(//a[@rel='nofollow'])[5]";
	public static final String OldPrice_WE = "//span[@class='txtStrike']";
	public static final String NewPrice_WE = "//p[@class='priceTxt']";
	public static final String Discount_WE = "//span[@class='offTxt']";

	//Contact Us widget
	public static final String TollFreeNo_WE = "//li[@class='nopointr']";
	public static final String CallMeBack_Lnk = "//div[@class='widgtLi_2']/a";
	public static final String ChatWithUs_Lnk = "(//a[@class='widgtLi_3'])[1]";
	public static final String FindNearestBranch_Lnk = "(//a[@class='widgtLi_3'])[2]";
	public static final String Name_Txt = "//input[@id='name']";
	public static final String Email_Txt = "//input[@id='emailId']";
	public static final String Mobile_Txt = "//input[@id='mobile']";
	public static final String Query_Txt = "//input[@id='query']";
	public static final String Course_Txt = "//input[@id='course']";
	public static final String CallmeBack_Btn = "//input[@id='submitQuery']";
	public static final String ErrorMessages_WE = "//form[@id='contactUsWidget']//small[contains(@id,'_err')]";
	public static final String ThankyouMessages_WE = "(//div[@id='thankMsg'])[1]";
	public static final String EnquireNow_Btn="//a[@id='forpgMenu']";
	public static final String CallmeBack_BtnCourseDetail = "//button[@id='submitQuery']";
	public static final String ThankyouMessages_CourseDetail=".//*[@id='thankMsg']/p";
	public static final String Inclusiveoftaxes_WE = "//p[@class='textBlack font_small pb10 bold']";
	public static final String CourseDetailQuery_WE="//textarea[@id='query']";

	public String GetAttribute_Class(String xpath)
	{
		String Active = driver.findElement(By.xpath(xpath)).getAttribute("class");
		return Active;
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

		System.out.println(Errors);
		return Errors;
	}
	public void Fillform_LeadForm(String Name,String Email,String Mobile,String Query,String Course){
		generic.Fill_Txt(Name_Txt, Name);
		generic.Fill_Txt(Email_Txt, Email);
		generic.Fill_Txt(Mobile_Txt, Mobile);
		generic.Fill_Txt(Query_Txt, Query);
		generic.Fill_Txt(Course_Txt, Course);
		generic.Click_Btn(CallmeBack_Btn);
	}
	
	public List<WebElement> GetAllCourses()
	{
		List<WebElement> option = null;
		if (driver.findElements(By.xpath(Courses)).size()>0) 
		{
			//			driver.findElement(By.xpath(Experience_DD)).click();
			option = driver.findElements(By.xpath(Courses));
			return option;
		}
		else
		{
			return option;	
		}
	}
}

