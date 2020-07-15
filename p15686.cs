using System;
using System.Collections;

namespace ConsoleApp1
{
    class p15686
    {
        static int n, m, answer;
        static int[,] map;
        static bool[] visit;
        static ArrayList al = new ArrayList();
        static void Main()
        {
            String[] s = Console.ReadLine().Split(' ');
            n = int.Parse(s[0]);
            m = int.Parse(s[1]);
            map = new int[n, n];
            answer = int.MaxValue;

            makeMap();
            chicken(0, 0, "");
            Console.WriteLine(answer);
        }

        static void cal(string[] s)
        {
            int sum = 0;
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (map[i, j] == 1)
                    {
                        int temp = 99999999;
                        for (int k = 0; k < s.Length; k++)
                        {
                            Point p = (Point)al[int.Parse(s[k])];
                            temp = Math.Min(temp, Math.Abs(i - p.x) + Math.Abs(j - p.y));
                        }
                        sum += temp;
                    }
                }
            }
            answer = Math.Min(answer, sum);
        }

        static void chicken(int length, int start, string s)
        {
            if (length == m)
            {
                cal(s.Trim().Split(' '));
                return;
            }
            else
            {
                for (int i = start; i < al.Count; i++)
                {
                    if (!visit[i])
                    {
                        visit[i] = true;
                        chicken(length + 1, i, s + i + " ");
                        visit[i] = false;
                    }
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
                    if (map[i, j] == 2)
                        al.Add(new Point(i, j));
                }
            }
            visit = new bool[al.Count];
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
