package codingTest.src.search;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new int[]{4, 6, 2, 9, 1})));
    }

    public static int[] bubbleSort(int[] arr){
        for(int i=arr.length-1; i>0; i--){
            boolean swapped = false;
            int j=0, tmp;
            while(j<i){
                if(arr[j]>arr[j+1]){
                    tmp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=tmp;
                    swapped=true;
                }
                j++;
            }
            if(!swapped) break; // 정렬 완료시 즉시 종료
        }

        return arr;
    }
}
