#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int main(void)
{
    int a;
    cin >> a;
    int z = 1;
    while (z <= a)
    {   
        int sum = 0;
        string tmp = to_string(z);
        sum += z;
        for (int i = 0; i < tmp.length(); i++)
        {
            sum += tmp[i] - '0';
        }
        if (sum == a)
        {
            cout << tmp;
            return 0;
        }
        z++;
    }
    
    cout << "0" << endl;

    return 0;
}