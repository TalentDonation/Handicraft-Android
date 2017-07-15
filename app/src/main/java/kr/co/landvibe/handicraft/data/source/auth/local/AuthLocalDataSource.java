package kr.co.landvibe.handicraft.data.source.auth.local;


import android.support.annotation.NonNull;

import io.reactivex.Maybe;
import io.reactivex.annotations.Nullable;
import io.realm.Realm;
import kr.co.landvibe.handicraft.data.domain.NaverOauthInfo;
import kr.co.landvibe.handicraft.data.source.auth.AuthDataSouce;

public class AuthLocalDataSource implements AuthDataSouce {

    @Nullable
    private static AuthLocalDataSource INSTANCE;

    private Realm mRealm;

    private AuthLocalDataSource() {
        mRealm = Realm.getDefaultInstance();
    }

    public static AuthLocalDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AuthLocalDataSource();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    @Override
    public Maybe<NaverOauthInfo> createAuth(@NonNull NaverOauthInfo naverOauthInfo) {
        return Maybe.create(e -> {
            try {
                mRealm.beginTransaction();
                NaverOauthInfo oauthInfo = mRealm.copyToRealm(naverOauthInfo);
                mRealm.commitTransaction();

                e.onSuccess(oauthInfo);
                e.onComplete();
            } catch (Exception error) {
                e.onError(error);
            }
        });
    }

    @Override
    public Maybe<NaverOauthInfo> getAuth(@NonNull String refreshToken) {
        return Maybe.create(e -> {
            try {
                NaverOauthInfo naverOauthInfo = mRealm.where(NaverOauthInfo.class)
                        .equalTo("refreshToken", refreshToken)
                        .findFirst();

                e.onSuccess(naverOauthInfo);
                e.onComplete();
            } catch (Exception error) {
                e.onError(error);
            }
        });
    }

    @Override
    public Maybe<NaverOauthInfo> updateAuth(@NonNull NaverOauthInfo naverOauthInfo) {
        return updateAuth(
                naverOauthInfo.getRefreshToken(),
                naverOauthInfo.getAccessToken(),
                naverOauthInfo.getExpiresAt());
    }

    @Override
    public Maybe<NaverOauthInfo> updateAuth(@NonNull String refreshToken,
                                            @NonNull String accessToken,
                                            long expiresAt) {
        return Maybe.create(e -> {
            try {
                mRealm.beginTransaction();
                NaverOauthInfo naverOauthInfo = mRealm.where(NaverOauthInfo.class).equalTo("refreshToken", refreshToken).findFirst();
                naverOauthInfo.setAccessToken(accessToken);
                naverOauthInfo.setExpiresAt(expiresAt);
                mRealm.commitTransaction();

                e.onSuccess(naverOauthInfo);
                e.onComplete();
            } catch (Exception error) {
                e.onError(error);
            }
        });
    }

    @Override
    public void deleteAuth(@NonNull NaverOauthInfo naverOauthInfo) {
        deleteAuth(naverOauthInfo.getRefreshToken());
    }

    @Override
    public void deleteAuth(@NonNull String refreshToken) {
        mRealm.executeTransactionAsync(realm ->
                realm.where(NaverOauthInfo.class)
                .equalTo("refreshToken",refreshToken)
                .findFirst()
                .deleteFromRealm());
    }
}
