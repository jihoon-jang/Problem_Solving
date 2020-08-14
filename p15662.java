import java.util.*;
import java.io.*;

public class p15662 {
	static int t;
	static LinkedList al[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		al = new LinkedList[t+1];
		String s;

		for(int i = 1; i <= t; i++) {
			s = br.readLine();
			al[i] = new LinkedList<Integer>();
			for(int j = 0; j < s.length(); j++)
				al[i].add(s.charAt(j)-'0');
		}

		int k = Integer.parseInt(br.readLine());
		StringTokenizer stz;
		for(int i = 0; i < k; i++) {
			stz = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(stz.nextToken());
			int dir = Integer.parseInt(stz.nextToken());

			rotate(number, dir, 2);
		}

		System.out.println(count());
	}

	public static void rotate(int number, int clock, int right) {
		if(clock == 1)
			clock = -1;
		else
			clock = 1;

		if(right == 1 || right == 2)
			if(diff(number, true)) {
				rotate(number+1, clock, 1);
			}
		if(right == 0 || right == 2)
			if(diff(number, false))
				rotate(number-1, clock, 0);

		if(clock == 1)
			clock = -1;
		else
			clock = 1;
		if(clock == 1)
			al[number].addFirst(al[number].removeLast());
		else
			al[number].addLast(al[number].removeFirst());

	}

	public static boolean diff(int number, boolean right) {
		if(right) {
			if(number == t)
				return false;

			if(al[number].get(2) == al[number+1].get(6))
				return false;
		}
		else {
			if(number == 1)
				return false;

			if(al[number].get(6) == al[number-1].get(2))
				return false;
		}

		return true;
	}

	public static int count() {
		int count = 0;

		for(int i = 1; i <= t; i++) {
			if((int)al[i].get(0) == 1)
				count++;
		}

		return count;
	}

}
