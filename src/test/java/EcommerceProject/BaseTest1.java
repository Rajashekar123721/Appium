package EcommerceProject;

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
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest1 {

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
		options.setApp(
				"D:\\Edureka Training\\Eclipse projects\\Appium\\src\\test\\java\\resources\\General-Store.apk");

		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
	}

	public Double getFormattedAmount(String amount) {
		Double price=Double.parseDouble(amount.substring(1));
		return price;
		
	}
	
	public void longPressAction(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(),
						"duration",2000));
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
		service.stop();
	}

}
