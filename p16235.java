import java.util.*;
import java.io.*;

public class p16235 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stz.nextToken());
		int m = Integer.parseInt(stz.nextToken());
		int k = Integer.parseInt(stz.nextToken());
		int map[][] = new int[n][n];
		int a[][] = new int[n][n]; 

		for(int i = 0; i < n; i++) {
			stz = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(stz.nextToken());
				map[i][j] = 5;
			}
		}

		LinkedList<Tree> list = new LinkedList<>();

		for(int i = 0; i < m; i++) {
			stz = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(stz.nextToken())-1;
			int y = Integer.parseInt(stz.nextToken())-1;
			int z = Integer.parseInt(stz.nextToken());
			list.add(new Tree(x, y, z, true));
		}

		for(int l = 0; l < k; l++) {
			for(Tree now : list) {
				if(map[now.x][now.y] >= now.age) {
					map[now.x][now.y] -= now.age;
					now.age++;
				}
				else
					now.alive = false;
			}

			for(Iterator<Tree> it = list.iterator(); it.hasNext(); ) {
				Tree now = it.next();
				if(!now.alive) {
					map[now.x][now.y] += now.age/2;
					it.remove();
				}
			}

			LinkedList<Tree> newList = new LinkedList<>();
			for(Iterator<Tree> it = list.iterator(); it.hasNext();) {
				Tree now = it.next();
				if(now.age % 5 == 0) {
					for(int i = -1; i <= 1; i++) {
						for(int j = -1; j <= 1; j++) {
							int nx = now.x + i;
							int ny = now.y + j;
							if(nx == now.x && ny == now.y)
								continue;

							if(nx >= 0 && ny >= 0 && nx < n && ny < n)
								newList.add(new Tree(nx, ny, 1, true));
						}
					}
				}
			}

			list.addAll(0, newList);

			for(int i = 0; i < n; i++) 
				for(int j = 0; j < n; j++)
					map[i][j] += a[i][j];
		}
		
		System.out.println(list.size());
	}

	static class Tree {
		int x, y, age;
		boolean alive;

		Tree(int x, int y, int age, boolean alive) {
			this.x = x;
			this.y = y;
			this.age = age;
			this.alive = alive;
		}

	}

}
