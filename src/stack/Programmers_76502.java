/*
 * [프로그래머스] 괄호 회전하기 (Lv.2)
 * https://school.programmers.co.kr/learn/courses/30/lessons/76502
 * 2026-02-02
 * [X] 자료구조 / 스택
 * */

package stack;

import java.util.HashMap;
import java.util.ArrayDeque;

public class Programmers_76502 {
    public static void main(String[] args) {
        int result = solution("[](){}");
        System.out.println(result);
    }

    private static int solution(String s) {
        // 올바른 괄호 짝
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        int slen = s.length();
        s += s;
        int answer = 0;

        // s의 길이만큼 회전
        A: for (int i = 0; i < slen; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();

            // i ~ n개가 올바른 괄호인지 확인(회전했다 침)
            for (int j = i; j < i + slen; j++) {
                char c = s.charAt(j);

                // 열린 괄호라면
                if (!map.containsKey(c)) {
                    stack.push(c);
                }
                // 닫힌 괄호라면
                else {
                    // 스택이 비어있거나 괄호 짝이 안맞으면 다음 회전으로
                    if (stack.isEmpty() || !stack.pop().equals(map.get(c))) {
                        continue A;
                    }
                }
            }

            // 회전한 괄호 확인이 끝나고 스택이 비어있으면 올바른 괄호
            if (stack.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}
