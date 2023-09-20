#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <stack>
using namespace std;

int main()
{
    int a;
    stack<int> stk;
    cin >> a;

    for (int i = 0; i < a; i++)
    {
        int tmp;
        cin >> tmp;
        if (tmp == 0)
            stk.pop();
        else
            stk.push(tmp);
    }
    int sum = 0;
    while (!stk.empty())
    {
        sum += stk.top();
        stk.pop();
    }
    cout << sum;
}
