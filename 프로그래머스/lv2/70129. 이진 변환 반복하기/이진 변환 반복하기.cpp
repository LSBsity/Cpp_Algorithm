#include <string>
#include <vector>
#include <stack>
using namespace std;

stack <int> stk;
string to_2digit(int a)
{
    string z = "";

    while (a != 0)
    {
        if (a % 2 == 1)
            stk.push(1);
        else
            stk.push(0);
        a /= 2;
    }

    while (!(stk.empty()))
    {
        z += to_string(stk.top());
        stk.pop();
    }
    return z;
}

vector<int> solution(string s)
{
    vector<int> answer;
    int count = 0, count2 = 0;
    while (s != "1")
    {
        for (int i = 0; i < s.length();)
        {
            if (s[i] == '0')
            {
                s.erase(s.begin() + i);
                count++;
            }
            else
                i++;
        }
        s = to_2digit(s.length());
        count2++;
    }
    answer.push_back(count2);
    answer.push_back(count);

    return answer;
}