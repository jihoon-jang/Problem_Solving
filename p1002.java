import java.util.Scanner;

public class p1002 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		
		for(int t = 0; t < tc; t++) {
			int x[] = new int[2];
			int y[] = new int[2];
			int r[] = new int[2];
			
			for(int i = 0; i < 2; i++) {
				x[i] = in.nextInt();
				y[i] = in.nextInt();
				r[i] = in.nextInt();
			}
			
			int rdis = Math.abs(r[0]-r[1]);
			double pdis = Math.sqrt(Math.pow(x[0]-x[1], 2) + Math.pow(y[0]-y[1], 2));
			int rsum = r[0]+r[1];
			if(rsum < pdis || pdis < rdis)
				System.out.println(0);
			else if(pdis == 0 && rdis == 0)
				System.out.println(-1);
			else if(rdis == pdis || rsum == pdis)
				System.out.println(1);
			else
				System.out.println(2);
			
		}

	}

}
