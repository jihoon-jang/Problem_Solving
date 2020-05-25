import java.util.ArrayList;
import java.util.Scanner;

public class p14891 {
	static ArrayList<Integer> al[];
	static boolean visit[];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		al = new ArrayList[4];
		for(int i = 0; i < 4; i++) {
			al[i] = new ArrayList<Integer>();
			String s = in.nextLine();
			for(int j = 0; j < s.length(); j++) 
				al[i].add((int)s.charAt(j)-'0');
		}
		int count = in.nextInt();
		int turn[][] = new int[2][count];
		for(int i = 0; i < count; i++) {
			turn[0][i] = in.nextInt();
			turn[1][i] = in.nextInt();
		}
		for(int i = 0; i < count; i++) {
			visit = new boolean[4];
			rot(turn[0][i]-1, turn[1][i]);
		}

		System.out.println((al[0].get(0) == 1 ? 1 : 0)+(al[1].get(0) == 1 ? 2 : 0)+
				(al[2].get(0) == 1 ? 4 : 0)+(al[3].get(0) == 1 ? 8 : 0));
	}

	public static void rot(int number, int dir) {
		if(!visit[number]) {
			visit[number] = true;
			if(number != 3) {
				if(al[number].get(2) != al[number+1].get(6)) {
					rot(number+1, dir*-1);
				}
			}

			if(number != 0)
				if(al[number].get(6) != al[number-1].get(2)) {
					rot(number-1, dir*-1);
				}
			if(dir == 1) {
				int temp = al[number].get(7);
				al[number].remove(7);
				al[number].add(0, temp);
			}
			else {
				int temp = al[number].get(0);
				al[number].remove(0);
				al[number].add(temp);
			}


			
		}
	}
}
