package com.zou;

import com.utils.Constant;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author : zw
 * @email : zsky@live.com,
 * @date : 2019/5/27 9:27.
 * @motto : To be, or not to be.
 */
public class ConstantZou {

    public static String FRAGMENT_HOME = "com.zao.zouz:id/rl_home";
    public static String FRAGMENT_STATUS = "com.zao.zouz:id/rl_status";
    public static String FRAGMENT_GROUP = "com.zao.zouz:id/rl_group";
    public static String FRAGMENT_PROFILE = "com.zao.zouz:id/rl_profile";

    /**
     * 荣耀手机，Honor-7C
     * @return
     */
    public static DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Honor-7C");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.PLATFORM, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
        capabilities.setCapability("appPackage", Constant.apkPackage);
        capabilities.setCapability("appActivity","com.zao.activity.BubbleActivity");// 被测app的Activity类
        return capabilities;
    }
}
