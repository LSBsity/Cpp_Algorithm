#include <string>
#include <vector>

using namespace std;

int solution(string t, string p)
{
    int answer = 0;
    vector<string> tmp;
    for (int i = 0; i < t.length() - p.length() + 1; i++)
    {
        tmp.push_back(t.substr(i, p.length()));
        if (tmp[i] <= p) answer++;
    }
    return answer;
}