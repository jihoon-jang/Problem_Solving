import java.util.*;
import java.io.*;

public class p9613 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(stz.nextToken());
		int array[];
		
		for(int t = 0; t < tc; t++) {
			stz = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(stz.nextToken());
			array = new int[num];
			
			for(int i = 0; i < num; i++)
				array[i] = Integer.parseInt(stz.nextToken());
			
			long sum = 0;
			
			for(int i = 0; i < num-1; i++) 
				for(int j = i+1; j < num; j++) 
					sum += gcd(array[i],array[j]);
				
			System.out.println(sum);
		}
	}

	public static int gcd(int n1, int n2) {
		if(n2 == 0)
			return n1;
		else
			return gcd(n2, n1%n2);
	}

}
