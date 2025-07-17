package codingTest.src.sort;

import java.util.Arrays;

public class MergeSortSimple {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[]{1, 2, 3, 5, 4, 6, 7, 8})));
        System.out.println(Arrays.toString(mergeSort(new int[]{-7, -1, 9, 40, 5, 6, 10, 11})));
        System.out.println(Arrays.toString(mergeSort(new int[]{-1, -1, 0, 1, 6, 9, 10})));
    }

    public static int[] mergeSort(int[] arr) {
        int totalLen= arr.length;
        int a = totalLen/2, b=totalLen-a;
        int[] arrA=new int[a], arrB=new int[b];

        System.arraycopy(arr, 0, arrA, 0, a);
        System.arraycopy(arr, a, arrB, 0, b);

        int[] result = new int[totalLen];
        int indexA = 0, indexB = 0, indexResult=0;

        //리팩토링 전
//        for (int i = 0; i < result.length; i++) {
//            if (indexA < arrA.length && indexB < arrB.length) {
//                if (arrA[indexA] < arrB[indexB]) {
//                    result[i] = arrA[indexA];
//                    indexA++;
//                } else {
//                    result[i] = arrB[indexB];
//                    indexB++;
//                }
//            } else if (indexA >= arrA.length && indexB < arrB.length) {
//                result[i] = arrB[indexB];
//                indexB++;
//            } else {
//                result[i] = arrA[indexA];
//                indexA++;
//            }
//        }

        //리팩토링 후
        while(indexA<a && indexB<b){
            if (arrA[indexA] < arrB[indexB]) {
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
