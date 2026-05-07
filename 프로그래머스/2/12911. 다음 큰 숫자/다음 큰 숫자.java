class Solution {
    public int solution(int n) {
        int n1 = Integer.bitCount(n);
        
        int next = n + 1;
        while (Integer.bitCount(next) != n1) {
            next++;
        }
        return next;
    }
} 