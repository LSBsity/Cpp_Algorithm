#include <iostream>

#define endl '\n'
using namespace std;

int sort(int a)
{
    string str = to_string(a);
    for (int i = 0; i < str.length(); i++)
    {
        for (int j = i + 1; j < str.length(); j++)
        {
            if (str[i] < str[j])
            {
                int temp = str[i];
                str[i] = str[j];
                str[j] = temp;
            }
        }
    }
    cout << str << endl;

    return 0;
}

int main()
{
    cin.tie(0)->sync_with_stdio(0);
    int a;
    cin >> a;

    sort(a);

    return 0;
}
