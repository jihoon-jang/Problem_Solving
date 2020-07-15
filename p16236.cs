

using System;
using System.Runtime.InteropServices.WindowsRuntime;

namespace ConsoleApp1
{
    class p16236
    {
        static int n, size, feed, time, x, y;
        static int[,] map;
        static int[] dy = { -1, 1 };
        static void Main()
        {
            n = int.Parse(Console.ReadLine());
            map = new int[n, n];
            size = 2;
            feed = 0;
            time = 0;
            makeMap();
            start();
            Console.WriteLine(time);
        }

        static bool check(int x, int y)
        {
            return x >= 0 && y >= 0 && x < n && y < n;
        }

        static void start()
        {
        }

        static void print()
        {
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                    Console.Write(map[i, j] + " ");
                Console.WriteLine();
            }
            Console.WriteLine();
        }

        static void makeMap()
        {
            for (int i = 0; i < n; i++)
            {
                String[] s = Console.ReadLine().Split(' ');
                for (int j = 0; j < n; j++)
                {
                    map[i, j] = int.Parse(s[j]);
                    if (map[i, j] == 9)
                    {
                        x = i;
                        y = j;
                    }
                }
            }
        }
    }
    class Point
    {
        public int x;
        public int y;
        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}
