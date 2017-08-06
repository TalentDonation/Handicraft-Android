package kr.co.landvibe.handicraft.auth;


public interface SignInContract {

    interface View {

        void showLoading();

        void hideLoading();

        void moveToMainActivity();

    }

    interface Presenter {

        void attachView(SignInContract.View view);

        void detachView();

        void signInWithNaverOauth(String accessToken, String refreshToken, long expiresAt, String tokenType);

        void checkSessionNaverOauth();

    }

}