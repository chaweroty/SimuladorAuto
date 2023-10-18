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

    private Vehiculo vehiculo;
    private Motor motor;
    private Llanta llanta;
    private LectorArchivoTexto lectorArchivoTexto;
    
    public Taller() {
        crearVehiculo();
    }
    
    private void crearVehiculo(){
        Vehiculo v = new Vehiculo(motor, llanta);
    }
    
    private void crearMotor() throws FormatoNoValidoException{
        int cilindraje = Integer.parseInt(lectorArchivoTexto.detectarCilindraje());  
        
        switch (cilindraje) {
            case 1000 -> motor = new Motor1000();
            case 2000 -> motor = new Motor2000();
            case 3000 -> motor = new Motor3000();
            default -> {
            }
        }
    }
    
    private void crearLlanta(){
        String llantas = lectorArchivoTexto.detectarLlanta();
        switch (llantas) {
            case "buenas" -> llanta = new LlantaBuena();
            case "bonitas" -> llanta = new LlantaBonita();
            case "baratas" -> llanta = new LlantaBarata();
            default -> {
            }
        }
    }
    
    public Vehiculo getVehiculo(){
        return this.vehiculo;
    }

    /**
     * @param vehiculo the vehiculo to set
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * @return the motor
     */
    public Motor getMotor() {
        return motor;
    }

    /**
     * @param motor the motor to set
     */
    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    /**
     * @return the llanta
     */
    public Llanta getLlanta() {
        return llanta;
    }

    /**
     * @param llanta the llanta to set
     */
    public void setLlanta(Llanta llanta) {
        this.llanta = llanta;
    }

    /**
     * @return the lectorArchivoTexto
     */
    public LectorArchivoTexto getLectorArchivoTexto() {
        return lectorArchivoTexto;
    }

    /**
     * @param lectorArchivoTexto the lectorArchivoTexto to set
     */
    public void setLectorArchivoTexto(LectorArchivoTexto lectorArchivoTexto) {
        this.lectorArchivoTexto = lectorArchivoTexto;
    }
    
}
