package net.copaba.integrandowebservicesanuestraaplicacion.view.fragment;


import net.copaba.integrandowebservicesanuestraaplicacion.adapter.PerfilAdaptador;
import net.copaba.integrandowebservicesanuestraaplicacion.adapter.PetAdaptador;
import net.copaba.integrandowebservicesanuestraaplicacion.pojo.Pet;

import java.util.ArrayList;

/**
 * Created by Polo on 01/09/16.
 */
public interface IRecyclerViewFragmentView {

    public void generarLineaLayoutVertical();

    public PetAdaptador crearAdaptador(ArrayList<Pet> pets);

    public void inicializarAdaptadorRV(PetAdaptador adaptador);
}
