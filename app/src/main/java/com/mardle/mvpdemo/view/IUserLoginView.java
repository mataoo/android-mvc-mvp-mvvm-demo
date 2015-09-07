package com.mardle.mvpdemo.view;/**
 * Created by matao on 6/23/15.
 */

import com.mardle.mvpdemo.model.bean.User;

/**
 * User: SuperMardle(matao.mardle@gmail.com)
 * Date: 2015-06-23
 * Time: 14:54
 */
public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailError();

    void clearUsername();

    void clearPassword();

}
