#include <iostream>


using namespace std;

int main()
{
    int a, b, c;

    cin >> a >> b >> c;

    int min = (a * 60) + b;
    min += c;

    int hour = (min / 60) % 24;
    int minute = min % 60;

    cout << hour << " " << minute;


    return 0;
}
