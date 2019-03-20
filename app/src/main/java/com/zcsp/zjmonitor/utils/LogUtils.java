package com.zcsp.zjmonitor.utils;

import android.util.Log;

/**
 * author: gaogq
 * time: 2019/3/19 15:17
 * description:
 */
public class LogUtils {
    private LogUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static boolean isShow = false;

    public static void logGGQ(String msg){
        if(isShow){
            Log.i("GGQ", msg);
        }
    }
}
