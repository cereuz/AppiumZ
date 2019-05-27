package com.utils;

/**
 * @author : zw
 * @email : zsky@live.com,
 * @date : 2019/5/20 13:47.
 * @motto : To be, or not to be.
 */
public class Constant {
    public static long ONE_SECOND = 1000;
    public static long TWO_SECOND = 2000;
    public static long THREE_SECOND = 3000;
    public static long FOUR_SECOND = 3000;
    public static long SIX_SECOND = 6000;
    public static long TEN_SECOND = 10 * 1000;
    public static long TWENTY_SECOND = 20 * 1000;

    public static int SWIPE_DURING = 3 * 1000;
    public static int SWIPE_SLEEP = 1 * 1000;
    /**
     * 机型区分
     *  1 ：魅族
     */
    public static int DEVICE = 1;

    public static String UDID_HUAWEI = "8RYBB18307505264";
    public static String UDID_HONOR = "CYSBBBE730206768";
    public static String UDID_MEIZU = "80SQBDQF2237K";


    /**
     * 下载安装包，更新提示url 和 下载文件url
     */
    public static String  apkUpdate = "https://coding.net/api/share/download/ff61ea71-517e-41c4-b688-7b08b832002d";
    public static String apkFile2 = "https://coding.net/api/share/download/59f0a880-e97c-419f-994d-cffd701d3f49";
    public static String apkFile1 = "http://coding-net-production-file-1257242599.cos.ap-shanghai.myqcloud.com/6912fe70-7ae6-11e9-ae11-bf9699f034ec.apk?sign=q-sign-algorithm%3Dsha1%26q-ak%3DAKIDay83lFmaS6Y4LTdzMVO1SdZOyJSNOYpr%26q-sign-time%3D1558400563%3B1558404163%26q-key-time%3D1558400563%3B1558404163%26q-header-list%3D%26q-url-param-list%3Dresponse-content-disposition%3Bresponse-expires%26q-signature%3Dd71002c96986ea646d968b5a26e8370028203b99&response-content-disposition=attachment%3Bfilename%3Dzouz.apk&response-expires=Thu%2C%2023%20May%202019%2013%3A02%3A43%20GMT";
    public static String apkFile = "https://raw.githubusercontent.com/cereuz/zouz/master/app/src/zouz.apk";
    public static String apkPackage = "com.zao.zouz";

    /**
     * 输入法区分
     */
//    public static String GOOGLE_INPUT = "adb shell ime set com.android.inputmethod.pinyin/.PinyinIME";
    public static String GOOGLE_INPUT = "adb shell ime set com.android.inputmethod.latin/.LatinIME";
    public static String APPIUM_INPUT = "adb shell ime set io.appium.android.ime/.UnicodeIME";
    public static String HUAWEI_INPUT = "adb shell ime set com.baidu.input_huawei/.ImeService";
    public static String MEIZU_INPUT = "adb shell ime set com.meizu.flyme.input/com.meizu.input.MzInputService";

    public static String HONOR_BACK = "adb shell input keyevent 66";


    public static String id_permission_message = "com.android.packageinstaller:id/permission_message";
    public static String id_permission_allow_button = "com.android.packageinstaller:id/permission_allow_button";

    public static String id_permission_message_honor_51 = "com.huawei.systemmanager:id/tv_hold_dialog_warning_message";
    public static String id_permission_allow_button_honor_51 = "com.huawei.systemmanager:id/btn_allow";
    public static String id_permission_hold_checkbox = "com.huawei.systemmanager:id/hold_checkbox";


}
