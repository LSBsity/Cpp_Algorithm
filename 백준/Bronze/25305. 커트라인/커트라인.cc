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
    int a , b;

    cin >> a >> b;

    for (int i = 0; i < a; i++)
    {
        int c = 0;
        cin >> c;
        arr.push_back(c);
    }
    sort(arr);

    cout << arr[arr.size() - b] << endl;
}