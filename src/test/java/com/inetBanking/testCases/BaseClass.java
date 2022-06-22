package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

//import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	public String baseUrl=readconfig.getApplicationUrl();
	public String username=readconfig.getUserName();
	public String pasword=readconfig.getPassword();
	public static Logger logger;
	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
	    logger=Logger.getLogger("ebanking");

	    PropertyConfigurator.configure("Log4j.properties");
	    
	    if(br.equals("chrome")) {
	    	System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		    driver=new ChromeDriver();
	    }else {
	    	System.setProperty("webdriver.edge.driver",readconfig.getEdgePath());
		    driver=new EdgeDriver();
	    }
//	    driver.manage().timeouts().implicitlyWait(10,TimeUnits.SECOND);
	    driver.get(baseUrl);
	    
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	public void captureScreen(WebDriver driver,String tname) throws IOException {
		
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		File target=new File(System.getProperty("user.dir")+"\\Screenshots\\"+tname+".png");
		
		FileUtils.copyFile(source, target);
		System.out.println("Screen shot taken");
		
	}
}
