using System;
using System.Collections.Generic;
using System.Text;

namespace _0727
{
    class p2167
    {
        static void Main()
        {
            string[] s = Console.ReadLine().Split(' ');
            int n = int.Parse(s[0]);
            int m = int.Parse(s[1]);
            int[,] map = new int[n + 1, m + 1];
            int[,] dp = new int[n + 1, m + 1];
            for (int i = 1; i <= n; i++)
            {
                s = Console.ReadLine().Split(' ');
                for (int j = 1; j <= m; j++)
                    map[i, j] = int.Parse(s[j - 1]);
            }

            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= m; j++)
                    dp[i, j] = map[i, j] + dp[i - 1, j] + dp[i, j - 1] - dp[i - 1, j - 1];

            int k = int.Parse(Console.ReadLine());
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < k; i++)
            {
                s = Console.ReadLine().Split(' ');
                int x1 = int.Parse(s[0]);
                int y1 = int.Parse(s[1]);
                int x2 = int.Parse(s[2]);
                int y2 = int.Parse(s[3]);

                sb.AppendLine(dp[x2, y2] + dp[x1 - 1, y1 - 1] - dp[x1-1, y2] - dp[x2, y1-1]+"");
            }

            Console.WriteLine(sb.ToString());
        }
    }
}
