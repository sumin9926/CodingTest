package codingTest.src.stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
    }

    public static boolean solution(String s) {

        Deque<Character> dq = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if(c=='('){
                dq.addFirst(c);
            }else{
                if(dq.isEmpty()) return false;
                dq.pop();
            }
        }

        return dq.isEmpty();
    }
}
