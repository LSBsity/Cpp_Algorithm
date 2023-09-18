#include <iostream>
#include <algorithm>
#include <queue>
#define endl '\n'
using namespace std;

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    priority_queue<int, vector<int>, greater<int>> pq;
    int a;
    cin >> a;

    for (int i = 0; i < a; i++)
    {
        int a;
        cin >> a;

        if (a == 0)
        {
            if (pq.empty())
                cout << "0" << endl;
            else
            {
                cout << pq.top() << endl;
                pq.pop();
            }
        }
        else
            pq.push(a);
    }
    return 0;
}
