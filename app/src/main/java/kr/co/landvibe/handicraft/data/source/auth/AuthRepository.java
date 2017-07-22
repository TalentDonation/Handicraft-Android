package kr.co.landvibe.handicraft.data.source.auth;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import io.reactivex.Maybe;
import kr.co.landvibe.handicraft.data.domain.NaverOauthInfo;
import kr.co.landvibe.handicraft.data.source.auth.local.AuthLocalDataSource;
import kr.co.landvibe.handicraft.data.source.auth.remote.AuthRemoteDataSource;



// Rxjava 익숙해질때까지 사용 x
@Deprecated
public class AuthRepository implements AuthDataSource {

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
        deleteAuth(naverOauthInfo.getUniqueId(),naverOauthInfo.getAccessToken());
    }

    @Override
    public void deleteAuth(@NonNull String uniqueId, @NonNull String accessToken) {

    }


}
