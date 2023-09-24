#include <string>
#include <vector>

using namespace std;

int solution(vector<int> v) {
    int answer = 0, pos = 0;
    string str = "";
    for (int i = 0; i < v.size(); i++) str += to_string(v[i]);

    while (1) {
        int cur = str.find("1231", pos);
        if (cur == string::npos)
            break;
        else {
            str.erase(cur, 4);
            answer++;
            if (cur > 2)
                pos  = cur - 3;
        }
    }
    return answer;
}
