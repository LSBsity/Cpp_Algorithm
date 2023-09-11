#include <iostream>
#include <string>
#include <stack>
using namespace std;

int solution(string s)
{
    int z = 0;
    stack<char> stk;
    for (const auto& c: s)
    {
        if (!stk.empty())
        {
            if (stk.top() == c) stk.pop();
            else stk.push(c);
        }
        else stk.push(c);
    }
    return stk.empty() ? 1 : 0;
}