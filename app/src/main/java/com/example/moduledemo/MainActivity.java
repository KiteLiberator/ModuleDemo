package com.example.moduledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.xiaojinzi.component.anno.RouterAnno;
import com.xiaojinzi.component.impl.Router;
import com.xiaojinzi.component.support.NavigationDisposable;

/**
 @author KiteLiberator */
@RouterAnno(
        host = "main",
        path = "main"
)
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected TextView             startWay_tv;
    protected Button               toLogin_btn;
    protected NavigationDisposable nd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startWay_tv = findViewById(R.id.startway_tv);
        startWay_tv.setText(getIntent().getBooleanExtra("startWay", false) ? "Launcher启动" : "MyInfo启动");

        toLogin_btn = findViewById(R.id.toLogin_btn);
        toLogin_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        nd = Router.with(this)
                .host("login")
                .path("login")
                .navigate();
    }
}
