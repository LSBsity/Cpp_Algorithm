#include <string>
#include <vector>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    for (int i = 0; i < s.size(); i++)
    {
        if (i == 0)
            answer.push_back(-1);
        else
        {
            int temp = i;
            int count = 0;
            while (temp--)
            {
                if (s[i] == s[temp])
                    break;
                count++;
            }
            if (temp < 0 && s[i] != s[0])
                answer.push_back(-1);
            else if (temp >= 0)
                answer.push_back(count + 1);
        }
    }
    return answer;
}