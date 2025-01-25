import java.util.Arrays;

class Solution {

    int[] check = new int[100001];

    public int[] solution(int[] arr, int k) {
        int[] answers = new int[k];
        int idx = 0;
        
        for (int i = 0; i < arr.length && idx < k; i++) {
            if (check[arr[i]]++ == 0) {
                answers[idx++] = arr[i];
            }
        }

        if (idx < arr.length) {
            Arrays.fill(answers, idx, k, -1);
        }

        return answers;
    }
}