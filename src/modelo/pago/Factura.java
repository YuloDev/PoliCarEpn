/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.pago;

import modelo.reservacion.Reservacion;

/**
 *
 * @author Kevin
 */
public class Factura {
    protected Reservacion reservacion;
    public double valorTotal;
    public double valorIva;
    public double valorServicio;
    public double valorViaje;

    public Factura(Reservacion reservacion) {
        this.valorViaje = reservacion.getPrecio();
        this.reservacion = reservacion;
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
}
