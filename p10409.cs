using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp4
{
    class p10409
    {
        static void Main()
        {
            String[] s = Console.ReadLine().Split(' ');
            int n = int.Parse(s[0]);
            int t = int.Parse(s[1]);
            int[] array = new int[n];
            s = Console.ReadLine().Split(' ');

            for (int i = 0; i < n; i++)
                array[i] = int.Parse(s[i]);

            int count = 0;
            int sum = 0;
            for(int i = 0; i < n; i++)
            {
                sum += array[i];
                if (sum <= t)
                    count++;
            }
            Console.WriteLine(count);
        }
    }
}
