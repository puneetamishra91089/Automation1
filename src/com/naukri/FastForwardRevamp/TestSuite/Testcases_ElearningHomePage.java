package com.naukri.FastForwardRevamp.TestSuite;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naukri.FastForwardRevamp.Code.ContactUsLeadFormWidget;
import com.naukri.FastForwardRevamp.Code.ElearningPage;
import com.naukri.FastForwardRevamp.Code.HomePage;
import com.naukri.FastForwardRevamp.Code.LoginLayer;
import com.naukri.FastForwardRevamp.ConfigDetails.ConfigDetails;
import com.naukri.FastForwardRevamp.ConfigDetails.URLProvider;
import com.naukri.GenericFunctionsPack.GenericFunctions;
import com.naukri.datatable.Xls_Reader;

public class Testcases_ElearningHomePage extends ConfigDetails {
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
	//To verify that on clicking naukri link in e-Learning Bread crumb it lands on Home page
	public void TC_Elearning_001()
	{			
		driver.get(URLProvider.Return_EcoursesURL());
		generic.Click_Lnk(ElearningPage.Naukri_Lnk);
		String result = generic.GetElementText(HomePage.HP_Image_WE);
		result = result.replace("\n", " ");
		Assert.assertEquals(result, "Speed Up Your Career with our personalized services");
		//
	}

	@Test
	//To verify that IT course tab visibility ,functionality on being clicked
	public void TC_Elearning_002()
	{		
		driver.get(URLProvider.Return_EcoursesURL());
		String result = generic.GetElementText_WE(ElearningPage.ITSkills_Lnk);
		Assert.assertTrue(result.equals("IT"),result);
		generic.Click(ElearningPage.ITSkills_Lnk);
		String result2 = generic.GetElementText(ElearningPage.TopCourse_Lnk);
		Assert.assertEquals(result2, "IT");
		generic.Click(ElearningPage.TopCourse_Lnk);
		result = generic.GetElementText(ElearningPage.CoursesHeading_WE);
		Assert.assertEquals(result,"IT Courses, Certification & Training");

	}
	@Test
	//To verify that Operations course tab visibility ,functionality on being clicked
	public void TC_Elearning_003()
	{		
		driver.get(URLProvider.Return_EcoursesURL());
		String result = generic.GetElementText_WE(ElearningPage.Operations_Lnk);
		Assert.assertTrue(result.equals("Operations"),result);
		generic.Click(ElearningPage.Operations_Lnk);
		String result2 = generic.GetElementText(ElearningPage.TopCourse_Lnk);
		Assert.assertEquals(result2, "Operations");
		generic.Click(ElearningPage.TopCourse_Lnk);
		result = generic.GetElementText(ElearningPage.CoursesHeading_WE);
		Assert.assertEquals(result,"Operations Courses, Certification & Training");

	}
	@Test
	//To verify that Design course tab visibility ,functionality on being clicked
	public void TC_Elearning_004()
	{		
		driver.get(URLProvider.Return_EcoursesURL());
		String result = generic.GetElementText_WE(ElearningPage.Design_Lnk);
		Assert.assertTrue(result.equals("Design"),result);
		generic.Click(ElearningPage.Design_Lnk);
		String result2 = generic.GetElementText(ElearningPage.TopCourse_Lnk);
		Assert.assertEquals(result2, "Design");
		generic.Click(ElearningPage.TopCourse_Lnk);
		result = generic.GetElementText(ElearningPage.CoursesHeading_WE);
		Assert.assertEquals(result,"Design Courses, Certification & Training");
	}
	@Test
	//To verify that Finance course tab visibility ,functionality on being clicked
	public void TC_Elearning_005()
	{		
		driver.get(URLProvider.Return_EcoursesURL());
		String result = generic.GetElementText_WE(ElearningPage.Finance_Lnk);
		Assert.assertTrue(result.equals("Finance"),result);
		generic.Click(ElearningPage.Finance_Lnk);
		String result2 = generic.GetElementText(ElearningPage.TopCourse_Lnk);
		Assert.assertEquals(result2, "Finance");
		generic.Click(ElearningPage.TopCourse_Lnk);
		result = generic.GetElementText(ElearningPage.CoursesHeading_WE);
		Assert.assertEquals(result,"Finance Courses, Certification & Training");
	}
	@Test
	//To verify that View All tab visibility
	public void TC_Elearning_006()
	{		
		driver.get(URLProvider.Return_EcoursesURL());
		String result1 = generic.GetElementText_WE(ElearningPage.ViewAll_Lnk);
		Assert.assertTrue(result1.equals("View All"),result1);
		generic.Click(ElearningPage.ViewAll_Lnk);
		String result2 = generic.GetElementText(ElearningPage.CourseBreadcrumb_WE);
		Assert.assertEquals(result2, "Learning > Online Courses");
	}


	@Test
	//To verify that on selecting Course Type All it displays all courses
	public void TC_Elearning_007()
	{		
		driver.get(URLProvider.Return_EcoursesURL());
		generic.Click_Lnk(ElearningPage.All_Lnk);
		String result = driver.getCurrentUrl();
		Assert.assertTrue(result.equals("http://learning.naukri.com/?id=tab1#forFixdForm"),result);
	}

	@Test
	//To verify that on selecting Course Type Preparatory it displays preparatory courses
	public void TC_Elearning_008()
	{			
		driver.get(URLProvider.Return_EcoursesURL());
		generic.Click_Lnk(ElearningPage.Preparatory_Lnk);
		String result = driver.getCurrentUrl();
		Assert.assertTrue(result.equals("http://learning.naukri.com/?id=tab1&type=PREP#forFixdForm"),result);
	}

	@Test
	//To verify that on selecting Course Type Up skilling it displays Up skilling courses
	public void TC_Elearning_009()
	{		
		driver.get(URLProvider.Return_EcoursesURL());
		generic.Click_Lnk(ElearningPage.Upskilling_Lnk);
		String result = driver.getCurrentUrl();
		Assert.assertTrue(result.equals("http://learning.naukri.com/?id=tab1&type=UPSKILL#forFixdForm"),result);
	}


	@Test
	//To verify that on clicking IT View All IT courses are displayed
	public void TC_Elearning_010()
	{	
		driver.get(URLProvider.Return_EcoursesURL());
		generic.Click_Lnk(ElearningPage.ViewAll1_Lnk);
		String result = driver.getCurrentUrl();
		Assert.assertEquals(result, URLProvider.Return_Ecourses_ITURL());
		String result1 = generic.GetElementText_WE(ElearningPage.CourseBreadcrumb_WE);
		Assert.assertTrue(result1.equals("Learning > IT Courses"),result1);
		String result2 = generic.GetElementText_WE(ElearningPage.CoursesHeading_WE);
		Assert.assertTrue(result2.equals("IT Courses, Certification & Training"),result2);
	}
	@Test
	//To verify that on clicking Operations View All Operations courses are displayed
	public void TC_Elearning_011()
	{				
		driver.get(URLProvider.Return_EcoursesURL());
		generic.Click_Lnk(ElearningPage.ViewAll2_Lnk);
		String result = driver.getCurrentUrl();
		Assert.assertTrue(result.equals(URLProvider.Return_Ecourses_OperationsURL()),result);
		String result1 = generic.GetElementText_WE(ElearningPage.CourseBreadcrumb_WE);
		Assert.assertTrue(result1.equals("Learning > Operations Courses"),result1);
		String result2 = generic.GetElementText_WE(ElearningPage.CoursesHeading_WE);
		Assert.assertTrue(result2.equals("Operations Courses, Certification & Training"),result2);
	}

	@Test
	//To verify that on clicking Design View All Design courses are displayed
	public void TC_Elearning_012()
	{			
		driver.get(URLProvider.Return_EcoursesURL());
		generic.Click_Lnk(ElearningPage.ViewAll3_Lnk);
		String result1 = generic.GetElementText_WE(ElearningPage.CourseBreadcrumb_WE);
		Assert.assertTrue(result1.equals("Learning > Design Courses"),result1);
		String result2 = generic.GetElementText_WE(ElearningPage.CoursesHeading_WE);
		Assert.assertTrue(result2.equals("Design Courses, Certification & Training"),result2);
	}
	@Test
	//To verify that on clicking Finance View All Finance courses are displayed
	public void TC_Elearning_013()
	{			
		driver.get(URLProvider.Return_EcoursesURL());
		generic.Click_Lnk(ElearningPage.ViewAll4_Lnk);
		String result1 = generic.GetElementText_WE(ElearningPage.CourseBreadcrumb_WE);
		Assert.assertTrue(result1.equals("Learning > Finance Courses"),result1);
		String result2 = generic.GetElementText_WE(ElearningPage.CoursesHeading_WE);
		Assert.assertTrue(result2.equals("Finance Courses, Certification & Training"),result2);
	}

	@Test
	//To verify that on clicking Free Aptitude link it lands to Aptitude page
	public void TC_Elearning_014()
	{
		driver.get(URLProvider.Return_EcoursesURL());
		generic.Click_Lnk(ElearningPage.FreeApti_Lnk);
		String result = driver.getCurrentUrl();
		Assert.assertEquals(result,URLProvider.Return_AptitudePageURL(),result);	
	}
	@DataProvider (name = "LeadFormData")
	public Object[][] DataProvider() {
		String SheetName = "LeadForm";
		datatable = new Xls_Reader(TestDataSheetPath_Elearning);
		int rowcount = datatable.getRowCount(SheetName);
		Object result[][] = new Object[rowcount-1][6];

		for(int i=2 ; i<= rowcount ; i++){
			String Name = datatable.getCellData(SheetName, "Name", i);
			String Email = datatable.getCellData(SheetName, "Email", i);
			String Mobile = datatable.getCellData(SheetName, "Mobile", i);
			String Query = datatable.getCellData(SheetName, "Query", i);
			String Course = datatable.getCellData(SheetName, "Course Interested", i);
			result[i-2][0] = i;
			result[i-2][1] = Name;
			result[i-2][2] = Email;
			result[i-2][3] = Mobile;
			result[i-2][4] = Query;
			result[i-2][5] = Course;
		}

		return result;
	}
	//To Validate Field level Validations in Lead Form Not Logged In State
	@Test (dataProvider = "LeadFormData")
	public void TC_Elearning_015(int RowNo,String Name, String Email, String Mobile, String Query, String Course)
	{
		String SheetName = "LeadForm";
		driver.get(URLProvider.Return_EcoursesURL());
		generic.Click_Btn(ElearningPage.CallMeBack_Lnk);
		generic.GoToSleep(500);
		ElearningPage leadForm = new ElearningPage(driver, generic);
		leadForm.Fillform_LeadForm(Name, Email, Mobile, Query, Course);
		String ErrorMessages = leadForm.CaptureErrors();
		System.out.println(ErrorMessages);
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
	public void TC_Elearning_016()
	{
		driver.get(URLProvider.Return_EcoursesURL());
		LoginLayer loginLayer = new LoginLayer(driver, generic);
		generic.Click_Lnk(LoginLayer.GNB_Login_Lnk);
		loginLayer.Fillform_Login("Email", Email, Password);
		generic.Click_Btn(ContactUsLeadFormWidget.CallMeBack_Lnk); 
		Assert.assertEquals(generic.GetText_Txt(ContactUsLeadFormWidget.Name_Txt), "Puneeta Mishra");
		Assert.assertEquals(generic.GetText_Txt(ContactUsLeadFormWidget.Email_Txt), Email);
		Assert.assertEquals(generic.GetText_Txt(ContactUsLeadFormWidget.Mobile_Txt), "1234567890");
	}

	@Test
	//To verify that on searching course E-learning course page is displayed
	public void TC_Elearning_017()
	{	
		datatable = new Xls_Reader(TestDataSheetPath_Elearning);
		for (int i = 2; i <= datatable.getRowCount("Search"); i++){
			driver.get(URLProvider.Return_EcoursesURL());
			generic.Fill_Txt(ElearningPage.SearchField_Txt,datatable.getCellData("Search", "CourseName", i));		
			generic.Click_Lnk(ElearningPage.Search2_Btn);
			String result = driver.getCurrentUrl();
			generic.GoToSleep(2000);
			Assert.assertTrue(result.equals(URLProvider.Return_Ecourses_SearchURL()),result);
			String result1 = generic.GetElementText_WE(ElearningPage.CourseBreadcrumb_WE);
			Assert.assertTrue(result1.equals("Naukri FastForward > Learning"),result1);
			String result2 = generic.GetElementText_WE(ElearningPage.CourseSearch_WE);		
			Assert.assertTrue(result2.contains(datatable.getCellData("Sheet1", "CourseName", i)),result2);
		}
	}
	@Test
	//To verify that on searching course E-learning sorry message is displayed if course does not exist
	public void TC_Elearning_018()
	{	
		Xls_Reader datatable = new Xls_Reader(TestDataSheetPath_Elearning);
		for (int i = 2; i <= datatable.getRowCount("Sheet1"); i++){
			driver.get(URLProvider.Return_EcoursesURL());
			generic.Fill_Txt(ElearningPage.SearchField_Txt,datatable.getCellData("Search", "Junk", i));		
			generic.Click_Lnk(ElearningPage.Search2_Btn);
			String result = driver.getCurrentUrl();
			System.out.println(result);
			Assert.assertTrue(result.equals(URLProvider.Return_Ecourses_SearchURL()),result);
			String result1 = generic.GetElementText_WE(ElearningPage.CourseBreadcrumb_WE);
			Assert.assertTrue(result1.equals("Naukri FastForward > Learning"),result1);
			String result2 = generic.GetElementText_WE(ElearningPage.CourseError_WE);		
			Assert.assertTrue(result2.contains(datatable.getCellData("Search", "Junk", i)),result2);
		}
	}



	@DataProvider(name = "BrowseCourse_tabs")
	public Object[][] DataProvider_BrowseCourse_tabs()
	{
		String SheetName = "BrowseCourse_tabs";
		datatable = new Xls_Reader(TestDataSheetPath_Elearning);
		int rowcount = datatable.getRowCount(SheetName);
		Object result[][] =new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData(SheetName, "BrowseCourse_tabs",i );
			result[i-2][0] = i;	
		}
		return result;
	}
	@Test (dataProvider = "BrowseCourse_tabs")
	//To verify Browse Courses landings
	public void TC_Elearning_019(int row , String BrowseCourse_tabs){
		driver.get(URLProvider.Return_Ecourses_ITURL());
		generic.Scroll_The_Page(ElearningPage.BrowseCatagory_Lnk);
		generic.Click_Lnk(ElearningPage.BrowseCatagory_Lnk);
		generic.GoToSleep(2000);
		String Xpath = "//div[@class='fl browse']//a[text()='"+BrowseCourse_tabs+"']";
		generic.Click_Lnk(Xpath);
		String result =generic.GetElementText(ElearningPage.CourseBreadcrumb_WE);
		Assert.assertEquals(result,datatable.getCellData("BrowseCourse_tabs", "BreadCrumb", row) );
	}

	@Test
	//To verify that Inclusive of all Taxes is displayed on Course Detail page
	public void TC_Elearning_020()
	{
		driver.get(URLProvider.Return_EcoursesURL());
		generic.Click(ElearningPage.Course1_Lnk);
		String result =generic.GetElementText(ElearningPage.Inclusiveoftaxes_WE);
		Assert.assertEquals(result, "( Inclusive of all taxes )");
	}
	@Test
	//To verify that e-Learning Static content is displayed or not
	public void TC_Elearning_021()
	{			

		//To verify that e-Learning Bread crumb is displayed or not

		driver.get(URLProvider.Return_EcoursesURL());
		String result = generic.GetElementText_WE(ElearningPage.Breadcrumb_WE);
		Assert.assertTrue(result.equals("Naukri FastForward > Learning"),result);

		result = generic.GetElementText_WE(ElearningPage.HeroLine_WE);
		Assert.assertTrue(result.equals("Upskill yourself, Get Certified"),result);

		//To verify that e-Learning Hero line sub heading is displayed or not

		result = generic.GetElementText_WE(ElearningPage.HeroSubHeading_WE);
		Assert.assertTrue(result.equals("Enhance your job prospects"),result);

		//To verify that Preparatory courses heading is displayed or not

		result = generic.GetElementText_WE(ElearningPage.PreparatoryHeading_WE);
		Assert.assertTrue(result.equals("Preparatory Courses"),result);

		//To verify that Preparatory courses content is displayed or not

		result = generic.GetElementText_WE(ElearningPage.PreparatoryContent_WE);
		Assert.assertEquals(result,"Our Online Preparatory Courses will prepare you for Industry Certifications. You get a completion certificate along with it.");

		//To verify that Up skilling courses heading is displayed or not

		result = generic.GetElementText_WE(ElearningPage.UpskillingHeading_WE);
		Assert.assertTrue(result.equals("Upskilling Courses"),result);

		//To verify that Up skilling courses content is displayed or not

		result = generic.GetElementText_WE(ElearningPage.UpskillingContent_WE);
		Assert.assertTrue(result.equals("Our Online Upskilling Courses will upgrade you with in demand industry skills. You get a completion certificate along with it."),result);

		//To verify that Explore courses heading is displayed or not

		result = generic.GetElementText_WE(ElearningPage.ExploreHeading_WE);
		Assert.assertTrue(result.equals("Explore Online Courses by Category"),result);

		//To verify that Online Course Type is displayed or not

		result = generic.GetElementText_WE(ElearningPage.CourseType_WE);
		Assert.assertTrue(result.equals("Online Course Type:"),result);

		//To verify that Course Type All is displayed or not

		result = generic.GetElementText_WE(ElearningPage.All_Lnk);
		Assert.assertTrue(result.equals("All"),result);

		//To verify that Course Type Preparatory is displayed or not

		result = generic.GetElementText_WE(ElearningPage.Preparatory_Lnk);
		Assert.assertTrue(result.equals("Preparatory"),result);

		//To verify that Course Type Up skilling is displayed

		result = generic.GetElementText_WE(ElearningPage.Upskilling_Lnk);
		Assert.assertTrue(result.equals("Upskilling"),result);

		//To verify that search button is displayed on E-Learning page 

		result =generic.GetElementText_WE(ElearningPage.Search2_Btn);
		Assert.assertTrue(result.equals("Search"),result);

		//To verify that IT Course link,count,View All is displayed or not

		result = generic.GetElementText_WE(ElearningPage.ServiceName1_Lnk);
		Assert.assertTrue(result.equals("IT"),result);
		result = generic.GetElementText_WE(ElearningPage.ViewAll1_Lnk);
		Assert.assertTrue(result.equals("View All"),result);


		//To verify that Contact US widget Toll Free number is displayed

		result = generic.GetElementText(ContactUsLeadFormWidget.TollFreeNo_WE);
		result = result.replace("\n", " ");
		Assert.assertEquals(result, "TALK TO US 1800-103-4702 Toll Free 9:30 AM to 6:30 PM IST");

		//To verify that Contact US widget Call me Back is displayed

		result = generic.GetElementText(ContactUsLeadFormWidget.CallMeBack_Lnk);
		Assert.assertEquals(result, "ENQUIRE NOW");

		//To verify that  Aptitude Test link is displayed

		result = generic.GetElementText_WE(ElearningPage.FreeApti_Lnk);
		Assert.assertTrue(result.equals("Try Our Aptitude Test FREE"),result);	
	}
	@Test
	//To verify for inactive course oops page not found message is displayed
	public void TC_Elearning_022()
	{
		driver.get("http://learning.naukri.com/test-course-test");
		String URL=driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://learning.naukri.com/?error=1");
	}

	@Test
	//To verify Ecourse Detail Enquire Now functionality
	public void TC_Elearning_023()
	{
		driver.get("http://learning.naukri.com/oracle-primavera-e-learning-program-course-kw10");
		generic.Click(ElearningPage.EnquireNow_Btn);
		generic.Scroll_The_Page(ElearningPage.Name_Txt);

		generic.Fill_Txt(ElearningPage.Name_Txt, "Name");


		generic.Fill_Txt(ElearningPage.Mobile_Txt, "9999999999");



		generic.Fill_Txt(ElearningPage.CourseDetailQuery_WE, "Query");
		generic.GoToSleep(1000);
		generic.Click_Btn(ElearningPage.CallmeBack_BtnCourseDetail);
		generic.GoToSleep(1000);
		String Result=generic.GetElementText(ElearningPage.ThankyouMessages_CourseDetail);
		System.out.println(Result);
	}

	@DataProvider(name="IT")
	public Object[][] DataProvider_EcoursesITTabs()
	{
		String SheetName = "IT";
		datatable = new Xls_Reader(TestDataSheetPath_Elearning);
		int rowcount = datatable.getRowCount(SheetName);
		Object result[][] =new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData(SheetName, "IT_Courses",i );
			result[i-2][0] = i;	
		}
		return result;
	}
	@Test (dataProvider = "IT")
	//To verify IT Course Page
	public void TC_Elearning_024(int row , String IT_Courses)
	{
		String SheetName = "IT";
		driver.get(URLProvider.Return_Ecourses_ITURL());
		String Xpath = "//ul[@class='wrap']//a[text()='" + IT_Courses + "']";
		generic.Click(Xpath);
		generic.GoToSleep(2000);
		String result = generic.GetElementText(ElearningPage.CourseBreadcrumb_WE);
		Assert.assertEquals(result,datatable.getCellData(SheetName, "IT_Breadcrumb", row) );
		generic.Click_Lnk(ElearningPage.Prep_Lnk);
		String result1 = generic.GetElementText(ElearningPage.CourseBreadcrumb_WE);
		Assert.assertEquals(result1,datatable.getCellData(SheetName, "IT_Breadcrumb", row) );
		generic.Click_Lnk(ElearningPage.UpSkilling_Lnk);
		String result2 = (generic.GetElementText(ElearningPage.CourseBreadcrumb_WE));
		Assert.assertTrue(result2.equalsIgnoreCase(datatable.getCellData(SheetName, "IT_Breadcrumb", row)));
		
	}

	@DataProvider(name="Operations")
	public Object[][] DataProvider_EcoursesOperationsTabs()
	{
		String SheetName = "Operations";
		datatable = new Xls_Reader(TestDataSheetPath_Elearning);
		int rowcount = datatable.getRowCount(SheetName);
		Object result[][] =new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData(SheetName, "Operations_Courses",i );
			result[i-2][0] = i;	
		}
		return result;
	}
	@Test (dataProvider = "Operations")
	//To verify Operation Course page
	public void TC_Elearning_025(int row , String Operations_Courses)
	{
		String SheetName = "Operations";
		driver.get(URLProvider.Return_Ecourses_OperationsURL());
		String Xpath = "//ul[@class='wrap']//a[text()='" + Operations_Courses + "']";
		generic.Click(Xpath);
		generic.GoToSleep(2000);
		String result = generic.GetElementText(ElearningPage.CourseBreadcrumb_WE);
		Assert.assertEquals(result,datatable.getCellData(SheetName, "Operations_Breadcrumb", row) );
		generic.Click_Lnk(ElearningPage.Prep_Lnk);
		String result1 = generic.GetElementText(ElearningPage.CourseBreadcrumb_WE);
		Assert.assertEquals(result1,datatable.getCellData(SheetName, "Operations_Breadcrumb", row) );
		generic.Click_Lnk(ElearningPage.UpSkilling_Lnk);
		String result2 = (generic.GetElementText(ElearningPage.CourseBreadcrumb_WE));
		Assert.assertTrue(result2.equalsIgnoreCase(datatable.getCellData(SheetName, "Operations_Breadcrumb", row) ));
	}


	@DataProvider(name="Design")
	public Object[][] DataProvider_EcoursesDesignTabs()
	{
		String SheetName = "Design";
		datatable = new Xls_Reader(TestDataSheetPath_Elearning);
		int rowcount = datatable.getRowCount(SheetName);
		Object result[][] =new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData(SheetName, "Design_Courses",i );
			result[i-2][0] = i;	
		}
		return result;
	}
	@Test (dataProvider = "Design")
	//To verify Design course page
	public void TC_Elearning_026(int row , String Design_Courses)
	{
		String SheetName = "Design";
		driver.get(URLProvider.Return_Ecourses_DesignURL());
		String Xpath = "//ul[@class='wrap']//a[text()='" + Design_Courses + "']";
		generic.Click(Xpath);
		generic.GoToSleep(2000);
		String result = generic.GetElementText(ElearningPage.CourseBreadcrumb_WE);
		Assert.assertEquals(result,datatable.getCellData(SheetName, "Design_Breadcrumb", row) );
		generic.Click_Lnk(ElearningPage.Prep_Lnk);
		String result1 = generic.GetElementText(ElearningPage.CourseBreadcrumb_WE);
		Assert.assertEquals(result1,datatable.getCellData(SheetName, "Design_Breadcrumb", row) );
		generic.Click_Lnk(ElearningPage.UpSkilling_Lnk);
		String result2 = (generic.GetElementText(ElearningPage.CourseBreadcrumb_WE));
		Assert.assertTrue(result2.equalsIgnoreCase(datatable.getCellData(SheetName, "Design_Breadcrumb", row) ));
	}


	@DataProvider(name="Finance")
	public Object[][] DataProvider_EcoursesFinanceTabs()
	{
		String SheetName = "Finance";
		datatable = new Xls_Reader(TestDataSheetPath_Elearning);
		int rowcount = datatable.getRowCount(SheetName);
		Object result[][] =new Object[rowcount-1][2];
		for(int i = 2; i<rowcount+1;i++) {
			result[i-2][1]= datatable.getCellData(SheetName, "Finance_Courses",i );
			result[i-2][0] = i;	
		}
		return result;
	}
	@Test (dataProvider = "Finance")
	//To verify Finance course page
	public void TC_Elearning_027(int row , String Finance_Courses)
	{
		String SheetName = "Finance";
		driver.get(URLProvider.Return_Ecourses_FinanceURL());
		String Xpath = "//ul[@class='wrap']//a[text()='" + Finance_Courses + "']";
		generic.Click(Xpath);
		generic.GoToSleep(2000);
		String result = generic.GetElementText(ElearningPage.CourseBreadcrumb_WE);
		Assert.assertTrue(result.equalsIgnoreCase(datatable.getCellData(SheetName, "Finance_Breadcrumb", row) ));
		generic.Click_Lnk(ElearningPage.Prep_Lnk);
		String result1 = generic.GetElementText(ElearningPage.CourseBreadcrumb_WE);
		Assert.assertEquals(result1,datatable.getCellData(SheetName, "Finance_Breadcrumb", row) );
		generic.Click_Lnk(ElearningPage.UpSkilling_Lnk);
		String result2 = (generic.GetElementText(ElearningPage.CourseBreadcrumb_WE));
		Assert.assertTrue(result2.equalsIgnoreCase(datatable.getCellData(SheetName, "Finance_Breadcrumb", row) ));
	}


}