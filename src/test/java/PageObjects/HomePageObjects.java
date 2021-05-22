package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects {
	public WebDriver driver;
	By text=By.xpath("//input[@id='twotabsearchtextbox']");
	By search=By.xpath("//input[@id='nav-search-submit-button']");
	By value=By.xpath("//div[@class='sg-col-inner']//div//h2//a//span");
	
	
	
	public HomePageObjects(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement getText()
	{
		return driver.findElement(text);
	}
	public WebElement getSearch()
	{
		return driver.findElement(search);
	}
	public List<WebElement> getValue()
	{
		return driver.findElements(value);
	}
	
	
}
