package codingTest.src.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SugarDelivery {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 방법 1 브루트 포스
        int cnt=10_000;
        for (int i = 0; i <= N/5; i++) { //5kg 개수
            int left=N - 5 * i;
            if (left % 3 == 0) {
                cnt = Math.min(cnt, (i + left / 3));
            }
        }

        if (cnt == 10_000) {
            System.out.println(-1);
        } else {
            System.out.println(cnt);
        }

//        // 방법 2 DP
        int[] cntArr = new int[N + 1]; // 최소 봉지 개수
        Arrays.fill(cntArr, 10_000); // 최소 봉지 개수는 최대값으로 초기화
        int[] types = new int[]{3,5}; // 봉지 종류
        cntArr[0]=0; // 중요

        for (int k : types) {
            for (int j = k; j < N + 1; j++) {
                cntArr[j] = Math.min(cntArr[j], cntArr[j - k] + 1);
            }
        }

        if (cntArr[N] == 10_000) {
            System.out.println(-1);
        } else {
            System.out.print(cntArr[N]);
        }

        // 방법 3 수학
        int cnt5 = N / 5;
        if (N % 5 != 0) {
            int left = N - cnt5 * 5;
            while (cnt5 >= 0) {
                if (left % 3 == 0) {
                    System.out.println(cnt5 + left / 3);
                    return;
                }
                cnt5--;
                left += 5;
            }
            System.out.println(-1);
        } else {
            System.out.println(cnt5);
        }
    }
}
