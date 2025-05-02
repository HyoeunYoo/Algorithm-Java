/*
 * [책] 15번 - 요세푸스 문제
 * 2025.05.02
 * [O] 자료구조 / 큐
 * */

package queue;

import java.util.ArrayDeque;

public class Book_15 {
    public static Integer solution(int n, int k) {
        // 1부터 n까지 번호를 큐에 추가
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            queue.addLast(i + 1);
        }

        // 큐에 하나만 남을 때까지 반복
        while (queue.size() > 1) {
            // 앞에서부터 k-1번째까지 제거하고 뒤에 추가
            for (int i = 0; i < k - 1; i++) {
                queue.addLast(queue.pollFirst());
            }
            // k번째 번호 제거
            queue.pollFirst();
        }

        // 마지막에 남은 번호 반환
        return queue.pollFirst();
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        int answer = solution(n, k);
        System.out.println(answer);
    }
}
