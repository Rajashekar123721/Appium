package rahulshettyacademy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasics extends BaseTest{

	@Test
	public void WifiSettingsName() {

		//doc available at https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
		// AndroidDriver,IOSDriver
		// Appium Code --> Appium Server --> Mobile

		// Instead of manually starting the server here we written code for automatic
		// start of server.
	
		
		//Actual Automation
		//xpath,id,accessibility id,classname,androidUIAutomator
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String actualText=driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(actualText,"WiFi settings");
		
		driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("Shekar Wifi");
		driver.findElements(By.className("android.widget.Button")).get(1).click();
		
		
	}
}
