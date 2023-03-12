/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.pago;

/**
 *
 * @author Kevin
 */
public class BilleteraPoliCar {
    public double saldo;

    public BilleteraPoliCar() {
        
    }   
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public boolean aumentarSaldo(double valor){
        double saldoActual = this.saldo;
        this.saldo = this.saldo + valor;
        System.out.println(saldoActual + "  " +this.saldo+ "   " + valor);
        return saldoActual < saldo;
    }   
}
