using System;
using System.Collections.Generic;
using System.Text;

namespace _0727
{
    class p9251
    {
        static void Main()
        {
            string s1 = Console.ReadLine();
            string s2 = Console.ReadLine();
            int n = s1.Length;
            int m = s2.Length;
            int[,] dp = new int[n+1, m+1];

            for(int i = 1; i <= n; i++)
            {
                for(int j = 1; j <= m; j++)
                {
                    if (s1[i - 1] == s2[j - 1])
                        dp[i, j] = dp[i - 1, j - 1] + 1;
                    else
                        dp[i, j] = Math.Max(dp[i - 1, j], dp[i, j - 1]);
                }
            }

            Console.WriteLine(dp[n, m]);
        }
    }
}
