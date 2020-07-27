using System;
using System.Collections.Generic;
using System.Text;

namespace bj
{
    class p1932
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int[,] map = new int[n + 1, n + 1];
            int[,] dp = new int[n + 1, n + 1];
            for (int i = 1; i <= n; i++)
            {
                string[] s = Console.ReadLine().Split(' ');
                for(int j = 1; j <= i; j++)
                    map[i, j] = int.Parse(s[j - 1]);
            }

            dp[1, 1] = map[1, 1];
            for(int i = 2; i <= n; i++) {
                for(int j = 1; j <= i; j++)
                {
                    dp[i, j] = Math.Max(dp[i - 1, j - 1], dp[i - 1, j])+map[i,j];
                }
            }
            int max = 0;
            for (int i = 1; i <= n; i++)
                max = Math.Max(max, dp[n, i]);

            Console.WriteLine(max);
        }
    }
}
