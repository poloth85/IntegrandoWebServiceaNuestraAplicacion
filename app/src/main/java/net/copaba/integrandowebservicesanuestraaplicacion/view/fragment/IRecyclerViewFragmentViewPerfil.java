package net.copaba.integrandowebservicesanuestraaplicacion.view.fragment;


import net.copaba.integrandowebservicesanuestraaplicacion.adapter.PerfilAdaptador;
import net.copaba.integrandowebservicesanuestraaplicacion.adapter.PetAdaptador;
import net.copaba.integrandowebservicesanuestraaplicacion.pojo.Pet;
import net.copaba.integrandowebservicesanuestraaplicacion.pojo.PetPerfil;

import java.util.ArrayList;

/**
 * Created by Polo on 01/09/16.
 */
public interface IRecyclerViewFragmentViewPerfil {

    public void generarGridLayout();

    public PerfilAdaptador crearAdaptador(ArrayList<PetPerfil> pets);

    public void inicializarAdaptadorRV(PerfilAdaptador adaptador);

    public void setFullName(String name);

    public void setUserID(String userID);

    public void setUrlImg(String urlImg);



}
