package com.zcsp.zjmonitor.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.jess.arms.utils.ArmsUtils;
import com.zcsp.zjmonitor.R;
import com.zcsp.zjmonitor.app.base.BaseActivity;

public class SplashActivity extends BaseActivity {


    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_splash;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        startActivity(new Intent(this,LoginActivity.class));
        this.finish();
    }
}
