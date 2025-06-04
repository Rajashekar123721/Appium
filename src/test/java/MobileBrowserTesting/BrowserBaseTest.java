package MobileBrowserTesting;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BrowserBaseTest {

	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException 
	{
		 service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\graja\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();

		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Shekar Phone");
		options.setChromedriverExecutable("C:\\Users\\graja\\Downloads\\136.0.7103.49 chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		options.setCapability("browserName","Chrome");
		
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
	}

	
	
	
	
	@AfterClass
	public void teardown() {
		driver.quit();
		service.stop();
	}

}
