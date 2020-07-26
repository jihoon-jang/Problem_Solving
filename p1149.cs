using System;
using System.Collections.Generic;
using System.Text;

namespace bj
{
    class p1149
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int[,] map = new int[n + 1, 4];
            int[,] dp = new int[n + 1, 4];

            for(int i = 1; i <= n; i++)
            {
                string[] s = Console.ReadLine().Split(' ');

                for (int j = 1; j <= 3; j++)
                    map[i, j] = int.Parse(s[j-1]);
            }

            dp[1, 1] = map[1, 1];
            dp[1, 2] = map[1, 2];
            dp[1, 3] = map[1, 3];

            for (int i = 2; i <= n; i++)
            {
                dp[i, 1] = Math.Min(dp[i - 1, 2], dp[i - 1, 3]) + map[i, 1];
                dp[i, 2] = Math.Min(dp[i - 1, 1], dp[i - 1, 3]) + map[i, 2];
                dp[i, 3] = Math.Min(dp[i - 1, 2], dp[i - 1, 1]) + map[i, 3];
            }

            Console.Write(Math.Min(dp[n, 1], Math.Min(dp[n, 2], dp[n, 3])));
        }
    }
}
