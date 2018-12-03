package com.matao.improvedmvc.DataCenter;

import com.matao.improvedmvc.model.User;

/**
 * Created by matao on 2018/12/4
 */
public interface OnLoginListener {
    void onLoginSuccess(User user);

    void onLoginFailure();
}
