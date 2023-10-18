/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

/**
 *
 * @author lopez
 */
public abstract class Llanta {
    
    private int limitePermitido;

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
