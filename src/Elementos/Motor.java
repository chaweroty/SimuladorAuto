/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

/**
 * La clase abstracta Motor representa el motor de un vehículo. Define la velocidad máxima
 * que puede alcanzar el vehículo con este motor.
 *
 * @author Juan Felipe López
 *  * @author Sebastián García Gil
 */
public abstract class Motor {
    
    private int velocidadMaxima; // La velocidad máxima que puede alcanzar el vehículo con este motor.

     /**
     * Constructor de la clase Motor que recibe la velocidad máxima.
     *
     * @param velocidadMaxima La velocidad máxima que puede alcanzar el vehículo con este motor.
     */
    public Motor(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    /**
     * @return the velocidadMaxima
     */
    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    /**
     * @param velocidadMaxima the velocidadMaxima to set
     */
    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }
    
}
