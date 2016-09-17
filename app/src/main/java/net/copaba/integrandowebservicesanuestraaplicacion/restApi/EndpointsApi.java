package net.copaba.integrandowebservicesanuestraaplicacion.restApi;

import net.copaba.integrandowebservicesanuestraaplicacion.restApi.model.PetResponse;
import net.copaba.integrandowebservicesanuestraaplicacion.restApi.model.UserResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Polo on 12/09/16.
 */
public interface EndpointsApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIAUSER_ID)
    Call<PetResponse> getRecentMedia(@Path("userID") String userID);

    @GET(ConstantesRestApi.URL_SERCH)
    Call<UserResponse> getUserID(@QueryMap Map<String, String> params);

    @GET(ConstantesRestApi.URL_SANDBOX_USERS)
    Call<UserResponse> getUserSandboxID();
}
