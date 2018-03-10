using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace csharprecursive
{

    class TOH
    {
        int num;
        public TOH()
        {
            num = 0;
        }
        public TOH(int val)
        {
            num = val;
        }
        public int discs
        {
            get
            {
                return num;
            }
            set
            {
                if (value > 0)
                    num = value;
            }
        }
        public void move(int n, int from, int to, int aux)
        {
            if (n > 0)
            {
                move(n - 1, from, aux, to);
                Console.WriteLine("Move disk {0} from {1} to {2}", n, from, to);
                move(n - 1, aux, to, from);
            }
        }
        static void Main(string[] args)
        {
            TOH ob = new TOH();
            string discs;
            Console.Write("enter number of discs: ");
            discs = Console.ReadLine();
            ob.num = Convert.ToInt32(discs);
            ob.move(ob.num, 1, 2, 3);
            Console.ReadLine();
            return;
        }

    }
  
}
