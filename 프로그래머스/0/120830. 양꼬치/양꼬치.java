class Solution {
    public int solution(int n, int k) {
        int service = n / 10;
        int shouldPay = k - service;
        
        return (n * 12000) + (shouldPay * 2000);
    }
}