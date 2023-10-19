/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

/**
 *
 * @author Sebastián
 */
public class VehiculoNoExisteException extends RuntimeException{

    public VehiculoNoExisteException() {
        getMessage();
    }

    
    
    @Override
    public String getMessage() {
        return "El vehiculo no se ha creado.";
    }
    
}
