package kr.co.landvibe.handicraft.data.source.auth.remote;


import io.reactivex.Maybe;
import kr.co.landvibe.handicraft.data.domain.Member;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface NaverAuthService {

    @GET("/v1/nid/me")
    Maybe<Response<Member>> getUserInfo(
            @Header("Authorization") String accessToken
    );
}
