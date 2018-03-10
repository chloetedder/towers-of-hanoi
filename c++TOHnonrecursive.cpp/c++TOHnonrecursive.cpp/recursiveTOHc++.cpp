#include<iostream>
#include<stdlib.h>
using namespace std;
void tower(int num, char beg, char aux, char end)
{
	if (num >= 1)
	{
		tower(num - 1, beg, end, aux);
		cout << "Move disc " << num << " from " << beg << " to " << end << endl;
		tower(num - 1, aux, beg, end);
	}
}

int main()
{
	int N;
	cout << "enter number of discs: ";
	cin >> N;
	tower(N, 'A', 'B', 'C');
	system("pause");
	return 0;
}