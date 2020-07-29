import java.io.*;
import java.util.*;

public class p2573 {
	static int n, m, map[][], answer;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer stz = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(stz.nextToken());
	    m = Integer.parseInt(stz.nextToken());
	    map = new int[n][m];
	    answer = 0;

	    for(int i = 0; i < n; i++) {
	        stz = new StringTokenizer(br.readLine());
	        for(int j = 0; j < m; j++) 
	            map[i][j] = Integer.parseInt(stz.nextToken());
	    }

	    for(int i = 1; ; i++) {
	    	if(finish())
	    		break;
	        iceberg();  
	        if(split()) {
	            answer = i;
	            break;
	        }
	    }

	    System.out.println(answer);
	}
	
	public static boolean finish() {
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				if(map[i][j] != 0)
					return false;
		return true;
	}

	public static boolean split() {
	    boolean visit[][] = new boolean[n][m];
	    int count = 0;

	    for(int i = 0; i < n; i++) {
	        for(int j = 0; j < m; j++) {
	            if(map[i][j] != 0 && !visit[i][j]) {
	                visit[i][j] = true;
	                island(visit, i, j);
	                count ++;
	            }
	        }
	    }

	    if(count >= 2)
	        return true;
	    else 
	        return false;
	}

	public static void island(boolean visit[][], int x, int y) {
	    for(int i = 0; i < 4; i++) {
	        int nx = x + dx[i];
	        int ny = y + dy[i];

	        if(check(nx, ny) && map[nx][ny] != 0 && !visit[nx][ny]) {
	            visit[nx][ny] = true;
	            island(visit, nx, ny);
	        }
	    }
	}

	public static void iceberg() {
	    int temp[][] = new int[n][m];

	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < m; j++)
	            temp[i][j] = map[i][j];

	    for(int i = 0; i < n; i++) {
	        for(int j = 0; j < m; j++) {
	            if(map[i][j] != 0) {
	                temp[i][j] -= melt(i,j);
	                if(temp[i][j] < 0)
	                    temp[i][j] = 0;
	            }
	        }
	    }

	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < m; j++)
	            map[i][j] = temp[i][j];
	}

	public static int melt(int x, int y) {
	    int count = 0;
	    for(int i = 0; i < 4; i++) {
	        int nx = x + dx[i];
	        int ny = y + dy[i];

	        if(check(nx,ny) && map[nx][ny] == 0)
	            count ++;
	    }

	    return count;
	}

	public static boolean check(int x, int y) {
	    return x >= 0 && y >= 0 && y < m && x < n;
	}
}
