import java.util.Scanner;

public class p15649 {
	static boolean visit[]; //값은 한 번만 사용해야 하므로 방문 숫자 체크
	static int n, m;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		visit = new boolean[n+1];
		dfs(0,"");
	}

	//len은 수열의 길이를 체크
	public static void dfs(int len, String s) {
		if(len == m) {
			System.out.println(s);  
			return;
		}
		else {
			for(int i = 1; i <= n; i++) {
				//1부터 방문하지 않은 수를 찾아 들어감.
				if(visit[i] == false) {
					visit[i] = true;
					dfs(len+1, s + i+ " ");
					//재귀를 통해 반복. 
					//재귀가 끝났다면 잡았던 수를 놓아서 다음 수열에서도 이용할 수 있게 방문값을 거짓으로 돌려놓음.
					//이해가 안되면 손으로 그려보세요.
					visit[i] = false;
				}
			}
		}
	}
}
