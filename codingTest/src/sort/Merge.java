package codingTest.src.sort;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(new int[]{1, 2, 3, 5}, new int[]{4, 6, 7, 8})));
        System.out.println(Arrays.toString(merge(new int[]{-7, -1, 9, 40}, new int[]{5, 6, 10, 11})));
        System.out.println(Arrays.toString(merge(new int[]{-1, -1, 0}, new int[]{1, 6, 9, 10})));
        System.out.println(Arrays.toString(merge(new int[]{5, 3, 4}, new int[]{1, 2})));
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
