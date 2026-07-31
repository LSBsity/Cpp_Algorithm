class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        String regex = "[^" + skill + "]";
        for (String str : skill_trees) {
            String remain = str.replaceAll(regex, "");
            if (skill.startsWith(remain)) {
                answer++;
            }
        }
        
        return answer;
    }
}