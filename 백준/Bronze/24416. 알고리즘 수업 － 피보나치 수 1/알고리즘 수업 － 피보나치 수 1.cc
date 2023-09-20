#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int arr[41];
int count1 = 0;
int fib(int n)
{
    if (n == 1 || n == 2)
    {
        count1++;
        return 1;
    }
    else
        return (fib(n - 1) + fib(n - 2));
}

int main()
{
    int n;
    cin >> n;
    arr[1] = arr[2] = 1;
    int count2 = 0;

    fib(n);
    for (int i = 3; i <= n; i++)
    {
        arr[i] = arr[i - 1] + arr[i - 2];
        count2++;
    }
    cout << count1 << " " << count2;
}