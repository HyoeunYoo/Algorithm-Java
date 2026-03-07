/*
 * [책] 15번 - 요세푸스 문제
 * 2026.03.07
 * [O] 자료구조 / 큐
 * */

package queue;

import java.util.ArrayDeque;

public class Book_15_2 {
    public static void main(String[] args) {
        System.out.println(solution(5, 2));
    }

    private static int solution(int N, int K) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            for (int i = 0; i < K - 1; i++) {
                queue.add(queue.poll());
            }
            // K번째 제거
            queue.poll();
        }

        return queue.poll();
    }
}
