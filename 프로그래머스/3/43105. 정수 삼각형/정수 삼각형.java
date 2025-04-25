import java.util.*;

class Solution {
    public int solution(int[][] arr) {
        for (int i = arr[arr.length - 1].length - 1 - 1; i >= 0; i--) {
            for (int j = arr[i].length - 1; j >= 0; j--) {
                arr[i][j] = Math.max(arr[i][j] + arr[i + 1][j], arr[i][j] + arr[i + 1][j + 1]);
            }
        }
        return arr[0][0];
    }
}