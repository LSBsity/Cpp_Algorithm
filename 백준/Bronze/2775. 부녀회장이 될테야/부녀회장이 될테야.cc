#include <iostream>
using namespace std;


int N;
int arr[15][14];

int main()
{
    for (int i = 0; i <= 15; i++) // 층
    {
        for (int j = 1; j <= 14; j++) // 호
        {
            if (i == 0)
                arr[i][j] += 1;
            else
            {
                for (int z = 1; z <= j; z++)
                    arr[i][j] += arr[i - 1][z];
            }
        }
    }
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        int a, b;
        cin >> a >> b;
        cout << arr[a + 1][b] << endl;
    }
    return 0;
}