/*
 * [프로그래머스] 두 개 뽑아서 더하기 (Lv.1)
 * https://school.programmers.co.kr/learn/courses/30/lessons/68644
 * 2026-01-20
 * [O] 자료구조 / 배열
 * */

package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Programmers_68644 {
    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 4, 1};
        int[] result = solution(numbers);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                set.add(arr[i] + arr[j]);
            }
        }

        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
