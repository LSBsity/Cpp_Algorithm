class Solution {
    public int solution(int price) {
        int discountRate = getDiscountRate(price);
        return price * (100 - discountRate) / 100;
    }
    
    private int getDiscountRate(int price) {
        if (price >= 500_000) return 20;
        if (price >= 300_000) return 10;
        if (price >= 100_000) return 5;
        return 0;
    }
    
}