import java.util.Scanner;

public class p1138 {
	static int n, p[];
	static boolean visit[];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		p = new int[n+1];
		visit = new boolean[n+1];
		for(int i = 1; i <= n; i++)
			p[i] = in.nextInt();

		line(0, "");
	}

	public static void line(int length, String s) {
		if(length == n) {
			String s1[] = s.split(" ");
			char c[] = new char[s1.length];
			for(int i = 0; i < s1.length; i++)
				c[i] = s1[i].charAt(0);
			int diff[] = new int[n+1];
			
			for(int j = c.length-1; j >= 1; j--) {
				for(int k = j-1; k >= 0; k--) {
					if(c[j] < c[k])
						diff[j+1]++;
				}
			}
			for(int i = 1; i <= n; i++)
				System.out.print(diff[i]+" ");

			return;
		}
		else
			for(int i = 1; i <= n; i++) {
				if(!visit[i]) {
					visit[i] = true;
					line(length+1, s + i + " ");
					visit[i] = false;
				}

			}
	}

}
