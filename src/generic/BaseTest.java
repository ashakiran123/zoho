package generic;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements IAutoConst{
	public WebDriver driver;
	public static int pass=0,fail=0;//new code
	
	static {
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		System.setProperty(GECKO_KEY,GECKO_VALUE);
	}
	
	@BeforeMethod
	public void openApplication() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
		driver.get(URL);
	}
	
	@AfterMethod
	public void  CloseApplication(ITestResult iTestResult)
	{
		String name = iTestResult.getName();
		System.out.println(name);
		int status = iTestResult.getStatus();
		System.out.println(status);
		if(iTestResult.getStatus()==2) {
			doli_bar_FWUtil1.getPhoto(driver,PHOTO_PATH+name+".png");
			fail++;//new code
		}
		else {
			pass++;//new code
		}
		driver.close();
	}
	@AfterSuite
	public void writeReport()
	{
		doli_bar_FWUtil1.setXLdata(REPORT_PATH,"Sheet1",1,0,pass);
		doli_bar_FWUtil1.setXLdata(REPORT_PATH,"Sheet1",1,1,fail);
	}
}
