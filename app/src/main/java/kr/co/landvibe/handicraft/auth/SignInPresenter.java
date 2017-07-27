package kr.co.landvibe.handicraft.auth;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableMaybeObserver;
import io.reactivex.schedulers.Schedulers;
import kr.co.landvibe.handicraft.data.domain.Member;
import kr.co.landvibe.handicraft.data.domain.NaverOauthInfo;
import kr.co.landvibe.handicraft.data.source.auth.AuthDataSource;
import kr.co.landvibe.handicraft.data.source.auth.remote.AuthRemoteDataSource;
import kr.co.landvibe.handicraft.utils.LogUtils;

public class SignInPresenter implements SignInContract.Presenter {

    private SignInContract.View view;

    private AuthDataSource authDataSource;

    private CompositeDisposable disposables;

    @Override
    public void attachView(SignInContract.View view) {
        this.view = view;
        authDataSource = AuthRemoteDataSource.getInstance();

        disposables = new CompositeDisposable();
    }

    @Override
    public void detachView() {
        this.view = null;
        authDataSource = null;
        disposables.dispose();
    }

    @Override
    public void signInWithNaverOauth(String accessToken, String refreshToken, long expiresAt, String tokenType) {
        disposables.add(
                authDataSource.getNaverUserInfo(accessToken, tokenType)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableMaybeObserver<Member>() {
                            @Override
                            public void onSuccess(@NonNull Member member) {
                                createAuthToRemote(new NaverOauthInfo(
                                        accessToken, refreshToken, expiresAt, tokenType, member));
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                                // TODO exception 처리
                            }

                            @Override
                            public void onComplete() {
                                LogUtils.d("Complete get Naver user information");
                            }
                        }));
    }

    private void createAuthToRemote(NaverOauthInfo naverOauthInfo) {
        disposables.add(
                authDataSource.createAuth(naverOauthInfo)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(
                                new DisposableMaybeObserver<NaverOauthInfo>() {
                                    @Override
                                    public void onSuccess(@NonNull NaverOauthInfo oauthInfo) {
                                        // TODO 유저정보 캐싱

                                        view.moveToMainActivity();
                                    }

                                    @Override
                                    public void onError(@NonNull Throwable e) {
                                        // TODO exception 처리
                                    }

                                    @Override
                                    public void onComplete() {
                                        LogUtils.d("Complete create auth");
                                    }
                                }));
    }

    @Override
    public void checkSessionNaverOauth() {
        // TODO 인증 로직 추가
        boolean success = false; // tmp

        if (success) {
            // 인증성공
            view.moveToMainActivity();
        } else {
            // 인증해야함
        }

    }
}
