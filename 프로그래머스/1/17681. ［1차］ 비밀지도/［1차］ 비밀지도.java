class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        
        for (int i = 0, idx = 0; i < arr1.length; i++) {
            int or = arr1[i] | arr2[i];
            
            String bitStr = Integer.toBinaryString(or)
                .replaceAll("1", "#")
                .replaceAll("0", " ");
            
            if (bitStr.length() < n) {
                String padding = " ".repeat(n - bitStr.length());
                bitStr = padding + bitStr;
            }
            
            answer[idx++] = bitStr;
        }
        return answer;
    }
}
//10110
//01110