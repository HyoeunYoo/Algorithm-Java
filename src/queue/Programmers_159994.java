/*
 * [프로그래머스] 카드 뭉치 (Lv.1)
 * https://school.programmers.co.kr/learn/courses/30/lessons/159994
 * 2026-03-12
 * [O] 자료구조 / 큐
 * */

package queue;

import java.util.ArrayDeque;
import java.util.List;

public class Programmers_159994 {
    public static void main(String[] args) {
        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        String result = solution(cards1, cards2, goal);
        System.out.println(result);
    }

    private static String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> queue1 = new ArrayDeque<>(List.of(cards1));
        ArrayDeque<String> queue2 = new ArrayDeque<>(List.of(cards2));

        for (String word : goal) {
            if (word.equals(queue1.peek()))
                queue1.pollFirst();
            else if (word.equals(queue2.peek()))
                queue2.pollFirst();
            else {
                return "No";
            }
        }

        return "Yes";
    }
}
