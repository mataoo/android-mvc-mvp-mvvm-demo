package com.matao.mvc;

import android.os.Handler;

import com.matao.mvc.DataCenter.LoginBiz;
import com.matao.mvc.DataCenter.OnLoginListener;
import com.matao.mvc.model.User;

/**
 * Created by matao on 2018/12/4
 */
public class LoginPresenter {

    public interface ILoginView {
        void showLoading();

        void hideLoading();

        void showUserInfo(User user);

        void showError(String error);
    }

    private ILoginView loginView;

    private Handler handler = new Handler();
    private LoginBiz loginBiz = new LoginBiz();

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    public void login(String username, String password) {
        loginView.showLoading();
        loginBiz.login(username, password, new OnLoginListener() {
            @Override
            public void onLoginSuccess(final User user) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.showUserInfo(user);
                        loginView.hideLoading();
                    }
                });
            }

            @Override
            public void onLoginFailure() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.showError("login failed!!");
                        loginView.hideLoading();
                    }
                });
            }
        });
    }
}
