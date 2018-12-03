package com.matao.improvedmvc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.matao.improvedmvc.DataCenter.LoginBiz;
import com.matao.improvedmvc.DataCenter.OnLoginListener;
import com.matao.improvedmvc.model.User;

public class LoginActivity extends AppCompatActivity {

    private LoginLayout loginLayout;
    private LoginBiz loginBiz = new LoginBiz();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginLayout = findViewById(R.id.login_layout);
        loginLayout.setOnLoginListener(new LoginLayout.OnLoginListener() {
            @Override
            public void onClickLogin(String username, String password) {
                loginBiz.login(username, password, new OnLoginListener() {
                    @Override
                    public void onLoginSuccess(User user) {
                        loginLayout.showUserInfo(user);
                    }

                    @Override
                    public void onLoginFailure() {
                        loginLayout.showError("login failed!!!");
                    }
                });
            }
        });
    }

    public interface ILoginView {
        void showUserInfo(User user);

        void showError(String error);
    }
}
