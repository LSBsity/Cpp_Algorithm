#include <iostream>
#include <deque>

#define endl '\n'
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int a;
    string tmp = "";
    deque<int> dq;
    cin >> a;
    for (int i = 0; i < a; i++)
    {
        cin >> tmp;
        if (tmp == "push_front")
        {
            int a;
            cin >> a;
            dq.push_front(a);
        }
        else if (tmp == "push_back")
        {
            int a;
            cin >> a;
            dq.push_back(a);
        }
        else if (tmp == "pop_front")
        {
            if (dq.empty())
                cout << "-1" << endl;
            else
            {
                cout << dq.front() << endl;
                dq.pop_front();
            }
        }
        else if (tmp == "pop_back")
        {
            if (dq.empty())
                cout << "-1" << endl;
            else
            {
                cout << dq.back() << endl;
                dq.pop_back();
            }
        }
        else if (tmp == "size")
        {
            cout << dq.size() << endl;   
        }
        else if (tmp == "empty")
        {
            cout << dq.empty() << endl;
        }
        else if (tmp == "front")
        {
            if (dq.empty())
                cout << "-1" << endl;
            else
                cout << dq.front() << endl;
        }
        else if (tmp == "back")
        {
            if (dq.empty())
                cout << "-1" << endl;
            else
                cout << dq.back() << endl;
        }
    }
}
