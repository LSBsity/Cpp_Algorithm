#include <iostream>
#include <string>

using namespace std;
int main() {
    string a;
    cin >> a;

    if ("A+" == a)
        cout << "4.3" << endl;
    else if ("A0" == a)
        cout << "4.0" << endl;
    else if ("A-" == a)
        cout << "3.7" << endl;
    else if ("B+" == a)
        cout << "3.3" << endl;
    else if ("B0" == a)
        cout << "3.0" << endl;
    else if ("B-" == a)
        cout << "2.7" << endl;
    else if ("C+" == a)
        cout << "2.3" << endl;
    else if ("C0" == a)
        cout << "2.0" << endl;
    else if ("C-" == a)
        cout << "1.7" << endl;
    else if ("D+" == a)
        cout << "1.3" << endl;
    else if ("D0" == a)
        cout << "1.0" << endl;
    else if ("D-" == a)
        cout << "0.7" << endl;
    else if ("F" == a)
        cout << "0.0" << endl;

    return 0;
}