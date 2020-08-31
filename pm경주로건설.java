import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	//U,R,D,L
	public int dx[] = {-1,0,1,0};
	public int dy[] = {0,1,0,-1};
	public int map[][];
	public int value[][][];
	public int n, answer;

	public int solution(int[][] map) {
		n = map.length;
		this.map = map;
		answer = Integer.MAX_VALUE;
		value = new int[4][n][n];
		
		for(int i = 0; i < 4; i++) 
			value[i][0][0] = 1;

		drive();
		
		for(int i = 0; i < 4; i++) 
			answer = Math.min(answer, value[i][n-1][n-1] == 0 ? Integer.MAX_VALUE : value[i][n-1][n-1]);

		return answer;
	}

	public void drive() {
		Queue<Car> q = new LinkedList<Car>();
		q.add(new Car(0, 0, -1, 0));

		while(!q.isEmpty()) {
			Car now = q.poll();
			
			if(now.x == n-1 && now.y == n-1) {
				continue;
			}

			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if(check(nx, ny) && (value[i][nx][ny] == 0 || value[i][nx][ny] > now.cost)) {
					if(now.dir == -1) {
						value[i][nx][ny] = 100;
						q.add(new Car(nx, ny, i, 100));
					}
					else {
						int nextCost = now.getCost(nx, ny);
						if(value[i][nx][ny] == 0 || now.cost + nextCost < value[i][nx][ny]) {
							value[i][nx][ny] = now.cost + nextCost;
							q.add(new Car(nx, ny, i, now.cost + nextCost)); 
						}
					}
				}
			}
		}

	}

	public boolean check(int x, int y) {
		return x >= 0 && y >= 0 && x < n && y < n; 
	}

	class Car {
		int x, y, dir, cost;

		Car(int x, int y, int dir, int cost) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cost = cost;
		}

		int getCost(int x, int y) {
			for(int i = 0; i < 4; i++) {
				int nx = this.x + dx[i];
				int ny = this.y + dy[i];

				if(nx == x && ny == y) {
					if(dir % 2 == 0) {
						if(i % 2 == 0)
							return 100;
						else
							return 600;
					}
					else {
						if(i % 2 == 1)
							return 100;
						else
							return 600;
					}				
				}
			}
			
			return 0;
		}
	}
}