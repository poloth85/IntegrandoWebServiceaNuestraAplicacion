package net.copaba.integrandowebservicesanuestraaplicacion.restApi.model;

import net.copaba.integrandowebservicesanuestraaplicacion.pojo.Pet;
import net.copaba.integrandowebservicesanuestraaplicacion.pojo.PetPerfil;

import java.util.ArrayList;

/**
 * Created by Polo on 12/09/16.
 */
public class PetResponse {
    ArrayList<PetPerfil> pets;

    public ArrayList<PetPerfil> getPets() {
        return pets;
    }

    public void setPets(ArrayList<PetPerfil> pets) {
        this.pets = pets;
    }
}
