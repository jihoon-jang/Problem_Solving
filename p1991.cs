using System;
using System.Collections.Generic;
using System.Text;

namespace _0721
{
    class p1991
    {
        static List<char>[] list;
        static int n;
        static void Main()
        {
            n = int.Parse(Console.ReadLine());
            list = new List<char>[n];
            for (int i = 0; i < n; i++)
                list[i] = new List<char>();

            for (int i = 0; i < n; i++)
            {
                String[] s = Console.ReadLine().Split(' ');
                char v = char.Parse(s[0]);
                char l = char.Parse(s[1]);
                char r = char.Parse(s[2]);

                list[v - 'A'].Add(l);
                list[v - 'A'].Add(r);
            }
            preorder('A');
            Console.WriteLine();
            inorder('A');
            Console.WriteLine();
            postorder('A');
            Console.WriteLine();
        }

        static void preorder(char c)
        {
            Console.Write(c);
            if (list[c - 'A'][0] != '.')
                preorder(list[c - 'A'][0]);

            if (list[c - 'A'][1] != '.')
                preorder(list[c - 'A'][1]);
        }
        static void inorder(char c)
        {
            if (list[c - 'A'][0] != '.')
                inorder(list[c - 'A'][0]);
            Console.Write(c);

            if (list[c - 'A'][1] != '.')
                inorder(list[c - 'A'][1]);
        }
        static void postorder(char c)
        {
            if (list[c - 'A'][0] != '.')
                postorder(list[c - 'A'][0]);

            if (list[c - 'A'][1] != '.')
                postorder(list[c - 'A'][1]);
            Console.Write(c);
        }
    }
}
