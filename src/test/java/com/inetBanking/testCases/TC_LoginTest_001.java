package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{


	@Test
	public void loginTest() throws IOException
	{
		
		logger.info("url is opened");
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("entered username");
		lp.setPassword(pasword);
		logger.info("entred password");
		lp.clickSubmit();
		
		logger.info("clicked the button");
		
		if(driver.getTitle().equals(" Guru99 Bank Manager HomePage ")) {
			Assert.assertTrue(true);
			System.out.println(driver.getTitle());
		}else {
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info(" login test failed");
		}
	}
	
	
	
}
