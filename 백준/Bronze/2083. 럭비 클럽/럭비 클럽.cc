#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

string name;
int age, weight;

int main()
{

	while (true) {
		cin >> name >> age >> weight;
		if (name == "#" && age == 0 && weight == 0) break;
		if (age > 17 || weight >= 80) cout << name << " Senior" << '\n';
		else cout << name << " Junior" << '\n';
	}
}