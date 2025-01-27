class Solution {
    public int solution(int M, int N) {
        int row = M - 1;
        int col = (N - 1) * (row + 1);
        return row + col;
    }
}