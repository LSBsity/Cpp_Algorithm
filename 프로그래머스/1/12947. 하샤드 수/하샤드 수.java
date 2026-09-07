class Solution {
    public boolean solution(int x) {
        int y = x;
        int sum = 0;
        
        while (y >= 1) {
            int rem = y % 10;
            y /= 10;
            sum += rem;
        }
        
        return x % sum == 0 ? true : false;
    }
}