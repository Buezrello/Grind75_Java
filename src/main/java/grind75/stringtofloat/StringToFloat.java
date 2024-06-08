package grind75.stringtofloat;

/**
 * Get string, return float
 */

public class StringToFloat {

    private static float stringToFloat(String str) {
        if (str == null || str.isEmpty()) {
            throw new NumberFormatException("String is null or empty");
        }

        float result = 0;
        boolean negative = false;
        int start = 0;
        boolean decimal = false;
        float decimalDivisor = 1;

        if (str.charAt(0) == '-') {
            negative = true;
            start = 1;
        }

        for (int i = start; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '.') {
                if (decimal) {
                    throw new NumberFormatException("Two decimal characters not allowed");
                }
                decimal = true;
                continue;
            }
            if (c < '0' || c > '9') {
                throw new NumberFormatException("Illegal character '" + c + "'");
            }

            int digit = c - '0';
            if (decimal) {
                decimalDivisor *= 10;
                result += digit / decimalDivisor;
            } else {
                result = result * 10 + digit;
            }
        }

        return negative ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(stringToFloat("-12345"));
    }
}
