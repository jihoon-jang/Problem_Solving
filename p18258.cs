using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1
{
    class p18258
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            Queue<int> q = new Queue<int>();
            int current = 0;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++)
            {
                string[] c = Console.ReadLine().Split(' ');
                switch (c[0])
                {
                    case "push":
                        q.Enqueue(int.Parse(c[1]));
                        current = int.Parse(c[1]);
                        break;
                    case "pop":
                        if (q.Count == 0)
                            sb.AppendLine("-1");
                        else
                            sb.AppendLine(q.Dequeue() + "");
                        break;
                    case "size":
                        sb.AppendLine("" + q.Count);
                        break;
                    case "empty":
                        sb.AppendLine(q.Count == 0 ? "" + 1 : "" + 0);
                        break;
                    case "front":
                        if (q.Count == 0)
                            sb.AppendLine("-1");
                        else
                            sb.AppendLine("" + q.Peek());
                        break;
                    case "back":
                        if (q.Count == 0)
                            sb.AppendLine("-1");
                        else
                            sb.AppendLine("" + current);
                        break;
                }
            }

            Console.WriteLine(sb.ToString());
        }
    }
}
