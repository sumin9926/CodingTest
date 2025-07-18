package codingTest.src.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[]{5,3,4,1,2})));
    }

    public static int[] mergeSort(int[] arr){
        if(arr.length<=1) return arr;
        int totalLen= arr.length, a = totalLen/2, b=totalLen-a;
        int[] arrA=new int[a], arrB=new int[b];
        System.arraycopy(arr, 0, arrA, 0, a);
        System.arraycopy(arr, a, arrB, 0, b);

        return merge(mergeSort(arrA), mergeSort(arrB));
    }
    public static int[] merge(int[] arrA, int[] arrB) {
        int a=arrA.length, b=arrB.length;
        int[] result = new int[a+b];
        int indexA = 0, indexB = 0, indexResult=0;

        //리팩토링 후
        while(indexA<a && indexB<b){
            if (arrA[indexA] <= arrB[indexB]) {
                result[indexResult++] = arrA[indexA++];
            } else {
                result[indexResult++] = arrB[indexB++];
            }
        }
        while(indexA<a){
            result[indexResult++]=arrA[indexA++];
        }
        while(indexB<b){
            result[indexResult++]=arrB[indexB++];
        }

        return result;
    }
}
