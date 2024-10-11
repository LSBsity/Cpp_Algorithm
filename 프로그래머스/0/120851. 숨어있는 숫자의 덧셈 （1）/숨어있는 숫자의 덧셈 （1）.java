class Solution {
    public int solution(String str) {
        return str.chars()
                .filter(Character::isDigit)
                .map(c -> c - '0')
                .sum();
    }
}