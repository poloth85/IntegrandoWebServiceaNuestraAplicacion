package net.copaba.integrandowebservicesanuestraaplicacion.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.copaba.integrandowebservicesanuestraaplicacion.restApi.ConstantesRestApi;
import net.copaba.integrandowebservicesanuestraaplicacion.restApi.EndpointsApi;
import net.copaba.integrandowebservicesanuestraaplicacion.restApi.deserializador.PetDeseralizador;
import net.copaba.integrandowebservicesanuestraaplicacion.restApi.deserializador.UserDeserealizador;
import net.copaba.integrandowebservicesanuestraaplicacion.restApi.model.PetResponse;
import net.copaba.integrandowebservicesanuestraaplicacion.restApi.model.UserResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Polo on 12/09/16.
 */
public class ResApiAdapter {
    public EndpointsApi establecerConexionResApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(EndpointsApi.class);
    }
    public Gson construyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PetResponse.class, new PetDeseralizador());
        return gsonBuilder.create();
    }
    public Gson construyeGsonDeserializadorUser(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(UserResponse.class, new UserDeserealizador());
        return gsonBuilder.create();
    }
}
