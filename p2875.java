import java.util.Scanner;

public class p2875 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);	

		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		
		int temp = Math.abs(m*2 >= n ? n/2-m : n-2*m);
		int answer = m > n/2 ? n/2*3 : m*3;
		k -= temp;
		
		if(k > 0) 
			answer -= k;
		
		System.out.println(answer/3);
	}

}
