package com.matao.mvc;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.matao.mvc.DataCenter.LoginBiz;
import com.matao.mvc.DataCenter.OnLoginListener;
import com.matao.mvc.model.User;

public class MainActivity extends AppCompatActivity {

    private EditText userNameEt;
    private EditText passwordEt;
    private Button loginBt;
    private Button clearBt;
    private ProgressBar loadingPb;
    private TextView userInfoTv;

    private Handler mHandler = new Handler();
    private LoginBiz loginBiz = new LoginBiz();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }

    private void initView() {
        userNameEt = findViewById(R.id.username_et);
        passwordEt = findViewById(R.id.password_et);
        loginBt = findViewById(R.id.login_bt);
        clearBt = findViewById(R.id.clear_bt);
        loadingPb = findViewById(R.id.loading_pb);
        userInfoTv = findViewById(R.id.user_info_tv);
    }

    private void initListener() {
        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = userNameEt.getText().toString();
                String password = passwordEt.getText().toString();
                loadingPb.setVisibility(View.VISIBLE);
                loginBiz.login(userName, password, new OnLoginListener() {
                    @Override
                    public void onLoginSuccess(final User user) {
                        userInfoTv.setText(user.toString());
                        loadingPb.setVisibility(View.GONE);
                    }

                    @Override
                    public void onLoginFailure() {
                        userInfoTv.setText("login failed!!");
                        loadingPb.setVisibility(View.GONE);
                    }
                });
            }
        });
        clearBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userNameEt.setText("");
                passwordEt.setText("");
            }
        });
    }
}
