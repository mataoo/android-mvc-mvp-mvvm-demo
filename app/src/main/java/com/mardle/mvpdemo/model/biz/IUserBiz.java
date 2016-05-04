package com.mardle.mvpdemo.model.biz;/**
 * Created by matao on 6/23/15.
 */

/**
 * User: SuperMardle(matao.mardle@gmail.com)
 * Date: 2015-06-23
 * Time: 14:24
 */
public interface IUserBiz {
    void login(String username, String password, OnLoginListener onLoginListener);
}