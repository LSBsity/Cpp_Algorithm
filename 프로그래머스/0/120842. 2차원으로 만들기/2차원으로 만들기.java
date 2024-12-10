class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length / n][n];
        int row = 0, col = 0;
        
        for (int num : num_list) {
            answer[row][col++] = num;
            if (col >= n) {
                row++;
                col %= n;
            }
        }
        
        return answer;
    }
}