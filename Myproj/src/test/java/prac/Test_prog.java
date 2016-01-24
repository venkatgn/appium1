package prac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,MethodListener.class })
public class Test_prog 
{

	{
		 System.setProperty("atu.reporter.config", "F:\\App_jan_2016\\Myproj\\src\\test\\resources\\atu.properties");
	}
	WebDriver driver;
	
	@Test
	@Parameters({"browser"})
	public void testing(String br) throws Exception
	{
		if(br.matches("firefox"))
		{
			driver=new FirefoxDriver();
		}
		if(br.matches("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		Home h=new Home(driver);
		h.createacc();
		h.login();
		
		Compose c=new Compose(driver);
		c.sendmail();
		c.signout();
		
	}
}
