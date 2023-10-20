/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

/**
 * La clase abstracta Llanta representa una llanta de vehículo. Define un límite permitido de velocidad
 * para la llanta, que puede variar según el tipo de llanta.
 *
 * @author Juan Felipe López
 * @author Sebastián García Gil
 */
public abstract class Llanta {
    
    private int limitePermitido; // El límite de velocidad permitido para la llanta.

    /**
     * Constructor de la clase Llanta que recibe el límite permitido de velocidad.
     *
     * @param limitePermitido El límite de velocidad permitido para la llanta.
     */
    public Llanta(int limitePermitido) {
        this.limitePermitido = limitePermitido;
    }

    /**
     * @return the limitePermitido
     */
    public int getLimitePermitido() {
        return limitePermitido;
    }

    /**
     * @param limitePermitido the limitePermitido to set
     */
    public void setLimitePermitido(int limitePermitido) {
        this.limitePermitido = limitePermitido;
    }
    
}
