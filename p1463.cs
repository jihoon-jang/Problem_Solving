using System;
using System.Collections.Generic;
using System.Text;

namespace _0724
{
    class p1463
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int[] dp = new int[1000001];

            if (n >= 2)
                dp[2] = 1;
            if (n >= 3)
                dp[3] = 1;

            if (n >= 4)
                for (int i = 4; i <= n; i++)
                {
                    dp[i] = dp[i - 1] + 1;
                    if (dp[i] % 3 == 0)
                        dp[i] = dp[i / 3] + 1;
                    Console.WriteLine(dp[5]);
                    if (dp[i] % 2 == 0)
                        dp[i] = dp[i / 2] + 1;
                }

            Console.WriteLine(dp[n]);
        }
    }
}
