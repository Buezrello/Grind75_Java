package fiveyearscodinginterview;

/**
 * Sum Digits of a Positive Integer Until a Single Digit is Obtained
 */
public class SumOfPositiveIntegers {

    public static int sumOfPositiveIntegers(int n) {
        while (n >= 10) {
            n = sumOfDigits(n);
        }

        return n;
    }

    private static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 5674;
        System.out.println(sumOfPositiveIntegers(n));
    }
}
