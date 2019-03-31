package framework;
 
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
 
/*思路：

1. 写一个配置文件，例如properties文件，里面写好浏览器的类型和测试服务器的地址，方便切换

2 .编写一个浏览器引擎类，通过读取配置文件加上if语句去控制启动不同浏览器。

3. 测试脚本调用浏览器引擎类实例，得到driver，开始测试自动化脚本*/


/*geckodriver.exe获取地址
https://github.com/mozilla/geckodriver/releases
*/	


public class BrowserEngine {
	
	public String browserName;
	public String serverURL;
	public WebDriver driver;
	
	public void initConfigData() throws IOException{
		
		Properties p = new Properties();
		// 加载配置文件
		InputStream ips = new FileInputStream(".\\TestConfig\\config.properties");
		p.load(ips);
		
		/*
		 * Logger.Output(LogType.LogTypeName.INFO,
		 * "Start to select browser name from properties file");
		 */
		browserName=p.getProperty("browserName");
		/*
		 * Logger.Output(LogType.LogTypeName.INFO,
		 * "Your had select test browser type is: "+ browserName);
		 */
		serverURL = p.getProperty("URL");
		/*
		 * Logger.Output(LogType.LogTypeName.INFO, "The test server URL is: "+
		 * serverURL); ips.close();
		 */
		
	}
	
	public WebDriver getBrowser(){
		
		if(browserName.equalsIgnoreCase("Firefox")){
			
			
			System.setProperty("webdriver.gecko.driver", ".\\TestConfig\\geckodriver.exe");
			driver = new FirefoxDriver();
			
			/* Logger.Output(LogType.LogTypeName.INFO, "Launching Firefox ..."); */
			
		}else if(browserName.equalsIgnoreCase("Chrome")){
			
			System.setProperty("webdriver.chrome.driver", "E:\\Google\\Chrome\\Application\\chromedriver.exe");
			driver= new ChromeDriver();
			/* Logger.Output(LogType.LogTypeName.INFO, "Launching Chrome ..."); */
			
			/*
			 * Driver for Chrome73.0.3683.86 http://npm.taobao.org/mirrors/chromedriver/2.46/
			 */			
			
		}else if(browserName.equalsIgnoreCase("IE")){
			
			System.setProperty("webdriver.ie.driver", ".\\TestConfig\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
			/* Logger.Output(LogType.LogTypeName.INFO, "Launching IE ..."); */
		}
		
		driver.get(serverURL);
		/* Logger.Output(LogType.LogTypeName.INFO, "Open URL: "+ serverURL); */
		driver.manage().window().maximize();
		/* Logger.Output(LogType.LogTypeName.INFO, "Maximize browser..."); */
		callWait(5);
		return driver;
	}
	
	/*
	 * 关闭浏览器并退出方法
	 */
	
	public void tearDown() throws InterruptedException{
		
		/* Logger.Output(LogType.LogTypeName.INFO, "Closing browser..."); */
		driver.quit();
		Thread.sleep(3000);
	}
	
	/*
	 * 隐式时间等待方法
	 */
	public void callWait(int time){
		
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		/* Logger.Output(LogType.LogTypeName.INFO, "Wait for "+time+" seconds."); */
	}
	
	
	/*
	 * createFireFox Driver
	 * @Param: null
	 * @return: WebDriver
	 */
	
	private WebDriver createFireFoxDriver() {
		
		WebDriver driver = null;
		FirefoxProfile firefoxProfile = new FirefoxProfile();
 
		firefoxProfile.setPreference("prefs.converted-to-utf8", true);
		//set download folder to default folder: TestDownload
		firefoxProfile.setPreference("browser.download.folderList", 2);
		firefoxProfile.setPreference("browser.download.dir", ".\\TestDownload");
		
		/*
		 * try { driver = new FirefoxDriver(firefoxProfile); } catch (Exception e) {
		 * Logger.Output(LogType.LogTypeName.ERROR, e.getMessage());
		 * Logger.Output(LogType.LogTypeName.ERROR,
		 * "Failed to initialize the Firefox driver"); }
		 */
		return driver;
	}
 
	
}