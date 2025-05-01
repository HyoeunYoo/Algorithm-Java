/*
 * [책] 19번 - 완주하지 못한 선수
 * 2025.05.01
 * [X] 자료구조 / 해시
 * */

package hash;

import java.util.HashMap;

public class Book_19 {

    public static String solution(String[] participant, String[] completion) {
        // 완주한 선수를 해시맵에 저장, 이름-이름 개수
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String i : completion) {
            int num = hashMap.containsKey(i) ? hashMap.get(i) : 0;
            hashMap.put(i, num + 1);

            // 간결하게
//            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }

        // 해시맵에서 참가자 이름을 찾아 값을 1씩 감소
        for (String i : participant) {
            // 완주하지 못한 선수를 찾으면 반환
            if (!hashMap.containsKey(i) || hashMap.get(i) == 0) {
                return i;
            }
            else {
                hashMap.put(i, hashMap.get(i) - 1);
            }

            // 간결하게
//            if (hashMap.getOrDefault(i, 0) == 0) {
//                return i;
//            }
//            hashMap.put(i, hashMap.get(i) - 1);
        }

        return null;
    }

    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        String result = solution(participant, completion);
        System.out.println(result);
    }
}
