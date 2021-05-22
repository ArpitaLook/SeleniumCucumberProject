package StepDefinition;

import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageObjects.CartPageObject;
import PageObjects.HomePageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDefinition extends BaseClass{
	public WebDriver driver;
	public HomePageObjects hpo;
	public CartPageObject cpo;
	public String parentwindow;
	@Given("^Land of the Amazon website$")
    public void land_of_the_amazon_website() throws Throwable {
       driver=BaseClass.init();
    }
	
    @When("^search for the product \"([^\"]*)\"$")
    public void search_for_the_product_something(String search_item) throws Throwable {
    	hpo=new HomePageObjects(driver);
        hpo.getText().sendKeys(search_item);
        hpo.getSearch().click();
    }
    

    @Then("^click on the \"([^\"]*)\" to add it to cart and click on the cart icon and verify the product name$")
    public void click_on_the_icon_to_add_the_item_to_cart(String act_value) throws Throwable {
        List<WebElement> value=hpo.getValue();
        for(int i=0;i<value.size();i++)
        {
        	//System.out.println(value.get(i).getText());
        	if(value.get(i).getText().contains(act_value))
        	{
        		//System.out.println(value.get(i).getText());
        		Assert.assertTrue(true);
        		value.get(i).click();
        		parentwindow=driver.getWindowHandle();
        		//System.out.println("parent: "+parentwindow);
        		Set<String> allwindows=driver.getWindowHandles();
                for(String handle:allwindows)
                {
                	//System.out.println("child: "+driver.switchTo().window(handle));
                	if(!parentwindow.equals(handle))
                	{
                	driver.switchTo().window(handle);
                	cpo=new CartPageObject(driver);
                	cpo.getAddToCart().click();
                	driver.switchTo().window(parentwindow);
                	Set<String> handles=driver.getWindowHandles();
                	for(String handle1:handles)
                	{
                		//System.out.println(driver.switchTo().window(handle1));
                		if(!parentwindow.equals(handle1))
                		{
                			driver.switchTo().window(handle1);
                			cpo.getCart().click();
                			List<WebElement> titles=cpo.getProdTtile();
                	    	for(int j=0;j<titles.size();j++)
                	    	{
                	    		if(titles.get(j).getText().contains(act_value))
                	    			Assert.assertTrue(true);
                	    	}
                			break;
                		}
                	}
                	break;
                	}
        	    }
        	break;
          }
        	else
        	Assert.assertTrue(false);
        }   
    }

    
    @When("^search for the product (.+) field$")
    public void search_for_the_product_field(String search_item) throws Throwable {
    	hpo=new HomePageObjects(driver);
        hpo.getText().sendKeys(search_item);
        hpo.getSearch().click();
    }
    

    @Then("^click on the (.+) to add it to cart and click on the cart icon and verify the product names$")
    public void click_on_the_to_add_it_to_cart_and_click_on_the_cart_icon_and_verify_the_product_names(String act_value) throws Throwable {
        List<WebElement> value=hpo.getValue();
        for(int i=0;i<value.size();i++)
        {
        	//System.out.println(value.get(i).getText());
        	if(value.get(i).getText().contains(act_value))
        	{
        		//System.out.println(value.get(i).getText());
        		Assert.assertTrue(true);
        		value.get(i).click();
        		parentwindow=driver.getWindowHandle();
        		//System.out.println("parent: "+parentwindow);
        		Set<String> allwindows=driver.getWindowHandles();
                for(String handle:allwindows)
                {
                	//System.out.println("child: "+driver.switchTo().window(handle));
                	if(!parentwindow.equals(handle))
                	{
                	driver.switchTo().window(handle);
                	cpo=new CartPageObject(driver);
                	cpo.getAddToCart().click();
                	driver.switchTo().window(parentwindow);
                	Set<String> handles=driver.getWindowHandles();
                	for(String handle1:handles)
                	{
                		//System.out.println(driver.switchTo().window(handle1));
                		if(!parentwindow.equals(handle1))
                		{
                			driver.switchTo().window(handle1);
                			cpo.getCart().click();
                			List<WebElement> titles=cpo.getProdTtile();
                	    	for(int j=0;j<titles.size();j++)
                	    	{
                	    		if(titles.get(j).getText().contains(act_value))
                	    			Assert.assertTrue(true);
                	    	}
                			break;
                		}
                	}
                	break;
                	}
        	    }
        	break;
          }
        }   
    }


    }
