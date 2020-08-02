import java.util.Scanner;

public class p1722 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int w = in.nextInt();
		long f[] = new long[n+1];
		boolean visit[] = new boolean[n+1];

		f[0] = 1;
		for(int i = 1; i <= n; i++)
			f[i] = f[i-1] * i;

		int a[] = new int[n];
		if(w == 1) {
			long k = in.nextLong();
			for(int i = 0; i < n; i++) {
				for(int j = 1; j <= n; j++) {
					if(visit[j])
						continue;

					if(k > f[n-i-1])
						k -= f[n-i-1];
					else { 
						a[i] = j;
						visit[j] = true;
						break;
					}
				}
			}
			for(int i : a)
				System.out.print(i+" ");
		}
		else {
			for(int i = 0; i < n; i++)
				a[i] = in.nextInt();

			long ans = 1;
			for(int i = 0; i < n; i++) {
				for(int j = 1; j < a[i]; j++) {
					if(!visit[j])
						ans += f[n-i-1];
				}
				visit[a[i]] = true;
			}
			System.out.println(ans);
		}
	}

}
