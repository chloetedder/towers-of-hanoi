using System;
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
            if(value>0)
                num=value;
        }
    }
    public void move(int n, char from, char to, char aux)
    {
        if(n>0)
        {
            move(n-1,from,aux,to);
            Console.WriteLine("Move disk {0} from {1} to {2}", n, from,to);
            move(n-1,aux,to,from);
        }
    }
    
}
class App
{
    public static int Main()
    {
        TOH ob = new TOH();
        string discs;
        Console.Write("enter number of discs: ");
        discs = Console.Readline();
        ob.num = Convert.ToInt32(discs);
        ob.move(ob.num, A, B, C);
        Console.ReadLine();
        return 0;
    }
}