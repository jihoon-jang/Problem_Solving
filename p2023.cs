using System;
using System.Collections.Generic;
using System.Text;

namespace _0720
{
    class p2023
    {
        static int n;
        static void Main()
        {
            init();
            dfs(0, "");
        }

        static bool check(string s)
        {
            int number = int.Parse(s);
            if (number == 1)
                return false;
            for(int i = 2; i <= Math.Sqrt(number); i++)
            {
                if (number % i == 0)
                    return false;
            }
            return true;
        }

        static void dfs(int length, String s)
        {
            if (length == n)
            {
                Console.WriteLine(s);
                return;
            }
            else
            {
                for (int i = 1; i <= 9; i++)
                {
                    if (check(s + i))
                    {
                        dfs(length + 1, s + i);
                    }
                }
            }
        }

        static void init()
        {
            n = int.Parse(Console.ReadLine());
        }
    }
}
