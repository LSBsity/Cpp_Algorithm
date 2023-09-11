#include <string>
#include <vector>

using namespace std;

vector<int> solution(string my_string) {
    vector<int> answer(52,0);
    for (int i = 0; i < my_string.size(); i++)
    {
        char cur = my_string[i];
        if ('a' <= cur && 'z' >= cur)
            answer[cur - 'a' + 26]++;
        else if ('A' <= cur && 'Z' >= cur)
            answer[cur - 'A']++;
    }
    return answer;
}
