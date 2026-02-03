/*
 * [프로그래머스] 짝지어 제거하기 (Lv.2)
 * https://school.programmers.co.kr/learn/courses/30/lessons/12973
 * 2026-02-03
 * [O] 자료구조 / 스택
 * */

package stack;

import java.util.ArrayDeque;

public class Programmers_12973 {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
    }

    private static int solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            }
            else if (s.charAt(i) == stack.peek()) {
                stack.pop();
            }
            else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
