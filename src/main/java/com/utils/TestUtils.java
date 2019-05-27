package com.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author : zw
 * @email : zsky@live.com,
 * @date : 2019/5/20 13:39.
 * @motto : To be, or not to be.
 */
public class TestUtils {

    public static AndroidDriver driver;
    /**
     * 初始化驱动连接设备，启动APP， 检查权限
     * @param deviceName
     * @param automationName
     * @param platformName
     * @param platformVersion
     * @param appPackage
     * @param appActivity
     * @param noReset
     * @return
     */
    public static AndroidDriver initDevice(String deviceName,String udid ,String automationName, String platformName, String platformVersion, String appPackage, String appActivity, boolean noReset,String urlPort) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("udid", udid);
        capabilities.setCapability("automationName", automationName);
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("platformVersion", platformVersion);
//        capabilities.setCapability("platformVersion", "5.1");
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        capabilities.setCapability("unicodeKeyboard", "true"); //Appium版本1.3.3以上，解决无法输入中文问题  使用unicode编码
        capabilities.setCapability("resetKeyboard", "true"); //在关闭后重置设备的默认输入法
        capabilities.setCapability("noReset", noReset); //不需要再次安装

        LogZ.debug("startAPP");
        LogZ.info(capabilities.toString() +"== Init and Connect Device , start APP. SUCCESS ==");
        try {
            driver = new AndroidDriver(new URL(urlPort), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            LogZ.error("MalformedURLException ：初始化 driver 失败。"  );
        }


        TestUtils.testSleep(Constant.TEN_SECOND);
        TestUtils.checkPermission(driver,true);
        LogZ.info("check Permissions And Allow it , SUCCESS");
        TestUtils.testSleep(Constant.TWO_SECOND);
        return driver;
    }

    /**
     * 测试间隔的时候睡眠时间。单位：毫秒。
     * @param time
     */
    public static void testSleep(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 上滑
     *
     * @param driver
     * @param during
     * @param num
     */
    public static void swipeToUp(AppiumDriver<WebElement> driver, long during, int num) {
        try {
            AppiumUtil.before(driver);
            Dimension size = driver.manage().window().getSize();
            int height = size.height;
            int width = size.width;
            LogZ.info("【swipeToUp】 屏幕尺寸：" + "宽=" + width + "，高=" + height);
            for (int i = 0; i < num; i++) {
                new TouchAction(driver)
                        .longPress(PointOption.point(width / 2, height - 300))
                        .moveTo(PointOption.point(width / 2, 300)).release().perform();
                testSleep(during);
            }
        } catch (WebDriverException exception){
            LogZ.error("WebDriverException : 滑动屏幕--等待时间过长。操作失败");
        }
    }


    /**
     * 上滑到屏幕指定比例的位置
     * 注意：安卓的屏幕坐标原点是屏幕的左上角。
     * @param driver   驱动
     * @param during   停顿时间
     * @param num      重复操作的次数
     * @param divide   将屏幕高度切割的份数
     * @param to       滑动屏幕到对应份数的位置
     */
    public static void swipeToUp(AppiumDriver<WebElement> driver,int during, int num,int divide,int to) {
        try {
            AppiumUtil.before(driver);
            Dimension size = driver.manage().window().getSize();
            int height = size.height;
            int width = size.width;
            int yoff = height / divide * to;
            LogZ.info("【swipeToUp】 屏幕尺寸：" + "宽=" + width + "，高=" + height);
            for (int i = 0; i < num; i++) {
                new TouchAction(driver)
                        .longPress(PointOption.point(width / 2, height - 300))
                        .moveTo(PointOption.point(width / 2, yoff)).release().perform();
                testSleep(during);
                LogZ.debug(yoff + "=" + (height - 300) + "=" + yoff);
            }
        } catch (WebDriverException exception){
            LogZ.error("WebDriverException : 滑动屏幕--等待时间过长。操作失败");
        }
    }

    /**
     * 下拉
     *
     * @param driver
     * @param during
     * @param num
     */
    public static void swipeToDown(AppiumDriver<WebElement> driver,long during, int num) {
        try {
            AppiumUtil.before(driver);
            Dimension size = driver.manage().window().getSize();
            int height = size.height;
            int width = size.width;
            LogZ.info("【swipeToDown】 屏幕尺寸：" + "宽=" + width + "，高=" + height);
            for (int i = 0; i < num; i++) {
                new TouchAction(driver).longPress(PointOption.point(width / 2, 300))
                        .moveTo(PointOption.point(width / 2, height - 300)).release()
                        .perform();
                testSleep(during);
            }
        } catch (WebDriverException exception){
            LogZ.error("WebDriverException : 滑动屏幕--等待时间过长。操作失败");
        }
    }


    /**
     * 向下滑到屏幕指定比例的位置
     * 注意：安卓的屏幕坐标原点是屏幕的左上角。
     * @param driver   驱动
     * @param during   停顿时间
     * @param num      重复操作的次数
     * @param divide   将屏幕高度切割的份数
     * @param to       滑动屏幕到对应份数的位置
     */
    public static void swipeToDown(AppiumDriver<WebElement> driver,int during, int num,int divide,int to) {
        try {
            AppiumUtil.before(driver);
            Dimension size = driver.manage().window().getSize();
            int height = size.height;
            int width = size.width;
            int yoff = height / divide * to;
            LogZ.info("【swipeToDown】 屏幕尺寸：" + "宽=" + width + "，高=" + height);
            for (int i = 0; i < num; i++) {
                new TouchAction(driver).longPress(PointOption.point(width / 2, 300))
                        .moveTo(PointOption.point(width / 2, yoff)).release()
                        .perform();
                testSleep(during);
            }
        } catch (WebDriverException exception){
            LogZ.error("WebDriverException : 滑动屏幕--等待时间过长。操作失败");
        }
    }

    /**
     * 向左滑动
     *
     * @param driver
     * @param during
     * @param num
     */
    public static void swipeToLeft2(AppiumDriver<WebElement> driver,long during, int num) {
        try {
            AppiumUtil.before(driver);
            Dimension size = driver.manage().window().getSize();
            int height = size.height;
            int width = size.width;
            LogZ.info("【swipeToLeft】 屏幕尺寸：" + "宽=" + width + "，高=" + height);
            for (int i = 0; i < num; i++) {
                new TouchAction(driver)
                        .longPress(PointOption.point(width - 200, height / 2))
                        .moveTo(PointOption.point(200, height / 2)).release().perform();
                testSleep(during);
            }
        } catch (WebDriverException exception){
            LogZ.error("WebDriverException : 滑动屏幕--等待时间过长。操作失败");
        }
    }

    /**
     * 向右滑动
     *
     * @param driver
     * @param during
     * @param num
     */
    public static void swipeToRight2(AppiumDriver<WebElement> driver, long during, int num) {
        try {
            AppiumUtil.before(driver);
            Dimension size = driver.manage().window().getSize();
            int height = size.height;
            int width = size.width;
            LogZ.info("【swipeToRight】 屏幕尺寸：" + "宽=" + width + "，高=" + height);
            for (int i = 0; i < num; i++) {
                new TouchAction(driver).longPress(PointOption.point(200, height / 2))
                        .moveTo(PointOption.point(width - 200, height / 2)).release()
                        .perform();
                testSleep(during);
            }
        } catch (WebDriverException exception){
            LogZ.error("WebDriverException : 滑动屏幕--等待时间过长。操作失败");
        }
    }

    /**
     * 向左滑动
     *
     * @param driver
     * @param during
     * @param num
     */
    public static void swipeToLeft(AppiumDriver<WebElement> driver, long during, int num) {
        try {
            AppiumUtil.before(driver);
            Dimension size = driver.manage().window().getSize();
            int height = size.height;
            int width = size.width;
            LogZ.info("【swipeToLeft】 屏幕尺寸：" + "宽=" + width + "，高=" + height);
            for (int i = 0; i < num; i++) {
                new TouchAction(driver)
                        .longPress(PointOption.point(width * 7 / 8, height / 2))
                        .moveTo(PointOption.point(width / 8, height / 2))
                        .release()
                        .perform();
                testSleep(during);
            }
        } catch (WebDriverException exception){
            LogZ.error("WebDriverException : 滑动屏幕--等待时间过长。操作失败");
        }
    }

    /**
     * 向右滑动
     *
     * @param driver
     * @param during
     * @param num
     */
    public static void swipeToRight(AppiumDriver<WebElement> driver, long during, int num) {
        try {
            AppiumUtil.before(driver);
            Dimension size = driver.manage().window().getSize();
            int height = size.height;
            int width = size.width;
            LogZ.info("【swipeToRight】 屏幕尺寸：" + "宽=" + width + "，高=" + height);
            for (int i = 0; i < num; i++) {
                new TouchAction(driver).longPress(PointOption.point(width / 8, height / 2))
                        .moveTo(PointOption.point(width * 7 / 8, height / 2))
                        .release()
                        .perform();
                testSleep(during);
            }
        } catch (WebDriverException exception){
            LogZ.error("WebDriverException : 滑动屏幕--等待时间过长。操作失败");
        }
    }

    /**
     * 检测获取系统权限的弹框，并点击确认
     * @param driver
     */
    public static void checkPermission(AndroidDriver driver,Boolean isToCheck) {
        if (AppiumUtil.isExist(driver, By.id(Constant.id_permission_allow_button))) {
            WebElement elementPermission = driver.findElementById(Constant.id_permission_allow_button);
            while (isToCheck && elementPermission != null) {
                if (AppiumUtil.isExist(driver, By.id(Constant.id_permission_allow_button))) {
                    LogZ.debug("同意权限 ：" + AppiumUtil.getText(driver, By.id(Constant.id_permission_message)));
                    elementPermission.click();
                    TestUtils.testSleep(Constant.TWO_SECOND);
                } else {
                    isToCheck = false;
                    LogZ.error("已同意需要的全部权限");
                }
            }
        }  else {
            LogZ.error("路过哦");
        }
    }


    /**
     * 执行adb命令
     * @param s 要执行的命令
     */
    public static void excuteAdbShell(String s) {
        Runtime runtime=Runtime.getRuntime();
        try{
            runtime.exec(s);
        }catch(Exception e){
            LogZ.info("执行命令:"+s+"出错");
        }
    }

    /**
     * 卸载 APPIUM的 输入法
     */
    public static void uninstallAppiumInput(){
        driver.removeApp("io.appium.android.ime");
        LogZ.info("REMOVE  io.appium.android.ime");
    }


    /**
     * 返回 0 到 10之间的整数
     */
    public static int randomTen() {
        return (int) (Math.random() * 10);
    }

    /**
     *  ×× 返回 0 到 10之间的整数
     *  ×× 集合和数组都是从序号 0 开始取值。
     */
    public static int random(int i) {
        return (int) (Math.random() * i);
    }

    @Test
    public void test(){
        System.out.println(TestUtils.random(8));
    }
}
