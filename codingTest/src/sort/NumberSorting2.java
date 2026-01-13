package codingTest.src.sort;

import java.io.*;
import java.util.Arrays;

public class NumberSorting2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        // 오름차순 정렬
        // 퀵 정렬
//        quickSort(nums, 0, N-1);
//        for (int num : nums) {
//            bw.write(Integer.toString(num));
//            bw.newLine();
//        }

        // 병합 정렬
        int[] sortedNums = mergeSort(nums);
        for (int num : sortedNums) {
            bw.write(Integer.toString(num));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    // 병합 정렬 오름차순 구현
    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) return arr;
        else {
            int mid = arr.length / 2;
            int[] leftArr = mergeSort(Arrays.copyOfRange(arr, 0, mid));
            int[] rightArr = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

            return merge(leftArr, rightArr);
        }
    }

    public static int[] merge(int[] leftArr, int[] rightArr) {
        int[] mergedArr = new int[leftArr.length + rightArr.length];
        int l = 0, r = 0, idx = 0;

        while (l < leftArr.length && r < rightArr.length) {
            if (leftArr[l] < rightArr[r]) {
                mergedArr[idx++] = leftArr[l++];
            } else {
                mergedArr[idx++] = rightArr[r++];
            }
        }

        while (l < leftArr.length) {
            mergedArr[idx++] = leftArr[l++];
        }

        while (r < rightArr.length) {
            mergedArr[idx++] = rightArr[r++];
        }

        return mergedArr;
    }

//    // 퀵 정렬 오름차순 구현
//    public static void quickSort(int[] arr, int low, int high){
//        if(low<high){
//            int pivotIndex = partition(arr, low, high);
//            quickSort(arr, low, pivotIndex-1); //pivot 기준 작은 수 (왼쪽)
//            quickSort(arr, pivotIndex+1, high); //pivot 기준 큰 수 (오른쪽)
//        }
//    }
//
//    public static int partition(int[] arr, int low, int high){
//        int mid = low+(high-low)/2;
//        swap(arr, mid, high);
//        int pivot = arr[high];
//        int i=low;
//
//        for(int j=low; j<high; j++){
//            if(arr[j]<=pivot){ //pivot 보다 작은 수는 왼쪽으로
//                swap(arr, i, j);
//                i++;
//            }
//        }
//        swap(arr, i, high);
//        return i;
//    }
//
//    public static void swap(int[] arr, int i, int j){
//        int tmp = arr[i];
//        arr[i]=arr[j];
//        arr[j]=tmp;
//    }
}
