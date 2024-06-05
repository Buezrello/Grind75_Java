package grind75.addbinary;

/**
 * Given two decimal strings a and b, return their sum as a binary string.
 */
public class AddDecimal {
    public String addDecimal(String a, String b) {
        int carry = 0;
        StringBuilder sbA = new StringBuilder(a);
        StringBuilder sbB = new StringBuilder(b);
        StringBuilder sbResult = new StringBuilder();

        while (sbA.length() != 0 || sbB.length() != 0) {
           String lastA = removeLast(sbA);
           String lastB = removeLast(sbB);
           int temp = (Integer.parseInt(lastA) + Integer.parseInt(lastB) + carry) % 10;
           carry = (Integer.parseInt(lastA) + Integer.parseInt(lastB) + carry) / 10;
           sbResult.insert(0, temp);
        }
        if (carry != 0 || sbResult.length() == 0) {
            sbResult.insert(0, carry);
        }

        return sbResult.toString();
    }

    private String removeLast(StringBuilder sb) {
        if (sb.length() == 0) {
            return "0";
        }
        String str = String.valueOf(sb.charAt(sb.length()-1));
        sb.deleteCharAt(sb.length()-1);
        return str;
    }

    public static void main(String[] args) {
        AddDecimal addDecimal = new AddDecimal();
        System.out.println(addDecimal.addDecimal("11", "12"));
        System.out.println(addDecimal.addDecimal("123", "2"));
        System.out.println(addDecimal.addDecimal("0", "456"));
        System.out.println(addDecimal.addDecimal("0", "0"));
    }
}
