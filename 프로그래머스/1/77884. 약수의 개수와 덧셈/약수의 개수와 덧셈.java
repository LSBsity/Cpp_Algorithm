class Solution {

    public int go(int value) {
        if (value == 1) return 1;
        int count = 2;
        for (int i = 2; i <= value / 2; i++) {
            if (value % i == 0) count++;
        }
        return count;
    }

    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            answer += go(i) % 2 == 0 ? i : -i;
        }
        return answer;
    }
}