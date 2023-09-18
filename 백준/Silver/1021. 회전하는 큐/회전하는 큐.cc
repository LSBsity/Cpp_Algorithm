#include <iostream>
#include <deque>

#define endl '\n'
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int a, b, num, idx;
    int count = 0;
    deque<int> dq;
    cin >> a >> b;
    for (int i = 0; i < a; i++)
        dq.push_back(i + 1);

    while (b--)
    {
        cin >> num;

        for (int i = 0; i < dq.size(); i++)
        {
            if (dq[i] == num)
            {
                idx = i;
                break;
            }
        }
        if (idx < dq.size() - idx)
        {
            while (1)
            {
                if (dq.front() == num)
                {
                    dq.pop_front();
                    break;
                }
                count++;
                dq.push_back(dq.front());
                dq.pop_front();
            }
        }
        else
        {
            while (1)
            {
                if (dq.front() == num)
                {
                    dq.pop_front();
                    break;
                }
                count++;
                dq.push_front(dq.back());
                dq.pop_back();
            }
        }
    }
    cout << count << endl;

    return 0;
}