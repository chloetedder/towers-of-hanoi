using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;

namespace csharprecursive
{
    class csharpnonrecursive
    {
        static int legalMove(Stack<int> A, Stack<int> B)
        {
            int a, b;
            try {
                a = A.Peek();
            }
            catch(Exception e)
            {
                a = 0;
            }
            try
            {
                b = B.Peek();
            }
            catch (Exception e)
            {
                b = 0;
            }
            if (a == b) return 0;
            if (a == 0)
            {
                A.Push(B.Pop());
                return 2;
            }
            else if (b == 0)
            {
                B.Push(A.Pop());
                return 1;
            }

            if (a < b)
            {
                B.Push(A.Pop());
                return 1;
            }
            else if (a > b)
            {
                A.Push(B.Pop());
                return 2;
            }
            return -1;
        }

        static void Main()
        {
            int stepNumber = 0;
            int status = 0;
            try
            {
                Stack<int> source = new Stack<int>();
                Stack<int> aux = new Stack<int>();
                Stack<int> dest = new Stack<int>();
                Console.WriteLine("enter number of discs: ");
                int n = Convert.ToInt32(Console.ReadLine());
                if (n <= 0)
                {
                    Console.WriteLine("wrong input");

                }
                for (int i = n; i > 0; i--)
                    source.Push(i);
                int m = n % 2;
                do
                {
                    if (m == 1)
                    {
                        if ((status = legalMove(source, dest)) == 1)
                            Console.WriteLine("'{0}' source --> dest ", (++stepNumber));
                        else if (status == 2)
                            Console.WriteLine("'{0}' dest--> source", (++stepNumber));
                        if ((status = legalMove(source, aux)) == 1)
                            Console.WriteLine("'{0}' source --> aux", (++stepNumber));
                        else if (status == 2)
                            Console.WriteLine("'{0}' aux--> source", (++stepNumber));
                        else break;
                    }
                    else
                    {
                        if ((status = legalMove(source, aux)) == 1)
                            Console.WriteLine("'{0}' source --> aux", (++stepNumber));
                        else if (status == 2)
                            Console.WriteLine("'{0}' aux--> source", (++stepNumber));
                        if ((status = legalMove(source, dest)) == 1)
                            Console.WriteLine("'{0}' source --> dest", (++stepNumber));
                        else if (status == 2)
                            Console.WriteLine("'{0}' dest--> source", (++stepNumber));
                    }
                    if ((status = legalMove(aux, dest)) == 1)
                        Console.WriteLine("'{0}' aux--> dest", (++stepNumber));
                    else if (status == 2)
                        Console.WriteLine("'{0}' dest--> aux", (++stepNumber));
                }
                while (dest.Count != n);
                }
            catch (Exception e) { Console.WriteLine("'{0}'", e); }
            Console.ReadLine();
        }
    }
}
