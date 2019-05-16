package com.example.login;

import android.app.Activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


import com.example.componentbase.service.IAccountService;

/**
 * 登陆组件的 Service 类实现
 * Created by xwxwaa on 2019/5/9.
 */
public class AccountService implements IAccountService{

    @Override
    public boolean isLogin() {
        return AccountUtils.userBean != null;
    }

    @Override
    public String getAccountId() {
        return AccountUtils.userBean == null ? null:AccountUtils.userBean.getAccountId();
    }

    @Override
    public Fragment newUserFragment(Activity activity, int containerId, FragmentManager manager, Bundle bundle, String tag) {
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment userFragment = new UserFragment();
        transaction.add(containerId,userFragment,tag);
        transaction.commit();
        return userFragment;
    }
}
