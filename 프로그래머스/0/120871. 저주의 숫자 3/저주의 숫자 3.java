class Solution {
    public int solution(int n) {
        int d3 = 1;
        int d10 = 1;
        
        while (d10 < n) {
            d3++;
            while (d3 % 3 == 0 || contains(d3)) {
                d3++;
            }
            d10++;
        }
        
        return d3;
    }
    
    private boolean contains(int num) {
        while (num >= 1) {
            int val = num % 10;
            if (val == 3) return true;
            num /= 10;
        }
        return false;
    }
}