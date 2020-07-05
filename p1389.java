import java.util.*;

public class p1389 {
	static Queue<Integer> q;
	static int array[], map[][], n, m, min, index;
	static boolean visit[];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt(); 
		m = in.nextInt();
		map = new int[n+1][n+1];

		for(int i = 0; i < m; i++) {
			int x = in.nextInt();
			int y = in.nextInt();

			map[x][y] = 1;
			map[y][x] = 1;
		}

		min = Integer.MAX_VALUE;
		index = 0;
		for(int i = 1; i <= n; i++) {
			q = new LinkedList<>();
			array = new int[n+1];
			Arrays.fill(array, 5000);
			array[i] = 0;
			q.add(i);
			visit = new boolean[n+1];
			find();
			int sum = 0;

			for(int j = 1; j <= n; j++)
				sum += array[j];

			if(min > sum) {
				min = sum;
				index = i;
			}
		}

		System.out.println(index);

	}

	public static void find() {

		while(!q.isEmpty()) {
			int line = q.poll();

			if(!visit[line])
				for(int i = 1; i <= n; i++) {
					if(map[line][i] == 1) {
						q.add(i);
						array[i] = Math.min(array[i], array[line]+1);
					}
				}
			visit[line] = true;	
		}
	}	

}
