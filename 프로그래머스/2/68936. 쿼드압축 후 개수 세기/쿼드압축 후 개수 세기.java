import java.util.*;

class Solution {

    static int[] answer = {0, 0};
    
    public int[] solution(int[][] arr) {
        go(arr, 0, 0, arr.length);
        return answer;
    }
    
    private int go(int[][] arr, int x, int y, int size) {
        if (size == 1) {
            answer[arr[x][y]]++;
            return arr[x][y];
        }
        
        int a = go(arr, x, y, size / 2);
        int b = go(arr, x + size / 2, y, size / 2);
        int c = go(arr, x, y + size / 2, size / 2);
        int d = go(arr, x + size / 2, y + size / 2, size / 2);    

        if (a == b && b == c && c == d && a != -1) {
            answer[arr[x][y]] -= 3;
            return a;
        }
        
        return -1;
    }
}