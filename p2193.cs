using System;
using System.Collections.Generic;
using System.Text;

namespace _0727
{
    class p2193
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            long[] dp = new long[n + 1];
            dp[1] = 1;
            if (n > 1)
                dp[2] = 1;

            for (int i = 3; i <= n; i++)
                dp[i] = dp[i - 1] + dp[i - 2];

            Console.WriteLine(dp[n]);

        }
    }
}
