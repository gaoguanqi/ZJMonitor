package com.zcsp.zjmonitor.app.global;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.blankj.utilcode.util.Utils;
import com.jess.arms.base.delegate.AppLifecycles;
import com.jess.arms.utils.ArmsUtils;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.zcsp.zjmonitor.BuildConfig;
import com.zcsp.zjmonitor.utils.LogUtils;

import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Author：gaoguanqi
 * Time：  2018/9/28 下午4:20
 * Desc：  AppLifecyclesImpl
 */
public class AppLifecyclesImpl implements AppLifecycles {




    @Override
    public void attachBaseContext(Context base) {
         MultiDex.install(base);  //这里比 onCreate 先执行,常用于 MultiDex 初始化,插件化框架的初始化
    }

    @Override
    public void onCreate(Application application) {
        if (LeakCanary.isInAnalyzerProcess(application)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        if (BuildConfig.DEBUG) {//Timber初始化
            //Timber 是一个日志框架容器,外部使用统一的Api,内部可以动态的切换成任何日志框架(打印策略)进行日志打印
            //并且支持添加多个日志框架(打印策略),做到外部调用一次 Api,内部却可以做到同时使用多个策略
            //比如添加三个策略,一个打印日志,一个将日志保存本地,一个将日志上传服务器
            Timber.plant(new Timber.DebugTree());
            // 如果你想将框架切换为 Logger 来打印日志,请使用下面的代码,如想切换为其他日志框架请根据下面的方式扩展
//                    Logger.addLogAdapter(new AndroidLogAdapter());
//                    Timber.plant(new Timber.DebugTree() {
//                        @Override
//                        protected void log(int priority, String tag, String message, Throwable t) {
//                            Logger.log(priority, tag, message, t);
//                        }
//                    });
            ButterKnife.setDebug(true);
        }
        //LeakCanary 内存泄露检查
        //使用 IntelligentCache.KEY_KEEP 作为 key 的前缀, 可以使储存的数据永久存储在内存中
        //否则存储在 LRU 算法的存储空间中, 前提是 extras 使用的是 IntelligentCache (框架默认使用)

        ArmsUtils.obtainAppComponentFromContext(application).extras()
                .put(RefWatcher.class.getName(),
                BuildConfig.DEBUG ? LeakCanary.install(application) : RefWatcher.DISABLED);

        initUtils(application);
        initUpdate(application);
    }


    private void initUpdate(Application application) {
//        XUpdate.get()
//                .debug(true) //开启debug模式，可用于问题的排查
//                .isWifiOnly(true)     //默认设置只在wifi下检查版本更新
//                .isGet(true)          //默认设置使用get请求检查版本
//                .isAutoMode(false)    //默认设置非自动模式，可根据具体使用配置
////                .param("VersionCode", UpdateUtils.getVersionCode(application)) //设置默认公共请求参数
////                .param("AppKey", getPackageName())
//                .setOnUpdateFailureListener(new OnUpdateFailureListener() { //设置版本更新出错的监听
//                    @Override
//                    public void onFailure(UpdateError error) {
//                        ToastUtil.showToast(error.toString());
//                    }
//                })
//                .setIUpdateHttpService(new OKHttpUpdateHttpService()) //这个必须设置！实现网络请求功能。
//                .init(application);   //这个必须初始化
    }

    private void initUtils(Application application) {
        Utils.init(application);
    }

    @Override
    public void onTerminate(Application application) {
        LogUtils.logGGQ("app onTerminate");
    }
}
