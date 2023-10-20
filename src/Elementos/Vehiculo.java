package Elementos;

import java.io.File;
import javax.sound.sampled.*;

/**
 * La clase Vehiculo representa un vehículo con un motor y una llanta, y permite realizar operaciones como encender, apagar,
 * acelerar y frenar. También puede reproducir sonidos asociados a estas acciones. El vehículo almacena su estado (encendido o apagado)
 * y su velocidad actual.
 *
 * @author Juan Felipe López
 * @author Sebastián García Gil
 */
public class Vehiculo {
    
    int BRUSCAMENTE = 30; // Constante que define el límite de frenado brusco.
    
    private Motor motor; // El motor del vehículo.
    private Llanta llanta; // La llanta del vehículo.
    private boolean estado; // El estado del vehículo (encendido o apagado).
    private int velocidad; // La velocidad actual del vehículo.

    
     /**
     * Constructor de la clase Vehiculo que recibe un motor y una llanta como parámetros.
     *
     * @param motor   El motor del vehículo.
     * @param llanta  La llanta del vehículo.
     */
    public Vehiculo(Motor motor, Llanta llanta) {
        this.motor = motor;
        this.llanta = llanta;
        this.estado = false;
    }
    
     /**
     * Enciende el vehículo y reproduce un sonido de encendido. Si el vehículo ya está encendido, se lanza una excepción.
     *
     * @throws VehiculoEncendidoException Si el vehículo ya está encendido.
     */
    public void encender() throws VehiculoEncendidoException{
        if(estado == true){
            VehiculoEncendidoException vee = new VehiculoEncendidoException();
            throw vee;
        }else{
            estado = true;
            sonidoencender();
        }
    }
    /**
     * Reproduce un sonido de aceleración.
     */
    public void sonidoAceleracion() {
        File soundFile = new File("C:\\Users\\smasg\\Downloads\\aceleracion.wav");

        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Reproduce un sonido de encender.
     */
    public void sonidoencender() {
        File soundFile = new File("C:\\Users\\smasg\\Downloads\\encender.wav");

        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Apaga el vehículo y, si la velocidad es mayor que 60, lanza una excepción de accidente. Si el vehículo ya está apagado, se lanza una excepción.
     *
     * @throws VehiculoApagadoException   Si el vehículo ya está apagado.
     * @throws VehiculoAccidentadoException  Si la velocidad es mayor que 60 y se produce un accidente.
     */
    public void apagar() throws VehiculoApagadoException, VehiculoAccidentadoException{
        if(estado == false){
            VehiculoApagadoException vae = new VehiculoApagadoException();
            throw vae;
        }else if(velocidad > 60){
            VehiculoAccidentadoException vace = new VehiculoAccidentadoException();
            velocidad = 0;
            estado = false;
            throw vace;
        }else{
            estado = false;
            velocidad = 0;
        }
    }
    
    /**
     * Acelera el vehículo a la velocidad especificada y reproduce un sonido de aceleración. Si el vehículo está apagado o la velocidad
     * excede la velocidad máxima del motor, se lanza una excepción.
     *
     * @param velocidadAcelerado La velocidad a la que se acelerará el vehículo.
     * @throws VehiculoApagadoException        Si el vehículo está apagado.
     * @throws VehiculoAccidentadoException    Si la velocidad excede la velocidad máxima del motor y se produce un accidente.
     */
    
    public void acelerar(int velocidadAcelerado) throws VehiculoApagadoException, VehiculoAccidentadoException{
        if(estado == false){
            VehiculoApagadoException vae = new VehiculoApagadoException();
            throw vae;
        }else if(velocidadAcelerado > motor.getVelocidadMaxima()){
            velocidad = 0;
            estado = false;
            VehiculoAccidentadoException vace = new VehiculoAccidentadoException();
            throw vace;
        }else{
            setVelocidad(velocidadAcelerado);
            sonidoAceleracion();
        }
    }
    
    /**
     * Frena el vehículo a la velocidad especificada. Si el vehículo está apagado o detenido, o si la velocidad de frenado es
     * excesiva, se lanzan excepciones.
     *
     * @param velocidadFrenado La velocidad a la que se frenará el vehículo.
     * @throws VehiculoApagadoException        Si el vehículo está apagado.
     * @throws VehiculoDetenidoException       Si el vehículo ya está detenido.
     * @throws VehiculoPatinandoException      Si la velocidad de frenado es excesiva o superior al límite permitido por la llanta.
     */
    public void frenar(int velocidadFrenado) throws VehiculoApagadoException, VehiculoDetenidoException{
        if(estado == false){
            VehiculoApagadoException vae = new VehiculoApagadoException();
            throw vae;
        }else if(velocidad == 0){
            VehiculoDetenidoException vde = new VehiculoDetenidoException();
            throw vde;
        }else if(velocidadFrenado > BRUSCAMENTE |  velocidadFrenado > llanta.getLimitePermitido() | velocidadFrenado > velocidad){
            VehiculoPatinandoException vpe = new VehiculoPatinandoException();
            velocidad = 0;
            throw vpe;
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