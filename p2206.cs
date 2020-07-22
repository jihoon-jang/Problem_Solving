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
        static bool[,,] visit;
        static Queue<Point> q = new Queue<Point>();
        static void Main()
        {
            String[] s = Console.ReadLine().Split(' ');
            n = short.Parse(s[0]);
            m = short.Parse(s[1]);
            map = new int[n + 1, m + 1];
            visit = new bool[n + 1, m + 1, 2];

            for (int i = 1; i <= n; i++)
            {
                String str = Console.ReadLine();
                for (int j = 1; j <= m; j++)
                {
                    map[i, j] = str[j - 1] - '0';
                }
            }

            bfs();
        }

        static void bfs()
        {
            int answer = 0;
            q.Enqueue(new Point(1, 1, 1, 1));

            while (q.Count != 0)
            {
                Point p = q.Dequeue();

                if (p.x == n && p.y == m)
                {
                    answer = p.distance;
                    break;
                }

                for (short i = 0; i < 4; i++)
                {
                    short nx = (short)(p.x + dx[i]);
                    short ny = (short)(p.y + dy[i]);

                    if (nx >= 1 && ny >= 1 && nx <= n && ny <= m)
                    {
                        if (map[nx, ny] == 0 && !visit[nx, ny, p.chance])
                        {
                            visit[nx, ny, p.chance] = true;
                            q.Enqueue(new Point(nx, ny, p.chance, p.distance + 1));
                        }
                        else if (map[nx, ny] == 1 && p.chance == 1 && !visit[nx, ny, 0])
                        {
                            visit[nx, ny, 0] = true;
                            q.Enqueue(new Point(nx, ny, 0, p.distance + 1));
                        }
                    }
                }
                p = null;
            }

            Console.WriteLine(answer == 0 ? -1 : answer);
        }

    }

    class Point
    {
        public short x, y;
        public int chance;
        public int distance;
        public Point(short x, short y, int c, int d)
        {
            this.x = x;
            this.y = y;
            this.chance = c;
            this.distance = d;
        }
    }

}
