package mardle.com.login.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import mardle.com.login.R;
import mardle.com.login.login.model.User;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    @InjectView(R.id.et_username)
    EditText mUsernameEt;
    @InjectView(R.id.et_password)
    EditText mPasswordEt;
    @InjectView(R.id.bt_login)
    Button mLoginBt;
    @InjectView(R.id.bt_clear)
    Button mClearBt;
    @InjectView(R.id.pb_loading)
    ProgressBar mLoadingPb;

    private LoginContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

        mPresenter = new LoginPresenter(this);

        mLoginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.login();
            }
        });
        mClearBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.clearAll();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
//        mPresenter = presenter;
    }

    @Override
    public String getUserName() {
        return mUsernameEt.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return mPasswordEt.getText().toString().trim();
    }

    @Override
    public void showLoading() {
        mLoadingPb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mLoadingPb.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, "Welcome " + user.getUsername(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearUserName() {
        mUsernameEt.setText("");
    }

    @Override
    public void clearPassword() {
        mPasswordEt.setText("");
    }
}
