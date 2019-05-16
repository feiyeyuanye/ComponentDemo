package com.example.base;

import android.app.Application;

/**
 * Created by xwxwaa on 2019/5/9.
 */

public abstract class BaseApp extends Application{

    /**
     * 当前组件初始化
     */
    public abstract void initModuleApp(Application application);

    /**
     * 所有组件都初始化完毕后，调用这个方法
     */
    public abstract void initModuleData(Application application);

}
