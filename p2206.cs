using System;
using System.Collections.Generic;
using System.Text;

namespace _0721
{
    class p2206
    {
        static short n, m;
        static short[] dx = { -1, 1, 0, 0 };
        static short[] dy = { 0, 0, -1, 1 };
        static int[,] map;
        static Queue<Point> q = new Queue<Point>();
        static void Main()
        {
            String[] s = Console.ReadLine().Split(' ');
            n = short.Parse(s[0]);
            m = short.Parse(s[1]);
            map = new int[n + 1, m + 1];

            for (int i = 1; i <= n; i++)
            {
                String str = Console.ReadLine();
                for (int j = 1; j <= m; j++)
                {
                    map[i, j] = str[j - 1] - '0';
                }
            }
            q.Enqueue(new Point(1, 1, true, 1));

            while (q.Count != 0)
            {
                Point p = q.Dequeue();
                map[p.x, p.y] = p.distance;
                if (p.x == n && p.y == m)
                    break;
                for (short i = 0; i < 4; i++)
                {
                    short nx = (short)(p.x + dx[i]);
                    short ny = (short)(p.y + dy[i]);

                    if (nx >= 1 && ny >= 1 && nx <= n && ny <= m)
                    {
                        if (map[nx, ny] == 0)
                        {
                            q.Enqueue(new Point(nx, ny, p.chance, map[p.x, p.y] + 1));
                        }
                        else if (map[nx, ny] == 1 && p.chance)
                        {
                            q.Enqueue(new Point(nx, ny, false, map[p.x, p.y] + 1));
                        }
                    }
                }
                p = null;
            }
            Console.WriteLine(map[n, m] == 0 ? -1 : map[n, m]);
        }

    }

    class Point
    {
        public short x, y;
        public bool chance;
        public int distance;
        public Point(short x, short y, bool c, int d)
        {
            this.x = x;
            this.y = y;
            this.chance = c;
            this.distance = d;
        }
    }

}
