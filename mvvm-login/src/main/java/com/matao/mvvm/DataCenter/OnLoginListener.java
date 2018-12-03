package com.matao.mvvm.DataCenter;

import com.matao.mvvm.model.User;

/**
 * Created by matao on 2018/12/4
 */
public interface OnLoginListener {
    void onLoginSuccess(User user);

    void onLoginFailure();
}
