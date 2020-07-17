using System;

namespace _0717
{
    class p1987
    {
        static int r, c, answer;
        static char[,] map;
        static bool[] history;
        static int[] dx = { -1, 1, 0, 0 };
        static int[] dy = { 0, 0, -1, 1 };

        static void Main(string[] args)
        {
            init();
            search(0, 0, 1);
            Console.WriteLine(answer);
        }

        static bool check(int x, int y)
        {
            return x >= 0 && y >= 0 && x < r && y < c;
        }

        static void search(int x, int y, int count)
        {
            char value = map[x, y];
            if (!history[value - 'A'])
            {
                history[value - 'A'] = true;
                for (int i = 0; i < 4; i++)
                {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (check(nx, ny))
                        search(nx, ny, count + 1);
                }
                history[value - 'A'] = false;
                answer = Math.Max(answer, count);
            }
        }

        static void init()
        {
            String[] s = Console.ReadLine().Split(' ');
            r = int.Parse(s[0]);
            c = int.Parse(s[1]);
            answer = 0;
            map = new char[r, c];
            history = new bool[26];

            for (int i = 0; i < r; i++)
            {
                string str = Console.ReadLine();
                for (int j = 0; j < c; j++)
                    map[i, j] = str[j];
            }
        }
    }
}
