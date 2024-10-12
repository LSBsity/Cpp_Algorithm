import java.util.Arrays;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        return arr1.length == arr2.length ? check(arr1, arr2) : arr1.length > arr2.length ? 1 : -1;

    }


    public static int check(int[] arr1, int[] arr2) {
        int arr1Sum = Arrays.stream(arr1).sum();
        int arr2Sum = Arrays.stream(arr2).sum();
        return arr1Sum == arr2Sum ? 0 : arr1Sum > arr2Sum ? 1 : -1;
    }
    
}
