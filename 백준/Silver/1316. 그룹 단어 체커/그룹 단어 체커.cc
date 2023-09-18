#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main()
{
    int n;
    int cnt = 0;
    string str;
    cin >> n;

    for (int i = 0; i < n; i++)
    {
        cin >> str; //happy
        int size = str.length(); // 5
        bool flag = true; 

        for (int j = 0; j < size; j++) // j 4
        {
            for (int k = 0; k < j; k++) // k 0
            {
                if (str[j] != str[j - 1] && str[j] == str[k])
                {
                    flag = false;
                    break;
                }
            }
        }
        if (flag)
            cnt++;
    }

    cout << cnt;
    return 0;
}