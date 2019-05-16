package com.example.login;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.base.AppConfig;

/**
 * 登陆页
 * 添加注解，注意path跳转路径至少有两级。
 * 并且，注意第一级的名称不要相同，否则会报错
 */
@Route(path = AppConfig.LOGINPATH)
public class LoginActivity extends AppCompatActivity {


    private TextView tvLoginState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_login);
        initView();
        updateLoginState();
    }

    private void initView() {
        tvLoginState = (TextView) findViewById(R.id.tv_login_state);
    }

    /**
     * 登陆
     */
    public void login(View view){
        AccountUtils.userBean = new UserBean("123456","admin");
        updateLoginState();
    }

    private void updateLoginState() {
        String str = AccountUtils.userBean==null?"未登录":AccountUtils.userBean.getUserName();
        tvLoginState.setText("登陆界面："+str);

        // 返回结果给app->MainActivity
        Intent intent = getIntent();
        intent.putExtra("login_result",str);
        setResult(RESULT_OK,intent);
    }

    /**
     * 退出
     */
    public void exit(View view){
        AccountUtils.userBean = null;
        updateLoginState();
    }

    /**
     * 去分享页面
     */
    public void loginShare(View view){
        ARouter.getInstance().build(AppConfig.SHAREPATH).withString("share_content","分享数据").navigation(this, new NavCallback() {
            @Override
            public void onArrival(Postcard postcard) {
                // 路由到达了
            }

            @Override
            public void onInterrupt(Postcard postcard) {
                // 路由被拦截了
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(LoginActivity.this,"请先登录",Toast.LENGTH_SHORT).show();
                    }
                });
                super.onInterrupt(postcard);
            }
        });
    }

}
