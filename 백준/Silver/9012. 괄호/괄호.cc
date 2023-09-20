#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <stack>
using namespace std;

int main()
{
    int n;
    cin >> n;

    for (int i = 0; i < n; i++)
    {
        string tmp = "";
        stack<char> arr;
        cin >> tmp;
        string answer = "YES";
        for (int i = 0; i < tmp.length(); i++)
        {
            if (tmp[i] == '(')
            {
                arr.push('(');
            }
            else if (tmp[i] == ')')
            {
                if (!arr.empty())
                    arr.pop();
                else if (arr.empty())
                {
                    answer = "NO";
                }
            }
        }
        if (!arr.empty())
            answer = "NO";
        cout << answer << '\n';
    }

    return 0;
}
