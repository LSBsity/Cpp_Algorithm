#include <iostream>

using namespace std;

int main()
{
    int arr[9];
    int maxv = 0;
    int maxi = 0;

    for (int i = 0; i < 9; i++)
    {
        cin >> arr[i];
        if (maxv < arr[i])
        {
            maxv = arr[i];
            maxi = i;
        }
    }
    cout << maxv << endl << maxi + 1;   



    return 0;
}