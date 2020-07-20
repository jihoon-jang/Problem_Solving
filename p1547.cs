using System;
using System.Collections.Generic;
using System.Text;

namespace _0720
{
    class p1547
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int pos = 1;
            for(int i = 0; i < n; i++)
            {
                String[] s = Console.ReadLine().Split(' ');
                if (int.Parse(s[0]) == pos)
                    pos = int.Parse(s[1]);
                else if (int.Parse(s[1]) == pos)
                    pos = int.Parse(s[0]);
            }
            Console.WriteLine(pos);
        }
    }
}
