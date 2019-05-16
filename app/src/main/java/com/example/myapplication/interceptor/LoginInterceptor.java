package com.example.myapplication.interceptor;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.example.base.AppConfig;
import com.example.componentbase.ServiceFactory;

/**
 * Login模块中
 * 对登录状态的过滤拦截器
 * 自定义的过滤器需要通过 Interceptor 来注解
 * priority 是优先级
 * name 是对这个拦截器的描述
 * Created by xwxwaa on 2019/5/10.
 */
@Interceptor(priority = 8,name = "登录状态拦截器")
public class LoginInterceptor implements IInterceptor {

    private Context context;

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        // onContinue 和 onInterrupt 至少要调用其中一种，否则不会继续路由。
        if (AppConfig.SHAREPATH.equals(postcard.getPath())){
            if (ServiceFactory.getInstance().getiAccountService().isLogin()){
                // 处理完成，交换控制权
                // 已经登陆，就继续跳转
                callback.onContinue(postcard);
            }else {
                // 中断路由流程
                callback.onInterrupt(null);
            }
        }else {
            // 处理完成，交换控制权
            callback.onContinue(postcard);
        }
    }

    /**
     * 拦截器的初始化
     * 在sdk初始化时会调用该方法，并且只会调用一次
     * @param context
     */
    @Override
    public void init(Context context) {
        this.context = context;
    }
}
