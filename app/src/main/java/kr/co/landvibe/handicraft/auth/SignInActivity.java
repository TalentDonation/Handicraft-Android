package kr.co.landvibe.handicraft.auth;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginDefine;
import com.nhn.android.naverlogin.OAuthLoginHandler;
import com.nhn.android.naverlogin.ui.view.OAuthLoginButton;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.landvibe.handicraft.R;
import kr.co.landvibe.handicraft.auth.presenter.SignInPresenter;
import kr.co.landvibe.handicraft.auth.presenter.SignInPresenterImpl;
import kr.co.landvibe.handicraft.data.domain.NaverOauthInfo;
import kr.co.landvibe.handicraft.main.MainActivity;
import kr.co.landvibe.handicraft.utils.LogUtils;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SignInActivity extends AppCompatActivity implements SignInPresenter.View {

    @BindString(R.string.naver_client_id)
    String OAUTH_CLIENT_ID;

    @BindString(R.string.naver_client_secret)
    String OAUTH_CLIENT_SECRET;

    @BindString(R.string.naver_client_name)
    String OAUTH_CLIENT_NAME;

    @BindView(R.id.buttonOAuthLoginImg)
    OAuthLoginButton mOAuthLoginButton;

    private OAuthLogin mOAuthLoginInstance;
    private Context mContext;

    private SignInPresenter.Presenter mSignInPresenter;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);

        OAuthLoginDefine.DEVELOPER_VERSION = true;
        mContext = this;

        init();

    }

    private void init() {
        mOAuthLoginInstance = OAuthLogin.getInstance();
        mOAuthLoginInstance.init(mContext, OAUTH_CLIENT_ID, OAUTH_CLIENT_SECRET, OAUTH_CLIENT_NAME);

        mOAuthLoginButton.setOAuthLoginHandler(mOAuthLoginHandler);

        mSignInPresenter = new SignInPresenterImpl();
        mSignInPresenter.attachView(this);
        mSignInPresenter.checkSessionNaverOauth();
    }

    @Override
    protected void onResume() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        mOAuthLoginHandler = null;
        mSignInPresenter.detachView();
        super.onDestroy();
    }

    private OAuthLoginHandler mOAuthLoginHandler = new OAuthLoginHandler() {
        @Override
        public void run(boolean success) {
            if (success) {
                String accessToken = mOAuthLoginInstance.getAccessToken(mContext);
                String refreshToken = mOAuthLoginInstance.getRefreshToken(mContext);
                long expiresAt = mOAuthLoginInstance.getExpiresAt(mContext);
                String tokenType = mOAuthLoginInstance.getTokenType(mContext);
                LogUtils.d("accessToken: " + accessToken);
                LogUtils.d("refreshToken: " + refreshToken);
                LogUtils.d("expiresAt: " + String.valueOf(expiresAt));
                LogUtils.d("tokenType: " + tokenType);
                LogUtils.d("state: " + mOAuthLoginInstance.getState(mContext).toString());

                mSignInPresenter.signInWithNaverOauth(
                        new NaverOauthInfo(accessToken, refreshToken, expiresAt, tokenType,""));
            } else {
                String errorCode = mOAuthLoginInstance.getLastErrorCode(mContext).getCode();
                String errorDesc = mOAuthLoginInstance.getLastErrorDesc(mContext);
                LogUtils.d("errorCode:" + errorCode + ", errorDesc:" + errorDesc);
            }
        }
    };

    /**
     * SignInPresenter.View
     */
    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void moveToMainActivity() {
        final Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();
    }


}
