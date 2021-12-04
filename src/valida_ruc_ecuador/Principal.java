/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valida_ruc_ecuador;

import static valida_ruc_ecuador.ValidaRUC.ValidateRUC;

/**
 *
 * @author mint
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String ruc = "1791288106001";
        boolean valid = ValidateRUC(ruc);
        if (valid) {
            System.out.println(String.format("El RUC %1$s es válido", ruc));
        } else {
            System.out.println(String.format("El RUC %1$s NO es válido", ruc));
        }
    }
}
