package codingTest.src.sort;

import java.io.*;

public class NumberSorting2 {
    static int[] nums, temps;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        // 오름차순 정렬
        // 퀵 정렬
//        quickSort(nums, 0, N-1);

        // 인덱스 기반 병합 정렬
        temps = new int[N];
        mergeSort(0, N-1);
        for (int num : nums) {
            bw.write(Integer.toString(num));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    // 인덱스 기반 병합 정렬 오름차순 구현
    public static void mergeSort(int start, int end) {
        if (start>=end) return;
        else {
            int mid = (end+start) / 2;
            mergeSort(start, mid);
            mergeSort(mid+1,end);

            merge(start, mid, end);
        }
    }

    public static void merge(int start, int mid, int end) {
        int l = start, r = mid+1, idx = start;

        while (l <= mid && r <= end) {
            if (nums[l] <= nums[r]) {
                temps[idx++] = nums[l++];
            } else {
                temps[idx++] = nums[r++];
            }
        }

        while (l <= mid) {
            temps[idx++] = nums[l++];
        }

        while (r <= end) {
            temps[idx++] = nums[r++];
        }

        for(int i=start; i<=end; i++){
            nums[i]= temps[i];
        }
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
