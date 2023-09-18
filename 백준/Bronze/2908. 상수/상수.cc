#include <iostream>
#include <string>

using namespace std;


int main()
{
    string x, y;

    cin >> x >> y;

    string bigger;

    for (int i = 2; i >= 0; i--)
    {
        if (x[i] > y[i])
        {
            bigger = x; break;
        }
        else if (x[i] < y[i])
        {
            bigger = y; break;
        }    
    }
    for (int i = 2; i >= 0; i--)
    {
        cout << bigger[i];
    }
    
    
}