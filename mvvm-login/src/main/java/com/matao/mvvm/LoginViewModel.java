package com.matao.mvvm;

import android.widget.TextView;

import com.matao.mvvm.DataCenter.LoginBiz;
import com.matao.mvvm.DataCenter.OnLoginListener;
import com.matao.mvvm.model.User;

/**
 * Created by matao on 2018/12/4
 */
public class LoginViewModel {

    private LoginBiz loginBiz = new LoginBiz();
    private ObservableString loginResultOb = new ObservableString();

    public LoginViewModel(ViewBinder viewBinder, TextView userInfoTv) {
        viewBinder.bind(userInfoTv, loginResultOb);
    }

    public void login(final String username, String password) {
        loginBiz.login(username, password, new OnLoginListener() {
            @Override
            public void onLoginSuccess(User user) {
                loginResultOb.setValue(user.toString());
            }

            @Override
            public void onLoginFailure() {
                loginResultOb.setValue("login failed");
            }
        });
    }
}
