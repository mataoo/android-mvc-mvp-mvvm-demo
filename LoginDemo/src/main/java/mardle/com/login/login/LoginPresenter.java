package mardle.com.login.login;

import android.os.Handler;

import mardle.com.login.login.model.IUserBiz;
import mardle.com.login.login.model.OnLoginListener;
import mardle.com.login.login.model.User;
import mardle.com.login.login.model.UserBizImpl;

/**
 * Created by matao on 2016-05-09 11:57
 */
public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mLoginView;
    private IUserBiz mUserBiz;
    private Handler mHandler = new Handler();

    public LoginPresenter(LoginContract.View mLoginView) {
        this.mLoginView = mLoginView;
        this.mUserBiz = new UserBizImpl();

        mLoginView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void login() {
        mLoginView.showLoading();
        final String userName = mLoginView.getUserName();
        final String password = mLoginView.getPassword();
        mUserBiz.login(userName, password, new OnLoginListener() {
            @Override
            public void onLoginSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mLoginView.toMainActivity(user);
                        mLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void onLoginFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mLoginView.showFailError();
                        mLoginView.hideLoading();
                    }
                });
            }
        });
    }

    @Override
    public void clearAll() {
        mLoginView.clearUserName();
        mLoginView.clearPassword();
    }
}
