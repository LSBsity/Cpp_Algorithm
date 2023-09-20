#include <iostream>
using namespace std;


int arr[20000001];

int main(void)
{
    int a;
    scanf("%d", &a);
    for (int i = 0; i < a; i++)
    {
        int temp;
        scanf("%d", &temp);
        arr[temp + 10000000]++;
    }
    int b;
    scanf("%d", &b);
    for (int i = 0; i < b; i++)
    {
        int temp;
        scanf("%d", &temp);
        if (arr[temp + 10000000] >= 1)
            cout << "1" << " ";
        else
            cout << "0" << " ";
    }
  
    return 0;
}