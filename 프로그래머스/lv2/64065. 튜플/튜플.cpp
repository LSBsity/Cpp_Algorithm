#include <string>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;
#define pp pair<int, int>

bool cmp(pp a, pp b)
{
    if (a.second == b.second)
        return a.first > b.first;
    return a.second > b.second;
}

vector<int> solution(string s)
{
    vector<int> answer;
    map<int, int> m;
    string tmp;
    
    for (int i = 1; i < s.length() - 1; i++)
    {
        if (s[i] != '{' && s[i] != '}' && s[i] != ',')
        {
            tmp += s[i];

            if (s[i + 1] != ',' && s[i + 1] != '}')
                continue;
            m[stoi(tmp)]++;
        }
        tmp = "";
    }

    vector<pp> vec(m.begin(), m.end());
    sort(vec.begin(), vec.end(), cmp);

    for (int i = 0; i < vec.size(); i++)
        answer.push_back(vec[i].first);

    return answer;
}