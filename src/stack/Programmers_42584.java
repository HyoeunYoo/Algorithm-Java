/*
 * [프로그래머스] 주식가격 (Lv.2)
 * https://school.programmers.co.kr/learn/courses/30/lessons/42584
 * 2026-02-05
 * [X] 자료구조 / 스택
 * */

package stack;

import java.util.Arrays;
import java.util.ArrayDeque;

public class Programmers_42584 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(prices)));
    }

    private static int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for (int i = 1; i < n; i++) {
            // 가격이 떨어졌다면 현재 가격이 더 클 때까지 pop하며 기간 계산
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                // 이전 주식의 기간 계산
                int j = stack.pop();
                answer[j] = i - j;
            }
            // 기간이 확정되지 않은 주식은 스택에 저장
            stack.push(i);
        }

        // 스택에 남은 건 한번도 가격이 안떨어진 주식의 인덱스
        while (!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = n - 1 - j;
        }

        return answer;
    }
}
