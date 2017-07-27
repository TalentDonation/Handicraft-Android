package kr.co.landvibe.handicraft.data.source.auth.remote;


import io.reactivex.Maybe;
import kr.co.landvibe.handicraft.data.domain.NaverOauthInfo;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AuthService {

    String HOST_URL = "";

    @Headers("User-Agent: Android")
    @FormUrlEncoded
    @POST("/auth/signup")
    Maybe<Response<NaverOauthInfo>> signUp(
            @Field("accessToken") String accessToken,
            @Field("expiresAt") long expiresAt,
            @Field("uniqueId") String uniqueId
    );

    @Headers("User-Agent: Android")
    @GET("/auth/check")
    Maybe<Response<NaverOauthInfo>> checkAuth(
            @Header("Authorization") String accessToken,
            @Query("uniqueId") String uniqueId
    );

    @Headers("User-Agent: Android")
    @GET("/auth/delete")
    Maybe<Response> deleteAuth(
            @Header("Authorization") String accessToken,
            @Query("uniqueId") String uniqueId
    );
}
