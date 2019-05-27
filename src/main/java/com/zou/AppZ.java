package com.zou;

import com.utils.Constant;
import com.utils.LogZ;
import com.utils.TestUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author : zw
 * @email : zsky@live.com,
 * @date : 2019/5/20 13:38.
 * @motto : To be, or not to be.
 */
public class AppZ {

    /**
     * Appium Desktop  ： Version 1.13.0
     */
    @Test
    public static void testZ(){
/*        installAPP();
        startAPP();*/
        TestZouz.under();
    }

    /**
     * 从网上链接下载安装包，并安装APP
     */
    @Test
    public static void installAPP(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Honor-7C");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.PLATFORM, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
        capabilities.setCapability(MobileCapabilityType.APP, Constant.apkFile); //文件下载和安装

        AndroidDriver driver = null;
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        LogZ.error("安装完成");
        TestUtils.testSleep(Constant.TEN_SECOND);
        TestUtils.checkPermission(driver,true);
    }

    /**
     * 启动APP
     */
    @Test
    public static void startAPP(){
        DesiredCapabilities capabilities = ConstantZou.getDesiredCapabilities();

        AndroidDriver driver = null;
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        LogZ.error("已打开");
        TestUtils.testSleep(Constant.TEN_SECOND);
        TestUtils.checkPermission(driver,true);
    }


}
