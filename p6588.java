import java.io.*;
import java.util.*;

public class p6588 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(stz.nextToken());
		boolean prime[] = new boolean[1000001];
		prime = prime(prime);

		while(n != 0) {
			search(prime, n);
			stz = new StringTokenizer(br.readLine());
			n = Integer.parseInt(stz.nextToken());
		}
	}

	public static boolean[] prime(boolean prime[]) {
		Arrays.fill(prime, true);
		prime[2] = false;
		prime[1] = false;
		prime[0] = false;

		for(int i = 2; i < prime.length; i++) {
			for(int j = 2; j * i < prime.length; j++)
				prime[j*i] = false;
		}

		return prime;
	}

	public static void search(boolean prime[], int number) {
		for(int i = number - 1; i >= number-i; i--) {
			if(prime[i] && prime[number-i]) {
				System.out.printf("%d = %d + %d\n", number, number - i, i);
				return;
			}
		}
		System.out.println("Goldbach's conjecture is wrong.");
	}

}
