package grind75.climbingstairs;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
//        System.out.println(climbingStairs.climbStairs(2));
//        System.out.println(climbingStairs.climbStairs(3));
//        System.out.println(climbingStairs.climbStairs(4));
        System.out.println(climbingStairs.climbStairs(5));
    }

    public int climbStairs(int n) {

        if (n==1 || n==2 || n==3) {
            return n;
        }

        int prev = 3;
        int prevPrev = 2;
        for (int i=4; i<n; i++) {
            int temp = prev + prevPrev;
            prevPrev = prev;
            prev = temp;
        }

        return prevPrev + prev;
    }
}
