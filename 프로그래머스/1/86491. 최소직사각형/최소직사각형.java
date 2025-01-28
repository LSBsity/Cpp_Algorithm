import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        
        int xMax = -1;
        int yMax = -1;
        for (int[] arr : sizes) {
            Arrays.sort(arr);
            if (arr[0] > xMax) {
                xMax = arr[0];
            }
            if (arr[1] > yMax) {
                yMax = arr[1];
            }
        }
        
        return xMax * yMax;
    }
}