class Solution {
    public long solution(int price, int money, int count) {
        long sum = 0;
        for (int i = 0, init = price; i < count; i++) {
            sum += price;
            price += init;
        }
        return sum < money ? 0 : sum - money;
    }
}