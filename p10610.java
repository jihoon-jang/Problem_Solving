import java.util.Scanner;

public class p10610 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		boolean zero = false;
		int sum = 0;
		int number[] = new int[10];
		for(int i = 0; i < s.length(); i++) {
			int n = s.charAt(i) - '0';
			if(n == 0)
				zero = true;
			sum += n;
			number[n]++;
		}
		
		if(!zero || sum % 3 != 0)
			System.out.println(-1);
		else if(zero && sum % 3 == 0) {
			for(int i = 9; i >= 0; i--) {
				for(int j = 0; j < number[i]; j++) 
					System.out.print(i);
			}			
		}
	}

}
