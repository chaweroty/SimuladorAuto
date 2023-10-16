/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

/**
 *
 * @author lopez
 */
public class Vehiculo {
    
    private Motor motor;
    private Llanta llanta;
    private boolean estado;
    private int velocidad;

    public Vehiculo(Motor motor, Llanta llanta) {
        this.motor = motor;
        this.llanta = llanta;
        this.estado = false;
    }
    
    public Vehiculo(int cc){
        this.motor = new Motor1000(cc);
        this.llanta = new LlantaBarata(cc);
    }
    
    public void encender() throws VehiculoEncendidoException{
        if(estado == true){
            VehiculoEncendidoException vee = new VehiculoEncendidoException();
            throw vee;
        }else{
            estado = true;
        }
    }
    
    public void apagar() throws VehiculoApagadoException, VehiculoAccidentadoException{
        if(estado == false){
            VehiculoApagadoException vae = new VehiculoApagadoException();
            throw vae;
        }else{
            estado = false;
            velocidad = 0;
        }
    }
    
    public void acelerar(int velocidadAcelerado) throws VehiculoApagadoException{
        if(estado == false){
            VehiculoApagadoException vae = new VehiculoApagadoException();
            throw vae;
        }else{
            setVelocidad(velocidadAcelerado);
        }
    }
    
    public void frenar(int velocidadFrenado) throws VehiculoApagadoException, VehiculoDetenidoException{
        if(estado == false){
            VehiculoApagadoException vae = new VehiculoApagadoException();
            throw vae;
        }else if(velocidad == 0){
            VehiculoDetenidoException vde = new VehiculoDetenidoException();
            throw vde;
        }else{
            if((this.velocidad -= velocidadFrenado) <= 0){
                this.velocidad = 0;
            }
        }
    }

    /**
     * @return the motor
     */
    public Motor getMotor() {
        return motor;
    }

    /**
     * @return the llanta
     */
    public Llanta getLlanta() {
        return llanta;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the velocidad
     */
    public int getVelocidad() {
        return velocidad;
    }

    /**
     * @param velocidad the velocidad to set
     */
    public void setVelocidad(int velocidad) {
        this.velocidad += velocidad;
    }
    
}
