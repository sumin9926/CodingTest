package codingTest.src.defaultQuestions;

import java.util.ArrayList;

public class FindAllPrimeNumbers {
    public static void main(String[] args) {
        System.out.println(findPrimeListUnderNumber(20));
    }

    public static ArrayList<Integer> findPrimeListUnderNumber(int num) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] numArr = new boolean[num + 1];
        for (int i = 2; i <= num; i++) {
            numArr[i] = true;
        }

        for (int i = 2; i <= num; i++) { //가장 작은 수부터 배수만 순회하면서 삭제(false)한다
            if (numArr[i]) {
                for (int j = i * i; j <= num; j += i) {
                    numArr[j] = false;
                }
            }
        }

        for (int i = 2; i <= num; i++) {
            if (numArr[i]) result.add(i);
        }

        return result;
    }
}
