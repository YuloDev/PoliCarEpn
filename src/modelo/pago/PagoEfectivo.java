/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.pago;

import modelo.pago.Pago;
import modelo.pago.Factura;

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
