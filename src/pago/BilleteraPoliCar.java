/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pago;

/**
 *
 * @author Kevin
 */
public class BilleteraPoliCar {
    double saldo;

    public BilleteraPoliCar() {
        
    }
    
    public boolean aumentarSaldo(double valor){
        double saldoActual;
        saldoActual = this.saldo;
        this.saldo += valor;
        return saldoActual < saldo;
    }
}
