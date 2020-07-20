using System;
using System.Collections.Generic;
using System.Numerics;
using System.Text;

namespace _0720
{
    class p2407
    {
        static void Main()
        {
            String[] s = Console.ReadLine().Split(' ');
            int n = int.Parse(s[0]);
            int m = int.Parse(s[1]);
            Console.WriteLine(cal(n, m));
        }

        static BigInteger cal(int n, int m)
        {
            BigInteger answer;
            answer = fac(n, m)/fac(n-m,1);

            return answer;
        }

        static BigInteger fac(int n, int m)
        {
            if(n == m)
            {
                return 1;
            }
            else
            {
                return n * fac(n - 1, m);
            }
        }
    }
}
