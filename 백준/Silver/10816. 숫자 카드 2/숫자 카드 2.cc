#include <iostream>

using namespace std;

int arr[20000001];

int main(void)
{
    int a, b, temp;
    scanf("%d", &a);
    for (int i = 0; i < a; i++)
    {
        scanf("%d", &temp);
        arr[temp + 10000000]++;
    }
    scanf("%d", &b);
    for (int i = 0; i < b; i++)
    {
        scanf("%d", &temp);
        printf("%d ", arr[temp + 10000000]);
    }

    return 0;
}