package com.zcsp.zjmonitor.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.zcsp.zjmonitor.di.module.HomeModule;
import com.zcsp.zjmonitor.mvp.contract.HomeContract;

import com.jess.arms.di.scope.ActivityScope;
import com.zcsp.zjmonitor.mvp.ui.activity.HomeActivity;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/19/2019 15:32
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = HomeModule.class, dependencies = AppComponent.class)
public interface HomeComponent {
    void inject(HomeActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        HomeComponent.Builder view(HomeContract.View view);

        HomeComponent.Builder appComponent(AppComponent appComponent);

        HomeComponent build();
    }
}