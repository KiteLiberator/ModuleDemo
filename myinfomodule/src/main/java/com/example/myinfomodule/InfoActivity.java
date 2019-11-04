package com.example.myinfomodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xiaojinzi.component.anno.RouterAnno;
import com.xiaojinzi.component.impl.Router;
import com.xiaojinzi.component.support.NavigationDisposable;

import org.w3c.dom.Text;

@RouterAnno(
        host = "info",
        path = "info"
)
public class InfoActivity extends AppCompatActivity implements View.OnClickListener {

    protected TextView username_tv;
    protected TextView password_tv;
    protected Button   close_btn;

    protected NavigationDisposable nd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        username_tv = findViewById(R.id.username_tv);
        password_tv = findViewById(R.id.password_tv);
        close_btn = findViewById(R.id.close_btn);
        close_btn.setOnClickListener(this);

        Intent intent = getIntent();
        username_tv.setText(intent.getStringExtra("username"));
        password_tv.setText(intent.getStringExtra("password"));
    }

    @Override
    public void onClick(View v) {
        nd = Router.with(this)
                .host("main")
                .path("main")
                .putBoolean("isReturn", true)
                .navigate();
    }
}
