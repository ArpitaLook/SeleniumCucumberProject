package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPageObject {
	public WebDriver driver;
	By cart=By.xpath("//a[@id='nav-cart']");
	By addToCart=By.xpath("//input[@id='add-to-cart-button']"); 
	By prod_title=By.xpath("//span[contains(@class,'product-title')]");
	public CartPageObject(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public WebElement getAddToCart()
	{
		return driver.findElement(addToCart);
	}
	public WebElement getCart()
	{
		return driver.findElement(cart);
	}
	public List<WebElement> getProdTtile()
	{
		return driver.findElements(prod_title);
	}

}
