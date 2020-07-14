using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp4
{
    class p1773
    {
        static void Main()
        {
            String[] s = Console.ReadLine().Split(' ');
            int n = int.Parse(s[0]);
            int c = int.Parse(s[1]);
            bool[] fire = new bool[c+1];
            int[] time = new int[n];

            for (int i = 0; i < n; i++)
                time[i] = int.Parse(Console.ReadLine());

            for(int i = 0; i < n; i++)
            {
                for(int j = 1; j*time[i] <= c; j++)
                {
                    fire[j * time[i]] = true;
                }
            }

            int count = 0;
            for(int i = 0; i <= c; i++)
            {
                if (fire[i])
                    count++;
            }
            Console.WriteLine(count);
        }
    }
}
