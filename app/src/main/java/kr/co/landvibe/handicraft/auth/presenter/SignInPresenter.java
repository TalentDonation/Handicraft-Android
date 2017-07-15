package kr.co.landvibe.handicraft.auth.presenter;


import kr.co.landvibe.handicraft.data.domain.NaverOauthInfo;

public interface SignInPresenter {

    interface View {

        void showLoading();

        void hideLoading();

        void moveToMainActivity();

    }

    interface Presenter {

        void attachView(SignInPresenter.View view);

        void detachView();

        void signInWithNaverOauth(NaverOauthInfo naverOauthInfo);

        void checkSessionNaverOauth();

    }

}