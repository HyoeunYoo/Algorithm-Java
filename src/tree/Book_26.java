/*
 * [책] 26번 - 예상 대진표
 * 2025.05.08
 * [X] 자료구조 / 이진 트리
 * */

package tree;

public class Book_26 {
    public static int solution(int n, int a, int b) {
        int answer;

        for (answer = 0; a != b ; answer ++) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }

        return answer;
    }

    public static void main(String[] args) {
        int answer = solution(8, 4, 7);
        System.out.println(answer);
    }
}
