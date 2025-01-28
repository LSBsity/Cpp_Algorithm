class Solution {

    public int solution(int chicken) {
        int answer = 0, service;

        int coupon = chicken;
        while (coupon >= 10) {
            service = coupon / 10;
            coupon = service + coupon % 10;

            answer += service;
        }

        return answer;
    }
}
