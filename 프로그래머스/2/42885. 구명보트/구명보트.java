import java.util.Arrays;
class Solution {

    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int front = 0;
        int rear = people.length - 1;

        int count = 0;
        while (front <= rear) {
            if (people[front] + people[rear] <= limit) {
                front++;
                rear--;
            } else {
                rear--;
            }
            ++count;
        }

        return count;
    }
}