package codingTest.src.sort;

import java.io.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberSorting3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N=Integer.parseInt(br.readLine());

        // 병합정렬로 풀어보기 (메모리: 304764kb, 시간: 2332ms)
//        Map<Integer, Integer> hm = new HashMap<>();
//        for(int i=0; i<N; i++){
//            int num  = Integer.parseInt(br.readLine());
//            hm.put(num, hm.getOrDefault(num,0)+1);
//        }
//
//        Integer[] arr = hm.keySet().toArray(new Integer[0]);
//        Integer[] sortedArr = mergeSort(arr);

//        for(Integer n : sortedArr){
//            int cnt = hm.get(n);
//            for(int i=0; i<cnt; i++){
//                bw.write(Integer.toString(n));
//                bw.newLine();
//            }
//        }

        // 카운팅 배열 (메모리: 300972kb, 시간: 1848ms)
        int[] countingArr = new int[10001];

        for(int i=0; i<N; i++){
            int idx = Integer.parseInt(br.readLine());
            countingArr[idx]+=1;
        }

        for(int i=0; i< countingArr.length; i++){
            int cnt = countingArr[i];
            if(cnt>0){
                for(int j=0; j<cnt; j++){
                    bw.write(Integer.toString(i));
                    bw.newLine();
                }
            }
        }

        bw.flush();
        bw.close();
    }

//    // 오름차순 정렬
//    public static Integer[] mergeSort(Integer[] arr){
//        if(arr.length<=1) return arr;
//        else{
//            int mid = arr.length/2;
//            Integer[] leftArr = mergeSort(Arrays.copyOfRange(arr, 0, mid));
//            Integer[] rightArr = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
//
//            return merge(leftArr,rightArr);
//        }
//    }
//
//    public static Integer[] merge(Integer[] leftArr, Integer[] rightArr){
//        Integer[] mergedArr = new Integer[leftArr.length+ rightArr.length];
//        int l=0, r=0, idx=0;
//
//        while(l<leftArr.length && r<rightArr.length){
//            if(leftArr[l]>rightArr[r]){
//                mergedArr[idx++]=rightArr[r++];
//            }else{
//                mergedArr[idx++]=leftArr[l++];
//            }
//        }
//
//        while(l<leftArr.length){
//            mergedArr[idx++]=leftArr[l++];
//        }
//
//        while(r<rightArr.length){
//            mergedArr[idx++]=rightArr[r++];
//        }
//
//        return mergedArr;
//    }
}
