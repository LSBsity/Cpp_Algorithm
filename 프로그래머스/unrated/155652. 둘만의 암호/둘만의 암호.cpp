#include <string>
#include <vector>

using namespace std;

string solution(string s, string skip, int index) {
    string answer = "";
    for (int i = 0; i < s.size(); i++) {
        int temp = s[i];
        int k = index;
        while (k--) {
            if (temp + 1 <= 'z')
                temp++;
            else
                temp -= 25;
            if (skip.find(temp) != string::npos) k++;
        }
        answer += temp;
    }
    return answer;
}