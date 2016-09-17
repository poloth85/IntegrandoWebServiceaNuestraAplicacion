package net.copaba.integrandowebservicesanuestraaplicacion.pojo;

import java.io.Serializable;

/**
 * Created by Polo on 16/09/16.
 */
public class User implements Serializable {
    String id;

    public User() {
    }

    public User(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
