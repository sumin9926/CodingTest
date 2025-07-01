package codingTest.src.defaultQuestions;

public class FindMaxPlusOrMultiply {
    public static void main(String[] args) {
        System.out.println(findMaxResult(new int[]{0,3,5,6,1,2,4}));
        System.out.println(findMaxResult(new int[]{3,2,1,5,9,7,4}));
        System.out.println(findMaxResult(new int[]{1,1,1,3,3,2,5}));
    }

    public static int findMaxResult(int[] array){
        int result = array[0];
        for(int i=1; i<array.length; i++){
            result = Math.max(array[i]*result, array[i]+result);
        }
        return result;
    }
}
