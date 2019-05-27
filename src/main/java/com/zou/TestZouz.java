package com.zou;

import com.utils.AppiumUtil;
import com.utils.Constant;
import com.utils.LogZ;
import com.utils.TestUtils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author : zw
 * @email : zsky@live.com,
 * @date : 2019/5/27 9:24.
 * @motto : To be, or not to be.
 */
public class TestZouz {
    static AndroidDriver driver = null;

    public TestZouz() {

    }

    public static void under(){
        DesiredCapabilities capabilities = ConstantZou.getDesiredCapabilities();

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        LogZ.error("已打开");
        TestUtils.testSleep(Constant.TEN_SECOND);
        TestUtils.checkPermission(driver,true);

        for (int i = 0 ; i < 3; i++){
            AppiumUtil.click(driver, By.id(ConstantZou.FRAGMENT_HOME));
            TestUtils.swipeToLeft(driver,Constant.TWO_SECOND,3);
            TestUtils.swipeToRight(driver,Constant.TWO_SECOND,3);

            AppiumUtil.click(driver, By.id(ConstantZou.FRAGMENT_GROUP));
            TestUtils.swipeToUp(driver,Constant.TWO_SECOND,3);
            TestUtils.swipeToDown(driver,Constant.TWO_SECOND,3);

            AppiumUtil.click(driver, By.id(ConstantZou.FRAGMENT_STATUS));
            TestUtils.swipeToLeft(driver,Constant.TWO_SECOND,3);
            TestUtils.swipeToRight(driver,Constant.TWO_SECOND,3);

            AppiumUtil.click(driver, By.id(ConstantZou.FRAGMENT_PROFILE));
            TestUtils.swipeToUp(driver,Constant.TWO_SECOND,3);
            TestUtils.swipeToDown(driver,Constant.TWO_SECOND,3);
        }


    }
}
