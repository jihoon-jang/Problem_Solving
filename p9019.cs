using System;
using System.Collections.Generic;
using System.Text;

namespace bj
{
    class p9019
    {
        static void Main()
        {
            char[] c = { ' ', 'D', 'S', 'L', 'R' };
            int t = int.Parse(Console.ReadLine());
            String[] s;
            int start;
            int end;
            Queue<int> number;
            Queue<long> command;
            bool[] visit;

            for (int tc = 0; tc < t; tc++)
            {
                s = Console.ReadLine().Split(' ');
                start = int.Parse(s[0]);
                end = int.Parse(s[1]);
                number = new Queue<int>();
                command = new Queue<long>();
                visit = new bool[10000];
                number.Enqueue(start);
                command.Enqueue(0);

                int num;
                long com;
                while (number.Count != 0)
                {
                    num = number.Dequeue();
                    com = command.Dequeue();
                    if (visit[num])
                        continue;
                    visit[num] = true;

                    if (num == end)
                    {
                        String answer = com.ToString();
                        for (int i = 0; i < answer.Length; i++)
                            Console.Write(c[answer[i] - '0']);
                        Console.WriteLine();
                        break;
                    }

                    int temp;
                    for (int i = 1; i <= 4; i++)
                    {
                        temp = cal(num, i);
                        if (visit[temp])
                            continue;

                        switch (i)
                        {
                            case 1: command.Enqueue(com * 10 + 1); break;
                            case 2: command.Enqueue(com * 10 + 2); break;
                            case 3: command.Enqueue(com * 10 + 3); break;
                            case 4: command.Enqueue(com * 10 + 4); break;
                        }
                        number.Enqueue(temp);
                    }
                }
            }
        }

        static int cal(int number, int op)
        {
            switch (op)
            {
                case 1:
                    number = number * 2 % 10000;
                    break;
                case 2:
                    number -= 1;
                    if (number == -1)
                        number = 9999;
                    break;
                case 3:
                    int n = number / 1000;
                    number = number * 10 % 10000;
                    number += n;
                    break;
                case 4:
                    int n2 = number % 10;
                    number /= 10;
                    number += n2 * 1000;
                    break;
            }

            return number;
        }
    }
}
