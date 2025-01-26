class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int idx = 0;
        for (int[] query: queries) {
            int k = query[2];
            int max = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (query[0] <= i && i <= query[1]) {
                    if (arr[i] > k && arr[i] < max) {
                        max = arr[i];
                    }
                }
            }
            answer[idx++] = max == Integer.MAX_VALUE ? -1 : max;
        }
        
        return answer;
    }
}