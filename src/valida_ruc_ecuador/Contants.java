/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valida_ruc_ecuador;

/**
 *
 * @author mint
 */
public class Contants {

    public class VATLength {

        public static final int LENGTH_RUC = 13;
        public static final String BIN_VALIDATOR_DIGIT = "0-6;9-9";
        public static final String BIN_NUMBER_OF_PROVINCES = "01-24;31-31;80-85";
        public static final String BIN_LAST_DIGITS_RUC = "001-999";
    }  

    public class RegularExpression {       

        public static final String NUMBERS = "\\d";
        public static final String LETTERS_NUMBERS = "^[a-zA-Z0-9]+$";
    }
}
