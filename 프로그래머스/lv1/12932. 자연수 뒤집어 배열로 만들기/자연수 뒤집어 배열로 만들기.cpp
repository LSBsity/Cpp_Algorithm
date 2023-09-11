#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(long long n)
{
    vector<int> answer;
    string s = to_string(n);

    for (int i = s.length()-1; i >= 0; i--)
        answer.push_back(s[i] - 48);
        
    return answer;
}