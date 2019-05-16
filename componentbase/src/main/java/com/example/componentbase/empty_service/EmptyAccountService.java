package com.example.componentbase.empty_service;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.componentbase.service.IAccountService;

/**
 * 组件Service空实现
 * service中，定义的，接口的空实现。
 * Created by xwxwaa on 2019/5/9.
 */

public class EmptyAccountService implements IAccountService {

    @Override
    public boolean isLogin() {
        return false;
    }

    @Override
    public String getAccountId() {
        return null;
    }

    @Override
    public Fragment newUserFragment(Activity activity, int containerId, FragmentManager manager, Bundle bundle, String tag) {
        return null;
    }
}
