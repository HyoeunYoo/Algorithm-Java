/*
 * [프로그래머스] 실패율 (Lv.1)
 * https://school.programmers.co.kr/learn/courses/30/lessons/42889
 * 2026-01-23
 * [X] 자료구조 / 배열
 * */

package array;

import java.util.*;

public class Programmers_42889 {
    public static void main(String[] args) {
        int N = 4;
        int[] stages = {4, 4, 4, 4, 4};
        int[] result = solution(N, stages);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(int N, int[] stages) {
        // 결과 배열
        int[] answer = new int[N];
        // 실패율 배열
        double[][] fail = new double[N][2];
        // 실패율 0번째 열을 스테이지 번호로 초기화
        for (int i = 0; i < N; i++) {
            fail[i][0] = i + 1;
        }

        // 실패율 계산, 1번째 열에 저장
        for (int i = 0; i < N; i++) {
            int challenge = 0, clear = 0; // 도전중인 유저 수, 도전중이거나 클리어한 유저 수
            for (int stage : stages) {
                if (i + 1 == stage) {
                    challenge++;
                }
                if (i + 1 <= stage) {
                    clear++;
                }
            }
            fail[i][1] = (double) challenge / clear;
        }

        // 정렬
        Arrays.sort(fail, (a, b) -> {
            // 1번째 열이 동일하면 0번째 열 오름차순
            if (a[1] == b[1]) {
                return Double.compare(a[0], b[0]);
            } else {
                // 1번째 열 내림차순
                return Double.compare(b[1], a[1]);
            }
        });

        for (int i = 0; i < answer.length; i++) {
            answer[i] = (int) fail[i][0];
        }

        return answer;
    }
}
