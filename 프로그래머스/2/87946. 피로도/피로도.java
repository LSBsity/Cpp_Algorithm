import java.util.*;

class Solution {
    public int solution(int k, int[][] arr) {
        return this.permute(arr, 0, k);
    }
    
    public int permute(int[][] arr, int index, int k) {
        int cnt = 0;
        if (index == arr.length) {
            int max = k;
            for (int[] ints : arr) {
                if (ints[0] <= max) {
                    cnt++;
                    max -= ints[1];
                }
            }
            return cnt;
        }
        int temp = 0;
        for (int i = index; i < arr.length; i++) {
            this.swap(arr, index, i);
            temp = Math.max(temp, this.permute(arr, index + 1, k));
            this.swap(arr, index, i);
        }
        return temp;
    }

    private void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}