class Solution {
    
    static final String[] vowels = {"a", "e", "i", "o", "u"};
    
    public String solution(String my_string) {
        for (String vowel : vowels) {
            my_string = my_string.replaceAll(vowel, "");
        }
        return my_string;
    }
}