package com.naukri.FastForwardRevamp.Code;

import org.openqa.selenium.WebDriver;

import com.naukri.GenericFunctionsPack.GenericFunctions;

public class HomePage {
	WebDriver driver;
	GenericFunctions generic;

	public HomePage(WebDriver driver, GenericFunctions generic)
	{
		this.driver = driver;
		this.generic = generic;
		
	}
	//Home page (HP)
	public static final String HP_Image_WE = "//div[@class='bannerHom']";
	public static final String HP_ResumeHeading_WE = "//h2[@id='forTop']";
	public static final String HP_TextResumeImage_Lnk = "//img[@alt='Text Resume Format']";
	public static final String HP_VisualResumeImage_Lnk = "//img[@alt='Visual Resume Format']";
	public static final String HP_TextResumeHeading_Lnk = "(//a[@class='contentHd'])[1]";
	public static final String HP_VisualResumeHeading_Lnk = "(//a[@class='contentHd'])[2]";
	public static final String HP_TextResumeContent_WE = "(//p[@class='servcSubHd'])[1]";
	public static final String HP_VisualResumeContent_WE = "(//p[@class='servcSubHd'])[2]";
	public static final String HP_TextResumeSubContent_WE = "(//p[@class='contnt'])[1]";
	public static final String HP_VisualResumeSubContent_WE = "(//p[@class='contnt'])[2]";
	public static final String HP_GetTextResume_Lnk = "(//a[@class='white_btn'])[1]";
	public static final String HP_GetVisualResume_Lnk = "(//a[@class='white_btn'])[2]";
	public static final String Hp_ResumeQualityScoreHeading_WE = "(//div[@class='homeCol3']/div/p)[1]";
	public static final String HP_ResumeQualityScoreContent_WE = "(//div[@class='homeCol3']/div/p)[2]";
	public static final String HP_ResumeQualityGetReport_Lnk = "(//div[@class='homeCol3']/div/a)[1]";
	public static final String HP_ResumeSampleHeading_WE = "(//div[@class='grid pdLR']/p)[1]";
	public static final String HP_ResumeSampleContent_WE = "(//p[@class='content'])[2]";
	public static final String HP_TextResumeSample_Lnk = "(//div[@class='homeCol3']/div/a)[2]";
	public static final String HP_VisualResumeSample_Lnk = "(//div[@class='homeCol3']/div/a)[3]";
	public static final String HP_Coverletter_Heading = "(//div[@class='grid']/p)[3]";
	public static final String HP_Coverletter_Content = "(//div[@class='grid']/p)[4]";
	public static final String HP_Coverletter_Lnk = "(//div[@class='homeCol3']/div/a)[4]";
	public static final String HP_ProfileHeading_WE = "//h4[@class='bigHd']";
	public static final String HP_ECourseImage_Lnk = "//img[@alt='Online Courses & Certifications']";
	public static final String HP_EcoursesHeading_Lnk = "(//a[@class='contentHd'])[5]";
	public static final String HP_EcoursesContent_WE = "(//p[@class='servcSubHd'])[5]";
	public static final String HP_EcoursesSubContent_WE = "(//p[@class='contnt'])[5]";
	public static final String HP_BrowseCourses_Lnk = "(//a[@class='white_btn'])[5]";
	public static final String HP_RecruitersHeading_WE = "//h3[@id='forFixdForm']";
	public static final String HP_RecruiterConnectionImage_Lnk = "//img[@alt='Search Recruiters']";
	public static final String HP_ResumeDisplayImage_Lnk = "//img[@alt='Resume Display']";
	public static final String HP_RecruiterConnectionHeading_Lnk = "(//a[@class='contentHd'])[3]";
	public static final String HP_ResumeDisplayHeading_Lnk = "(//a[@class='contentHd'])[4]";
	public static final String HP_RecruiterConnectionContent_WE = "(//p[@class='servcSubHd'])[3]";
	public static final String HP_ResumeDisplayContent_WE = "(//p[@class='servcSubHd'])[4]";
	public static final String HP_RecruiterConnectionSubContent_WE = "(//p[@class='contnt'])[3]";
	public static final String HP_ResumeDisplaySubContent_WE = "(//p[@class='contnt'])[4]";
	public static final String HP_FindRecriuters_Lnk = "(//a[@class='white_btn'])[3]";
	public static final String HP_GetHighlighted_Lnk = "(//a[@class='white_btn'])[4]";
	public static final String HP_JobsHeading_WE = "//h5[@class='bigHd']";   
	public static final String HP_JobsOnMailandSmsImage_Lnk = "//img[@alt='Job Alerts']";
	public static final String HP_JobsOnMailandSmsHeading_Lnk = "(//a[@class='contentHd'])[6]";
	public static final String HP_JobsOnMailandSmsContent_WE ="(//p[@class='servcSubHd'])[6]";
	public static final String HP_JobsOnMailandSmsSubContent_WE = "(//p[@class='contnt'])[6]";
	public static final String HP_GetJobsonMailsandSMS_Lnk = "(//a[@class='white_btn'])[6]";

	//Career Advice
	public static final String CareerAdviceHeading_WE = "//h6[@class='midHd']";
	public static final String MostViewedArticles_WE = "(//a[@class='smallHd dspIB'])[1]";
	public static final String Cat1Article1_Lnk = "(//ul[@class='viewList']/li/a)[1]";
	public static final String Cat1Article2_Lnk = "(//ul[@class='viewList']/li/a)[2]";
	public static final String Cat1Article3_Lnk = "(//ul[@class='viewList']/li/a)[3]";
	public static final String Cat2Article1_Lnk = "(//ul[@class='mb10 viewList']/li/a)[1]";
	public static final String Cat2Article2_Lnk = "(//ul[@class='mb10 viewList']/li/a)[2]";
	public static final String Cat3Article1_Lnk = "(//ul[@class='mb10 viewList']/li/a)[3]";
	public static final String Cat3Article2_Lnk = "(//ul[@class='mb10 viewList']/li/a)[4]";
	public static final String Cat4Article1_Lnk = "(//ul[@class='viewList']/li/a)[4]";
	public static final String Cat4Article2_Lnk = "(//ul[@class='viewList']/li/a)[5]";
	public static final String Cat5Article1_Lnk = "(//ul[@class='viewList']/li/a)[6]";		
	public static final String Viewmore_lnk = "//a[@class='rightLink']";
//	public static final String CareerAdviceBreadCrumb_WE = "(//div[@class='wrapper'])[3]";
	
	
	public static final String ArticleTitle_WE = "//h1[@class='entry-title']";
	public static final String ArticlesBreadcrumb_WE = "//div[@class='wrapper pT10']";
	//Testimonials
	public static final String TestimonialContent_WE = "//div[@class='testimnlTxt']/p";
	public static final String TestimonialNavigationPrevious_Btn = "//div[@class='bx-controls-direction']/a[1]";
	public static final String TestimonialNavigationNext_Btn = "//div[@class='bx-controls-direction']/a[2]";


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
	public static final String CallMeBack_Btn = "//input[@id='submit2']";
	public static final String Close_Btn = "//a[@class='closeLead closeQuery']";
	public static final String CloseIcon_WE = "//p[@class='crossHome closeQuery']/em";
	public static final String MandatoryContent_WE = "";
	public static final String TL_ThankYou_Msg_WE = "(//div[@id='thankMsg'])[1]";
	
	

	//GotoTop icon section
	public static final String GotoTop_Btn = "//a[@id='goTop']";		
	public static final String Disclaimer_WE = "//div[@class='bgGray gryLesPd']/div";
	public static final String Security_Guidelines_Lnk = "(//div[@class='bgGray gryLesPd']/div/a)[1]";
	public static final String TermsandConditions_Lnk = "(//div[@class='bgGray gryLesPd']/div/a)[2]";
	public static final String TermsandCondition_WE = "//div[@class='hd3']";
}



