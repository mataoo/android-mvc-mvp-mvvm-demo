package com.matao.mvvm.DataCenter;

import android.os.Handler;

import com.matao.mvvm.model.User;

/**
 * Created by matao on 2018/12/4
 */
public class LoginBiz {

    private Handler handler = new Handler();

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
                    final User user = new User("00001", "mattao", true, 26);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            onLoginListener.onLoginSuccess(user);
                        }
                    });
                } else {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            onLoginListener.onLoginFailure();
                        }
                    });
                }
            }
        }.start();
    }
}
