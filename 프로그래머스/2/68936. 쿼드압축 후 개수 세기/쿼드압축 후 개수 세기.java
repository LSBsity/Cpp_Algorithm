class Solution {
    
    int[] answer = {0, 0};
    
    private int go(int[][] arr, int row, int col, int size) {
        if (size == 1) {
            answer[arr[row][col]]++;
            return arr[row][col];
        }
        
        int half = size / 2;
        int a = this.go(arr, row, col, size / 2);
        int b = this.go(arr, row, col + half, size / 2);
        int c = this.go(arr, row + half, col, size / 2);
        int d = this.go(arr, row + half, col + half, size / 2);
        
        if (a == b & b == c & c == d && a != -1) {
            answer[a] -= 3;
            return a;
        }
    
        return -1;
    }
    
    public int[] solution(int[][] arr) {
        this.go(arr, 0, 0, arr.length);
        return answer;
    }
}