#include <iostream>
#include <queue>

#define endl '\n'
using namespace std;

int main()
{
    int count = 0;
    int test_case;
    cin >> test_case;
    int n, m, ipt;
    for (int i = 0; i < test_case; i++)
    {
        count = 0;
        cin >> n >> m;
        queue<pair<int, int>> q;
        priority_queue<int> pq;
        for (int j = 0; j < n; j++)
        {
            cin >> ipt;
            q.push({j, ipt});
            pq.push(ipt);
        }
        while (!q.empty())
        {
            int idx = q.front().first;
            int val = q.front().second;
            q.pop();
            if (pq.top() == val)
            {
                pq.pop();
                count++;
                if (idx == m)
                {
                    cout << count << endl;
                    break;
                }
            }
            else
                q.push({idx, val});
        }
    }
}
