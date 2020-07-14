import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p9019 {

	public static void main(String[] args)
	{
		char[] c = {' ','D', 'S', 'L', 'R'};
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		String[] s;
		int start;
		int end;
		Queue<Integer> number;
		Queue<Long> command;
		boolean[] visit;

		for (int tc = 0; tc < t; tc++)
		{
			s = in.nextLine().split(" ");
			start = Integer.parseInt(s[0]);
			end = Integer.parseInt(s[1]);
			number = new LinkedList<Integer>();
			command = new LinkedList<Long>();
			visit = new boolean[10000];
			number.add(start);
			command.add(0L);

			int num;
			long com;
			while (number.size() != 0)
			{
				num = number.poll();
				com = command.poll();
				if (visit[num])
					continue;
				visit[num] = true;

				if (num == end)
				{
					String answer = String.valueOf(com);
					for (int i = 0; i < answer.length(); i++)
						System.out.print(c[answer.charAt(i)-'0']);
					System.out.println();
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
					case 1: command.add(com * 10 + 1); break;
					case 2: command.add(com * 10 + 2); break;
					case 3: command.add(com * 10 + 3); break;
					case 4: command.add(com * 10 + 4); break;
					}
					number.add(temp);
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
