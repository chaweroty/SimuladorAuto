/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

import java.io.*;
import java.util.ArrayList;

/**
 * La clase LectorArchivoTexto se encarga de leer y validar archivos de texto que contienen información sobre vehículos,
 * incluyendo datos de motor y llantas. Permite leer, validar y extraer información relevante de los archivos de texto.
 *
 * @author Juan Felipe López
 *  * @author Sebastián García Gil
 */
public class LectorArchivoTexto {

    private File file; // El archivo de texto a leer y validar.
    private ArrayList <String> lineas; // Lista de líneas del archivo.
    
      /**
     * Lee el archivo de texto especificado y almacena sus líneas en la lista lineas. Además, llama al método que valida el formato del archivo.
     *
     * @param file El archivo de texto a leer y validar.
     * @return Una lista de las líneas del archivo de texto.
     * @throws IOException    Si ocurre un error de lectura o acceso al archivo.
     * @throws FormatoNoValidoException   Si el formato del archivo no cumple con ciertas reglas.
     */

    public ArrayList leerArchivo(File file) throws IOException{

        setLineas(new ArrayList<>());

        try (BufferedReader buffered = new BufferedReader(new FileReader(file))){
            String linea;
            while((linea =  buffered.readLine()) != null){
                getLineas().add(linea);
            }
            buffered.close();
            try{
                validarArchivo(file);
            }catch(IOException e){
                throw e;
            }catch (FormatoNoValidoException e1){
                throw e1;
            }
        }catch(IOException e){
            throw e;
        }
        return getLineas();
    }
    /**
     * Valida el formato del archivo de texto. Comprueba si las líneas comienzan con palabras clave "motor" o "llantas" y si
     * los valores son válidos.
     *
     * @param file El archivo de texto a validar.
     * @return `true` si el formato es válido; de lo contrario, `false`.
     * @throws IOException   Si ocurre un error de lectura o acceso al archivo.
     * @throws FormatoNoValidoException   Si el formato del archivo no cumple con ciertas reglas.
     */
    public boolean validarArchivo(File file) throws IOException, FormatoNoValidoException{
        try (BufferedReader buffered = new BufferedReader(new FileReader(file))){
            String linea;
            while((linea  = buffered.readLine()) != null){
                String[] elementos = linea.split(" ");
                if(elementos[0].equals("llantas") || elementos[0].equals("motor")){
                }else if(elementos[0].equals("motor")){
                    try{
                        Integer.parseInt(elementos[1]);
                        String.valueOf(elementos[1]);
                    }catch(NumberFormatException e){
                        throw e;                
                    }
                }else{
                    throw new FormatoNoValidoException();
                }
            }
            buffered.close();
        }catch(IOException e){
            throw e;
        }
        return false;
    }
    
    /**
     * Valida el formato de la primera línea del archivo para detectar la presencia de "motor".
     *
     * @param file El archivo de texto a validar.
     * @return `true` si el formato es válido; de lo contrario, `false`.
     * @throws IOException   Si ocurre un error de lectura o acceso al archivo.
     * @throws FormatoNoValidoException   Si el formato del archivo no cumple con ciertas reglas.
     */
    
    public boolean validarArchivoLineaMotor(File file) throws IOException, FormatoNoValidoException{
        try (BufferedReader buffered = new BufferedReader(new FileReader(file))){
            String linea = buffered.readLine();
            String[] elementos = linea.split(" ");
            if(!elementos[0].equals("motor")){
                throw new FormatoNoValidoException();
            }
            buffered.close();
        }catch(IOException e){
            throw e;
        }
        return false;
    }
    
     /**
     * Detecta y extrae el cilindraje del archivo de texto. Busca la línea que comienza con "cilindraje" y retorna el valor.
     *
     * @return El valor del cilindraje.
     * @throws IndexOutOfBoundsException Si no se encuentra la línea de cilindraje en el archivo.
     */

    public String detectarCilindraje() throws IndexOutOfBoundsException{

        String[] cilindraje;
        try {
            cilindraje = getLineas().get(1).split(" ");
            if(cilindraje[1].equals("1000") | cilindraje[1].equals("2000") | cilindraje[1].equals("3000")){
                return cilindraje[1];
            }
        }catch (IndexOutOfBoundsException e) {
            throw e;
        }
        return null;
    }
    
     /**
     * Detecta y extrae el tipo de llanta del archivo de texto. Busca la línea que comienza con "llantas" y retorna el valor.
     *
     * @return El tipo de llanta.
     * @throws IndexOutOfBoundsException Si no se encuentra la línea de llantas en el archivo.
     */
    public String detectarLlanta() throws IndexOutOfBoundsException{
        
        String[] tipoLlanta;
        try{
            tipoLlanta = getLineas().get(0).split(" ");
            if(tipoLlanta[1].equals("buenas") | tipoLlanta[1].equals("bonitas")| tipoLlanta[1].equals("baratas")){
                    return tipoLlanta[1];
            }
        }catch (IndexOutOfBoundsException e){
            throw e;
        }
        return null;
    }

    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * @return the lineas
     */
    public ArrayList <String> getLineas() {
        return lineas;
    }

    /**
     * @param lineas the lineas to set
     */
    public void setLineas(ArrayList <String> lineas) {
        this.lineas = lineas;
    }
}
