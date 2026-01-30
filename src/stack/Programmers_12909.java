/*
 * [프로그래머스] 올바른 괄호 (Lv.2)
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
 * 2026-01-30
 * [O] 자료구조 / 스택
 * */

package stack;

import java.util.Stack;

public class Programmers_12909 {
    public static void main(String[] args) {
        String s = "(()(";
        boolean result = solution(s);

        System.out.println(result);
    }

    private static boolean solution(String s) {
        char[] charsarr = s.toCharArray();

        Stack<Character> stack = new Stack<>();


        for (char chars : charsarr) {
            if (chars == '(') {
                stack.push(chars);
            } else {
                if (stack.isEmpty() || stack.pop() != '(') { // 또는 stack.pop() == c
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
