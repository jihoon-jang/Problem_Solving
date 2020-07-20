using System;
using System.Collections.Generic;
using System.Text;

namespace _0720
{
    class p11725
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int[] parent = new int[n + 1];
            parent[1] = 1;
            for (int i = 0; i < n - 1; i++)
            {
                String[] s = Console.ReadLine().Split(' ');
                int x = int.Parse(s[0]);
                int y = int.Parse(s[1]);
                if (y == 1 || parent[x] == 0)
                    parent[x] = y;
                else if (x == 1 || parent[y] == 0)
                    parent[y] = x;
            }

            for (int i = 2; i <= n; i++)
                Console.WriteLine(parent[i]);
        }
    }
}
