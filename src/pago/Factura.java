/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pago;

import reservacion.*;

/**
 *
 * @author Kevin
 */
public class Factura {
    Reservacion reservacion;
    public double valorTotal;
    public double valorIva;
    public double valorServicio;
    public double valorViaje;

    public Factura(double valorViaje) {
        this.valorViaje = valorViaje;
    }
    
    private void calcularIva(){
        this.valorIva = this.valorViaje * 0.12;
        this.valorIva = Math.round(this.valorIva*100.0)/100.0;
    }
    
    private void calcularValorServicio(){
        this.valorServicio = this.valorViaje*0.1;
        this.valorServicio = Math.round(this.valorServicio*100.0)/100.0;
    }
    
    public void calcularTotal(){
        calcularIva();
        calcularValorServicio();
        this.valorTotal = this.valorViaje+this.valorIva+this.valorServicio;
        this.valorTotal = Math.round(this.valorTotal*100.0)/100.0;
    }

    @Override
    public String toString() {
        return "Factura{" + "valorTotal=" + valorTotal + ", valorIva=" + valorIva 
                + ", valorServicio=" + valorServicio + ", valorViaje=" + valorViaje + '}';
    }
    
}
