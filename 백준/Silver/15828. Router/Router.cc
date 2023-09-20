#include <iostream>
#include <queue>
using namespace std;

int main()
{
    cin.sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    int limit;
    queue<int> q;
    cin >> limit;

    while (1)
    {
        int n;
        cin >> n;
        if (n != 0 && q.size() < limit && n != -1)
            q.push(n);
        else if (n == 0)
            q.pop();
        else if (n == -1)
            break;
    }

    if (q.empty())
        cout << "empty";
    else
    {
        while (!q.empty())
        {
            cout << q.front() << " ";
            q.pop();
        }
    }

    return 0;
}
