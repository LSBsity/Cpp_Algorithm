class Solution {
    public int solution(int[] num_list) {
        int sum = 0;
        int mult = 1;
        
        for (int num : num_list) {
            sum += num;
            mult *= num;
        }
        
        return mult < sum * sum ? 1 : 0;
    }
}