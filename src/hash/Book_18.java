/*
 * [책] 18번 - 두 개의 수로 특정값 만들기
 * 2025.05.01
 * [X] 자료구조 / 해시
 * */

package hash;

import java.util.HashSet;

public class Book_18 {
    public static boolean solution(int[] arr, int target) {
        // 키만 저장하는 HashSet
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i : arr) {
            // target 에서 현재 원소를 뺀 값이 해시셋에 있는지 확인
            if (hashSet.contains(target - i)) {
                return true;
            }
            // 없으면 해시셋에 현재 값 저장
            hashSet.add(i);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 8};
        int target = 6;
        boolean result = solution(arr, target);
        System.out.println(result);
    }
}
