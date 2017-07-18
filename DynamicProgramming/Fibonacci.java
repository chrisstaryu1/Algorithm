
public static long fibonacciDP(int n) {

long[] results = new long[n+1];
    results[1] = 1;

    results[2] = 1;

    for (int i = 3; i <= n; i++) {

        results[i] = results[i-1] + results[i-2];

    }

    return results[n];

}
