/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.usuarios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RestriccionDominio {
    protected String dominioEPN = "^[a-z]+\\.([a-z]+[0-9]*)@epn.edu.ec$";
    
    public boolean validarDominio(String correo){
        Pattern pattern = Pattern.compile(dominioEPN);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }
}
