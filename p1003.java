import java.util.Scanner;

public class p1003 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		fi dp[] = new fi[41];
		dp[0] = new fi(1, 0);
		dp[1] = new fi(0, 1);
		for(int i = 2; i <= 40; i++) {
			dp[i] = new fi(dp[i-1].ze + dp[i-2].ze,	dp[i-1].one + dp[i-2].one);
		}
		
		for(int i = 0; i < t; i++) { 
			int n = in.nextInt(); 
			System.out.println(dp[n].ze +" "+dp[n].one);
		}
	}

}


class fi{
	int ze; int one;
	fi(int ze, int one){
		this.ze = ze;
		this.one = one;
	}
}