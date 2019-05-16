package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.componentbase.ServiceFactory;

/**
 * Created by xwxwaa on 2019/5/14.
 */

public class FragmentActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_activity_fragment);
        // 1.通过反射来解决
//        showFragment(0);
        // 2.通过 componentbase 模块实现
        ServiceFactory.getInstance().getiAccountService().newUserFragment(this,R.id.layout_fragment,getSupportFragmentManager(),null,"");
    }

    /************************************************************************************
     * 通过反射来加载Fragment
     * currIndex 上一个fragment的序列号
     * showFragment() 展示Fragment
     */
    int currIndex = -1;
    Fragment[] fragmentList = new Fragment[1];

    public void showFragment(int index) {
        if (currIndex == index)
            return;
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (currIndex != -1) {
            ft.detach(fragmentList[currIndex]);
        }
        if (fragmentList[index] != null) {
            ft.attach(fragmentList[index]);
        } else {
            creatFragment(index);
            ft.replace(R.id.layout_fragment, fragmentList[index]);
        }
//        if (currIndex != -1) {
//            tab.getChildAt(currIndex).setSelected(false);
//        }
//        tab.getChildAt(index).setSelected(true);
        currIndex = index;
        ft.commit();
    }
    public String[] str = {"ShareFragment"};

    public void creatFragment(int index) {
        try {
            Fragment fragment = (Fragment) Class.forName("com.example.share." + str[index]).newInstance();
            fragmentList[index] = fragment;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /************************************************************************************/

    /**
     * 界面跳转
     * @param mContext
     * @param bundle
     */
    public static void startAction(Context mContext,Bundle bundle){
        Intent intent = new Intent(mContext,FragmentActivity.class);
        mContext.startActivity(intent);
    }
}
