using System;
using System.Collections.Generic;
using System.Text;

namespace _0722
{
    class p11660
    {
        static int n, m;
        static int[,] map;
        static int[,] dp;
        static StringBuilder sb = new StringBuilder();
        static void Main()
        {
            String[] s = Console.ReadLine().Split(' ');
            n = int.Parse(s[0]);
            m = int.Parse(s[1]);
            map = new int[n + 1, n + 1];
            dp = new int[n + 1, n + 1];

            for (int i = 1; i <= n; i++)
            {
                s = Console.ReadLine().Split(' ');
                for (int j = 1; j <= n; j++) { 
                    map[i, j] = int.Parse(s[j - 1]);
                    dp[i, j] = dp[i - 1, j] + dp[i, j - 1] + map[i, j] - dp[i - 1, j - 1];
                }
            }

            for (int i = 0; i < m; i++)
            {
                sum();
            }

            Console.WriteLine(sb.ToString());
        }

        static void sum()
        {
            string[] s = Console.ReadLine().Split(' ');
            int x1 = int.Parse(s[0]);
            int y1 = int.Parse(s[1]);
            int x2 = int.Parse(s[2]);
            int y2 = int.Parse(s[3]);

            sb.AppendLine((dp[x2, y2] - dp[x1 - 1, y2] - dp[x2, y1 - 1] + dp[x1 - 1, y1 - 1]).ToString());
        }
    }
}
