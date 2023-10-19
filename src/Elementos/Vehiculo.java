package Elementos;

import java.io.File;
import javax.sound.sampled.*;

/**
 *
 * @author lopez
 */
public class Vehiculo {
    
    int BRUSCAMENTE = 30;
    
    private Motor motor;
    private Llanta llanta;
    private boolean estado;
    private int velocidad;

    public Vehiculo(Motor motor, Llanta llanta) {
        this.motor = motor;
        this.llanta = llanta;
        this.estado = false;
    }
    
    public void encender() throws VehiculoEncendidoException{
        if(estado == true){
            VehiculoEncendidoException vee = new VehiculoEncendidoException();
            throw vee;
        }else{
            estado = true;
            sonidoencender();
        }
    }
    
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