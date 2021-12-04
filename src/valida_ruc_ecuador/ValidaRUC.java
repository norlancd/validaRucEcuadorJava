/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valida_ruc_ecuador;

import java.util.regex.Pattern;
import valida_ruc_ecuador.Contants.RegularExpression;
import valida_ruc_ecuador.Contants.VATLength;

/**
 *
 * @author mint
 */
public class ValidaRUC {

    public static boolean ValidateRUC(String ruc) {
        String regex = RegularExpression.NUMBERS;
        String quantifier = "{" + VATLength.LENGTH_RUC + "}";
        regex += quantifier;

        Pattern pattern = Pattern.compile(regex);
        if (!pattern.matcher(ruc).matches()) {
            System.out.println(String.format("No cumple con la expresion regular %1$s", regex));
            return false;
        } else {
            //Validate Validator Digit
            if (!SharedMethods.ValidateInRanges(ruc, 2, 1, VATLength.BIN_VALIDATOR_DIGIT, "BIN_VALIDATOR_DIGIT")) //"0-6;9-9";
            {
                return false;
            }

            //Validate Provinces
            if (!SharedMethods.ValidateInRanges(ruc, 0, 2, VATLength.BIN_NUMBER_OF_PROVINCES, "BIN_NUMBER_OF_PROVINCES")) //"01-24;31-31;80-85";
            {
                return false;
            }

            //Validate Branch Digits
            if (!SharedMethods.ValidateInRanges(ruc, 10, 3, VATLength.BIN_LAST_DIGITS_RUC, "BIN_LAST_DIGITS_RUC")) //"001-999";
            {
                return false;
            }
        }
        return true;
    }
}
