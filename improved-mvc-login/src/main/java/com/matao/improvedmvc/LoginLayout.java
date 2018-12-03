package com.matao.improvedmvc;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.matao.improvedmvc.model.User;

/**
 * Created by matao on 2018/12/4
 */
public class LoginLayout extends ConstraintLayout implements LoginActivity.ILoginView {

    private EditText userNameEt;
    private EditText passwordEt;
    private Button loginBt;
    private Button clearBt;
    private ProgressBar loadingPb;
    private TextView userInfoTv;

    public OnLoginListener onLoginListener;

    public interface OnLoginListener {
        void onClickLogin(String username, String password);
    }

    public LoginLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setOnLoginListener(OnLoginListener onLoginListener) {
        this.onLoginListener = onLoginListener;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
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
                if (onLoginListener != null) {
                    loadingPb.setVisibility(View.VISIBLE);
                    onLoginListener.onClickLogin(userName, password);
                }
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
    public void showUserInfo(User user) {
        if (user == null) return;

        loadingPb.setVisibility(View.GONE);
        userInfoTv.setText(user.toString());
    }

    @Override
    public void showError(String error) {
        loadingPb.setVisibility(View.GONE);
        userInfoTv.setText(error);
    }
}
