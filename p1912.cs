using System;
using System.Collections.Generic;
using System.Text;

namespace _0727
{
    class p1912
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int[] array = new int[n + 1];
            int[] dp = new int[n + 1];
            string[] s = Console.ReadLine().Split(' ');

            for (int i = 1; i <= n; i++) 
                array[i] = int.Parse(s[i-1]);

            dp[1] = array[1];
            int max = dp[1];
            for (int i = 2; i <= n; i++)
            {
                dp[i] = Math.Max(dp[i - 1] + array[i], array[i]);
                max = Math.Max(max, dp[i]);
            }

            Console.Write(max);
        }
    }
}
