#include <iostream>
#include <algorithm>
#include <queue>
#include <cmath>
#define endl '\n'
using namespace std;

struct cmp
{
    bool operator()(int a, int b)
    {
        if (abs(a) == abs(b))
            return a > b;
        else
            return abs(a) > abs(b);
    }
};

priority_queue<int, vector<int>, cmp> pq;
int N, x;

int main()
{
    cin.tie(0)->sync_with_stdio(0);
    cin >> N;
    while (N--)
    {
        cin >> x;
        if (x == 0)
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
            pq.push(x);
    }

    return 0;
}
