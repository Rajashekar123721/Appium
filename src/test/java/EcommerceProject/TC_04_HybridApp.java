package EcommerceProject;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.functions.ExpectedCondition;

public class TC_04_HybridApp extends BaseTest1 {

	@Test
	public void FillForm() throws InterruptedException {
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Belgium\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Belgium']")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Shiva");
		driver.hideKeyboard();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		List<WebElement> productPrices=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count=productPrices.size();
		double totalSum=0;
		for(int i=0;i<count;i++) {
			String amountString=productPrices.get(i).getText();
			Double price=getFormattedAmount(amountString);
			totalSum=totalSum+price;
		}
		System.out.println("Total Sum calculated is :"+totalSum);
		
		String displaySum=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double displayFormattedSum=getFormattedAmount(displaySum);
		Assert.assertEquals(totalSum, displayFormattedSum);
		System.out.println("Total Sum displayed is :"+displayFormattedSum);
		
		WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(ele);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(10000);
		
		/*Hybrid app:App which can navigate to web browser.(Means mix of both  native app and web browser)
		
		Then driver doesn't have control on web browser since driver is initiated as Android driver.
		To get control on web browser view we need to shift the contexts
		*/
		
		Set<String> contexts=driver.getContextHandles(); //will get the set of contexts
		for(String contextName:contexts) {
			System.out.println(contextName);//prints each available contexts
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");  //to execute this chrome driver path is needed
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		searchBox.sendKeys("Shopping in Shekar Phone");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK)); //press back key
		driver.context("NATIVE_APP"); //context change back to the native app
		Thread.sleep(6000);
	}
	
}
