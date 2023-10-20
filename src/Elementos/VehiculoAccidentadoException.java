/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

/**
 *
 * @author lopez
 */
public class VehiculoAccidentadoException extends RuntimeException{

    @Override
    public String getMessage() {
        return "El vehículo se encuentra accidentado, por lo tanto no se puede acelerar y se apagará.";
    }
    
}
