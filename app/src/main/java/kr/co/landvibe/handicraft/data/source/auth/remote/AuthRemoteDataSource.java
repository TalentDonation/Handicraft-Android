package kr.co.landvibe.handicraft.data.source.auth.remote;


import android.support.annotation.NonNull;

import io.reactivex.Maybe;
import io.reactivex.annotations.Nullable;
import kr.co.landvibe.handicraft.GlobalApp;
import kr.co.landvibe.handicraft.data.domain.Member;
import kr.co.landvibe.handicraft.data.domain.NaverOauthInfo;
import kr.co.landvibe.handicraft.data.source.auth.AuthDataSource;
import kr.co.landvibe.handicraft.error.ForbiddenException;
import kr.co.landvibe.handicraft.error.InternalServerException;
import kr.co.landvibe.handicraft.error.NotFoundException;
import kr.co.landvibe.handicraft.error.UnAuthorizationException;
import kr.co.landvibe.handicraft.utils.LogUtils;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static kr.co.landvibe.handicraft.utils.DefineUtils.NAVER_HOST_URL;


public class AuthRemoteDataSource implements AuthDataSource {

    @Nullable
    private static AuthRemoteDataSource INSTANCE;

    private AuthService mAuthService;

    private NaverAuthService mNaverAuthService;

    private AuthRemoteDataSource() {
        OkHttpClient okHttpClient = GlobalApp.getOkHttpClientInstance();

        Retrofit retrofit = GlobalApp.getRetrofitInstance(okHttpClient);

        Retrofit naverRetrofit = new Retrofit.Builder()
                .baseUrl(NAVER_HOST_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        mAuthService = retrofit.create(AuthService.class);

        mNaverAuthService = naverRetrofit.create(NaverAuthService.class);

    }

    public static AuthRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AuthRemoteDataSource();
        }
        return INSTANCE;
    }

    public void destroyInstance() {
        INSTANCE = null;
        mAuthService = null;
        mNaverAuthService = null;
    }

    @Override
    public Maybe<NaverOauthInfo> createAuth(@NonNull NaverOauthInfo naverOauthInfo) {
        return mAuthService.signUp(
                naverOauthInfo.getAccessToken(),
                naverOauthInfo.getExpiresAt(),
                naverOauthInfo.getMember().getId())
                .flatMap(response -> {
                    if (response.isSuccessful()) {
                        LogUtils.d("Success to create auth");
                        LogUtils.d("Response Code : " + response.code());
                        return Maybe.just(response.body());
                    } else {
                        switch (response.code()) {
                            case 401:
                                return Maybe.error(new UnAuthorizationException(response.errorBody().string()));
                            case 500:
                                return Maybe.error(new InternalServerException(response.errorBody().string()));
                            default:
                                return Maybe.empty();
                        }
                    }
                });
    }

    @Override
    public Maybe<NaverOauthInfo> getAuth(@NonNull String uniqueId, @NonNull String accessToken) {
        // Not Used, Only Local
        return null;
    }


    @Override
    public Maybe<NaverOauthInfo> updateAuth(@NonNull NaverOauthInfo naverOauthInfo) {
        return mAuthService.checkAuth(
                naverOauthInfo.getTokenType() + " " + naverOauthInfo.getAccessToken(),
                naverOauthInfo.getMember().getId())
                .flatMap(response -> {
                    if (response.isSuccessful()) {
                        LogUtils.d("Success to create auth");
                        LogUtils.d("Response Code : " + response.code());
                        return Maybe.just(response.body());
                    } else {
                        switch (response.code()) {
                            case 401:
                                return Maybe.error(new UnAuthorizationException(response.errorBody().string()));
                            case 500:
                                return Maybe.error(new InternalServerException(response.errorBody().string()));
                            default:
                                return Maybe.empty();
                        }
                    }
                });
    }

    @Override
    public Maybe<NaverOauthInfo> updateAuth(@NonNull String uniqueId, @NonNull String accessToken, long expiresAt) {
        // Not Used, Only Local
        return null;
    }

    @Override
    public void deleteAuth(@NonNull NaverOauthInfo naverOauthInfo) {
        deleteAuth(naverOauthInfo.getMember().getId(), naverOauthInfo.getAccessToken());
    }

    @Override
    public void deleteAuth(@NonNull String uniqueId, @NonNull String accessToken) {
        mAuthService.deleteAuth(
                accessToken,
                uniqueId)
                .flatMap(response -> {
                    if (response.isSuccessful()) {
                        LogUtils.d("Success Delete");
                        LogUtils.d("Response Code : " + response.code());
                        return Maybe.just("Success Delete");
                    } else {
                        switch (response.code()) {
                            case 401:
                                return Maybe.error(new UnAuthorizationException(response.errorBody().string()));
                            case 403:
                                return Maybe.error(new ForbiddenException(response.errorBody().string()));
                            case 500:
                                return Maybe.error(new InternalServerException(response.errorBody().string()));
                            default:
                                return Maybe.empty();
                        }
                    }
                });
    }

    @Override
    public Maybe<Member> getNaverUserInfo(@NonNull String accessToken, @NonNull String tokenType) {
        return mNaverAuthService.getUserInfo(tokenType + " " + accessToken)
                .flatMap(response -> {
                    if (response.isSuccessful()) {
                        return Maybe.just(response.body());
                    } else {
                        switch (response.code()) {
                            case 401:
                                return Maybe.error(new UnAuthorizationException(response.errorBody().string()));
                            case 403:
                                return Maybe.error(new ForbiddenException(response.errorBody().string()));
                            case 404:
                                return Maybe.error(new NotFoundException(response.errorBody().string()));
                            case 500:
                                return Maybe.error(new InternalServerException(response.errorBody().string()));
                            default:
                                return Maybe.empty();
                        }
                    }
                });
    }
}
