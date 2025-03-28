import java.util.*;

class Solution {
    
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Deque<Element> q = new ArrayDeque<>();
        
        for (int i = 0; i < numbers.length; i++) {
            while (!q.isEmpty() && numbers[i] > q.peek().value) {
                   answer[q.peek().pos] = numbers[i];
                   q.pop();
            }
            q.push(new Element(numbers[i], i));
        }
        
        while (!q.isEmpty()) {
            answer[q.peek().pos] = -1;
            q.pop();
        }

        return answer;
    }
       
    static class Element {
        int value;
        int pos;
        
        public Element(int value, int pos) {
            this.value = value;
            this.pos = pos;
        }
    }
}