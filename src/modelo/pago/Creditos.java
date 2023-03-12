/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.pago;

/**
 *
 * @author Kevin
 */
public class Creditos {
    private double saldo;

    public Creditos(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public double recargarSaldo(double cantidad) {
        return this.saldo += cantidad;
    }

    public double disminuirSaldo(double cantidadPagar) {
        return this.saldo -= cantidadPagar;
    }
    
}
