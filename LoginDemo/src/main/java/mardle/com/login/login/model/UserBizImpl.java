package mardle.com.login.login.model;

/**
 * Created by matao on 2016-05-09 14:25
 */
public class UserBizImpl implements IUserBiz {

    @Override
    public void login(final String userName, final String password, final OnLoginListener onLoginListener) {
        // 模拟耗时操作
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("matao".equals(userName) && "123".equals(password)) {
                    User user = new User();
                    user.setUsername(userName);
                    user.setPassword(password);
                    onLoginListener.onLoginSuccess(user);
                } else {
                    onLoginListener.onLoginFailed();
                }
            }
        }.start();
    }
}
