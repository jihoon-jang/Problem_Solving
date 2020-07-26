using System;
using System.Collections.Generic;
using System.Text;

namespace bj
{
    class p11726
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int[] dp = new int[1001];
            dp[1] = 1;
            dp[2] = 2;

            for (int i = 3; i <= 1000; i++)
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;

            Console.Write(dp[n]);
        }
    }
}
