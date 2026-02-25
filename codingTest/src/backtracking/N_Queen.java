package codingTest.src.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_Queen {
    static int N, total;
    static long nMask;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nMask = (1L << N) - 1L; // n = 00...0111..11(N개만큼 1 표시)
        int half = N / 2;
        for (int c = 0; c < half; c++) { //0행에서의 퀸 시작점을 c열로 고정
            long checkCal = 1L << c;
            NQueen(1, checkCal, checkCal << 1, checkCal >> 1); //1~(N-1)행까지의 경우의 수만 판별
        }
        total *= 2;

        if (N % 2 != 0) { //N이 홀수일 경우, 0행의 중간 cal에 퀸을 놓았을 때의 경우의 수를 따로 total에 더해야함
            long checkCal = 1L << half;
            NQueen(1, checkCal, checkCal << 1, checkCal >> 1);
        }

        System.out.print(total);
    }

    /* 퀸의 공격 방향을 비트로 표시한 col, diag1, diag2을 조합해 놓을 수 있는 곳 유추
     * 1로 표시된 곳은 이미 놓여져있는 곳
     */
    //diag1: 좌상->우하, diag2: 우상->좌하
    private static void NQueen(int row, long col, long diag1, long diag2) {
        if (row >= N) {
            total++;
        } else {
            long availableCol = nMask & ~(col | diag1 | diag2); // 현재 행에서 놓을 수 있는 곳
            while (availableCol != 0) {
                long checkCol = availableCol & -availableCol; //가장 오른쪽 1을 제외한 나머지 비트를 0으로 반전
                availableCol -= checkCol;
                NQueen(row + 1, (col | checkCol), (diag1 | checkCol) << 1, (diag2 | checkCol) >> 1);
            }
        }
    }
}
