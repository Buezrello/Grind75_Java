package grind75.addbinary;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder aSB = new StringBuilder(a);
        StringBuilder bSB = new StringBuilder(b);
        int carry = 0;

        StringBuilder sbRes = new StringBuilder();

        while (aSB.length() != 0 || bSB.length() != 0) {
            String aLast = removeLast(aSB);
            String bLast = removeLast(bSB);
            int temp = (Integer.parseInt(aLast) + Integer.parseInt(bLast) + carry) % 2;
            carry = (Integer.parseInt(aLast) + Integer.parseInt(bLast) + carry) / 2;
            sbRes.insert(0, temp);
        }
        if (carry != 0 || sbRes.length() == 0) {
            sbRes.insert(0, carry);
        }

        return sbRes.toString();
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
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("11", "1"));
        System.out.println(addBinary.addBinary("1010", "1011"));
        System.out.println(addBinary.addBinary("0", "0"));
    }
}
