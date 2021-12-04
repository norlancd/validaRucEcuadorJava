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
public class SharedMethods {

    public static boolean ValidateInRanges(String ruc, int valueInitPos, int valueLastPos, String valueRanges, String validationName) {
        try {
            String valueDigits = ruc.substring(valueInitPos, valueInitPos + valueLastPos);
            int value = Integer.parseInt(valueDigits);
            String[] acceptedValues = valueRanges.split(";");

            for (int i = 0; i < acceptedValues.length; i++) {
                String[] range = acceptedValues[i].split("-");
                int rangeMinValue = Integer.parseInt(range[0]);
                int rangeMaxValue = Integer.parseInt(range[1]);
                if ((rangeMinValue <= value) && (rangeMaxValue >= value)) {
                    return true;
                }
            }
            System.out.println(String.format("%1$s debe estar dentro de los rangos aceptados [%2$s]", validationName, valueRanges));
            return false;
        } catch (RuntimeException e) {
            return false;
        }
    }
}
