/*#include <iostream>
#include<stdlib.h>
using namespace std;

#define MAXSTACK 100
struct details {
	int number;
	char beg;
	char end;
	char aux;
};

struct stack {
	int top;
	struct details item[MAXSTACK];
};

void push(struct stack *s, struct details *current)
{
	if (s->top == MAXSTACK - 1)
	{
		cout << "overflow";
		exit(1);
	}
	else
		s->item[++(s->top)] = *current;
	return;
}

void pop(struct stack *s, struct details *current, int *flag)
{
	if (s->top == -1) {
		*flag = 1;
		return;
	}
	*flag = 0;
	*current = s->item[s->top--];
	return;
}

void towers(int n, char begp, char endp, char auxp)
{
	struct stack s;
	struct details current;
	int flag;
	char temp;
	s.top = -1;
	current.number = n;
	current.end = endp;
	current.beg = begp;
	current.aux = auxp;
	while (1) {
		while (current.number != 1)
		{
			push(&s, &current);
			--current.number;
			temp = current.end;
			current.end = current.aux;
			current.aux = temp;
		}
		cout << "Move disc 1 from " << current.beg << " to " << current.end << endl;
		pop(&s, &current, &flag);
		if (flag == 1)
			return;
		cout << "Move disc " << current.number << " from " << current.beg << " to " << current.end << endl;
		--current.number;
		temp = current.beg;
		current.beg = current.aux;
		current.aux = temp;
	}
}

int main()
{
	int N;
	cout << "enter number of discs: ";
	cin >> N;
	towers(N, 'A','B', 'C');
	system("pause");
	return 0;
}*/

#include <iostream>
#include <stack>
#include <deque>

using namespace std;

int legalMove(stack<int>& A, stack<int>& B)
{
	int a, b;
	if (!A.empty())
		a = A.top();
	else
		a = 0;
	if (!B.empty())
		b = B.top();
	else
		b = 0;
	if (a == b)return 0;
	if (a == 0) {
		if (!B.empty()) {
			A.push(B.top());
			B.pop();
			return 2;
		}
	}
	else if (b == 0) {
		if (!A.empty()) {
			B.push(A.top());
			A.pop();
			return 1;
		}
	}
	if (a < b) {
		if (!A.empty()) {
			B.push(A.top());
			A.pop();
			return 1;
		}
	}
	else if (a>b) {
		if (!B.empty()) {
			A.push(B.top());
			B.pop();
			return 2;
		}
	}
	return -1;
}

void main()
{
	int steps = 0;
	int status = 0;
	int n;
	try {
		stack<int> source;
		stack<int> aux;
		stack<int> dest;

		cout << "enter number of discs: ";
		cin >> n;
		if (n <= 0) {
			cout << "wrong input" << endl;
			return;
		}
		for (int x = n; x > 0; x--)
		{
			source.push(x);
		}
		int m = n % 2;
		do {
			if (m == 1) {
				if ((status = legalMove(source, dest)) == 1)
				cout << ++steps << "source --> dest" << endl;
				else if (status == 2)
					cout << ++steps << "dest --> source" << endl;
				if ((status = legalMove(source, aux)) == 1)
				cout << ++steps << "source --> aux" << endl;
				else if (status == 2)
					cout << ++steps << "aux --> source" << endl;
				else
					break;
			}
			else {
				if ((status = legalMove(source, aux)) == 1)
				cout << ++steps << "source --> aux" << endl;
				else if (status == 2)
					cout << ++steps << "aux --> source" << endl;
				if ((status = legalMove(source, dest)) == 1)
				cout << ++steps << "source --> dest" << endl;
				else if (status == 2)
					cout << ++steps << "dest --> source" << endl;
			}

			if ((status = legalMove(aux, dest)) == 1)
			cout << ++steps << "aux --> dest" << endl;
			else if (status == 2)
				cout << ++steps << "dest --> aux" << endl;
		} while (dest.size() != n);
	}
	catch (exception e) {
		cout << "exception" << endl;
	}
	system("pause");
}