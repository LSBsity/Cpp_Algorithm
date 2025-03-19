import java.util.*;

class Solution {
    
    static class Element {
        int value;
        boolean isTarget;
        
        public Element(int value, boolean isTarget) {
            this.value = value;
            this.isTarget = isTarget;
        }
    }
    
    public int solution(int[] p, int l) {
        LinkedList<Element> list = new LinkedList<>();
        
        for (int i = 0; i < p.length; i++) {
            list.add(new Element(p[i], l == i));
        }
        
        int count = 0;
        while (true) {
            Element target = list.getFirst();
            boolean check = true;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).value > target.value) {
                    list.addLast(target);
                    list.removeFirst();
                    check = false;
                    break;
                }
            }
            
            if (check) {
                count++;
                list.removeFirst();
                if (target.isTarget) {
                    return count;
                }
            }
        }
    }
}