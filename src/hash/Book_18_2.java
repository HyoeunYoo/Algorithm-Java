/*
 * [책] 18번 - 두 개의 수로 특정값 만들기
 * 2026-03-14
 * [O] 자료구조 / 해시
 * */

package hash;

import java.util.HashMap;

public class Book_18_2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 2, 3, 4, 8}, 6));
    }

    private static boolean solution(int[] arr, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int a : arr) {
            int minus = target - a;
            if (minus > 0 && minus != a)
                hashMap.put(minus, a);
        }

        for (HashMap.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (hashMap.containsKey(entry.getValue()))
                return true;
        }

        return false;
    }
}
