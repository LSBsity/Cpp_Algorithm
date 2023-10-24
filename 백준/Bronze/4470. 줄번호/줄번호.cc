#include <iostream>
#include <string>
using namespace std;
int main() 
{
	int N; string input;
	cin >> N;
	cin.ignore();
	for (int i = 0; i < N; ++i)
	{
		getline(cin, input);
		cin.clear();
		cout << i + 1 << ". " << input << endl;
	}
}