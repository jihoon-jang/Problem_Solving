using System;
using System.Collections.Generic;
using System.Text;

namespace bj
{
    class p1003
    {
        static void Main()
        {
            int tc = int.Parse(Console.ReadLine());
            value[] dp = new value[41];
            dp[0] = new value(1, 0);
            dp[1] = new value(0, 1);

            for (int i = 2; i <= 40; i++)
                dp[i] = new value((dp[i - 1].zero + dp[i - 2].zero), dp[i - 1].one + dp[i - 2].one);


            for (int t = 1; t <= tc; t++)
            {
                int n = int.Parse(Console.ReadLine());
                Console.WriteLine($"{dp[n].zero} {dp[n].one}");
            }
        }
    }

    class value
    {
        public int zero;
        public int one;
        public value(int zero, int one)
        {
            this.zero = zero;
            this.one = one;
        }
    }

}
