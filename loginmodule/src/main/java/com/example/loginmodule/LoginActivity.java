package com.example.loginmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.xiaojinzi.component.anno.RouterAnno;
import com.xiaojinzi.component.impl.Router;
import com.xiaojinzi.component.support.NavigationDisposable;

@RouterAnno(
        host = "login",
        path = "login"
)
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    /** 可以用来取消路由 */
    private NavigationDisposable nd;

    protected Button login_btn;
    protected EditText username_ev;
    protected EditText password_ev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username_ev = findViewById(R.id.user_name_ev);
        password_ev = findViewById(R.id.password_ev);

        login_btn = findViewById(R.id.login_btn);
        login_btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login_btn) {
            nd = Router.with(this)
                    .host("info")
                    .path("info")
                    .putString("username", username_ev.getText().toString())
                    .putString("password", password_ev.getText().toString())
                    .navigate();
        } else {
            throw new IllegalStateException("Unexpected value: " + v.getId());
        }

    }
}
