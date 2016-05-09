package mardle.com.login.login.model;

/**
 * Created by matao on 2016-05-09 14:24
 */
public interface IUserBiz {
    void login(String username, String password, OnLoginListener onLoginListener);
}
