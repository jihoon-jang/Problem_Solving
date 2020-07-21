using System;
using System.Collections.Generic;
using System.Text;

namespace _0721
{
    class p1799
    {
        static int n, countb, countw;
        static int[,] map;
        static int[] dx = { -1, -1, 1, 1 };
        static int[] dy = { -1, 1, -1, 1 };

        public static void Main()
        {
            init();

            bool[,] black = new bool[n, n];
            bool[,] white = new bool[n, n];

            countb = countw = 0;

            chess_black(black, 0, 0, 0);
            chess_white(white, 0, 1, 0);

            Console.WriteLine(countb + countw);
        }

        public static bool check(bool[,] visit, int x, int y)
        {
            for (int i = 0; i < 4; i++)
            {
                for (int j = 1; j < n; j++)
                {
                    int nx = x + dx[i] * j;
                    int ny = y + dy[i] * j;

                    if (nx >= 0 && ny >= 0 && nx < n && ny < n)
                        if (visit[nx, ny])
                            return false;
                }
            }

            return true;
        }

        public static void chess_white(bool[,] visit, int x, int y, int count)
        {
            countw = Math.Max(countw, count);

            if (y >= n)
            {
                x++;
                y = (x % 2 == 0 ? 1 : 0);
            }

            if (x == n)
            {
                return;
            }

            if (map[x, y] == 1)
                if (check(visit, x, y))
                {
                    visit[x, y] = true;
                    chess_white(visit, x, y + 2, count + 1);
                    visit[x, y] = false;
                }

            chess_white(visit, x, y + 2, count);
        }

        public static void chess_black(bool[,] visit, int x, int y, int count)
        {
            countb = Math.Max(countb, count);

            if (y >= n)
            {
                x++;
                y = (x % 2 == 0 ? 0 : 1);
            }
            if (x == n)
            {
                return;
            }

            if (map[x, y] == 1)
                if (check(visit, x, y))
                {
                    visit[x, y] = true;
                    chess_black(visit, x, y + 2, count + 1);
                    visit[x, y] = false;
                }

            chess_black(visit, x, y + 2, count);
        }

        public static void init()
        {
            n = int.Parse(Console.ReadLine());
            map = new int[n, n];

            for (int i = 0; i < n; i++)
            {
                String[] s = Console.ReadLine().Split(' ');
                for (int j = 0; j < n; j++)
                {
                    map[i, j] = int.Parse(s[j]);
                }
            }
        }

    }

}
