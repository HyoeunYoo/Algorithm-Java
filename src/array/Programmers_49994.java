/*
 * [프로그래머스] 방문 길이 (Lv.2)
 * https://school.programmers.co.kr/learn/courses/30/lessons/49994
 * 2026-01-27
 * [X] 배열 / 구현
 * */

package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Programmers_49994 {
    public static void main(String[] args) {
        String dirs = "LULLLLLLU";
        int result = solution(dirs);
        System.out.println(result);
    }

    private static int solution(String dirs) {
        ArrayList<String> moves = new ArrayList<>(Arrays.asList(dirs.split(""))); // 명령어
        int x = 0, y = 0; // 현재 위치
        HashSet<String> answer = new HashSet<>(); // 지나간 경로

        for (String move : moves) {
            // 이동 위치
            int nx = x, ny = y;
            // 이동 위치 계산
            switch(move) {
                case "U": ny += 1;
                    break;
                case "D": ny -= 1;
                    break;
                case "R": nx += 1;
                    break;
                case "L": nx -= 1;
                    break;
                default:
                    break;
            }

            // 경로 저장
            if (-5 <= nx && nx <= 5 && -5 <= ny && ny <= 5) {
                answer.add(x + " " + y + " " + nx + " " + ny);
                answer.add(nx + " " + ny + " " + x + " " + y);

                x = nx;
                y = ny;
            }
        }

        return answer.size() / 2;
    }
}
