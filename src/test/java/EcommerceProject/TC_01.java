package EcommerceProject;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TC_01 extends BaseTest1 {

	@Test
	public void FillForm() throws InterruptedException {
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Shiva");
		driver.hideKeyboard();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//error msg when we not enter name and click login,we get error message
		String toastmsg= driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastmsg, "Please enter your name");
		Thread.sleep(4000);
	}
	
}
