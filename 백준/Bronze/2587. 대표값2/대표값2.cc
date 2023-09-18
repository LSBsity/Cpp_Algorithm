#include <iostream>
#include <vector>
#include <string>

using namespace std;

void sort(vector<int> &arr)
{
    for (int i = 0; i < arr.size(); i++)
    {
        for (int j = i + 1; j < arr.size(); j++)
        {
            if (arr[i] > arr[j])
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}

int main(void)
{
    vector<int> arr;
    int sum = 0;
    for (int i = 0; i < 5; i++)
    {

        int a = 0;
        cin >> a;
        arr.push_back(a);
        sum += a;
    }

    sort(arr);

    cout << sum / 5 << endl;
    cout << arr[2] << endl;
}