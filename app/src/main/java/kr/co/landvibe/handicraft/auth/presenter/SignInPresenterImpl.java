package kr.co.landvibe.handicraft.auth.presenter;


import kr.co.landvibe.handicraft.data.domain.NaverOauthInfo;

public class SignInPresenterImpl implements SignInPresenter.Presenter {

    private SignInPresenter.View view;

    @Override
    public void attachView(SignInPresenter.View view) {
        this.view=view;
    }

    @Override
    public void detachView() {
        this.view=null;
    }

    @Override
    public void signInWithNaverOauth(NaverOauthInfo naverOauthInfo) {

    }

    @Override
    public void checkSessionNaverOauth() {
        // TODO 인증 로직 추가
        boolean success = false; // tmp

        if(success){
            // 인증성공
            view.moveToMainActivity();
        }else {
            // 인증해야함
        }

    }
}
