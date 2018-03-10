import java.util.Scanner;

public class javarecursive
{
	public void solve(int n, String start, String aux, String end)
	{
		if(n==1)
			System.out.println("Move disc " + n + " " + start + " -> " + end);
		else
		{
			solve(n-1,start,end,aux);
			System.out.println("Move disc " + n + " " + start + " -> " + end);
			solve(n-1, aux,start,end);
		}
	}
	
	public static void main(String[] args)
	{
		javarecursive ob = new javarecursive();
		System.out.print("Enter number of discs: ");
		Scanner scanner = new Scanner(System.in);
		int discs = scanner.nextInt();
		ob.solve(discs, "A", "B", "C");
	}
}