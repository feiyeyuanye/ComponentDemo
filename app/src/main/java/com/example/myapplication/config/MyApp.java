package com.example.myapplication.config;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.base.AppConfig;
import com.example.base.BaseApp;

/**
 * 主module的Application
 * Created by xwxwaa on 2019/5/9.
 */

public class MyApp extends BaseApp{

    /**
     * 双数为正式（true）,单数为测试debug版本（false）
     */
    private boolean isReleaseVersion;

    @Override
    public void onCreate() {
        isReleaseVersion = (getVersionCode(this) % 2 == 0);
        super.onCreate();

        // 初始化Arouter
        if (!isReleaseVersion){
            Toast.makeText(this,"debug",Toast.LENGTH_SHORT).show();
            // debug版
            // 这两行必须写在init之前，否则这些配置在init过程中将无效

            // 打印日志
            ARouter.openLog();
            // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();

        }

        // 初始化 ARouter
        ARouter.init(this);

        // 初始化组件 Application
        initModuleApp(this);

        // 其他操作

        // 所有 Application 初始化后的操作
        initModuleData(this);

    }


    /**
     * 遍历 AppcConfig 类中定义的 moduleApps 数组中的类名，
     * 通过反射，初始化各个组件的 Application。
     */
    @Override
    public void initModuleApp(Application application) {
        for (String moduleApp : AppConfig.moduleApps) {
            try {
                Class clazz = Class.forName(moduleApp);
                BaseApp baseApp = (BaseApp) clazz.newInstance();
                baseApp.initModuleApp(this);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initModuleData(Application application) {
        for (String moduleApp : AppConfig.moduleApps) {
            try {
                Class clazz = Class.forName(moduleApp);
                BaseApp baseApp = (BaseApp) clazz.newInstance();
                baseApp.initModuleData(this);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getVersionCode(Context context){
        int versionCode = 0 ;
        PackageManager pm = context.getPackageManager();
        PackageInfo pi;
        try {
            pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionCode = pi.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }
}
