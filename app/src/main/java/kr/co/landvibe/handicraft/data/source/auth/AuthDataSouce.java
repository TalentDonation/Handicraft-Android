package kr.co.landvibe.handicraft.data.source.auth;


import android.support.annotation.NonNull;

import io.reactivex.Maybe;
import kr.co.landvibe.handicraft.data.domain.NaverOauthInfo;

public interface AuthDataSouce {

    Maybe<NaverOauthInfo> createAuth(@NonNull NaverOauthInfo naverOauthInfo);

    Maybe<NaverOauthInfo> getAuth(@NonNull String refreshToken);

    Maybe<NaverOauthInfo> updateAuth(@NonNull NaverOauthInfo naverOauthInfo);

    Maybe<NaverOauthInfo> updateAuth(@NonNull String refreshToken, @NonNull String accessToken, long expiresAt);

    void deleteAuth(@NonNull NaverOauthInfo naverOauthInfo);

    void deleteAuth(@NonNull String refreshToken);

}
