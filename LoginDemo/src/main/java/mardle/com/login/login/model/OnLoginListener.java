package mardle.com.login.login.model;

import mardle.com.login.login.model.User;

/**
 * Created by matao on 2016-05-09 12:00
 */
public interface OnLoginListener {
    void onLoginSuccess(User user);

    void onLoginFailed();
}
