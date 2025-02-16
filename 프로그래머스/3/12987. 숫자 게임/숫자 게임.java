import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int cnt = 0;
        for (int i = A.length - 1, idx = B.length - 1, idx2 = 0; i >= 0; i--) {
            if (A[i] >= B[idx]) {
                idx2++;
            } else {
                idx--;
                cnt++;
            }
        }

        return cnt;
    }
}