package kr.co.landvibe.handicraft.data.source.auth.remote;


import android.support.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import io.reactivex.Maybe;
import io.reactivex.annotations.Nullable;
import kr.co.landvibe.handicraft.data.domain.NaverOauthInfo;
import kr.co.landvibe.handicraft.data.source.auth.AuthDataSouce;
import kr.co.landvibe.handicraft.error.ForbiddenException;
import kr.co.landvibe.handicraft.error.InternalServerException;
import kr.co.landvibe.handicraft.error.UnAuthorizationException;
import kr.co.landvibe.handicraft.utils.LogUtils;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static kr.co.landvibe.handicraft.utils.DefineUtils.HOST_URL;

public class AuthRemoteDataSource implements AuthDataSouce {

    @Nullable
    private static AuthRemoteDataSource INSTANCE;

    private AuthService mAuthService;

    private AuthRemoteDataSource() {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HOST_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        mAuthService = retrofit.create(AuthService.class);
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
    }

    @Override
    public Maybe<NaverOauthInfo> createAuth(@NonNull NaverOauthInfo naverOauthInfo) {
        return mAuthService.signUp(
                naverOauthInfo.getAccessToken(),
                naverOauthInfo.getExpiresAt(),
                naverOauthInfo.getUniqueId())
                .flatMap(response -> {
                    if(response.isSuccessful()){
                        LogUtils.d("Success to create auth");
                        LogUtils.d("Response Code : "+ response.code());
                        return Maybe.just(response.body());
                    }else {
                        switch (response.code()){
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
                naverOauthInfo.getUniqueId())
                .flatMap(response -> {
                    if(response.isSuccessful()){
                        LogUtils.d("Success to create auth");
                        LogUtils.d("Response Code : "+ response.code());
                        return Maybe.just(response.body());
                    }else {
                        switch (response.code()){
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
        deleteAuth(naverOauthInfo.getUniqueId(),naverOauthInfo.getAccessToken());
    }

    @Override
    public void deleteAuth(@NonNull String uniqueId, @NonNull String accessToken) {
        mAuthService.deleteAuth(
                accessToken,
                uniqueId)
                .flatMap(response -> {
                    if(response.isSuccessful()){
                        return Maybe.just("Success Delete");
                    }else {
                        switch (response.code()){
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
}
