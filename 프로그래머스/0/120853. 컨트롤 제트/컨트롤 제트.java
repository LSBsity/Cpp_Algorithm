class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int before = 0;
        for (String str : s.split(" ")) {
            if (str.equals("Z")) {
                answer -= before;
                continue;
            }
            int val = Integer.parseInt(str);
            answer += val;
            before = val;
        }
        
        return answer;
    }
}