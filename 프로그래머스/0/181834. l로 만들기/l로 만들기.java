class Solution {
    public String solution(String myString) {
        char[] arr = myString.toCharArray();
        for (int i = 0; i < arr.length; i++) arr[i] = arr[i] < 'l' ? 'l' : arr[i];

        return String.valueOf(arr);
    }
}