package rahulshettyacademy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MisceallanousAppium extends BaseTest{

	@Test
	public void Miscellaneous() {

		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		
		//Device Rotation or Landscape
		DeviceRotation landScape=new DeviceRotation(0, 0, 90);
		driver.rotate(landScape);
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String actualText=driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(actualText,"WiFi settings");
		
		//copy paste
		//copy to clipboard or paste to clipboard
		driver.setClipboardText("Shekar Wifi");
		driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys(driver.getClipboardText());
		
		
		driver.findElements(By.className("android.widget.Button")).get(1).click();
		
		
	}
}
