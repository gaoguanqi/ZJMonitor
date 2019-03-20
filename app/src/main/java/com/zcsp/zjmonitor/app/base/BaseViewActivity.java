package com.zcsp.zjmonitor.app.base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jess.arms.integration.cache.Cache;
import com.jess.arms.integration.cache.CacheType;
import com.jess.arms.integration.lifecycle.ActivityLifecycleable;
import com.jess.arms.mvp.IPresenter;
import com.jess.arms.utils.ArmsUtils;
import com.trello.rxlifecycle2.android.ActivityEvent;

import javax.inject.Inject;

import butterknife.Unbinder;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

/**
 * author: gaogq
 * time: 2019/3/19 15:29
 * description:
 */
public abstract class BaseViewActivity<P extends IPresenter> extends BaseActivity {
    @Inject
    @Nullable
    protected P mPresenter;//如果当前页面逻辑简单, Presenter 可以为 null



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.onDestroy();//释放资源
        this.mPresenter = null;
    }
}
