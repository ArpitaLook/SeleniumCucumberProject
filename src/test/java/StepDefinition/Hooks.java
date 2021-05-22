package StepDefinition;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass{
	
	@After("@SmokeTest")
	public void close()
	{
		driver.quit();
	}
	
	@After("@RegTest")
	public void tearDown()
	{
		driver.quit();
	}
	
	@After("@RegTest")
	public void failedScenarios(Scenario scenario) throws IOException
	{
		if(scenario.isFailed())
		{
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String path=System.getProperty("user.dir")+"\\target\\screenShot.png";
			File desc=new File(path);
			FileHandler.copy(src,desc);
		}
	}

}
