package com.zcsp.zjmonitor.app.base;

import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.view.ViewStub;

import com.blankj.utilcode.util.ToastUtils;
import com.classic.common.MultipleStatusView;
import com.jess.arms.mvp.IPresenter;
import com.zcsp.zjmonitor.R;

import javax.inject.Inject;

/**
 * author: gaogq
 * time: 2019/3/19 15:29
 * description:
 */
public abstract class BaseViewActivity<P extends IPresenter> extends BaseActivity {
    protected MultipleStatusView mMultipleStatusView;
    protected ViewStub viewStubTitle;

    @Inject
    @Nullable
    protected P mPresenter;//如果当前页面逻辑简单, Presenter 可以为 null


    @Override
    protected void setRootView(int layoutResID) {
        mMultipleStatusView = (MultipleStatusView) findViewById(R.id.multiple_status_view);
        if(mMultipleStatusView != null){
            mMultipleStatusView.showContent(layoutResID,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            //设置重试视图点击事件
            mMultipleStatusView.setOnRetryClickListener(v -> onClickRetry());
            if(useTitleBar()){
                 viewStubTitle = findViewById(R.id.view_stub_title);
                if (viewStubTitle != null) {
                    viewStubTitle.inflate();
                    initTitleBar();
                }
            }
        }
    }

    protected void onClickRetry() {
        ToastUtils.showShort("刷新数据");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.onDestroy();//释放资源
        this.mPresenter = null;
    }
}
