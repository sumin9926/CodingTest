package codingTest.src.stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeBenchmark {
    private static final int N = 1_000_000; // 테스트 데이터 100만 건

    public static void main(String[] args) {
        // ArrayDeque 테스트
        Deque<Integer> arrayDeque = new ArrayDeque<>();
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            arrayDeque.offerLast(i); // 뒤에 삽입
        }
        for (int i = 0; i < N; i++) {
            arrayDeque.pollFirst(); // 앞에서 제거
        }
        long end = System.nanoTime();
        System.out.printf("ArrayDeque  : %d ms%n", (end - start) / 1_000_000);

        // LinkedList 테스트
        Deque<Integer> linkedList = new LinkedList<>();
        start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            linkedList.offerLast(i);
        }
        for (int i = 0; i < N; i++) {
            linkedList.pollFirst();
        }
        end = System.nanoTime();
        System.out.printf("LinkedList  : %d ms%n", (end - start) / 1_000_000);
    }
}
