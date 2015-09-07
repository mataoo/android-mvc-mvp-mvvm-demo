package com.mardle.mvpdemo.model.biz;/**
 * Created by matao on 6/23/15.
 */

import com.mardle.mvpdemo.model.bean.User;

/**
 * User: SuperMardle(matao.mardle@gmail.com)
 * Date: 2015-06-23
 * Time: 14:26
 */
public class UserBiz implements IUserBiz {

    @Override
    public void login(final String username, final String password, final OnLoginListener onLoginListener) {
        // 模拟耗时操作
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("matao".equals(username) && "123".equals(password)) {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    onLoginListener.loginSuccess(user);
                } else {
                    onLoginListener.loginFailure();
                }
            }
        }.start();
    }
}
