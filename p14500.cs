using System;

namespace ConsoleApp1
{
    class p14500
    {
        static int n, m, answer = 0;
        static int[,] map;
        static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, -1, 1 };
        static bool[,] visit;

        static void Main()
        {
            String[] s = Console.ReadLine().Split(' ');
            n = int.Parse(s[0]);
            m = int.Parse(s[1]);
            makeMap();
            cal();
            Console.WriteLine(answer);
        }

        static bool check(int x, int y)
        {
            return x >= 0 && y >= 0 && x < n && y < m;
        }

        static void special(int sum, int x, int y)
        {
            for (int i = 0; i < 2; i++)
            {
                int temp = sum;
                for (int j = 0; j < 2; j++)
                {
                    int nx = x + dx[i * 2 + j];
                    int ny = y + dy[i * 2 + j];
                    if (check(nx, ny))
                        temp += map[nx, ny];
                }
                for (int k = 0; k < 2; k++)
                {
                    if (i == 0)
                    {
                        int nx = x + dx[2 + k];
                        int ny = y + dy[2 + k];
                        if (check(nx, ny))
                            answer = Math.Max(temp + map[nx, ny], answer);
                    }
                    else
                    {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (check(nx, ny))
                            answer = Math.Max(temp + map[nx, ny], answer);
                    }
                }
            }
        }

        static void dfs(int length, int sum, int x, int y)
        {
            if (length == 4)
            {
                answer = Math.Max(answer, sum);
                return;
            }
            else
            {
                for (int i = 0; i < 4; i++)
                {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (check(nx, ny) && !visit[nx, ny])
                    {
                        visit[nx, ny] = true;
                        dfs(length + 1, sum + map[nx, ny], nx, ny);
                        visit[nx, ny] = false;
                    }
                }
            }
        }

        static void cal()
        {
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    dfs(0, 0, i, j);
                    special(map[i,j], i, j);
                }
            }
        }

        static void makeMap()
        {
            map = new int[n, m];
            visit = new bool[n, m];
            for (int i = 0; i < n; i++)
            {
                String[] s = Console.ReadLine().Split(' ');
                for (int j = 0; j < m; j++)
                    map[i, j] = int.Parse(s[j]);
            }
        }
    }
}
