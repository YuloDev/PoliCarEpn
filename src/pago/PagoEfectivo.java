/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pago;

/**
 *
 * @author Kevin
 */
public class PagoEfectivo extends Pago{
    
    public PagoEfectivo(Factura factura) {
        super(factura);
    }
    
    public boolean realizarPago(){
        //validar del Frame 
        return false;
    }
}
