#include <string>
#include <vector>

using namespace std;

bool solution(int x)
{
    bool answer = true;
    string s = to_string(x);
    int sum = 0;
    for (int i = 0; i < s.length(); i++)
        sum += s[i] - 48;

    if (x % sum != 0)
        answer = false;

    return answer;
}