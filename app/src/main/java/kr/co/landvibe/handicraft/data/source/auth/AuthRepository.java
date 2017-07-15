package kr.co.landvibe.handicraft.data.source.auth;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import io.reactivex.Maybe;
import kr.co.landvibe.handicraft.data.domain.NaverOauthInfo;
import kr.co.landvibe.handicraft.data.source.auth.local.AuthLocalDataSource;
import kr.co.landvibe.handicraft.data.source.auth.remote.AuthRemoteDataSource;


public class AuthRepository implements AuthDataSouce {

    @Nullable
    private static AuthRepository INSTANCE = null;

    @NonNull
    private AuthLocalDataSource mAuthLocalDataSource;

    @NonNull
    private AuthRemoteDataSource mAuthRemoteDataSource;

    private AuthRepository(@NonNull AuthLocalDataSource authLocalDataSource,
                           @NonNull AuthRemoteDataSource authRemoteDataSource) {
        mAuthLocalDataSource = authLocalDataSource;
        mAuthRemoteDataSource = authRemoteDataSource;
    }

    public static AuthRepository getInstance(@NonNull AuthLocalDataSource authLocalDataSource,
                                             @NonNull AuthRemoteDataSource authRemoteDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new AuthRepository(authLocalDataSource, authRemoteDataSource);
        }
        return INSTANCE;
    }

    public void destroyInstance() {
        mAuthLocalDataSource.destroyInstance();
        mAuthRemoteDataSource.destroyInstance();
        INSTANCE = null;
    }


    @Override
    public Maybe<NaverOauthInfo> createAuth(@NonNull NaverOauthInfo naverOauthInfo) {
        return null;
    }

    @Override
    public Maybe<NaverOauthInfo> getAuth(@NonNull String uniqueId, @NonNull String accessToken) {
        return null;
    }


    @Override
    public Maybe<NaverOauthInfo> updateAuth(@NonNull NaverOauthInfo naverOauthInfo) {
        return null;
    }

    @Override
    public Maybe<NaverOauthInfo> updateAuth(@NonNull String uniqueId, @NonNull String accessToken, long expiresAt) {
        return null;
    }

    @Override
    public void deleteAuth(@NonNull NaverOauthInfo naverOauthInfo) {

    }

    @Override
    public void deleteAuth(@NonNull String uniqueId, @NonNull String accessToken) {

    }


}
