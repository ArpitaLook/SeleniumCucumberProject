package StepDefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	public static WebDriver driver;

	public static WebDriver init() throws IOException
	{
		String path=System.getProperty("user.dir");
		String globalPath=path+"\\src\\test\\java\\DataFiles\\global.properties";
		String chroPath=path+"\\src\\test\\java\\DataFiles\\chromedriver.exe";
		FileInputStream fis=new FileInputStream(globalPath);
		Properties prop=new Properties();
		prop.load(fis);
		if(prop.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", chroPath);
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		}
		
		return driver;
	}
}
