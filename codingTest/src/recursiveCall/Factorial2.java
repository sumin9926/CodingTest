package codingTest.src.recursiveCall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        System.out.print(factorial(N));
    }

    static long factorial(long n) {
        if (n == 0L || n == 1L) return 1L;
        else {
            return n * factorial(n - 1);
        }
    }
}
