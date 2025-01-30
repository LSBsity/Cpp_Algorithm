class Solution {

    public int solution(int quantity, int reward, int emptyBottles) {
        int totalService = 0;

        while (emptyBottles >= quantity) {
            int eligibleQuantity = (emptyBottles / quantity) * reward;
            totalService += eligibleQuantity;
            emptyBottles %= quantity;
            emptyBottles += eligibleQuantity;
        }

        return totalService;
    }
}