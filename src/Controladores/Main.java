/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controladores;

import Elementos.LectorArchivoTexto;
import Elementos.Taller;
import Vistas.Ventana;

/**
 *
 * @author lopez
 */
public class Main {

    public static void main(String[] args) {
        Ventana v = new Ventana();
        Taller t = new Taller();
        v.setTaller(t);
        v.setVisible(true);
        v.setLocationRelativeTo(null);
        LectorArchivoTexto lat = new LectorArchivoTexto();
        t.setLectorArchivoTexto(lat);
    }
    
}
