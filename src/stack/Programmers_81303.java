/*
 * [프로그래머스] 표 편집 (Lv.3)
 * https://school.programmers.co.kr/learn/courses/30/lessons/81303
 * 2026-02-26
 * [X] 자료구조 / 스택 / 연결 리스트
 * */

package stack;

import java.util.Arrays;
import java.util.ArrayDeque;

public class Programmers_81303 {
    public static void main(String[] args) {
        String s = solution(8, 2, new String[] {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"});
        System.out.println(s);
    }

    private static String solution(int n, int k, String[] cmd) {
        // 표
        String[] table = new String[n];
        Arrays.fill(table, "O");

        // 삭제된 행
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String c : cmd) {
            String[] cc = c.split(" ");
            // 위로 이동
            if (cc[0].equals("U")) {
                int moved = 0;
                do {
                    k -= 1;
                    if (table[k].equals("O"))
                        moved += 1;
                } while (moved < Integer.parseInt(cc[1]));

            }
            // 아래로 이동
            else if (cc[0].equals("D")) {
                int moved = 0;
                do {
                    k += 1;
                    if (table[k].equals("O"))
                        moved += 1;
                } while (moved < Integer.parseInt(cc[1]));
            }
            // 삭제
            else if (cc[0].equals("C")) {
                table[k] = "X";
                stack.push(k);

                // k 변경(아래 번호로, 마지막 행이면 위 번호로)
                if (k == table.length - 1) {
                    do {
                        k -= 1;
                    } while (table[k].equals("X"));
                }
                else {
                    do {
                        k += 1;
                    } while (table[k].equals("X"));
                }
            }
            // 복구
            else if (cc[0].equals("Z")) {
                table[stack.pop()] = "O";
            }
        }

        return String.join("", table);
    }
}
