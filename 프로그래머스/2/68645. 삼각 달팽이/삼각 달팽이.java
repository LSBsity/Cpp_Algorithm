class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n + 1][n + 1];

        int i = 0, j = 0, cnt = 1;
        int N = n;
        while (N > 0) {
            for (int k = 0; k < N; k++) {
                arr[i++][j] = cnt++;
            }
            N--;

            i--;
            j++;
            for (int k = 0; k < N; k++) {
                arr[i][j++] = cnt++;
            }
            N--;

            j -= 2;
            i--;
            for (int k = 0; k < N; k++) {
                arr[i--][j--] = cnt++;
            }
            N--;

            i += 2;
            j++;
        }

        int[] answer = new int[cnt - 1];
        int idx = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < i + 1; j++) {
                answer[idx++] = arr[i][j];
            }
            System.out.println();
        }

        return answer;
    }
}