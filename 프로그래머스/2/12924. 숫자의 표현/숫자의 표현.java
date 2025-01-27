class Solution {

    public int solution(int n) {
        int answer = 0;

        int[] ints = new int[10001];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i + 1;
        }

        int start = 0;
        while (start < n) {
            int sum = 0;
            for (int i = start; i < n; i++) {
                sum += ints[i];
                if (sum == n) {
                    answer++;
                    break;
                } else if (sum >= n) {
                    break;
                }
            }
            start++;
        }

        return answer;
    }
}