package kr.co.landvibe.handicraft.data.source.auth.local;


import android.support.annotation.NonNull;

import io.reactivex.Maybe;
import io.reactivex.annotations.Nullable;
import io.realm.Realm;
import kr.co.landvibe.handicraft.data.domain.NaverOauthInfo;
import kr.co.landvibe.handicraft.data.source.auth.AuthDataSource;

public class AuthLocalDataSource implements AuthDataSource {

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

    public void destroyInstance() {
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
    public Maybe<NaverOauthInfo> getAuth(@NonNull String uniqueId, @NonNull String accessToken) {
        return Maybe.create(e -> {
            try {
                NaverOauthInfo naverOauthInfo = mRealm.where(NaverOauthInfo.class)
                        .equalTo("uniqueId", uniqueId)
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
                naverOauthInfo.getUniqueId(),
                naverOauthInfo.getAccessToken(),
                naverOauthInfo.getExpiresAt());
    }

    @Override
    public Maybe<NaverOauthInfo> updateAuth(@NonNull String uniqueId,
                                            @NonNull String accessToken,
                                            long expiresAt) {
        return Maybe.create(e -> {
            try {
                mRealm.beginTransaction();
                NaverOauthInfo naverOauthInfo = mRealm.where(NaverOauthInfo.class)
                        .equalTo("uniqueId", uniqueId)
                        .findFirst();
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
        deleteAuth(naverOauthInfo.getUniqueId(),naverOauthInfo.getAccessToken());
    }

    @Override
    public void deleteAuth(@NonNull String uniqueId, @NonNull String accessToken) {
        mRealm.executeTransactionAsync(realm ->
                realm.where(NaverOauthInfo.class)
                .equalTo("uniqueId",uniqueId)
                .findFirst()
                .deleteFromRealm());
    }
}
