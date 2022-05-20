package qa.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class test1 {

    private AndroidDriver driver;
    @BeforeClass
    public void setUp() throws MalformedURLException {



        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "test");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability("avd", "test");
        caps.setCapability("avdLaunchTimeout", 600000);
        caps.setCapability("uiautomator2ServerLaunchTimeout", 600000);
        caps.setCapability("adbExecTimeout", 600000);
        caps.setCapability("uiautomator2ServerInstallTimeout", 600000);
        caps.setCapability("appPackage", "www.onbeatapps.com");



//        caps.setCapability("noResetValue","false");

//        String appurl= System.getProperty("user.dir") + File.separator + "src" + File.separator
//                + "main" + File.separator + "resources" + File.separator + "OnBeat.apk";

        String appurl = File.separator + "home" + File.separator + "runner" + File.separator
                + "work" + File.separator + "onbeatcicd" + File.separator + "onbeatcicd"
                + File.separator + "app" + File.separator + "build" + File.separator + "outputs" + File.separator + "apk" + File.separator + "debug" + File.separator;

//        File appDir = new File("src/main/resources/");
//        File app = new File(appDir, "app-debug.apk");

        String urlDir = "/home/runner/work/onbeatcicd/onbeatcicd/onbeat-qa-automation-android/src/main/resources/";

        String fullPath = "/home/runner/work/onbeatcicd/onbeatcicd/onbeat-qa-automation-android/src/main/resources/app-debug.apk";
        Atring newpath = "../app/build/outputs/apk/debug/app-debug.apk";

        File appDir = new File("src/main/resources/");
        File app = new File(appDir, "app-debug.apk");

       // '/home/runner/work/onbeatcicd/onbeatcicd/onbeat-qa-automation-android/src/main/resources/app-debug.apk

//        String appurl= "app" + File.separator + "build" + File.separator + "outputs"
//                + File.separator + "apk" + File.separator + "debug" + File.separator + "app-debug.apk";

//        caps.setCapability("appPackage", "www.onbeatapps.com");
//        caps.setCapability("appActivity", "www.onbeatapps.com.ui.authActivity.AuthActivity");

        caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

       // caps.setCapability(MobileCapabilityType.APP, appurl);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, caps);
    }

    @Test
    public void Test() {
        String ticket = "test@0004";
        String phone = "09000000004";
        String pass1 = "1234";
        String pass2 = "1111";
        String pass3 = "2222";
        String limit = "50";
        String card = "4000002500003155";
        String expiry = "1234";
        String cvv = "123";
        String pincode = "682030";
        String name = "Appium Automation";
        String email = "appium@automation.com";
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el1 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btWhatOn");
        el1.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el2 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btBack");
        el2.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el3 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/editcode");
        el3.sendKeys(ticket);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el4 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btNext");
        el4.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el53 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/txtTeams");
        el53.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        driver.findElementByAndroidUIAutomator("new UiScrollable("
//                + "new UiSelector().scrollable(true)).scrollIntoView("
//                + "new UiSelector().textContains(\"click\"));");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el54 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btSideMenu");
        el54.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el5 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/spnCountry");
        el5.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator("new UiScrollable("
                + "new UiSelector().scrollable(true)).scrollIntoView("
                + "new UiSelector().textContains(\"(+91) India\"));").click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el7 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/editPhone");
        el7.sendKeys(phone);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el8 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btNext");
        el8.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        MobileElement el9 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btOk");
//        el9.click();
        MobileElement el9 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btConfirm");
        el9.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el10 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/txtPin");
        el10.sendKeys(pass1);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el11 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btConfirm");
        el11.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el12 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/txtPin");
        el12.sendKeys(pass1);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el13 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btConfirm");
        el13.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el14 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btBegin");
        el14.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        MobileElement el55 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/txtFundAdd");
//        el55.click();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        MobileElement el56 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btBack");
//        el56.click();
        MobileElement el15 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/editAmount");
        el15.sendKeys(limit);
//        MobileElement el15 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout
//        /android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout
//        /android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup
//        /android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout
//        /androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.Button");
//        el15.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el16 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btNext");
        el16.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el55 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/txtFundAdd");
        el55.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MobileElement el56 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btBack");
        el56.click();
        MobileElement el17 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/et_card_number");
        el17.sendKeys(card);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el18 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/et_expiry");
        el18.sendKeys(expiry);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el19 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/et_cvc");
        el19.sendKeys(cvv);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el21 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/et_postal_code");
        el21.sendKeys(pincode);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el22 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btNext");
        el22.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        MobileElement el23 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout" +
                "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView" +
                "/android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout[1]");
        el23.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el24 = (MobileElement) driver.findElementByAccessibilityId("COMPLETE AUTHENTICATION");
        el24.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el25 = (MobileElement) driver.findElementByAccessibilityId("Close tab");
        el25.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el26 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btLetGo");
        el26.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el27 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btSidMenu");
        el27.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el28 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout" +
                "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
                "/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup" +
                "/android.widget.LinearLayout/android.widget.TextView");
        el28.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el29 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btDelete");
        el29.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el30 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/txtPin");
        el30.sendKeys(pass1);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el31 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btLogin");
        el31.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el271 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btSidMenu");
        el271.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el32 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout" +
                "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
                "/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup" +
                "/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView" +
                "/androidx.appcompat.widget.LinearLayoutCompat[2]/android.widget.CheckedTextView");
        el32.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el33 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/txtUserName");
        el33.sendKeys(name);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el34 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/txtEmail");
        el34.sendKeys(email);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator("new UiScrollable("
                + "new UiSelector().scrollable(true)).scrollIntoView("
                + "new UiSelector().textContains(\"Passcode\"));");
        MobileElement el35 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btPassword");
        el35.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el36 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/txtOldPin");
        el36.sendKeys(pass1);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el37 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/txtNewPin");
        el37.sendKeys(pass2);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el38 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/txtConPin");
        el38.sendKeys(pass2);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el39 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btSave");
        el39.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el272 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btSideMenu");
        el272.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el282 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout" +
                "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
                "/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup" +
                "/android.widget.LinearLayout/android.widget.TextView");
        el282.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el292 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btDelete");
        el292.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el302 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/txtPin");
        el302.sendKeys(pass2);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el312 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btLogin");
        el312.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el273 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btSidMenu");
        el273.click();
        MobileElement el40 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout" +
                "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
                "/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup" +
                "/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView" +
                "/androidx.appcompat.widget.LinearLayoutCompat[3]/android.widget.CheckedTextView");
        el40.click();
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        driver.findElementByAndroidUIAutomator("new UiScrollable("
//                + "new UiSelector().scrollable(true)).scrollIntoView("
//                + "new UiSelector().textContains(\"Soundcloud\"));");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el274 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btSideMenu");
        el274.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el41 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/nav_contact");
        el41.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el275 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btSideMenu");
        el275.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el42 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout" +
                "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
                "/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup" +
                "/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView" +
                "/androidx.appcompat.widget.LinearLayoutCompat[5]/android.widget.CheckedTextView");
        el42.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        driver.findElementByAndroidUIAutomator("new UiScrollable("
//                + "new UiSelector().scrollable(true)).scrollIntoView("
//                + "new UiSelector().textContains(\"click\"));");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el276 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btSideMenu");
        el276.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el43 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/nav_invest");
        el43.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        MobileElement el44 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout" +
//                "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView" +
//                "/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout" +
//                "/android.widget.TextView");
//        el44.click();
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el45 = (MobileElement) driver.findElementById("android:id/button_once");
        el45.click();
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        driver.findElementByAndroidUIAutomator("new UiScrollable("
//                + "new UiSelector().scrollable(true)).scrollIntoView("
//                + "new UiSelector().textContains(\"hello@onbeatapp.com\"));");
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        MobileElement el46 = (MobileElement) driver.findElementByXPath("//android.webkit.WebView[@content-desc=" +
//                "\"INVEST IN ONBEAT - OnBeat\"]/android.view.View/android.view.View/android.widget.ListView" +
//                "/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]" +
//                "/android.widget.EditText");
//        el46.sendKeys(name);
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        MobileElement el47 = (MobileElement) driver.findElementByXPath("//android.webkit.WebView[@content-desc=" +
//                "\"INVEST IN ONBEAT - OnBeat\"]/android.view.View/android.view.View/android.widget.ListView" +
//                "/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]" +
//                "/android.widget.EditText");
//        el47.sendKeys(email);
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        MobileElement el48 = (MobileElement) driver.findElementByAccessibilityId("REGISTER INTEREST");
//        el48.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElementById("www.onbeatapps.com:id/btSideMenu").click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElementById("www.onbeatapps.com:id/navigation_map").click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el277 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btSideMenu");
        el277.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el287 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout" +
                "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
                "/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup" +
                "/android.widget.LinearLayout/android.widget.TextView");
        el287.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el297 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btDelete");
        el297.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el57 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btFogotPin");
        el57.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        MobileElement el58 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/spnCountry");
//        el58.click();
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el59 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/spnCountry");
        el59.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator("new UiScrollable("
                + "new UiSelector().scrollable(true)).scrollIntoView("
                + "new UiSelector().textContains(\"(+91) India\"));").click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el60 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/editPhone");
        el60.sendKeys(phone);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el61 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btNext");
        el61.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el62 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btConfirm");
        el62.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el63 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/txtPin");
        el63.sendKeys(pass3);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el64 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btConfirm");
        el64.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el65 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/txtPin");
        el65.sendKeys(pass3);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el66 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btConfirm");
        el66.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el67 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/txtPin");
        el67.sendKeys(pass3);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el68 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btLogin");
        el68.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el278 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btSidMenu");
        el278.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el328 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout" +
                "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
                "/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup" +
                "/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView" +
                "/androidx.appcompat.widget.LinearLayoutCompat[2]/android.widget.CheckedTextView");
        el328.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el49 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/txtulinkTicket");
        el49.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el50 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btYes");
        el50.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el51 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btYes");
        el51.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el52 = (MobileElement) driver.findElementById("www.onbeatapps.com:id/btNo");
        el52.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
