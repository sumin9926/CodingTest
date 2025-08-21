package codingTest.src.stackAndQueue;

import java.util.*;
import java.util.function.Supplier;

public class DequeVsStackBenchmark {
    static final int N = 1_000_000;       // 한 번에 넣고/빼는 원소 수
    static final int WARMUP = 2;          // 워밍업 라운드
    static final int ROUNDS = 3;          // 측정 라운드

    public static void main(String[] args) {
        System.out.printf("N=%d, WARMUP=%d, ROUNDS=%d%n%n", N, WARMUP, ROUNDS);

        benchStackLike("ArrayDeque<>()           (default cap)", ArrayDeque::new); //기본 용량 → 중간에 여러 번 리사이즈 발생
        benchStackLike("ArrayDeque<>(N)         (JDK rounds pow2)", () -> new ArrayDeque<Integer>(N)); // 초기 용량을 N으로 지정 → JDK가 내부에서 2의 거듭제곱으로 자동 반올림
        benchStackLike("ArrayDeque<>(nextPow2)", () -> new ArrayDeque<Integer>(nextPow2(N))); // 직접 2의 거듭제곱으로 지정
        benchStackLike("LinkedList", LinkedList::new); // Deque API로 push/pop 사용
        benchStackLikeStack("Stack");                  // java.util.Stack 직접 테스트
    }

    // ---------------------- Stack-like (Deque) ----------------------
    static void benchStackLike(String name, Supplier<Deque<Integer>> sup) {
        // 워밍업
        for (int w = 0; w < WARMUP; w++) runStackLikeOnce(sup.get());

        long[] times = new long[ROUNDS];
        for (int r = 0; r < ROUNDS; r++) {
            Deque<Integer> ds = sup.get();
            long t = runStackLikeOnce(ds);
            times[r] = t;
            ds.clear();
        }
        printStats(name, times);
    }

    static long runStackLikeOnce(Deque<Integer> s) {
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) s.push(i);  // push (LIFO)
        for (int i = 0; i < N; i++) {
            Integer v = s.pop();                // pop
            if (v == null) throw new AssertionError("null!");
        }
        return System.nanoTime() - start;
    }

    // ---------------------- Stack-like (java.util.Stack) ----------------------
    static void benchStackLikeStack(String name) {
        // 워밍업
        for (int w = 0; w < WARMUP; w++) runStackLikeOnceStack(new Stack<>());

        long[] times = new long[ROUNDS];
        for (int r = 0; r < ROUNDS; r++) {
            Stack<Integer> s = new Stack<>();
            long t = runStackLikeOnceStack(s);
            times[r] = t;
            s.clear();
        }
        printStats(name + " (synchronized)", times);
    }

    static long runStackLikeOnceStack(Stack<Integer> s) {
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) s.push(i);
        for (int i = 0; i < N; i++) {
            Integer v = s.pop();
            if (v == null) throw new AssertionError("null!");
        }
        return System.nanoTime() - start;
    }

    // ---------------------- 공통 유틸 ----------------------
    static int nextPow2(int x) { // x 이상인 가장 가까운 2의 거듭제곱 수를 구하는 함수. 인덱스 연산 최적화에 사용.
        int n = 1;
        while (n < x) n <<= 1;
        return n;
    }

    static void printStats(String name, long[] timesNs) {
        double[] ms = new double[timesNs.length];
        double sum = 0;
        for (int i = 0; i < timesNs.length; i++) {
            ms[i] = timesNs[i] / 1_000_000.0;
            sum += ms[i];
        }
        double avg = sum / ms.length;

        System.out.printf(Locale.US, "%-26s avg = %8.2f ms  (runs: %s)%n",
                name, avg, Arrays.toString(ms));
    }
}