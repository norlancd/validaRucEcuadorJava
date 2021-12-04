/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valida_ruc_ecuador;

import java.util.regex.Pattern;
import valida_ruc_ecuador.Contants.RegularExpressions;
import valida_ruc_ecuador.Contants.RucValidations;

/**
 *
 * @author mint
 */
public class ValidaRUC {

    public static boolean ValidateRUC(String ruc) {
        String regex = RegularExpressions.NUMBERS;
        String quantifier = "{" + RucValidations.LENGTH_RUC + "}";
        regex += quantifier;

        Pattern pattern = Pattern.compile(regex);
        if (!pattern.matcher(ruc).matches()) {
            System.out.println(String.format("No cumple con la expresion regular %1$s", regex));
            return false;
        } else {  
            //Validate Provinces
            if (!SharedMethods.ValidateInNumericRanges(ruc, 0, 2, RucValidations.BIN_NUMBER_OF_PROVINCES, "BIN_NUMBER_OF_PROVINCES")) //"01-24;31-31;80-85";
            {
                return false;
            }
            
            //Validate Validator Digit
            if (!SharedMethods.ValidateInNumericRanges(ruc, 2, 1, RucValidations.BIN_VALIDATOR_DIGIT, "BIN_VALIDATOR_DIGIT")) //"0-6;9-9";
            {
                return false;
            }

            //Validate Branch Digits
            if (!SharedMethods.ValidateInNumericRanges(ruc, 10, 3, RucValidations.BIN_LAST_DIGITS_RUC, "BIN_LAST_DIGITS_RUC")) //"001-999";
            {
                return false;
            }
        }
        return true;
    }
}
