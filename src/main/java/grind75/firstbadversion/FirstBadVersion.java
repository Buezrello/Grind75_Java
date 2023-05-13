package grind75.firstbadversion;

/**
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 * which causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which returns whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 * @author Igor Gindin
 * @since 25/01/2023
 */
public class FirstBadVersion {

    private int badVersion = 1;

    public static void main(String[] args) {


        final FirstBadVersion firstBadVersion = new FirstBadVersion();

        firstBadVersion.badVersion = 4;
        System.out.println(firstBadVersion.firstBadVersion(5));

        firstBadVersion.badVersion = 1;
        System.out.println(firstBadVersion.firstBadVersion(1));
    }

    int firstBadVersion(int n) {
        for (int start = 1;start <= n;) {
            int middle = start + ((n - start) / 2);
            boolean isBadVersionMiddle = isBadVersion(middle);
            if (isBadVersionMiddle && !isBadVersion(middle-1)) {
                return middle;
            }
            if (isBadVersionMiddle) {
                n = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return 1;
    }

    private boolean isBadVersion(int version) {
        return version == badVersion;
    }
}

