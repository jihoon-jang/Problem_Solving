import java.util.Scanner;

public class p15829 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len = in.nextInt();in.nextLine();
		String s = in.nextLine();
		long hash = 0;

		for(int i = 0; i < len; i++) {
			long n = (long)(s.charAt(i)-'a'+1);
			n *= po(i);
			hash += n;
			hash %= 1234567891;
		}
		
		System.out.println((int)hash);
	}
	
	public static long po(int n) {
		long num = 1;
		for(int i = 1; i <= n; i++) {
			num *= 31;
			num %= 1234567891;
		}
		
		return num; 
	}

}
