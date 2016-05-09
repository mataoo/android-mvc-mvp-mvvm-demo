package com.mardle.mvpdemo.presenter;/**
 * Created by matao on 6/23/15.
 */

import android.os.Handler;

import com.mardle.mvpdemo.model.bean.User;
import com.mardle.mvpdemo.model.biz.IUserBiz;
import com.mardle.mvpdemo.model.biz.OnLoginListener;
import com.mardle.mvpdemo.model.biz.UserBiz;
import com.mardle.mvpdemo.view.IUserLoginView;

/**
 * User: SuperMardle(matao.mardle@gmail.com)
 * Date: 2015-06-23
 * Time: 14:53
 */
public class UserLoginPresenter {
    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        userBiz = new UserBiz();
    }

    public void login() {
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void onLoginSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showSuccess(user);
                        userLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void onLoginFailure() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showFailure();
                        userLoginView.hideLoading();
                    }
                });
            }
        });
    }

    public void clear() {
        userLoginView.clearUsername();
        userLoginView.clearPassword();
    }
}
