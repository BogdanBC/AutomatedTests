import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class Objects {

    public AppiumDriver driver;
    public String device;
    public int SHORT_SLEEP = 300;

    public Objects(){
    }

    public void setUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        File classpathRoot = new File(System.getProperty("user.dir"));

        device = readProperty("APPIUM_PLATFORM");
        String deviceName = readProperty("APPIUM_DEVICE_NAME");
        String udid = readProperty("APPIUM_UDID");
        String appDir = readProperty("APPIUM_APPDIR");
        String appFile = readProperty("APPIUM_APPFILE");
        String appPackage = readProperty("APPIUM_APPPACKAGE");
        String url = readProperty("APPIUM_URL");
        String BID = readProperty("APPIUM_BUNDLE_ID");

        if (device.equals("android")) {
            File appDirFile = new File(classpathRoot, appDir);
            File app = new File(appDirFile, appFile);
            capabilities.setCapability(CapabilityType.BROWSER_NAME, " ");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", deviceName);
            capabilities.setCapability("platformVersion", "4.4");
            capabilities.setCapability("app", app.getAbsolutePath());
            capabilities.setCapability("appPackage", appPackage);
            capabilities.setCapability("autoWebView", "true");
            driver = new AndroidDriver(new URL(url), capabilities);
        }
    }

    public String readProperty(String property) {
        if (System.getProperty(property)==null) {
            return System.getenv(property);
        }
        else {
            return System.getProperty(property);
        }
    }

    public void takeScreenshot(String name) throws Exception {
        String fullFileName = System.getProperty("user.dir") + "/screenshots/" + name + ".png";
        File ss = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(ss, new File(fullFileName));
    }
}
