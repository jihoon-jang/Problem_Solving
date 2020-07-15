using System;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.Text;

namespace ConsoleApp1
{
    class p7785
    {
        static void Main()
        {
            LinkedList<string> ll = new LinkedList<string>();
            int n = int.Parse(Console.ReadLine());

            for(int i = 0; i < n; i++)
            {
                String[] s = Console.ReadLine().Split(' ');
                if (s[1].Equals("enter"))
                {
                    ll.AddFirst(s[0]);
                }
            }
        }

    }
}
