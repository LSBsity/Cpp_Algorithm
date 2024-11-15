class Solution {
    static int go(int first, String second, int third) {
        return switch (second) {
            case "*" -> first * third;
            case "+" -> first + third;
            case "-" -> first - third;
            default -> -1;
        };
    }

    public int solution(String binomial) {
        String[] split = binomial.split(" ");
        return go(Integer.parseInt(split[0]), split[1], Integer.parseInt(split[2]));
    }
}