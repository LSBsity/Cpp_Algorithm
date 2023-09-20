#include <iostream>
#include <string>

using namespace std;

int OX(string &s)
{
    int cumulative = 0;
    int sum = 0;

    for (char &v : s)
    {
        if (v == 'O')
        {
            cumulative++;
            sum += cumulative;
        }
        else
        {
            cumulative = 0;
        }
    }
    return sum;
}

int main()
{
    int t;
    cin >> t;

    for (int i = 0; i < t; i++)
    {
        string s;
        cin >> s;
        cout << OX(s) << endl;
    }

    

    return 0;
}
