package com.talkingsdk;

import org.cocos2dx.lib.Cocos2dxActivity;

import android.os.Bundle;

// 匹配类似qihoo的sdk
public class Cocos2dxBaseActivity extends Cocos2dxActivity {
    static Cocos2dxBaseActivity _instance = null;
    
    public static Cocos2dxBaseActivity getInstance() {
        return _instance;
    }
    
    public static void clearInstance() {
        _instance = null;
    }
    
    protected void onCreate(Bundle savedInstanceState) {
        _instance = this;
        super.onCreate(savedInstanceState);
//        if (getIntent().getAction() == "android.intent.action.MAIN") {
//            MainApplication.getInstance().getSdkInstance()
//                    .onActivityCreate(this);
//        }
    }
    
    public void destroyToorBar() {}
    
    @Override
    protected void onResume() {
        super.onResume();
        MainApplication.getInstance().getSdkInstance().onGameResume();
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        MainApplication.getInstance().getSdkInstance().onGameFade();
    }
}