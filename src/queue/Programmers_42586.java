/*
 * [프로그래머스] 기능개발 (Lv.2)
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 * 2026-03-07
 * [O] 자료구조 / 큐
 * */

package queue;

import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Programmers_42586 {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    private static int[] solution(int[] progresses, int[] speeds) {
        // 배포 가능일 계산
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }

        // 결과
        ArrayList<Integer> answer = new ArrayList<>();

        // 앞의 기능 배포일
        int deploy = queue.poll();
        int count = 1;

        while (!queue.isEmpty()) {
            // 뒤의 기능 배포 가능일과 비교
            int next = queue.poll();
            // 뒤의 기능 배포 가능하면 추가, 아니면 다음 배포로 지정
            if (deploy >= next)
                count++;
            else {
                answer.add(count);
                deploy = next;
                count = 1;
            }
        }
        answer.add(count);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
