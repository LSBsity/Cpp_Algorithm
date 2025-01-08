class Solution {
    public int solution(String[] order) {
        int answer = 0;
        for (String menu : order) {
            if (menu.equals("anything") || menu.contains("americano")) {
                answer += 4500;
            } else {
                answer += 5000;
            }
        }
        return answer;
    }
}