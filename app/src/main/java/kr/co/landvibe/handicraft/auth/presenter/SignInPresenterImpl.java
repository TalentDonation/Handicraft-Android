package kr.co.landvibe.handicraft.auth.presenter;


import kr.co.landvibe.handicraft.data.domain.NaverOauthInfo;
import kr.co.landvibe.handicraft.data.source.auth.AuthDataSource;
import kr.co.landvibe.handicraft.data.source.auth.AuthRepository;
import kr.co.landvibe.handicraft.data.source.auth.local.AuthLocalDataSource;
import kr.co.landvibe.handicraft.data.source.auth.remote.AuthRemoteDataSource;

public class SignInPresenterImpl implements SignInPresenter.Presenter {

    private SignInPresenter.View view;

    private AuthDataSource authDataSource;

    @Override
    public void attachView(SignInPresenter.View view) {
        this.view=view;
        authDataSource = AuthRepository.getInstance(
                AuthLocalDataSource.getInstance(),
                AuthRemoteDataSource.getInstance()
        );
    }

    @Override
    public void detachView() {
        this.view=null;
        authDataSource=null;
    }

    @Override
    public void signInWithNaverOauth(NaverOauthInfo naverOauthInfo) {
        // TODO 인증 로직 추가
        view.moveToMainActivity();
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
