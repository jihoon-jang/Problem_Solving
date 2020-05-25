import java.util.Scanner;

public class p10984 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		for(int t = 1; t <= tc; t++) {
			int lecture = in.nextInt();
			int sum = 0;
			double score = 0;
			
			for(int i = 0; i < lecture; i++) {
				int temp1 = in.nextInt();
				double temp2 = in.nextDouble();
				sum += temp1;
				score += temp1*temp2;
			}
			System.out.println(sum+" "+Math.round(score*10/sum)/10.0);
		}
	}
}
