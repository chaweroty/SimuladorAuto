/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

/**
 * La clase Taller representa un taller de vehículos que realiza operaciones relacionadas con la creación de vehículos
 * a partir de motores y llantas especificados en un archivo de texto. También permite acceder a las propiedades del vehículo,
 * motor, llanta y lector de archivo de texto.
 * 
 * @author Juan Felipe López
 * * @author Sebastián García Gil
 */
public class Taller {

    private Vehiculo vehiculo; // El vehículo creado en el taller.
    private Motor motor; //El motor del vehículo.
    private Llanta llanta; // La llanta del vehículo.
    private LectorArchivoTexto lectorArchivoTexto; // El lector de archivo de texto utilizado para detectar especificaciones
    
     /**
     * Constructor de la clase Taller.
     */
    public Taller() {
        
    }
    
    /**
     * Crea un nuevo vehículo a partir de un motor y una llanta, y lo almacena en la propiedad vehiculo.
     *
     * @throws FormatoNoValidoException Si el formato del archivo de texto no es válido.
     */
    private void crearVehiculo() throws FormatoNoValidoException{
        try{
            vehiculo = new Vehiculo(crearMotor(), crearLlanta());
        }catch(FormatoNoValidoException e){
            throw e;
        }
    }
    
    /**
     * Crea un motor en función del cilindraje detectado en el archivo de texto.
     *
     * @return El motor creado.
     * @throws FormatoNoValidoException Si el formato del archivo de texto no es válido.
     */
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
    
     /**
     * Crea una llanta en función de las especificaciones detectadas en el archivo de texto.
     *
     * @return La llanta creada.
     * @throws FormatoNoValidoException Si el formato del archivo de texto no es válido.
     */
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
    
    /**
     * Obtiene el vehículo creado en el taller.
     *
     * @return El vehículo creado.
     */
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
