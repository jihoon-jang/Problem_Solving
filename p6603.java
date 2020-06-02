import java.util.Scanner;

public class p6603 {
	static int n, array[];
	static boolean visit[];
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(true) {
			n = in.nextInt();
			if(n == 0)
				break;
			array = new int[n];
			visit = new boolean[n];
			for(int i = 0; i < n; i++) 
				array[i] = in.nextInt();
			f(0,0,"");
			System.out.println();
		}

	}
	
	public static void f(int cnt, int start, String s) {
		if(cnt == 6) {
			System.out.println(s);
			return;
		}
		else {
			for(int i = start; i < n; i++) {
				if(!visit[i]) {
					visit[i] = true;
					f(cnt + 1, i, s+array[i]+" ");
					visit[i] = false;
				}
			}
		}
		
	}

}
