package codingTest.src.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CoordinateCompression {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sortedNum = new int[N];
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            nums[i]=num;
            sortedNum[i]=num;
        }

        Arrays.sort(sortedNum);
        //유니크 배열 생성
        int idx=0;
        for(int i=0; i<N; i++){
            if(i==0||sortedNum[i]!=sortedNum[i-1]){
                sortedNum[idx++]=sortedNum[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int num:nums){
            int c = Arrays.binarySearch(sortedNum, 0, idx, num);
            sb.append(c).append(" ");
        }

        System.out.print(sb);
    }
}
