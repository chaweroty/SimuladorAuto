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
