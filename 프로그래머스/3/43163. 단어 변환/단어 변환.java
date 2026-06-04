import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        return go(words, begin, target);
    }
    
    private static int go(String[] words, String begin, String target) {
        Queue<Node> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        
        q.offer(new Node(begin, 0));
        set.add(begin);
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            if (cur.str.equals(target)) {
                return cur.level;
            }
            
            for (String word : words) {
                if (!set.contains(word) && check(cur.str, word)) {
                    q.offer(new Node(word, cur.level + 1));
                    set.add(word);
                }
            }
            
        }
        

        
        return 0;
    }
    
    private static boolean check(String word, String target) {
        int cnt = 0;
        for (int i = 0; i < word.length(); i++) {
           if (word.charAt(i) == target.charAt(i)) {
                cnt++;
           }
        }
            
        return cnt == word.length() - 1;
    }
    
    static class Node {
        String str;
        int level;
        
        public Node (String str, int level) {
            this.str = str;
            this.level = level;
        }
    }
}