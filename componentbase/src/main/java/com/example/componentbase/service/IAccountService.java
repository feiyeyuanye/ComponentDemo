package com.example.componentbase.service;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * 组件Service接口定义
 * 定义了，此组件向外提供的，数据传递的接口方法
 * Created by xwxwaa on 2019/5/9.
 */
public interface IAccountService {

    /**
     * 是否已经登陆
     * @return
     */
    boolean isLogin();

    /**
     * 获取登陆用户的AccountId
     * @return
     */
    String getAccountId();

    /**
     * 添加 newUserFragment() 方法
     * 用来获取 Fragment 实例
     * @param activity 上下文
     * @param containerId FrameLayout 的布局 id
     * @param manager
     * @param bundle
     * @param tag
     * @return
     */
    Fragment newUserFragment(Activity activity, int containerId, FragmentManager manager, Bundle bundle, String tag);
}
