import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AccessbilityTest extends DriverSingleton {

	AndroidDriver<AndroidElement> driver = null;
	
	@Test
	public void mainActivity() {
		driver = DriverSingleton.getDriverInstance();
		driver.startActivity(new  Activity("io.appium.android.apis", "io.appium.android.apis.ApiDemos"));
	}

	@Test(description = "Verifying that user is able to navigate to acessibility node provider screen")
	public void verifyTextOnAccessibilityNodeQuery() {
		driver.findElementByAccessibilityId("Accessibility").click();
		driver.findElementByAccessibilityId("Accessibility Node Querying").click();
		//assertEquals("Accessibility/Accessibility Node Querying", driver.findElementById("android:id/action_bar").getText());
	}
	
	@Test(description= "Verifying that user is able to navigate to acessibility node provider screen")
	public void verifyTextOnAccessibilityNodeProvider() {
		driver.findElementByAccessibilityId("Accessibility").click();
		driver.findElementByAccessibilityId("Accessibility Node Provider").click();
		driver.findElementByClassName("android.widget.TextView").click();
		assertEquals("Accessibility/Accessibility Node Provider", driver.findElementByClassName("android.widget.TextView").getText());
	}

}
