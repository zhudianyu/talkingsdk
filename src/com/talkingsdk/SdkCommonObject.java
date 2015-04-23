package com.talkingsdk;

import java.util.List;
import java.util.Properties;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;

import com.talkingsdk.models.LoginData;
import com.talkingsdk.models.PayData;

public abstract class SdkCommonObject implements SdkBase, RequestBase {

    private Activity _parentActivity;
    private LoginData _loginData;
    private PayData _payData;

    public Activity getParentActivity() {
        return this._parentActivity;
    }

    public void onActivityCreate(Activity parentActivity) {
        this._parentActivity = parentActivity;
    }

    @Override
    public LoginData getLoginData() {
        return _loginData;
    }

    @Override
    public void setLoginData(LoginData ld) {
        _loginData = ld;
    }

    @Override
    public PayData getPayData() {
        return _payData;
    }

    @Override
    public void setPayData(PayData ld) {
        _payData = ld;
    }

    @Override
    public String getPlatformId() {
        return getPropertiesByKey("TKSDKPLATFORMID");
    }

    // read parameters from appConfig file
    public String getPropertiesByKey(String key) {
        String url = null;
        Properties properties = new Properties();
        try {
            properties.load(_parentActivity.getAssets().open("appConfig.properties"));
            url = properties.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    public boolean isAppOnForeground() {
        ActivityManager activityManager = (ActivityManager) MainApplication
                .getInstance().getSystemService(Context.ACTIVITY_SERVICE);
        String packageName = MainApplication.getInstance().getPackageName();
        List<RunningAppProcessInfo> appProcesses = activityManager
                .getRunningAppProcesses();
        if (appProcesses == null)
            return false;
        for (RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(packageName)
                    && appProcess.importance == RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return true;
            }
        }
        return false;
    }

    public void clearInstances() {
        Cocos2dxBaseActivity.clearInstance();
        StartBaseActivity.clearInstance();
    }
}
