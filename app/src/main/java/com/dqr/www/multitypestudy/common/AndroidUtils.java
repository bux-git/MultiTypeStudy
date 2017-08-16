/*
 * Copyright (c) 2015.
 * 湖南球谱科技有限公司版权所有
 * Hunan Qiupu Technology Co., Ltd. all rights reserved.
 */

package com.dqr.www.multitypestudy.common;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 作者：Zhou
 * 日期：2015-10-13 上午10:30:43
 * 版权：地球人
 * 描述：（）
 */

public class AndroidUtils {

    /**
     * 获取屏幕的像素密度 <br/>
     *
     * @param [cx]-[上下文对象] <br/>
     * @return 屏幕像素密度
     */
    public static float getDeviceDisplayDensity(Context cx) {
        DisplayMetrics dm = new DisplayMetrics();
        dm = cx.getApplicationContext().getResources().getDisplayMetrics();
        return dm.density;
    }

    /**
     * 获取屏幕的宽度 <br/>
     *
     * @param [cx]-[上下文对象] <br/>
     * @return 屏幕宽度（单位px）
     */
    public static float getDeviceWidth(Context cx) {
        DisplayMetrics dm = new DisplayMetrics();
        dm = cx.getApplicationContext().getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    /**
     * 获取屏幕的高度 <br/>
     *
     * @param [cx]-[上下文对象] <br/>
     * @return 屏幕高度（单位px）
     */
    public static float getDeviceHight(Context cx) {
        DisplayMetrics dm = new DisplayMetrics();
        dm = cx.getApplicationContext().getResources().getDisplayMetrics();
        return dm.heightPixels;
    }

    /**
     * 获取屏幕的像素密度 ,一般情况下与density相同，字体大小转换时会有相应的变化，所以一般转换字体大小使用scaledDensity<br/>
     *
     * @param [cx]-[上下文对象] <br/>
     * @return 屏幕宽度（单位px）
     */
    public static float getDeviceScaledDensity(Context cx) {
        DisplayMetrics dm = new DisplayMetrics();
        dm = cx.getApplicationContext().getResources().getDisplayMetrics();
        return dm.scaledDensity;
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param cx
     * @param spValue
     * @return
     */
    public static int sp2px(Context cx, float spValue) {
        DisplayMetrics dm = new DisplayMetrics();
        dm = cx.getApplicationContext().getResources().getDisplayMetrics();
        return (int) (spValue * dm.scaledDensity + 0.5f);
    }

    /**
     * 将dp值转换为px值，保证文字大小不变
     *
     * @param cx
     * @param dipValue
     * @return
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 将px值转换为dp值，保证文字大小不变
     *
     * @param cx
     * @param pxValue
     * @return
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 获取安装包信息
     *
     * @param context     上下文
     * @param packageName 包名
     */
    public static PackageInfo getPackageInfo(Context context, String packageName) {
        List<PackageInfo> installedPackageList = context.getPackageManager()
                .getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);
        if (installedPackageList == null) {
            return null;
        }

        for (PackageInfo packageInfo : installedPackageList) {
            if ((null != packageInfo) && (null != packageInfo.packageName)
                    && packageInfo.packageName.equals(packageName)) {
                return packageInfo;
            }
        }

        return null;
    }

    /**
     * 获取软件版本号
     *
     * @param context
     * @return 获取应用版本号
     */
    public static int getVersionCode(Context context) {
        return getPackageInfo(context, context.getPackageName()).versionCode;
    }

    /**
     * 获取应用版本名
     *
     * @param context
     * @return 应用的版本名称
     */
    public static String getVersionName(Context context) {
        return getPackageInfo(context, context.getPackageName()).versionName;
    }

    /**
     * 检测GPS是否开启
     *
     * @param context
     * @return
     */
    public static boolean isGpsEnable(Context context) {
        LocationManager locationManager = ((LocationManager) context
                .getSystemService(Context.LOCATION_SERVICE));
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    /**
     * 判断网络是否可用
     *
     * @param mContext 上下文对象
     * @return 是否存在可用的网络
     */
    public static boolean isNetworkAvailable(Context mContext) {
        boolean isAvailable = false;
        final ConnectivityManager cm = (ConnectivityManager) mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (null != cm) {
            final NetworkInfo[] netinfo = cm.getAllNetworkInfo();
            if (null != netinfo) {
                for (int i = 0; i < netinfo.length; i++) {
                    if (netinfo[i].isConnected()) {
                        isAvailable = true;
                    }
                }
            }
        }
        return isAvailable;
    }

    /**
     * 判断当前网络是否为wifi
     *
     * @param mContext 上下文
     * @return boolean 网络为wifi返回真
     */
    public static boolean isWifi(Context mContext) {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetInfo != null
                && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            return true;
        }
        return false;
    }

    /**
     * 检测手机号码格式
     *
     * @param mobiles 手机号
     * @return 是否为手机号
     */
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern
                .compile("^((13[0-9])|(14[0-9])|(15[0-9])|(18[0-9])|(17[0-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);

        return m.matches();
    }

    /**
     * long类型时间格式化
     */
    public static String convertToTime(long time) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        return df.format(date);
    }

    /**
     * long类型时间格式化
     */
    public static String convertToTime(long time, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        Date date = new Date(time);
        return df.format(date);
    }

    /**
     * 判定SD卡是否挂载
     */
    public static boolean checkSdcardMounted() {
        return android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED);
    }

    /*
     * 截取URL文件地址
     */
    public static String getDownloadImgOrAudioName(String url) {
        if (url == null) {
            return url;
        }

        String[] urlArray = url.split("/");
        return urlArray[urlArray.length - 1];
    }

    /*
     * 设置录音长度
     */
    public static long setAudioLength(long audioSize, long max, long min) {
        if (audioSize <= 1) {
            return min;
        } else if (audioSize >= 60) {
            return max;
        }

        return ((max - min) * audioSize) / 59 + min;
    }

    /*
     * 截取URL地址路径
     */
    public static String getDownloadImgOrAudioURL(String url) {
        if (url == null) {
            return url;
        }

        if (url.startsWith("http") || url.startsWith("https")) {
            String[] urlArray = url.split("/");
            return "/" + url.substring(url.indexOf(urlArray[3]));
        }

        return url;
    }

    /*
     * 关闭软键盘
     */
    public static void closeKeyboard(Activity activity) {
        final View vInput = activity.getWindow().peekDecorView();

        if (vInput != null && vInput.getWindowToken() != null) {
            InputMethodManager imm = (InputMethodManager) activity
                    .getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(vInput.getWindowToken(), 0);
        }
    }


    // 将传入时间与当前时间进行对比，是否今天昨天
    public static String getTime(Date date) {
        String todySDF = "今天 HH:mm";
        String yesterDaySDF = "昨天 HH:mm";
        String otherSDF = "M月d日 HH:mm";
        SimpleDateFormat sfd = null;
        String time = "";
        Calendar dateCalendar = Calendar.getInstance();
        dateCalendar.setTime(date);
        Date now = new Date();
        Calendar targetCalendar = Calendar.getInstance();
        targetCalendar.setTime(now);
        targetCalendar.set(Calendar.HOUR_OF_DAY, 0);
        targetCalendar.set(Calendar.MINUTE, 0);
        if (dateCalendar.after(targetCalendar)) {
            sfd = new SimpleDateFormat(todySDF);
            time = sfd.format(date);
            return time;
        } else {
            targetCalendar.add(Calendar.DATE, -1);
            if (dateCalendar.after(targetCalendar)) {
                sfd = new SimpleDateFormat(yesterDaySDF);
                time = sfd.format(date);
                return time;
            }
        }
        sfd = new SimpleDateFormat(otherSDF);
        time = sfd.format(date);
        return time;
    }

    // 获取手机号码
    public static String getPhoneName(Context context) {
        String mobileNum = "";
        TelephonyManager phoneMgr = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        if (phoneMgr == null) {
            return mobileNum;
        }
        mobileNum = phoneMgr.getLine1Number();
        if (TextUtils.isEmpty(mobileNum)) {
            return mobileNum;
        }

        // 去掉“+86”
        if (mobileNum.startsWith("+86")) {
            mobileNum = mobileNum.replace("+86", "");
        }

        // 判断是否为合法手机号，不是则返回空
        if (!isMobileNO(mobileNum)) {
            mobileNum = "";
        }

        return mobileNum;
    }

    // ScrollView中嵌套Gridview， 代码中的columns，代表gridview 有columns列
    public static void setGridViewHeightBasedOnChildren(GridView gridView,
                                                        int columns, int vSpace, int padding) {
        ListAdapter listAdapter = gridView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }
        int totalHeight = 0;
        int hang = 0;
        if ((gridView.getCount() % columns) == 0) {

            hang = gridView.getCount() / columns;
        } else {
            hang = gridView.getCount() / columns + 1;
        }
        for (int i = 0; i < hang; i++) {
            View listItem = listAdapter.getView(i, null, gridView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        if (hang > 1) {
            totalHeight += vSpace * (hang - 1);
        }

        totalHeight += padding;
        ViewGroup.LayoutParams params = gridView.getLayoutParams();
        params.height = totalHeight;
        gridView.setLayoutParams(params);
    }

    // 在scrollView中嵌套ListView
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        // 获取ListView对应的Adapter
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) { // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0); // 计算子项View 的宽高
            totalHeight += listItem.getMeasuredHeight(); // 统计所有子项的总高度
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }


    /*
     * 判断是否有表情字符
     */
    public static boolean checkSpecialCharacter(String c) {
        if (TextUtils.isEmpty(c)) {
            return false;
        }

        for (int i = 0; i < c.length(); i++) {
            Character mChar = c.charAt(i);

            byte[] b = mChar.toString().getBytes();

            try {
                if (b[0] == -16 && b[1] == -97 && b[2] == -104 || b[0] == 63) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    /**
     * 获取imei
     *
     * @param context 上下文
     * @return String imei号
     */
    public static String getImei(Context context) {
        ContentResolver resolver = context.getContentResolver();
        String imei = Settings.System.getString(resolver, "device_imei");

        // 如果本地未保存，则获取手机设备ID
        if (TextUtils.isEmpty(imei)) {
            try {
                TelephonyManager tm = (TelephonyManager) context
                        .getSystemService(Context.TELEPHONY_SERVICE);
                imei = tm.getDeviceId();
                Settings.System.putString(resolver, "device_imei", imei);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 如无法获取设备ID则生成一个UUID
        if (TextUtils.isEmpty(imei)) {
            imei = UUID.randomUUID().toString();
            imei = imei.replace("-", "");
            Settings.System.putString(resolver, "device_imei", imei);
        }
        return imei;
    }

    /**
     * 将手机号中间四位隐藏 ，已****代替<br/>
     *
     * @param [numStr]-[原手机号] <br/>
     * @param [参数2]-[参数2说明]   <br/>
     */
    public static String getHideMobileNum(String numStr) {
        String numberString = "";
        if (TextUtils.isEmpty(numStr)) {
            return numberString;
        }

        if (numStr.length() == 11) {
            numberString = numStr.substring(0, 3) + "****"
                    + numStr.substring(7, numStr.length());
        }
        return numberString;
    }


    /**
     * 判断Task的栈顶Activity是否为本程序的
     *
     * @param context 环境
     */
    public static boolean isOwnerActivity(Context context) {
        PackageInfo info;
        try {
            info = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0);
            return getTopActivity(context).equals(info.packageName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 获取Task的栈顶Activity所在的包名
     *
     * @param context 环境
     */
    public static String getTopActivity(Context context) {
        ActivityManager manager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningTaskInfo> runningTaskInfos = manager.getRunningTasks(1);
        String packageName = null;
        if (null != runningTaskInfos) {
            packageName = runningTaskInfos.get(0).topActivity.getPackageName();
        }

        return packageName;
    }

    /**
     * 检测某Activity是否在当前Task的栈顶
     *
     * @param context  环境
     * @param activity Activity名
     * @return boolean 在栈顶返回真
     */
    public static boolean isTopActivy(Context context, String activity) {
        ActivityManager manager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningTaskInfo> runningTaskInfos = manager.getRunningTasks(1);
        String nameTemp = null;
        if (null != runningTaskInfos) {
            nameTemp = runningTaskInfos.get(0).topActivity.getClassName();
        }

        if (null == nameTemp) {
            return false;
        }

        return nameTemp.equals(activity);
    }

    /**
     * 获取咨询发布的时间差 <br/>
     *
     * @param [publishTime]-[参数1说明] <br/>
     * @param [参数2]-[参数2说明]         <br/>
     */
    public static String getConsultTime(long publishTime, long nowTime) {
        String timeStr = "";
        long time = nowTime - publishTime;
        if (time < 0) {
            timeStr = "";
        } else {
            // 分钟
            if (time < 60 * 1000l) {
                timeStr = "刚刚";
            } else if (time < 60 * 60 * 1000l) {
                long min = time / (60 * 1000l);
                timeStr = min + "分钟前";
            } else if (time < 24 * 60 * 60 * 1000l) {
                long hourCount = time / (60 * 60 * 1000l);
                timeStr = hourCount + "小时前";
            } else {
                timeStr = new SimpleDateFormat("MM月dd日", Locale.US)
                        .format(publishTime);
            }
        }
        return timeStr;
    }

    /**
     * 判断两个时间戳是否在同一天
     */
    public static boolean isSameDate(long publishTime, long nowTime) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Date pDate = new Date(publishTime);
        Date nowDate = new Date(nowTime);
        if (format.format(pDate).equals(format.format(nowDate))) {
            return true;
        }
        return false;
    }

    /**
     * bitmap转为base64
     *
     * @param bitmap
     * @return
     */
    public static String bitmapToBase64(Bitmap bitmap) {
        String result = null;
        ByteArrayOutputStream baos = null;
        try {
            if (bitmap != null) {
                baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);

                baos.flush();
                baos.close();

                byte[] bitmapBytes = baos.toByteArray();
                result = Base64.encodeToString(bitmapBytes, Base64.NO_WRAP);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * base64转为bitmap
     *
     * @param base64Data
     * @return
     */
    public static Bitmap base64ToBitmap(String base64Data) {
        byte[] bytes = Base64.decode(base64Data, Base64.NO_WRAP);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }


    /**
     * isEmail(判断是否是邮箱)
     *
     * @param email
     * @return boolean
     * @throws
     */
    public static boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);

        return m.matches();
    }

    /**
     * 校验银行卡卡号
     *
     * @param cardId
     * @return
     */
    public static boolean checkBankCard(String cardId) {
        char bit = getBankCardCheckCode(cardId.substring(0, cardId.length() - 1));
        if (bit == 'N') {
            return false;
        }
        return cardId.charAt(cardId.length() - 1) == bit;
    }

    /**
     * 从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位
     *
     * @param nonCheckCodeCardId
     * @return
     */
    public static char getBankCardCheckCode(String nonCheckCodeCardId) {
        if (nonCheckCodeCardId == null || nonCheckCodeCardId.trim().length() == 0
                || !nonCheckCodeCardId.matches("\\d+")) {
            //如果传的不是数据返回N
            return 'N';
        }
        char[] chs = nonCheckCodeCardId.trim().toCharArray();
        int luhmSum = 0;
        for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
            int k = chs[i] - '0';
            if (j % 2 == 0) {
                k *= 2;
                k = k / 10 + k % 10;
            }
            luhmSum += k;
        }
        return (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
    }

    /**
     * 判断当前是否为主线程
     * @return
     */
    public static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

}
