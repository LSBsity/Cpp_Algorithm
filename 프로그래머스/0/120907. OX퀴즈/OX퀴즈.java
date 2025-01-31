class Solution {

    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for (int i = 0; i < quiz.length; i++) {
            answer[i] = this.check(quiz[i]) ? "O" : "X";
        }
        
        return answer;
    }

    private boolean check(String str) {
        String[] split = str.split(" = ");
        int first, second, result;
        int answer = Integer.parseInt(split[1]);
        if (split[0].contains("+")) {
            String[] splited = split[0].split(" \\+ ");
            first = Integer.parseInt(splited[0]);
            second = Integer.parseInt(splited[1]);
            result = first + second;
        } else {
            String[] splited = split[0].split(" - ");
            first = Integer.parseInt(splited[0]);
            second = Integer.parseInt(splited[1]);
            result = first - second;
        }

        return result == answer;
    }
}