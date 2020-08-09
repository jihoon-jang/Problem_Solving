import java.io.*;

public class p10974 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean visit[] = new boolean[n+1];
		
		dfs(0, n, "", visit);
	}
	
	public static void dfs(int length, int n, String s, boolean visit[]) { 
		if(length == n) {
			System.out.println(s);
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(length+1, n, s+i+" ", visit);
				visit[i] = false;
			}
		}
	}

}
