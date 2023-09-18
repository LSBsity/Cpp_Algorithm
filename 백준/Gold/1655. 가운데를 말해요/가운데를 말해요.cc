#include <iostream>
#include <algorithm>
#include <queue>
#include <cmath>
#define endl '\n'
using namespace std;

int main()
{
    cin.tie(0)->sync_with_stdio(0);
    priority_queue<int> max;
    priority_queue<int, vector<int>, greater<int>> min;
    int t;
    cin >> t;

    while (t--)
    {
        int a, size;
        cin >> a;
        if (max.size() == min.size())
            max.push(a);
        else
            min.push(a);
        if (!max.empty() && !min.empty() && max.top() > min.top())
        {
            int max_val, min_val;
            max_val = max.top();
            min_val = min.top();
            max.pop();
            min.pop();
            max.push(min_val);
            min.push(max_val);
        }
        cout << max.top() << endl;
    }

    return 0;
}
