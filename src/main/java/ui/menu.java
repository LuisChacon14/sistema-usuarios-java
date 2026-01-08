/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.util.Scanner;
import model.Usuario;
import service.UsuarioServicie;

/**
 *
 * @author LEIZON
 */
public class menu {

    private UsuarioServicie servicie = new UsuarioServicie();
    private Scanner tec = new Scanner(System.in);

    private void login() {

        int i = 0;
        do {
            System.out.println("usuario: ");
            String usuario = tec.nextLine();
            System.out.println("Clave: ");
            String clave = tec.nextLine();

            if (servicie.estaVacio()) {
                System.out.println("No hay registros");
                return;
            }
            if (servicie.login(usuario, clave)) {
                System.out.println("Acceso concedido");
                return;
            } else {
                System.out.println("Usuario o clave incorrectas");
                i++;
            }
        } while (i < 3);
        System.out.println("Supero el limite de intentos");
    }

    private void mostrar() {
        if (servicie.estaVacio()) {
            System.out.println("No hay registros");
            return;
        }

        for (Usuario u : servicie.listar()) {
            System.out.println("Usuario: " + u.getUsuario());
            System.out.println("clave: **********");
            System.out.println("-------------------");
        }
    }

    private void registrar() {

        System.out.println("Usuario: ");
        String usuario = tec.nextLine();
        System.out.println("Clave");
        String clave = tec.nextLine();

        if (servicie.resgistrar(usuario, clave)) {
            System.out.println("Usuario registrado");
        } else {
            System.out.println("El Usuario ya existe");
        }
    }

    public void mostrarMenu() {

        int option;

        do {
            System.out.println("Menu\n1.Registrar\n2.Mostrar\n3.Login\n4.Salir");
            option = tec.nextInt();
            tec.nextLine();

            switch (option) {
                case 1:
                    registrar();
                    break;
                case 2:
                    mostrar();
                    break;
                case 3:
                    login();
                    break;
            }
        } while (option != 4);
        System.out.println("Adios");
        return;

    }

}
