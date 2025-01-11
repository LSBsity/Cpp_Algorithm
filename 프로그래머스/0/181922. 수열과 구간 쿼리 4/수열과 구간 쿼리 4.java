class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int i = 0; i < queries.length; i++) {
            for (int k = 0; k < arr.length; k++) {
                if (queries[i][0] <= k && k <= queries[i][1] && k % queries[i][2] == 0) {
                    arr[k]++;
                }
            }
        }

        return arr;
    }
}