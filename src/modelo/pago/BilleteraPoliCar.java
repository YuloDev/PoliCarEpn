/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.pago;

import controladorBD.pago.SqlPago;

/**
 *
 * @author Kevin
 */
public class BilleteraPoliCar {
    SqlPago s =  new SqlPago();
    public double saldo;

    public BilleteraPoliCar() {
        this.saldo = s.obtenerSaldo();
    }
    
    public boolean aumentarSaldo(double valor){
        double saldoActual = this.saldo;
        this.saldo = this.saldo + valor;
        System.out.println(saldoActual + "  " +this.saldo+ "   " + valor);
        return saldoActual < saldo;
    }   
}
