import java.util.*;

class Solution{
    public int solution(int n, int a, int b){
        int answer = 0;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == a - 1 || i == b - 1) arr[i] = -1;
            else arr[i] = i + 1;
        }
        
        int N = Integer.numberOfTrailingZeros(n);
    
        for (int i = 1; i <= N; i++) {
            int[] temp = new int[n / 2];
            for (int j = 0, idx = 0; j < arr.length; j += 2) {
                if (arr[j] == arr[j + 1]) {
                    return i;
                }
                temp[idx++] = Math.min(arr[j], arr[j + 1]);
            }
            arr = new int[n / 2];
            System.arraycopy(temp, 0, arr, 0, arr.length);
            n /= 2;
        }
        
        return -1;
    }
}
    
