class Solution {
    
    public int go(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1_000_000_007;
        }
        return arr[n];
    }
    
    public int solution(int n) {
        return this.go(n + 1) % 1_000_000_007;
    }
}