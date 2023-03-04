/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RestriccionDominio {
    protected String dominioEPN;

    public RestriccionDominio(String dominioEPN) {
        this.dominioEPN = dominioEPN;
    }
    
    public boolean validarDominio(String correo){
        String regex = "^[a-z]+\\.([a-z]+[0-9]*)@epn.edu.ec$" ;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }
}
