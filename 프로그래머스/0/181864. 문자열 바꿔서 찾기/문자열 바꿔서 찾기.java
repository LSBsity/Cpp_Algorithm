class Solution {
    public int solution(String myString, String pat) {
        char[] arr = myString.toCharArray();
        for (int i = 0; i < arr.length; i++) arr[i] = arr[i] == 'A' ? 'B' : 'A';

        return String.valueOf(arr).contains(pat) ? 1 : 0;
    }
}