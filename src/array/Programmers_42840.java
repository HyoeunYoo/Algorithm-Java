/*
 * [프로그래머스] 모의고사 (Lv.1)
 * https://school.programmers.co.kr/learn/courses/30/lessons/42840
 * 2026-01-20
 * [O] 자료구조 / 배열
 * */

package array;

import java.util.Arrays;
import java.util.ArrayList;

public class Programmers_42840 {
    public static void main(String[] args) {
        int[] result = solution(new int[]{1, 3, 2, 4, 2});
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(int[] answers) {
        // 수포자 패턴
        int[][] patterns = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        // 점수
        int[] scores = new int[3];

        // 점수 계산
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < patterns.length; j++) {
                if (answers[i] == patterns[j][i % patterns[j].length]) {
                    scores[j]++;
                }
            }
        }

        // 점수의 최댓값
        int max = Arrays.stream(scores).max().getAsInt();

        // 점수의 최댓값과 같은 점수를 가진 수포자 번호 저장
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == max) {
                result.add(i + 1);
            }
        }

        // 배열로 번환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
