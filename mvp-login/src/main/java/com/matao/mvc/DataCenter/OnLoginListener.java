package com.matao.mvc.DataCenter;

import com.matao.mvc.model.User;

/**
 * Created by matao on 2018/12/4
 */
public interface OnLoginListener {
    void onLoginSuccess(User user);

    void onLoginFailure();
}
