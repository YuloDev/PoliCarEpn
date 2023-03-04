/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;

import viaje.Viaje;

import java.util.Calendar;


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

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public void setNumeroAsientos(int numeroAsientos) {
        this.numeroAsientos = numeroAsientos;
    }
    
    
    public void validarAño(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        year = year - 15;
        if(this.año > year ){
            System.out.println("Vehículo Registrado");
        }else{
            System.out.println("Solo se pueden registrar vehiculos del " + year + " en adelante");
        }
    }
    
    public String mostrarInfo(){
        return "Placa: " + placa
                + "\nModelo: " + modelo
                + "\nColor: " + color
                + "\nAño: " + año;
    }

    
    
}
