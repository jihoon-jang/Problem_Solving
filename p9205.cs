using System;
using System.Collections.Generic;
using System.Text;

namespace bj
{
    class p9205
    {
        static void Main()
        {
            int t = int.Parse(Console.ReadLine());
            StringBuilder sb = new StringBuilder();

            for (int tc = 0; tc < t; tc++)
            {
                Queue<Point> q = new Queue<Point>();
                int conCount = int.Parse(Console.ReadLine());
                Point[] conCoor = new Point[101];
                bool[] visit = new bool[101];
                bool finish = false;

                String s = Console.ReadLine();
                Point home = new Point(int.Parse(s.Split(' ')[0]), int.Parse(s.Split(' ')[1]));

                for (int i = 0; i < conCount+1; i++)
                {
                    s = Console.ReadLine();
                    conCoor[i] = new Point(int.Parse(s.Split(' ')[0]), int.Parse(s.Split(' ')[1]));
                }

                q.Enqueue(home);

                while (q.Count != 0)
                {
                    Point p = q.Dequeue();
                    if (p == conCoor[conCount])
                    {
                        finish = true;
                        break;
                    }

                    for (int i = 0; i < conCount+1; i++)
                    {
                        if (!visit[i] && check(p.x, p.y, conCoor[i].x, conCoor[i].y))
                        {
                            visit[i] = true;
                            q.Enqueue(conCoor[i]);
                        }

                    }
                }
                if (finish)
                    sb.AppendLine("happy");
                else
                    sb.AppendLine("sad");
            }
            Console.WriteLine(sb.ToString());
        }

        public static bool check(int x, int y, int dx, int dy)
        {
            int distance = Math.Abs(x - dx) + Math.Abs(y - dy);
            if (distance > 1000)
                return false;
            return true;
        }
    }

    class Point
    {
        public int x, y;
        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}
