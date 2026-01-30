/*
 * [책] 09번 - 10진수를 2진수로 변환하기
 * 2026-01-30
 * [O] 자료구조 / 스택
 * */

package stack;

public class Book_09 {
    public static void main(String[] args){
        String result = solution(12345);
        System.out.println(result);
    }

    private static String solution(int decimal) {
        StringBuilder sb = new StringBuilder();

        while (decimal > 0) {
            sb.append(decimal % 2);
            decimal /= 2;
        }

        return sb.reverse().toString();
    }
}
