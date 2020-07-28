using System;

namespace _0727
{
    class p11048
    {
        static void Main()
        {
            string[] s = Console.ReadLine().Split(' ');
            int n = int.Parse(s[0]);
            int m = int.Parse(s[1]);
            int[,] map = new int[n+1, m+1];
            int[,] dp = new int[n+1, m+1];

            for (int i = 1; i <= n; i++)
            {
                s = Console.ReadLine().Split(' ');
                for (int j = 1; j <= m; j++)
                    map[i, j] = int.Parse(s[j - 1]);
            }

            for (int i = 1; i <= n; i++)
            {
                for (int j = 1; j <= m; j++)
                    dp[i, j] = Math.Max(dp[i - 1, j], dp[i, j - 1])+map[i,j];
            }

            Console.Write(dp[n, m]);

        }
    }
}
