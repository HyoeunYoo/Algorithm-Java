/*
 * [책] 25번 - 트리 순회
 * 2025.05.08
 * [X] 자료구조 / 이진 트리
 * */

package tree;

import java.util.Arrays;

public class Book_25 {
    public static String[] solution(int[] nodes) {
        String[] result = new String[3];
        result[0] = preorder(nodes, 0).trim();
        result[1] = inorder(nodes, 0).trim();
        result[2] = postorder(nodes, 0).trim();

        return result;
    }

    // 전위 순회
    private static String preorder(int[] nodes, int idx) {
        // idx가 범위를 벗어나면 빈 문자열 반환
        if (idx >= nodes.length) {
            return "";
        }

        // 루트 노드 -> 왼쪽 서브 트리 -> 오른쪽 서브 트리 순으로 재귀 호출하여 결과를 이어 붙임
        return nodes[idx] + " " + preorder(nodes, 2 * idx + 1) + preorder(nodes, 2 * idx + 2);
    }

    // 중위 순회
    private static String inorder(int[] nodes, int idx) {
        // idx가 범위를 벗어나면 빈 문자열 반환
        if (idx >= nodes.length) {
            return "";
        }

        // 왼쪽 서브 트리 -> 루트 노드 -> 오른쪽 서브 트리 순으로 재귀 호출하여 결과를 이어 붙임
        return inorder(nodes, 2 * idx + 1) + nodes[idx] + " " + inorder(nodes, 2 * idx + 2);
    }

    // 후위 순회
    private static String postorder(int[] nodes, int idx) {
        // idx가 범위를 벗어나면 빈 문자열 반환
        if (idx >= nodes.length) {
            return "";
        }

        // 왼쪽 서브 트리 -> 오른쪽 서브 트리 -> 루트 노드 순으로 재귀 호출하여 결과를 이어 붙임
        return postorder(nodes, 2 * idx + 1) + postorder(nodes, 2 * idx + 2) + nodes[idx] + " ";
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, 4, 5, 6, 7};
        String[] answer = solution(nodes);
        System.out.println(Arrays.toString(answer));
    }
}
