
public class pmÀÚ¹°¼è¿Í¿­¼è {
	
	public static void main(String[] args) {
		int key[][] = {{0,0,0},{1,0,0},{0,1,1}};
		int lock[][] = {{1,1,1},{1,1,0},{1,0,1}};
		solution(key, lock);
	}

	public static boolean solution(int[][] key, int[][] lock) {
		int n = lock.length;
		int m = key.length;

		int map[][] = new int[n + 2*(m-1)][n + 2*(m-1)];
		int temp[][] = new int[map.length][map.length];

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) 
				map[m-1+i][m-1+j] = lock[i][j];
		}

		for(int i = 0; i <= map.length-m; i++) {
			for(int j = 0; j <= map.length-m; j++) {
				l:	for(int k = 0; k < 4; k++) {
					//key È¸Àü
					key = rotate(key);
					//temp ¼¼Å¹
					temp = setMap(map);

					//ÀÚ¹°¼è¿¡ Å°¸¦ ²ÈÀ½
					for(int x = 0; x < m; x++) {
						for(int y = 0; y < m; y++) {
							if(temp[i+x][j+y] == 1 && key[x][y] == 1)
								continue l;
							else if(temp[i+x][j+y] == 0 && key[x][y] == 1)
								temp[i+x][j+y] = 1;
						}
					}
					//ÀÚ¹°¼è °Ë»ç
					if(check(temp, n, m))
						return true;
				}
			}
		}

		return false;
	}

	public static int[][] rotate(int key[][]) {
		int len = key.length;
		int convert[][] = new int[len][len];

		for(int i = 0; i < len; i++) {
			for(int j = 0; j < len; j++) {
				convert[j][len-i-1] = key[i][j];
			}
		}

		return convert;
	}

	public static int[][] setMap(int map[][]) {
		int len = map.length;
		int convert[][] = new int[len][len];

		for(int i = 0; i < len; i++) 
			convert[i] = map[i].clone();

		return convert;
	}
	
	public static boolean check(int map[][], int n, int m) {
		for(int i = m-1; i < n+m-1; i++) {
			for(int j = m-1; j < n+m-1; j++)
				if(map[i][j] == 0)
					return false;
		}
		
		return true;
	}

}