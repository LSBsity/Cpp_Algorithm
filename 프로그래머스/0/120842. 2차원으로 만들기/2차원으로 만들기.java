class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length / n][n];
        
        int rowIdx = 0;
        int colIdx = 0;

        int idx = 0;
        while (idx < num_list.length) {
            answer[rowIdx][colIdx++] = num_list[idx++];
            
            if (colIdx == n) {
                rowIdx++;
                colIdx = 0;
            }
        }
        
        return answer;
    }
}