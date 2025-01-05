class Solution {
    private final String[] str = {"수", "박"};

    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(str[i % 2]);
        }
        return sb.toString();
    }
}