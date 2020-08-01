using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks.Dataflow;

namespace bj
{
    class P1010
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            long[,] dp = new long[31, 31];

            for (int i = 1; i <= 30; i++)
                dp[1, i] = i;

            for (int i = 2; i <= 30; i++)
            {
                for (int j = i; j <= 30; j++)
                {
                    for (int k = 1; k <= j - i + 1; k++)
                        dp[i, j] += dp[i - 1, j - k];
                }
            }

            for (int i = 0; i < n; i++)
            {
                string[] s = Console.ReadLine().Split(' ');
                int a = int.Parse(s[0]);
                int b = int.Parse(s[1]);

                Console.WriteLine(dp[a, b]);
            }
        }
    }
}
