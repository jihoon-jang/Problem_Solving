using System;
using System.Collections.Generic;
using System.Runtime.ExceptionServices;
using System.Text;

namespace bj
{
    class p2579
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int[] stair = new int[n + 1];
            for (int i = 1; i <= n; i++)
                stair[i] = int.Parse(Console.ReadLine());
            int[] dp = new int[n + 1];
            dp[1] = stair[1];

            if (n > 1)
                dp[2] = stair[2] + dp[1];

            if (n > 2)
                dp[3] = Math.Max(stair[1] + stair[3], stair[2] + stair[3]);

            for (int i = 4; i <= n; i++)
                dp[i] = Math.Max(dp[i - 2] + stair[i], dp[i - 3] + stair[i - 1] + stair[i]);

            Console.WriteLine(dp[n]);
        }
    }
}
