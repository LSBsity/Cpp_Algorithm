#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main(void)
{
    int arr[9][9] = {};
    int max = 0;
    int idxX = 1;
    int idxY = 1;

    for (int i = 0; i < 9; i++)
    {
        for (int j = 0; j < 9; j++)
        {
            cin >> arr[i][j];
            if (arr[i][j] > max)
            {
                max = arr[i][j];
                idxX = i + 1;
                idxY = j + 1;
            }
        }
    }

    cout << max << "\n" << idxX << " " << idxY << "\n";
}