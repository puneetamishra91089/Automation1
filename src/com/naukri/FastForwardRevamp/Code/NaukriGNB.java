package com.naukri.FastForwardRevamp.Code;

import org.openqa.selenium.WebDriver;

import com.naukri.GenericFunctionsPack.GenericFunctions;

public class NaukriGNB {
	WebDriver driver;
	GenericFunctions generic;
	public NaukriGNB(WebDriver driver,GenericFunctions generic)
	{
		this.driver = driver;
		this.generic = generic;
	}
public static final String Naukri_JobsTab_Lnk = "//a[@title='Search Jobs']";
public static final String Naukri_RecruitersTab_Lnk = "(//a[@title='Search Recruiters'])[1]";
public static final String Naukri_CompaniesTab_Lnk = "//a[@title='Jobs Posted By Top Companies']";
public static final String Naukri_ServicesTab_Lnk = "//a[@title='Naukri FastForward- Resume Services']";
public static final String Naukri_MoreTab_Lnk = "(//ul[@class='midSec menu']/li)[5]";
public static final String Services_Breadcrumb_WE = "//div[@class='wrap breadCrmb']";
public static final String ServicesOther_Breadcrumb_WE = "//div[@class='wrapper pT10']";


public static final String More_ShikshaLogo_WE = "//img[@class='flLt']";


}
