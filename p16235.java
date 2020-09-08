import java.util.*;
import java.io.*;

public class p16235 {

	public static int n, k;
	public static Tree map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stz.nextToken());
		int m = Integer.parseInt(stz.nextToken());
		k = Integer.parseInt(stz.nextToken());
		map = new Tree[n][n];
		int a[][] = new int[n][n]; 
		int answer = 0;

		for(int i = 0; i < n; i++) {
			stz = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(stz.nextToken());
				map[i][j] = new Tree(5);
			}
		}

		for(int i = 0; i < m; i++) {
			stz = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(stz.nextToken())-1;
			int y = Integer.parseInt(stz.nextToken())-1;
			int z = Integer.parseInt(stz.nextToken());
			map[x][y].plant(z);
		}

		for(int l = 0; l < k; l++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					map[i][j].sort();
					map[i][j].spSummer(); 
					map[i][j].nut += a[i][j];
				System.out.print(map[i][j].al.size()+" ");
				}
				System.out.println();
			}
				System.out.println();
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j].fall()) 
						sex(i, j);
				}
			}
		}

			System.out.println();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				answer += map[i][j].al.size();
				System.out.print(map[i][j].al.size()+" ");
			}
			System.out.println();
			}

		System.out.println(answer);
	}

	public static void sex(int x, int y) {
		for(int i = -1; i <= 1; i++) {
			for(int j = -1; j <= 1; j++) {
				int nx = x + i;
				int ny = y + j;
				if(nx == x && ny == y)
					continue;

				if(nx >= 0 && nx < n && ny < n && ny >= 0) {
					map[nx][ny].al.add(0, 1);
				}
			}
		}
	}

	static class Tree {
		int nut = 0;
		List<Integer> al = new ArrayList<Integer>();

		Tree(int n) {
			nut = n;
		}

		void plant(int z) {
			al.add(z);
		}

		void sort() {
			Collections.sort(al);
		}

		void spSummer() {
			int count = 0;
			int index = -1;

			for(int i = 0; i < al.size(); i++) {
				int now = al.get(i);
				if(nut >= now) {
					nut -= now;
					al.set(i, now+1);
				}
				else {
					if(index == -1)
						index = i;
					count += al.get(i)/2;
				}
			}

			if(index != -1) {
				al = al.subList(0, index);
			}
			nut += count/2;
		}

		boolean fall() {
			for(int i = 0; i < al.size(); i++)
				if(al.get(i) % 5 == 0)
					return true;

			return false;
		}

	}

}
