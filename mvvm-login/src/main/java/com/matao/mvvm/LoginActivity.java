package com.matao.mvvm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity  {

    private EditText userNameEt;
    private EditText passwordEt;
    private Button loginBt;
    private Button clearBt;
    private ProgressBar loadingPb;
    private TextView userInfoTv;

    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        initListener();

        viewModel = new LoginViewModel(new ViewBinder(), userInfoTv);
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
                String username = userNameEt.getText().toString();
                String password = passwordEt.getText().toString();

                viewModel.login(username, password);

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
