public class javanonrecursive
{
	class Stack
	{
		int capacity;
		int top;
		int array[];
	}
	
	Stack createStack(int capacity)
	{
		Stack stack = new Stack();
		stack.capacity = capacity;
		stack.top = -1;
		stack.array = new int[capacity];
		return stack;
	}
	
	boolean isFull(Stack stack)
	{
		return (stack.top == stack.capacity - 1);
	}
	
	boolean isEmpty(Stack stack)
	{
		return (stack.top == -1);
	}
	
	void push(Stack stack, int item)
	{
		if(isFull(stack))
			return;
		stack.array[++stack.top] = item;
	}
	
	int pop(Stack stack)
	{
		if(isEmpty(stack))
			return Integer.MIN_VALUE;
		return stack.array[stack.top--];
	}
	
	void moveDisksBetweenTwo(Stack src, Stack dest, char s, char d)
	{
		int pole1Top = pop(src);
		int pole2Top = pop(dest);
		
		if(pole1Top == Integer.MIN_VALUE)
		{
			push(src, pole2Top);
			moveDisk(d, s, pole2Top);
		}
		
		else if(pole2Top == Integer.MIN_VALUE)
		{
			push(dest, pole1Top);
			moveDisk(s, d, pole1Top);
		}
		
		else if(pole1Top > pole2Top)
		{
			push(src, pole1Top);
			push(src, pole2Top);
			moveDisk(d, s, pole2Top);
		}
		else
		{
			push(dest, pole2Top);
			push(dest, pole1Top);
			moveDisk(s, d, pole1Top);
		}
	}
	
	void moveDisk(char fromPeg, char toPeg, int disk)
	{
		System.out.println("move disk " + disk + " from " + fromPeg + " to " + toPeg);
	}
	
	void iterative(int num_of_disks, Stack src, Stack aux, Stack dest)
	{
		int i, total_num_of_moves;
		char s = 'S', d = 'D', a = 'A';
		
		//if num of disks even interchange dest and aux poles
		if(num_of_disks % 2 == 0)
		{
			char temp = d;
			d = a;
			a = temp;
		}
		total_num_of_moves = (int) (Math.pow(2, num_of_disks)-1);
		
		//larger disks pushed first
		for(i = num_of_disks; i >= 1; i--)
			push(src,i);
			
		for(i = 1; i <= total_num_of_moves; i++)
		{
			if(i % 3 == 1)
				moveDisksBetweenTwo(src, dest, s, d);
			else if (i % 3 == 2)
				moveDisksBetweenTwo(src, aux, s, a);
			else if (i % 3 == 0)
				moveDisksBetweenTwo(aux, dest, a, d);
		}
	}
	
	public static void main(String[] args)
	{
		int num_of_disks = 5;
		javanonrecursive ob = new javanonrecursive();
		Stack src, dest, aux;
		
		src = ob.createStack(num_of_disks);
		dest = ob.createStack(num_of_disks);
		aux = ob.createStack(num_of_disks);
		
		ob.iterative(num_of_disks, src, aux, dest);
	}
}