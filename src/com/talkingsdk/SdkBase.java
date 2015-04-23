package com.talkingsdk;

import com.talkingsdk.models.LoginData;
import com.talkingsdk.models.PayData;

import android.app.Activity;
import android.app.Application;

public interface SdkBase{
    public enum LoginCode {
        Success, Cancel, Failure, GuestLogined
    };
    public enum PayCode {
        Success, Processing, Cancel, Failure, SmsSent, Submitted
    };
	// 初始化全局数据，早于所有的UI和业务之前
	public void onApplicationCreate(Application app);
	public void onAppTerminate();

	// 在initSdk之后，由android.intent.action.MAIN 在OnCreate调用初始化UI方面的工作，比如91可以初试悬浮条
	public void onActivityCreate(Activity mainActivity);
	public void onActivityDestroy();
	// 在C++中调用，实现显示平台（比如91）的登录界面
	public void login();
	// 在C++中调用，实现登出平台
	public void logout();
	// 在C++中调用，实现显示平台（比如91）的支付界面
	public void pay(PayData payData);
	// 在C++中调用，实现显示平台（比如91）的登录界面
	public void changeAccount();
	// 在登录成功以后，有关登录的数据（username,sessionid)等存储在LoginData对象里，该函数获取LoginData实例对象
	public LoginData getLoginData();
	public void setLoginData(LoginData ld);
	public PayData getPayData();
	public void setPayData(PayData pd);
    //设置切换账号时是否重新启动
    public void setRestartWhenSwitchAccount(boolean restart);
    //
    public LoginCode getLoginCode();
    // 游戏进入前台
    public void onGameResume();
    // 游戏进入后台
    public void onGameFade();
    // 监听back键
    public void onKeyBack();

    public String getPlatformId();
}
