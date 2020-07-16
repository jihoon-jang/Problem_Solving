using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices.ComTypes;

namespace bj
{
    class p16236
    {
        static int n, size, feed, time, x, y;
        static int[,] map;
        static bool[,] visit;
        static Queue<Point> q = new Queue<Point>();
        static int[] dx = { 0, 0, -1, 1 };
        static int[] dy = { -1, 1, 0, 0 };
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

        static void eat(List<Point> al)
        {
            Point fish = al[0];
            time += fish.dis;
            feed++;
            if (feed == size)
            {
                size++;
                feed = 0;
            }
            x = fish.x;
            y = fish.y;
            map[x, y] = 0;
            q.Enqueue(new Point(fish.x, fish.y, 0));
        }

        static void start()
        {
            q.Enqueue(new Point(x, y));
            List<Point> al = new List<Point>();
            map[x, y] = 0;
            visit = new bool[n, n];
            visit[x, y] = true;
            while (q.Count != 0)
            {
                Point p = q.Dequeue();

                for (int i = 0; i < 4; i++)
                {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];

                    if (check(nx, ny) && !visit[nx, ny] && map[nx, ny] <= size)
                    {
                        q.Enqueue(new Point(nx, ny, p.dis + 1));
                        visit[nx, ny] = true;
                        if (map[nx, ny] != 0 && map[nx, ny] < size)
                        {
                            al.Add(new Point(nx, ny, p.dis + 1));
                        }
                    }
                }

                if ((q.Count != 0 && p.dis != q.Peek().dis && al.Count != 0) || (q.Count == 0 && al.Count != 0))
                {
                    al.Sort();
                    q.Clear();
                    eat(al);
                    al.Clear();
                    visit = new bool[n, n];
                }

            }
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
    class Point : IComparable<Point>
    {
        public int x;
        public int y;
        public int dis;
        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
            dis = 0;
        }
        public Point(int x, int y, int dis)
        {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }

        public int CompareTo(Point point)
        {
            if (this.dis == point.dis)
            {
                if (this.x == point.x)
                    return this.y - point.y;
                else
                    return this.x - point.x;
            }
            else
                return this.dis - point.dis;
        }
    }
}