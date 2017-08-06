package kr.co.landvibe.handicraft.data.source.auth;


import android.support.annotation.NonNull;

import io.reactivex.Maybe;
import kr.co.landvibe.handicraft.data.domain.Member;
import kr.co.landvibe.handicraft.data.domain.NaverOauthInfo;

public interface AuthDataSource {

    Maybe<NaverOauthInfo> createAuth(@NonNull NaverOauthInfo naverOauthInfo);

    Maybe<NaverOauthInfo> getAuth(@NonNull String uniqueId, @NonNull String accessToken);

    Maybe<NaverOauthInfo> updateAuth(@NonNull NaverOauthInfo naverOauthInfo);

    Maybe<NaverOauthInfo> updateAuth(@NonNull String uniqueId, @NonNull String accessToken, long expiresAt);

    void deleteAuth(@NonNull NaverOauthInfo naverOauthInfo);

    void deleteAuth(@NonNull String uniqueId, @NonNull String accessToken);

    Maybe<Member> getNaverUserInfo(@NonNull String accessToken, @NonNull String tokenType);

}
