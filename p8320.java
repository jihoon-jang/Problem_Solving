import java.util.Scanner;

public class p8320 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int answer = 0;
		
		for(int i = 1; i <= n; i++) {
			for(int j = i; j <= n; j++) {
				if(i*j <= n)
					answer++;
			}
		}
		System.out.println(answer);

	}

}
