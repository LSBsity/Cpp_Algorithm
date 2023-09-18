#include <iostream>
#include <queue>
using namespace std;

int main()
{
    cin.sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    int a;
    queue<int> q;
    cin >> a;
    for (int i = 0; i < a; i++)
        q.push(i + 1);

    while (q.size() != 1)
    {
        q.pop();
        int temp = q.front();
        q.pop();
        q.push(temp);
    }
    cout << q.front();
}
