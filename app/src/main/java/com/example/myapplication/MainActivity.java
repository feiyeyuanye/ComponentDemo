package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.base.AppConfig;

public class MainActivity extends AppCompatActivity {

    private TextView tvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_activity_main);
        initView();
    }

    private void initView() {
        tvMsg = findViewById(R.id.tv_app_msg);
    }

    public void login(View view){
        ARouter.getInstance().build(AppConfig.LOGINPATH).navigation(this,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (requestCode == 1){
                if (data!=null){
                    String str=data.getStringExtra("login_result");
                    tvMsg.setText("登录状态；"+str);
                }
            }
        }
    }

    public void share(View view){
        ARouter.getInstance().build(AppConfig.SHAREPATH).withString("share_content","main_share_content").navigation(this, new NavCallback() {
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
                        Toast.makeText(MainActivity.this,"请先登录",Toast.LENGTH_SHORT).show();
                    }
                });
                super.onInterrupt(postcard);
            }
        });
    }

    public void fragment(View view){
        FragmentActivity.startAction(this,null);
    }
}
