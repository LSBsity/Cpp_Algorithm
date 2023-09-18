#include <iostream>
#include <array>

using namespace std;

int main()
{
    int init, N;
    int count = 0;
    cin >> init;

    N = init;

    do
    {
        N = (N % 10) * 10  +  ((N / 10) + (N % 10)) % 10;
                // 80             / 4
        count++;
    } while (init != N);
    
    cout << count;

    return 0;
}