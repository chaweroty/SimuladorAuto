/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author lopez
 */
public class LectorArchivoTexto {

    private File file;
    private ArrayList <String> lineas;

    public ArrayList leer(File file) throws IOException{

        setLineas(new ArrayList<>());

        try (BufferedReader buffered = new BufferedReader(new FileReader(file))){
            String linea;
            while((linea =  buffered.readLine()) != null){
                getLineas().add(linea);
            }
        }catch(IOException e){
            throw e;
        }
        return getLineas();
    }
    
    public boolean validarArchivo(File file) throws IOException, FormatoNoValidoException{
        try (BufferedReader buffered = new BufferedReader(new FileReader(file))){
            String linea;
            while((linea = buffered.readLine())!= null){
                
            }
        }catch(IOException e){
            throw e;
        }
        return false;
    }

    public String detectarCilindraje() throws IndexOutOfBoundsException{

        String[] cilindraje;
        try {
            cilindraje = getLineas().get(1).split(" ");
            if(cilindraje[0].equals("Motor")){
                if(cilindraje[1].equals("1000") | cilindraje[1].equals("2000") | cilindraje[1].equals("3000")){
                    return cilindraje[1];
                }
            }
        }catch (IndexOutOfBoundsException e) {
            throw e;
        }
        return null;
    }
    
    public String detectarLlanta() throws IndexOutOfBoundsException{
        
        String[] tipoLlanta;
        try{
            tipoLlanta = getLineas().get(0).split(" ");
            if(tipoLlanta[0].equals("Llantas")){
                if(tipoLlanta[1].equals("buenas") | tipoLlanta[1].equals("bonitas")| tipoLlanta[1].equals("baratas")){
                    return tipoLlanta[1];
                }
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
