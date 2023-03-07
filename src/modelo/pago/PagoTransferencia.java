/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.pago;

import modelo.pago.Pago;
import modelo.pago.Factura;
import modelo.pago.BilleteraPoliCar;
import modelo.reservacion.ControladorTiempoDeReserva;

/**
 *
 * @author Kevin
 */
public class PagoTransferencia extends Pago{
    
    public double valorTotal;
    public BilleteraPoliCar billetera = new BilleteraPoliCar();
    
    public PagoTransferencia(Factura factura, long timpoeRestante) {
        super(factura);
        controlador = new ControladorTiempoDeReserva(factura.reservacion,20*60*1000);
        factura.calcularTotal();
        this.valorTotal = super.factura.valorTotal;
    }
    
    public boolean realizarPago(){
        return billetera.aumentarSaldo(valorTotal);
    }
  
}
