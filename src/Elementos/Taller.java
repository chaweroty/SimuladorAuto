/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

/**
 *
 * @author lopez
 */
public class Taller {

    Vehiculo vehiculo;
    Motor motor;
    Llanta llanta;
    
    public Taller() {
        crearVehiculo();
    }
    
    private void crearVehiculo(){
        vehiculo = new Vehiculo(270);
    }
    
    public Vehiculo getVehiculo(){
        return this.vehiculo;
    }
    
}
