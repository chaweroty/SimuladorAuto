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
        
    }
    
    private void crearVehiculo() throws FormatoNoValidoException{
        try{
            vehiculo = new Vehiculo(crearMotor(), crearLlanta());
        }catch(FormatoNoValidoException e){
            throw e;
        }
    }
    
    private Motor crearMotor() throws FormatoNoValidoException{
        int cilindraje = Integer.parseInt(lectorArchivoTexto.detectarCilindraje());  
        try{
            switch (cilindraje) {
                case 1000 -> {
                    motor = new Motor1000();
                    return motor;
                }
                case 2000 -> {
                    motor = new Motor2000();
                    return motor;
                }
                case 3000 -> {
                    motor = new Motor3000();
                    return motor;
                }
                default -> {
                }
            }
        }catch(FormatoNoValidoException e){
                throw e;
        }
        return null;
    }
    
    private Llanta crearLlanta() throws FormatoNoValidoException{
        String llantas = lectorArchivoTexto.detectarLlanta();
        try{
            if(llantas.equals("buenas")){
                llanta = new LlantaBuena();
                return llanta;
            }else if(llanta.equals("bonitas")){
                llanta = new LlantaBonita();
                return llanta;
            }else if(llantas.equals("baratas")){
                llanta = new LlantaBarata();
                return llanta;
            }
        }catch (FormatoNoValidoException e){
            throw e;
        }
        return null;
    }
    
    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }

    /**
     * @param vehiculo the vehiculo to set
     */
    public void setVehiculo() throws  FormatoNoValidoException{
        try{
            crearVehiculo();
        }catch (FormatoNoValidoException e){
            throw e;
        }
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
