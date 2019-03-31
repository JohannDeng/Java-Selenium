import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import framework.BrowserEngine;

import static org.junit.Assert.*;
/*http://junit.sourceforge.net/javadoc/org/junit/Assert.html
*/  
  
  public class Baidu {
  
	 public static WebDriver driver; 
		
		public static void main(String[] args) throws IOException {
		BrowserEngine browser = new BrowserEngine();
		browser.initConfigData();
		driver=browser.getBrowser();
		
	    driver.findElement(By.id("kw")).sendKeys("automation");
	    driver.findElement(By.id("su")).click();
		/*
		 * Actions actions=new Actions(driver); WebElement textbox = null;
		 * actions.moveToElement(textbox, 1, 65).click().perform();
		 */
	    
		/* Verify baidu search results were displayed or not */
		 assertNotNull(driver.findElement(By.id("wrapper")));
		
		/*
		 * try { driver.findElement(By.id("wrapper"));
		 * 
		 * } catch(org.openqa.selenium.NoSuchElementException ex) {
		 * 
		 * }
		 */
		}
  
  }