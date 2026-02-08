/*
 * [프로그래머스] 크레인 인형뽑기 게임 (Lv.1)
 * https://school.programmers.co.kr/learn/courses/30/lessons/64061
 * 2026-02-08
 * [O] 자료구조 / 스택
 * */

package stack;

import java.util.ArrayDeque;

public class Programmers_64061 {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board, moves));
    }

    private static int solution(int[][] board, int[] moves) {
        ArrayDeque<Integer>[] stacks = new ArrayDeque[board.length];

        // 격자의 행열 바꾸어 스택 배열에 저장
        for (int i = 0; i < board.length; i++) {
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            for (int j = board.length - 1; j >= 0; j--) {
                if (board[j][i] > 0) {
                    stack.push(board[j][i]);
                }
            }
            stacks[i] = stack;
        }

        // 집은 인형 담을 바구니
        ArrayDeque<Integer> basketStack = new ArrayDeque<>();
        // 사라진 인형 개수
        int answer = 0;

        // 크레인 움직이기
        for (int move : moves) {
            // 칸에 인형이 있으면
            if (!stacks[move - 1].isEmpty()) {
                // 집은 인형
                int picked = stacks[move - 1].pop();

                // 집은 인형과 바구니 맨 위 인형이 같으면 터뜨리기
                if (!basketStack.isEmpty() && picked == basketStack.peek()) {
                    basketStack.pop();
                    answer += 2;
                }
                // 바구니가 비어있거나 집은 인형과 맨 위 인형이 다르면 쌓기
                else {
                    basketStack.push(picked);
                }
            }
        }

        return answer;
    }
}
