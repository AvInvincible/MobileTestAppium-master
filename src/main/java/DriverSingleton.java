import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverSingleton {

	private static DesiredCapabilities cap;
	private static AndroidDriver<AndroidElement> driver = null;
	
	@Parameters({ "device_name","platformVersion", "port" })
	@BeforeClass
	public static void setDriverInstance(String device_name, String platformVersion, String port) {
		if (driver == null) {
			File fs = new File("src/test/resource/app");
			File appPath = new File(fs,"ApiDemos-debug.apk");
			cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, device_name);
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
			cap.setCapability(MobileCapabilityType.APP, appPath.getAbsolutePath());
			try {
				driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:"+port+"/wd/hub"), cap);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static AndroidDriver<AndroidElement> getDriverInstance() {
		return driver;
	}

}
