import java.util.*;

class Solution {

    int[] answer = new int[]{0, 0};

    public int go(int[][] arr, int row, int col, int size) {
        if (size == 1) {
            answer[arr[row][col]]++;
            return arr[row][col];
        }
        int half = size / 2;
        int a = go(arr, row, col, half);
        int b = go(arr, row, col + half, half);
        int c = go(arr, row + half, col, half);
        int d = go(arr, row + half, col + half, half);
        if (a == b && b == c && c == d && a != Integer.MIN_VALUE) {
            answer[a] -= 3;
            return a;
        }
        return Integer.MIN_VALUE;
    }

    public int[] solution(int[][] arr) {
        this.go(arr, 0, 0, arr.length);
        return answer;
    }
}