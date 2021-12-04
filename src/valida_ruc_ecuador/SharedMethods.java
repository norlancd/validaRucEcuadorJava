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

    public static boolean ValidateInNumericRanges(String data, int position, int characters, String ranges) {
        return ValidateInNumericRanges(data, position, characters, ranges, "El valor");
    }

    public static boolean ValidateInNumericRanges(String data, int position, int characters, String ranges, String validationName) {
        try {
            String valueDigits = data.substring(position, position + characters);
            int value = Integer.parseInt(valueDigits);
            String[] acceptedValues = ranges.split(";");

            for (int i = 0; i < acceptedValues.length; i++) {
                String[] range = acceptedValues[i].split("-");
                int rangeMinValue = Integer.parseInt(range[0]);
                int rangeMaxValue = Integer.parseInt(range[1]);
                if ((rangeMinValue <= value) && (rangeMaxValue >= value)) {
                    return true;
                }
            }
            System.out.println(String.format("%1$s debe estar dentro de los rangos aceptados [%2$s]", validationName, ranges));
            return false;
        } catch (Exception e) {
            System.out.println(String.format("%1$s [%2$s]", "Excepción", e.toString()));
            return false;
        }
    }
}
