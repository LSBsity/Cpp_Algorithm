#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <queue>
using namespace std;

int main()
{
    cin.tie(0);
    cin.sync_with_stdio(0);
    int a;
    string tmp;
    queue<int> q;
    cin >> a;

    for (int i = 0; i < a; i++)
    {
        cin >> tmp;
        if (tmp == "push")
        {
            int a;
            cin >> a;
            q.push(a);
        }
        else if (tmp == "pop")
        {
            if (q.empty())
                cout << "-1" << "\n";
            else
            {
                cout << q.front() << "\n";
                q.pop();
            }
        }
        else if (tmp == "size")
            cout << q.size() << "\n";
        else if (tmp == "empty")
        {
            cout << q.empty() << "\n";
        }
        else if (tmp == "front")
        {
            if (q.empty())
                cout << "-1" << "\n";
            else
                cout << q.front() << "\n";
        }
        else if (tmp == "back")
        {
            if (q.empty())
                cout << "-1" << "\n";
            else
                cout << q.back() << "\n";
        }
    }
}
