package codingTest.src.recursiveCall;

public class FactorialRecursive {
    public static void main(String[] args) {
        System.out.println(factorial(5L));
    }

    public static long factorial(long num){
        if(num==1L){
            return 1L;
        }
        return num*factorial(num-1);
    }
}
