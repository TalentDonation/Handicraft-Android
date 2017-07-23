package kr.co.landvibe.handicraft.auth;


import kr.co.landvibe.handicraft.data.domain.NaverOauthInfo;

public interface SignInContract {

    interface View {

        void showLoading();

        void hideLoading();

        void moveToMainActivity();

    }

    interface Presenter {

        void attachView(SignInContract.View view);

        void detachView();

        void signInWithNaverOauth(NaverOauthInfo naverOauthInfo);

        void checkSessionNaverOauth();

    }

}