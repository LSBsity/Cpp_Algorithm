#include <string>
#include <vector>

using namespace std;

int solution(string s, vector<string> st) {
    int answer = 0;
    for (int i = 0; i < st.size(); i++) {
        int idx = 0, check = true;
        for (int j = 0; j < st[i].size(); j++)
            if (s.find(st[i][j]) != string::npos)
                if (st[i][j] != s[idx]) {
                    check = false;
                    break;
                } else 
                    idx++;
        if (check)
            answer++;
    }

    return answer;
}