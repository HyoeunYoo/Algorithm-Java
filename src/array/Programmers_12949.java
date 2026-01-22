/*
 * [프로그래머스] 행렬의 곱셈 (Lv.2)
 * https://school.programmers.co.kr/learn/courses/30/lessons/12949
 * 2026-01-22
 * [O] 자료구조 / 배열
 * */

package array;

import java.util.*;

public class Programmers_12949 {
    public static void main(String[] args) {
        int[][] org1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] org2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
        int[][] result = solution(org1, org2);
        System.out.println(Arrays.deepToString(result));
    }

    private static int[][] solution(int[][] arr1, int[][] arr2) {
        int r1 = arr1.length;
        int c1 = arr1[0]. length;
        int c2 = arr2[0]. length;

        int[][] answer = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}
