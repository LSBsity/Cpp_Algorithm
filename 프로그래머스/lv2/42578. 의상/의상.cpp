#include <string>
#include <vector>
#include <unordered_map>
using namespace std;

int solution(vector<vector<string>> clothes)
{
    int answer = 1;
    unordered_map<string, int> m;
    for (int i = 0; i < clothes.size(); i++)
        m[clothes[i][1]]++;

    for (const auto &pair : m)
        answer *= (pair.second + 1);

    return answer - 1;
}