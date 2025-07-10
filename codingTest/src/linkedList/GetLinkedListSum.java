package codingTest.src.linkedList;

import java.util.Arrays;
import java.util.LinkedList;

public class GetLinkedListSum {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>(Arrays.asList(6, 7, 8));
        LinkedList<Integer> list2 = new LinkedList<>(Arrays.asList(3, 5, 4));

        System.out.println(getLinkedListSum(list1, list2));
    }

    public static int getLinkedListSum(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        int num1 = makeInt(list1), num2 = makeInt(list2);

        return num1+num2;
    }

    public static int makeInt(LinkedList<Integer> list) {
        int result = 0, mul = 1;
        for(int i=list.size()-1; i>=0 ; i--){
            result+=list.remove(i)*mul;
            mul*=10;
        }

        return result;
    }
}
