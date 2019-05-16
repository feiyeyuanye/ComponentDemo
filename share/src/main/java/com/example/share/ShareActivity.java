package com.example.share;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.base.AppConfig;
import com.example.componentbase.ServiceFactory;

/**
 * 分享页
 * 添加注解，注意path跳转路径至少有两级。
 * 并且，注意第一级的名称不要相同，否则会报错
 */
@Route(path = AppConfig.SHAREPATH)
public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_activity_share);
        if (getIntent()!=null){
            String content = getIntent().getStringExtra("share_content");
            if (!TextUtils.isEmpty(content)){
                ((TextView)findViewById(R.id.tv_share_content)).setText(content);
            }
        }

        share();
    }

    private void share() {
        if (ServiceFactory.getInstance().getiAccountService().isLogin()){
            Toast.makeText(this,"分享成功",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"分享失败，用户未登录",Toast.LENGTH_SHORT).show();
        }
    }

    public void shareLogin(View view){
        ARouter.getInstance().build(AppConfig.LOGINPATH).navigation();
    }
}
