/*
 * [책] 02번 - 배열 제어하기
 * 2026.01.20
 * [X] 자료구조 / 배열
 * */

package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class Book_02 {
    public static void main(String[] args) {
        int[] org = {4, 2, 2, 1, 3, 4};
        int[] result = solution(org);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(int[] arr) {
        // 중복 제거
        Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);
        // 내림차순 정렬
        Arrays.sort(result, Collections.reverseOrder());
        // int형 배열로 변경 후 반환
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }

    private static int[] solution2(int[] arr) {
        // 중복 제거, 내림차순 정렬
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int num : arr) {
            set.add(num);
        }

        // int 배열에 담아 반환
        int[] result = new int[set.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = set.pollFirst();
        }
        return result;
    }

    private static int[] solution3(int[] arr) {
        // 중복 제거, 내림차순 정렬
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int num : arr) {
            set.add(num);
        }

        Integer[] integerArr = set.toArray(new Integer[0]);
        int[] result = new int[integerArr.length];
        for (int i = 0; i < integerArr.length; i++) {
            result[i] = integerArr[i]; // Integer를 int로 Unboxing
        }

        return result;
    }
}
