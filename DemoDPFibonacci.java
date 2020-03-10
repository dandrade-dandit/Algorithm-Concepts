import java.util.concurrent.TimeUnit;

public class DemoDPFibonacci {
    static long[] memo;

    static long FibNaive (int n) {
        if (n == 1 || n == 2) return 1;
        else return FibNaive(n -1 ) + FibNaive(n - 2);
    }

    static long FibDpTopDown (int n) {
        long result;
        if (memo[n] != 0) return memo[n];
        if (n == 1 || n == 2) result = 1;
        else result = FibDpTopDown(n -1 ) + FibDpTopDown(n - 2);
        memo[n] = result;
        return result;
    }

    static long FibDpBottomUp (int n) {
        long f=0;
        long[] fib = new long[n+1];
        for (int i = 1; i <= n; i++) {
            if (i <= 2) f = 1;
            else f = fib[i - 1] + fib[i -2];
            fib[i] = f;
        }
        return fib[n];
    }

    public static void main(String[] args) {
        int n = 40;
        memo = new long[n+1];
        long startTime;
        long endTime;
        long timeElapsed;

        startTime = System.nanoTime();
        System.out.println("The result of Fibonacci (Naïve) of " + n + " is : " + FibNaive(n));
        endTime = System.nanoTime();
        timeElapsed = (endTime - startTime);
        System.out.println("Execution time: " + ((timeElapsed / 1000) > 1000 ? (double)(timeElapsed / 1_000_000_000.000) + " second(s)." : (timeElapsed / 1000) + " millisecond(s)."));

        startTime = System.nanoTime();
        System.out.println("The result of Fibonacci (DP Top Down) of " + n + " is : " + FibDpTopDown(n));
        endTime = System.nanoTime();
        timeElapsed = (endTime - startTime);
        System.out.println("Execution time: " + ((timeElapsed / 1000) > 1000 ? (double)(timeElapsed / 1_000_000_000.000)  + " second(s)." : (timeElapsed / 1000) + " millisecond(s)."));

        startTime = System.nanoTime();
        System.out.println("The result of Fibonacci (DP - Bottom UP) of " + n + " is : " + FibDpBottomUp(n));
        endTime = System.nanoTime();
        timeElapsed = (endTime - startTime);
        System.out.println("Execution time: " + ((timeElapsed / 1000) > 1000 ? (double)(timeElapsed / 1_000_000_000.000)  + " second(s)." : (timeElapsed / 1000) + " millisecond(s)."));
    }
}
