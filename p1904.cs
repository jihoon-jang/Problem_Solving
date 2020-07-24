using System;
using System.Collections.Generic;
using System.Text;

namespace _0724
{
    class p1904
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int[] dp = new int[n + 1];
            dp[1] = 1;
            if (n >= 2)
                dp[2] = 2;
            if (n >= 3)
            {
                for(int i = 3; i <= n; i++)
                {
                    dp[i] = (dp[i - 1] + dp[i - 2])%15746;
                }
            }
            Console.WriteLine(dp[n]);
        }
    }
}
