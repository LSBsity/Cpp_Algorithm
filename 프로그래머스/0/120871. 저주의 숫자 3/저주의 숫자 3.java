class Solution {

    public int solution(int n) {
        int[] values = new int[101];

        for (int i = 1, val = 1; i <= 100; i++) {
            while (String.valueOf(val).contains("3") || val % 3 == 0) {
                val++;
            }
            values[i] = val++;
        }

        return values[n];
    }
}