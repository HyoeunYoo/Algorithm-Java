/*
 * [책] 08번 - 올바른 괄호
 * 2025.05.02
 * [O] 자료구조 / 스택
 * */

package stack;

import java.util.ArrayDeque;
import java.util.Stack;

public class Book_08 {
    public static boolean solution(String s) {
        // Stack 클래스보다 ArrayDeque 클래스를 사용하자 (성능 이슈)
        // Stack<Character> stack = new Stack<>();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        char[] a = s.toCharArray();

        for (char i : a) {
            if (i == '(') {
                stack.push(i);
//            } else if (!stack.isEmpty() && stack.peek() == '(') {
//                stack.pop();
//            } else {
//                stack.push(i);
//            }

            // peek 대신 pop하여 짝이 안맞음을 확인하면 바로 종료한다.
            } else {
                if (stack.isEmpty() || stack.pop() == i) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(()(";
        boolean answer = solution(s);
        System.out.println(answer);
    }
}
