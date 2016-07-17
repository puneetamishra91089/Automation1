package com.naukri.FastForwardRevamp.Code;

import org.openqa.selenium.WebDriver;

import com.naukri.GenericFunctionsPack.GenericFunctions;

public class FeedBackpage {
	public WebDriver driver;
	GenericFunctions generic;

	public FeedBackpage(WebDriver driver , GenericFunctions generic)
	{
		this.driver=driver;
		this.generic = generic;
	}
}
