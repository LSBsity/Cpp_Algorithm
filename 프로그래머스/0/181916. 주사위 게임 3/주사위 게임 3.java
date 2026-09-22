import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        if (a == b && b == c && c == d) return 1111 * a;

        int[] arr = new int[] {a, b, c, d};
        Arrays.sort(arr);
        
        if (arr[0] != arr[1] && arr[1] != arr[2] && arr[2] != arr[3]) return arr[0];
        if (arr[0] == arr[1] && arr[1] == arr[2]) {
            return (int) Math.pow(10 * arr[0] + arr[3], 2);
        } else if (arr[1] == arr[2] && arr[2] == arr[3]) {
            return (int) Math.pow(10 * arr[3] + arr[0], 2);
        }
        
        if (arr[0] == arr[1] && arr[1] != arr[2] && arr[2] != arr[3]) {
            int q = arr[2];
            int r = arr[3];
            return q * r;
        } else if (arr[1] == arr[2] && arr[2] != arr[3] && arr[0] != arr[3]) {
            int q = arr[0];
            int r = arr[3];
            return q * r;
        } else if (arr[2] == arr[3] && arr[1] != arr[2] && arr[0] != arr[1]) {
            int q = arr[0];
            int r = arr[1];
            return q * r;
        }
        
        if (arr[0] == arr[1] && arr[2] == arr[3]) {
            return (arr[0] + arr[2]) * Math.abs(arr[0] - arr[2]);
        } else if (arr[1] == arr[2] && arr[0] == arr[3]) {
            return (arr[1] + arr[0]) * Math.abs(arr[1] - arr[0]);
        } else if (arr[2] == arr[3] && arr[0] == arr[1]) {
            return (arr[2] + arr[0]) * Math.abs(arr[2] - arr[0]);
        }
        
        return -1;
    }
}