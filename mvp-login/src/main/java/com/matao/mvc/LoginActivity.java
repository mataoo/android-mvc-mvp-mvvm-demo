package com.matao.mvc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.matao.mvc.model.User;

public class LoginActivity extends AppCompatActivity implements LoginPresenter.ILoginView {

    private EditText userNameEt;
    private EditText passwordEt;
    private Button loginBt;
    private Button clearBt;
    private ProgressBar loadingPb;
    private TextView userInfoTv;

    private LoginPresenter presenter = new LoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
                String username = userNameEt.getText().toString();
                String password = passwordEt.getText().toString();

                presenter.login(username, password);

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

    @Override
    public void showLoading() {
        loadingPb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loadingPb.setVisibility(View.GONE);
    }

    @Override
    public void showUserInfo(User user) {
        if (user == null) return;

        userInfoTv.setText(user.toString());
    }

    @Override
    public void showError(String error) {
        userInfoTv.setText(error);
    }
}
