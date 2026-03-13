/*
 * [프로그래머스] 다리를 지나는 트럭 (Lv.2)
 * https://school.programmers.co.kr/learn/courses/30/lessons/42583
 * 2026-03-13
 * [O] 자료구조 / 큐
 * */

package queue;

import java.util.ArrayDeque;

public class Programmers_42583 {
    public static void main(String[] args) {
        int result = solution(2, 10, new int[]{7,4,5,6});
        System.out.println(result);
    }

    private static int solution(int bridge_length, int weight, int[] truck_weights) {
        // 다리 큐 생성
        ArrayDeque<Integer> bridgeQ = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) {
            bridgeQ.addLast(0);
        }

        int waitIdx = 0; // 대기 트럭 인덱스
        int bridgeWeight = 0; // 다리 위 트럭 무게 합
        int time = 0; // 걸리는 시간

        // 대기 트럭이 없을 때까지 반복
        while (waitIdx < truck_weights.length) {
            // 맨 앞 트럭 건너고 무게 계산
            bridgeWeight -= bridgeQ.pollFirst();

            // 다음 트럭 건너도 되면 다리 큐에 추가, 무게 추가
            if (bridgeWeight + truck_weights[waitIdx] <= weight) {
                bridgeQ.addLast(truck_weights[waitIdx]);
                bridgeWeight += truck_weights[waitIdx];
                waitIdx++;
            }
            // 안되면 0 추가
            else
                bridgeQ.addLast(0);

            time ++;
        }

        return time + bridge_length;
    }
}
