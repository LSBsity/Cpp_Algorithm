#include <iostream>

using namespace std;

int main()
{
    int a;
    double arr[1001];
    int max = 0;
    double sum = 0;

    cin >> a;

    for (int i = 0; i < a; i++)
    {
        cin >> arr[i];
        if (arr[i] > max)
            max = arr[i];
    }

    for (int i = 0; i < a; i++)
    {
         arr[i] = (arr[i] / max) * 100;
    }

    for (int i = 0; i < a; i++)
    {
        sum += arr[i];
    }

    cout << sum / a << endl;
    
    return 0;
}

