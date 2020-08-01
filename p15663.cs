using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Text;

namespace bj
{
    class p15663
    {
        static SortedSet<string> set = new SortedSet<string>();
        static int n, m;
        static int[] array;
        static bool[] visit;
        static void Main()
        {
            String[] s = Console.ReadLine().Split(' ');
            n = int.Parse(s[0]);
            m = int.Parse(s[1]);
            array = new int[n];
            visit = new bool[n];
            s = Console.ReadLine().Split(' ');

            for (int i = 0; i < n; i++)
                array[i] = int.Parse(s[i]);

            Array.Sort(array);
            func(0, "");

            for (int i = 0; i < set.Count; i++)
                Console.WriteLine(set.ToImmutableArray()[i]);
        }

        static void func(int length, String s)
        {
            if (length == m)
            {
                set.Add(s.Trim());
                return;
            }
            else
            {
                for (int i = 0; i < n; i++)
                {
                    if (!visit[i])
                    {
                        visit[i] = true;
                        func(length + 1, s + array[i] + " ");
                        visit[i] = false;
                    }
                }
            }
        }
    }


}
