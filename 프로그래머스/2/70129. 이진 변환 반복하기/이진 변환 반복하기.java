class Solution {
    public int[] solution(String s) {
        int[] result = {0, 0};
        
        int count = 0;
        int sum = 0;
        
        while (!s.equals("1")) {
            result[0]++;
            
            result[1] += s.length();
            int len = go(s);
            result[1] -= go(s);
            
            s = Integer.toBinaryString(len);
        }
        
        return result;
    }
    
    public int go(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') count++;
        }
        return count;
    }
}