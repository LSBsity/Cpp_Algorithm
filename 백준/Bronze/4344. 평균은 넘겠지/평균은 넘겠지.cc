#include <iostream>

using namespace std;

int main()
{
    int test, stu, sco[1001], avg = 0;
    double ans;
    cin >> test;

    for (int i = 0; i < test; i++)
    {
        cin >> stu;
        int sum = 0;
        for (int j = 0; j < stu; j++)
        {
            cin >> sco[j];
            sum += sco[j];
        }
        avg = sum / stu;

        double count = 0;

        for (int j = 0; j < stu; j++)
        {
            if (avg < sco[j])
                count++;
        }
        ans = (count / stu) * 100;
        cout.precision(3);
        cout << fixed;
        cout << ans << "%" << endl;
    }
    return 0;
}