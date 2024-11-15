class Solution {
    public int solution(int order) {
        String str = String.valueOf(order);
        return (int) str.chars()
                .filter(c -> c == '3' || c == '6' || c == '9')
                .count();
    }
}