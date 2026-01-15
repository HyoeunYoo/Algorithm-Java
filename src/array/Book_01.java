/*
 * [책] 01번 - 배열 정렬하기
 * 2026.01.15
 * [O] 자료구조 / 배열
 * */

package array;

import java.util.Arrays;

public class Book_01 {
    public static void main(String[] args) {
        int[] org = {1, -5, 2, 4, 3};
        int[] sorted = solution(org);

        System.out.println(Arrays.toString(sorted));
    }

    private static int[] solution(int[] arr) {
        // 원본 배열 그대로 사용
        // Arrays.sort(arr);
        // return arr;

        // 원본 배열 복사
        int[] clone = arr.clone();
        Arrays.sort(clone);
        return clone;
    }
}
