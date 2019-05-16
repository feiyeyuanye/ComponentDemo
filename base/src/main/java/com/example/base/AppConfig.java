package com.example.base;

/**
 * Created by xwxwaa on 2019/5/9.
 */

public class AppConfig {

    /**
     * 路由，路径path
     */
    public static final String SHAREPATH = "/share/share";
    public static final String LOGINPATH="/login/login";

    /**
     * 登陆组件，Application 路径
     */
    private static final String LOGINAPP = "com.example.login.LoginApp";

    /**
     * 将需要初始化的，组件的Application，的完整类名放入其中。
     */
    public static String[] moduleApps={LOGINAPP};

}
