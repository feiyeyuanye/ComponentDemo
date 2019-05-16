package com.example.login;

import android.app.Application;
import com.example.base.BaseApp;
import com.example.componentbase.ServiceFactory;

/**
 * Created by xwxwaa on 2019/5/9.
 */

public class LoginApp extends BaseApp{

    /**
     * 当主模块有Application的情况下
     * 组件在集成调试时，Application不会初始化
     */
    @Override
    public void onCreate() {
        super.onCreate();
        // 在单独调试时，这样也会调用initModuleApp()，完成在ServiceFactory中的注册操作。
        initModuleApp(this);
        initModuleData(this);
    }

    @Override
    public void initModuleApp(Application application) {
        // 将AccountService类的实例注册到ServiceFactory
        ServiceFactory.getInstance().setiAccountService(new AccountService());
    }

    @Override
    public void initModuleData(Application application) {

    }
}
