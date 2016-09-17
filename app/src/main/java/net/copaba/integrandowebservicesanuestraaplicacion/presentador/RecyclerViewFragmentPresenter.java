package net.copaba.integrandowebservicesanuestraaplicacion.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import net.copaba.integrandowebservicesanuestraaplicacion.db.ConstructorPets;
import net.copaba.integrandowebservicesanuestraaplicacion.pojo.Pet;
import net.copaba.integrandowebservicesanuestraaplicacion.pojo.PetPerfil;
import net.copaba.integrandowebservicesanuestraaplicacion.pojo.User;
import net.copaba.integrandowebservicesanuestraaplicacion.restApi.EndpointsApi;
import net.copaba.integrandowebservicesanuestraaplicacion.restApi.adapter.ResApiAdapter;
import net.copaba.integrandowebservicesanuestraaplicacion.restApi.model.PetResponse;
import net.copaba.integrandowebservicesanuestraaplicacion.restApi.model.UserResponse;
import net.copaba.integrandowebservicesanuestraaplicacion.view.fragment.IRecyclerViewFragmentView;

import java.util.ArrayList;
import java.util.Iterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Polo on 01/09/16.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorPets constructorPets;
    ArrayList<Pet> pets = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {

        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        getPetsBaseDatos();
        obtenUsuariosSandbox();


    }

    @Override
    public void getPetsBaseDatos() {

        constructorPets = new ConstructorPets(context);
//        pets = constructorPets.getData();
        constructorPets.setData();

        showPetsRV();
    }

    @Override
    public void obtenUsuariosSandbox() {
        ResApiAdapter resApiAdapter = new ResApiAdapter();
        Gson gsonMediaRecent = resApiAdapter.construyeGsonDeserializadorUser();
        EndpointsApi endpointApi =resApiAdapter.establecerConexionResApiInstagram(gsonMediaRecent);
        Call<UserResponse> userResponseCall = endpointApi.getUserSandboxID();
        userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                UserResponse userResponse = response.body();
                ArrayList<User> usersResponse = userResponse.getUsers();
                Iterator<User> iuser = usersResponse.iterator();
                while (iuser.hasNext()){
                    User user = iuser.next();

                    System.out.println("&&&&&&&"+user.getId());
                    obtenerMediosRecientes(user.getId());
                }
//                showPetsRV();
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(context, "Algo pasó en la conexión! Intenta nuevamente", Toast.LENGTH_SHORT).show();
                Log.e("FALLO LA CONEXION",t.toString());
            }
        });
    }

    @Override
    public void showPetsRV() {
        System.out.println("@@@@@@@@@@@@@"+ pets.size());
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(pets));
        iRecyclerViewFragmentView.generarLineaLayoutVertical();
    }

    @Override
    public void obtenerMediosRecientes() {

    }

    @Override
    public void obtenerMediosRecientes(String userID) {
        ResApiAdapter resApiAdapter = new ResApiAdapter();
        Gson gsonMediaRecent = resApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndpointsApi endpointApi =resApiAdapter.establecerConexionResApiInstagram(gsonMediaRecent);
        Call<PetResponse> petResponseCall = endpointApi.getRecentMedia(userID);
        petResponseCall.enqueue(new Callback<PetResponse>() {
            @Override
            public void onResponse(Call<PetResponse> call, Response<PetResponse> response) {
                PetResponse petResponse = response.body();
                //almaceno en variables valores devueltos del webservice
                if(petResponse!=null){
                Iterator<PetPerfil> petsResponse = petResponse.getPets().iterator();

                while (petsResponse.hasNext()){
                    PetPerfil petResp = petsResponse.next();
                    Pet petActual = new Pet(petResp.getId(),petResp.getNombre(),petResp.getUrlFoto(),petResp.getLikes());
                    System.out.println("########"+petActual.getNombre());
                    System.out.println("########"+petActual.getId_user());
                    System.out.println("########"+petActual.getUrlFoto());
                    System.out.println("########"+petActual.getLikes());
                    pets.add(petActual);

                }}
//                pets = petResponse.getPets();
//                name = pets.get(0).getNombre();
//                urlImg = pets.get(0).getUrlFotoPerfil();
                showPetsRV();
            }

            @Override
            public void onFailure(Call<PetResponse> call, Throwable t) {
                Toast.makeText(context, "Algo pasó en la conexión! Intenta nuevamente", Toast.LENGTH_SHORT).show();
                Log.e("FALLO LA CONEXION",t.toString());
            }
        });
    }
}
