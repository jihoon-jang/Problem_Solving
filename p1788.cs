using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp4
{
    class p1788
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            long[] array = new long[Math.Abs(n) + 2 < 1 ? 2 : Math.Abs(n) + 2];

            if (n < 0)
            {
                array[0] = 1;
                array[1] = 0;

                if (array.Length >= 2)
                    for (int i = 2; i <= Math.Abs(n) + 1; i++)
                        array[i] = (array[i - 2] - array[i - 1]) % 1000000000;
                if (array[Math.Abs(n) + 1] > 0)
                    Console.WriteLine(1);
                else if ((array[Math.Abs(n) + 1] < 0))
                    Console.WriteLine(-1);
                else
                    Console.WriteLine(0);
                Console.WriteLine($"{Math.Abs(array[Math.Abs(n) + 1])}");
            }
            else
            {
                array[0] = 0;
                array[1] = 1;

                if (array.Length >= 2)
                    for (int i = 2; i <= Math.Abs(n) + 1; i++)
                        array[i] = (array[i - 2] + array[i - 1]) % 1000000000;
                if (array[Math.Abs(n)] > 0)
                    Console.WriteLine(1);
                else if ((array[Math.Abs(n)] < 0))
                    Console.WriteLine(-1);
                else
                    Console.WriteLine(0);
                Console.WriteLine($"{Math.Abs(array[Math.Abs(n)])}");
            }

        }
    }
}
