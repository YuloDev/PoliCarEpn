/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.usuarios;

import modelo.viaje.Viaje;

import java.util.Calendar;
import modelo.externo.Fecha;


public class Vehiculo {
    private String placa;
    private String modelo;
    private String color;
    private int año;
    private int numeroAsientos;
    Viaje[] viajes;
    
    public Vehiculo(String placa, String modelo, String color, int año, int numeroAsientos) {
        this.placa = placa;
        this.modelo = modelo;
        this.color = color;
        this.año = año;
        this.numeroAsientos = numeroAsientos;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getNumeroAsientos() {
        return numeroAsientos;
    }

    public boolean validarAño(){        
        Fecha fecha = new Fecha();
        int añoMinimo = fecha.obtenerAñoActual() - 15;
        if(this.año > añoMinimo ){            
            return true;
        }else{           
            return false;
        }
    }
    
    public String mostrarInfo(){
        return "Placa: " + placa
                + "\nModelo: " + modelo
                + "\nColor: " + color
                + "\nAño: " + año;
    }

    
    
}
