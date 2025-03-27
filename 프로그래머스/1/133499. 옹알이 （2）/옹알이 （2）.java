class Solution {
    public int solution(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        int count = 0;

        for (String str : babbling) {
            String temp = str;
            
            for (String word : words) {
                if (temp.contains(word + word)) { 
                    break;
                }
                temp = temp.replace(word, " ");
                if (temp.trim().isEmpty()) {
                    count++;
                    break;
                }
            }
        }
        
        return count;
    }
}