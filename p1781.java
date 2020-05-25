import java.util.Scanner;

public class p1781 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int num[] = new int[n];
		int answer = 0;
		for(int i = 0; i < n; i++) {
			int pro = in.nextInt();
			int score = in.nextInt();
			if(num[pro] < score) {
				answer -= num[pro];
				answer += score;
				num[pro] = score;
			}
		}
		System.out.println(answer);
	}

}
