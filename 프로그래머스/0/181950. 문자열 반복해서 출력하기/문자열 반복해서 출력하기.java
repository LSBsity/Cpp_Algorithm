import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rep = sc.next().repeat(Integer.parseInt(sc.next()));
        System.out.println(rep);
    }
}