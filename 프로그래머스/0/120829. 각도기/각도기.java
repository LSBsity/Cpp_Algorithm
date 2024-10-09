class Solution {
    public int solution(int i) {
        return switch (i) {
            case 90 -> 2;
            case 180 -> 4;
            default -> {
                if (i > 0 && i < 90) yield 1;
                else if (i > 90 && i < 180) yield 3;
                else yield -1;
            }
        };
    }
}
