package mardle.com.login.login;

import mardle.com.login.BasePresenter;
import mardle.com.login.BaseView;
import mardle.com.login.login.model.User;

/**
 * Created by matao on 2016-05-09 11:57
 */
public interface LoginContract {
    interface Presenter extends BasePresenter {
        void login();

        void clearAll();
    }

    interface View extends BaseView<Presenter> {
        String getUserName();

        String getPassword();

        void showLoading();

        void hideLoading();

        void toMainActivity(User user);

        void showFailError();

        void clearUserName();

        void clearPassword();
    }
}
