package com.mardle.mvpdemo.biz;/**
 * Created by matao on 6/23/15.
 */

import com.mardle.mvpdemo.bean.User;

/**
 * User: SuperMardle(matao.mardle@gmail.com)
 * Date: 2015-06-23
 * Time: 14:27
 */
public interface OnLoginListener {
    void loginSuccess(User user);

    void loginFailure();
}
