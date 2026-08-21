class Solution {
    static String[][] arr = {
        {"zero", "0"},
        {"one", "1"},
        {"two", "2"},
        {"three", "3"},
        {"four", "4"},
        {"five", "5"},
        {"six", "6"},
        {"seven", "7"},
        {"eight", "8"},
        {"nine", "9"}
    };
    
    public int solution(String s) {
        for (int i = 0; i < arr.length; i++) s = s.replaceAll(arr[i][0], arr[i][1]);
        return Integer.parseInt(s);
    }
}