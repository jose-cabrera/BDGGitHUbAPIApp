package com.deltadax.bdggithubapiapp.entity;

/**
 * Created by JosePablo on 22/08/17.
 */

public class ReposEvent {

    public ReposEvent(String usuario) {
        this.usuario = usuario;
    }

    private String usuario;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
