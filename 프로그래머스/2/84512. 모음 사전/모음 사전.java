import java.util.*;

class Solution {
    List<String> dictionary = new ArrayList<>();
    String[] words = {"A", "E", "I", "O", "U"};
    
    private void generate(String current) {
        if (current.length() > 5) return;
        
        dictionary.add(current);
        
        for (String w : words) {
            generate(current + w);
        }
    }
    
    public int solution(String word) {
        generate("");
        return dictionary.indexOf(word);
    }
}