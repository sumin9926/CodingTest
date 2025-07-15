package codingTest.src.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectionSort(new int[]{4,6,2,9,1})));
    }
    public static int[] selectionSort(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            int min=arr[i], minIndex=i;
            for(int j=i+1; j<arr.length; j++){
                if(min>arr[j]){
                    min=arr[j];
                    minIndex=j;
                }
            }
            if(min!=arr[i]){
                int tmp=arr[minIndex];
                arr[minIndex]=arr[i];
                arr[i]=tmp;
            }
        }
        return arr;
    }
}
