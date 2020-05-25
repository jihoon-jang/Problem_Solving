import java.util.Scanner;

public class p11047 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
			int n = in.nextInt(); int k = in.nextInt();
			int coin[] = new int[n];
			int answer = 0;
			for(int i = 0; i < n; i++)
				coin[i] = in.nextInt();
			int index = n-1;
			while(k != 0) { 
				if(k >= coin[index]) { 
					answer += k/coin[index];
					k %= coin[index];
				}
				else {
					index --;
				}
			}
			System.out.println(answer);
			
	}

}
