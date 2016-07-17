package com.naukri.FastForwardRevamp.ConfigDetails;


public class URLProvider extends ConfigDetails {

	public static String Return_HomePageURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080";
		else
			return "http://resume.naukri.com/";
	}
	public static String Return_LoginlURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/resume-writing-for-freshers-entry-level";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/";
		else 
			return "https://login.naukri.com/nLogin/Login.php";
	}


	public static String Return_TextResume_EntryLevelURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/resume-writing-for-freshers-entry-level";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/resume-writing-for-freshers-entry-level";
		else 
			return "http://resume.naukri.com/resume-writing-for-freshers-entry-level";
	}


	public static String Return_TextResume_MidLevelURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/mid-level-experienced-professionals-resume-writing";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/mid-level-experienced-professionals-resume-writing";
		else 
			return "http://resume.naukri.com/mid-level-experienced-professionals-resume-writing";
	}


	public static String Return_TextResume_SeniorLevelURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/senior-manager-executive-resume-writing";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/senior-manager-executive-resume-writing";
		else 
			return "http://resume.naukri.com/senior-manager-executive-resume-writing";
	}


	public static String Return_VisualResume_EntryLevelURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/visual-resume-writing-for-freshers-entry-level";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/visual-resume-writing-for-freshers-entry-level";
		else 
			return "http://resume.naukri.com/visual-resume-writing-for-freshers-entry-level";
	}


	public static String Return_VisualResume_MidLevelURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/mid-level-experienced-professionals-visual-resume-writing";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/mid-level-experienced-professionals-visual-resume-writing";
		else 
			return "http://resume.naukri.com/mid-level-experienced-professionals-visual-resume-writing";
	}


	public static String Return_VisualResume_SeniorLevelURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/senior-manager-executive-visual-resume-writing";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/senior-manager-executive-visual-resume-writing";
		else 
			return "http://resume.naukri.com/senior-manager-executive-visual-resume-writing";
	}


	public static String Return_ResumeQualityScoreURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/resume-quality-score";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/resume-quality-score";
		else 
			return "http://resume.naukri.com/resume-quality-score";
	}
	public static String Return_ResumeSampleURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_" + TestorLive + ".php/sample-resume-for-experienced-mid-level";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test4.php/sample-resume-for-experienced-mid-level";
		else 
			return "http://resume.naukri.com/resume-samples";
	}

	public static String Return_ResumeSampleMidURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/sample-resume-for-experienced-mid-level";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/sample-resume-for-experienced-mid-level";
		else 
			return "http://resume.naukri.com/sample-resume-for-experienced-mid-level";
	}

	public static String Return_ResumeSampleSeniorURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/sample-resume-for-senior-manager-executive-level";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/sample-resume-for-senior-manager-executive-level";
		else 
			return "http://resume.naukri.com/sample-resume-for-senior-manager-executive-level";
	}


	public static String Return_VisualResumeSampleURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/visual-resume-samples";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/visual-resume-sample";
		else 
			return "http://resume.naukri.com/visual-resume-sample";
	}


	public static String Return_CoverLetterSampleURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/cover-letter-samples-for-resume";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/cover-letter-samples-for-resume";
		else 
			return "http://resume.naukri.com/cover-letter-samples-for-resume";
	}

	public static String Return_RecruiterConnectionURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/contact-recruiters-hr";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/contact-recruiters-hr";
		else 
			return "http://resume.naukri.com/contact-recruiters-hr";
	}


	public static String Return_TextResumeSampleURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/sample-resume-for-freshers";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/sample-resume-for-freshers";
		else 
			return "http://resume.naukri.com/sample-resume-for-freshers";
	}


	public static String Return_CertificateHighlighterURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/resume-display";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/cert-hightlighter";
		else 
			return "http://resume.naukri.com/cert-hightlighter";
	}
	public static String Return_ResumeDisplayURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/resume-display";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/resume-display";
		else 
			return "http://resume.naukri.com/resume-display";
	}

	public static String Return_PriorityApplicantURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/priority-job-application";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/priority-job-application";
		else 
			return "http://resume.naukri.com/priority-job-application";
	}
	
	public static String Return_EcoursesURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".e-learning.infoedge.com:8082/fastforward/app_"+TestorLive+".php/";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".e-learning.infoedge.com:8080";
		else 
			return "http://learning.naukri.com/";
	}


	public static String Return_Jobs4UURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/job-alerts-on-mobile-mail";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/job-alerts-on-mobile-mail";
		else 
			return "http://resume.naukri.com/job-alerts-on-mobile-mail";
	}
	public static String Return_TextResumeSample_ITURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/sample-resume-for-it-information-technology";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/sample-resume-for-it-information-technology";
		else 
			return "http://resume.naukri.com/sample-resume-for-it-information-technology";
	}

	public static String Return_TextResumeSample_BankingFinanceURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/sample-resume-for-automobile-engineering";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/sample-resume-for-automobile-engineering";
		else 
			return "http://resume.naukri.com/sample-resume-for-automobile-engineering";
	}


	public static String Return_TextResumeSample_HRURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/sample-resume-for-hr-human-resource";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/sample-resume-for-hr-human-resource";
		else 
			return "http://resume.naukri.com/sample-resume-for-hr-human-resource";
	}
	
	public static String Return_TextResumeSample_AutomobileURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/sample-resume-for-automobile-engineering";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/sample-resume-for-automobile-engineering";
		else 
			return "http://resume.naukri.com/sample-resume-for-automobile-engineering";
	}


	public static String Return_TextResumeSample_MarketingURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/sample-resume-for-marketing";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/sample-resume-for-marketing";
		else 
			return "http://resume.naukri.com/sample-resume-for-marketing";
	}


	public static String Return_TextResumeSample_OperationsURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/sample-resume-for-operations";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/sample-resume-for-operations";
		else 
			return "http://resume.naukri.com/sample-resume-for-operations";
	}


	public static String Return_TextResumeSample_ProductionURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/sample-resume-for-production";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/sample-resume-for-production";
		else 
			return "http://resume.naukri.com/sample-resume-for-production";
	}


	public static String Return_TextResumeSample_SalesURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/sample-resume-for-sales";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/sample-resume-for-sales";
		else 
			return "http://resume.naukri.com/sample-resume-for-sales";
	}

	public static String Return_SearchRecuitersURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/contact-recruiters-hr";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/contact-recruiters-hr";
		else 
			return "http://resume.naukri.com/contact-recruiters-hr";
	}


	public static String Return_VisualResumeSampleFreshersURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/visual-resume-format-for-freshers-experienced";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/visual-resume-format-for-freshers-experienced";
		else 
			return "http://resume.naukri.com/visual-resume-format-for-freshers-experienced";
	}


	public static String Return_ValuePackURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/value-pack";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/value-pack";
		else 
			return "http://resume.naukri.com/value-pack";
	}

	public static String Return_GulfValuePackURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/value-pack/gulf";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/value-pack/gulf";
		else 
			return "http://resume.naukri.com/value-pack/gulf";
	}


	public static String Return_Ecourses_ITURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".e-learning.infoedge.com:8082/fastforward/app_test1.php/online-it-courses/";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".learning.infoedge.com:8080/online-courses/it";
		else 
			return "http://learning.naukri.com/online-it-courses";
	}


	public static String Return_Ecourses_OperationsURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".learning.infoedge.com:8082/fastforward/app_test1.php/online-operations-courses";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".learning.infoedge.com:8080/online-operations-courses";
		else 
			return "http://learning.naukri.com/online-operations-courses";
	}


	public static String Return_Ecourses_DesignURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".learning.infoedge.com:8082/fastforward/app_test1.php/online-courses/design";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".learning.infoedge.com:8080/online-courses/design";
		else 
			return "http://learning.naukri.com/online-courses/design";
	}

	public static String Return_Ecourses_FinanceURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".learning.infoedge.com:8082/fastforward/app_test1.php/online-finance-courses";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".learning.infoedge.com:8080/online-finance-courses";
		else 
			return "http://learning.naukri.com/online-finance-courses";
	}


	public static String Return_Ecourses_ALLURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".learning.infoedge.com:8082/fastforward/app_test1.php/online-courses";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".learning.infoedge.com:8080/online-courses";
		else 
			return "http://learning.naukri.com/online-courses";
	}
	public static String Return_Ecourses_SearchURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".e-learning.infoedge.com:8082/fastforward/app_"+TestorLive+".php/online-course-search";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".learning.infoedge.com:8080/online-course-search";
		else 
			return "http://learning.naukri.com/courses";
	}
	public static String Return_ContactUsURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/contact-us";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/contact-us";
		else 
			return "http://resume.naukri.com/contact-us";
	}


	public static String Return_LocateBranchURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8082/fastforward/app_test1.php/locate-branch";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".resume.infoedge.com:8080/locate-branch";
		else 
			return "http://resume.naukri.com/locate-branch";
	}

	public static String Return_AptitudePageURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + ".learning.infoedge.com:8082/fastforward/app_test1.php/online-aptitude-test";
		else if (TestorLive.toLowerCase().contains("dev")) 
			return "http://" + TestorLive + ".learning.infoedge.com:8080/online-aptitude-test";
		else 
			return "http://learning.naukri.com/online-aptitude-test";
	}
	public static String Return_ChatWindowURL() {
		if (TestorLive.toLowerCase().contains("test")) 
			return "http://" + TestorLive + "server.iad.liveperson.net/hc/19285453/?cmd=file&file=visitorWantsToChat&site=19285453&byhref=1&imageUrl=http://www.jeevansathi.com/images&referrer=http%3A//resume.naukri.com/contact-us";
		else 
			return "https://server.iad.liveperson.net/hc/19285453/?cmd=file&file=visitorWantsToChat&site=19285453&byhref=1&imageUrl=http://www.jeevansathi.com/images&referrer=http%3A//resume.naukri.com/contact-us";
	}

}
