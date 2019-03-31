/*
 * import java.io.IOException;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.WebElement; import
 * org.openqa.selenium.interactions.Actions;
 * 
 * 
 * import framework.BrowserEngine;
 * 
 * public class TestBrowserEngine {
 * 
 * public WebDriver driver;
 * 
 * public void main(String[] args) throws IOException { BrowserEngine browser =
 * new BrowserEngine(); browser.initConfigData(); driver=browser.getBrowser(); }
 * 
 * public void openBaidu() {
 * driver.findElement(By.id("kw")).sendKeys("automation"); Actions actions=new
 * Actions(driver); WebElement textbox = null; actions.moveToElement(textbox, 1,
 * 65).click().perform();
 * 
 * try { driver.findElement(By.id("wrapper"));
 * 
 * } catch(org.openqa.selenium.NoSuchElementException ex) {
 * 
 * } } }
 */