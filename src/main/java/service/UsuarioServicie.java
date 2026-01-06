/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.Usuario;

/**
 *
 * @author LEIZON
 */
public class UsuarioServicie {

    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public boolean resgistrar(String usuario, String clave) {

        if (existeUsuario(usuario)) {
            return false;
        }

        usuarios.add(new Usuario(usuario, clave));
        return true;
    }

    public boolean login(String usuario, String clave) {

        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario)) {
                return u.getClave().equals(clave);
            }
        }
        return false;
    }

    public boolean existeUsuario(String usuario) {

        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Usuario> listar() {
        return usuarios;
    }

    public boolean estaVacio() {
        return usuarios.isEmpty();
    }

}
