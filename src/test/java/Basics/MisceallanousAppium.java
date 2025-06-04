package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.Immutable;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MisceallanousAppium extends BaseTest{

	@Test
	public void Miscellaneous() throws InterruptedException {

		//driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		//driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		
		
		/*instead of going click by click like above steps, we can able to go directly to the page we wanted using Activity.
		  1)Open the screen in emulator in which you want to test directly.
		  2)Open Command Prompt and enter below cmnd.
		  		adb shell dumpsys activity activities | findstr "ResumedActivity"
		  Note:Ensure that devices are running using command: adb devices
		  
		   App Package and App Activity are obtained in cmd prompt
		  
		*/
		
		
		Activity activity=new Activity("io.appium.android.apis", ".preference.PreferenceDependencies");
		((JavascriptExecutor) driver).executeScript("mobile:startActivity", ImmutableMap.of("intent","io.appium.android.apis/.preference.PreferenceDependencies"));
				
		
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
		
		
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(By.className("android.widget.Button")).get(1).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	
		
		
	}
}
