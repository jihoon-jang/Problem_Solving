using System;
using System.Collections.Generic;
using System.Text;

namespace _0727
{
    class p2156
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int[] dp = new int[n + 1];
            int[] wine = new int[n + 1];
            for (int i = 1; i <= n; i++)
                wine[i] = int.Parse(Console.ReadLine());

            dp[1] = wine[1];
            if (n >= 2)
                dp[2] = wine[1] + wine[2];

            for (int i = 3; i <= n; i++)
                dp[i] = Math.Max(dp[i - 1], Math.Max(wine[i - 1] + dp[i - 3] + wine[i], dp[i - 2] + wine[i])); ;


            Console.WriteLine(dp[n]);
        }
    }
}
