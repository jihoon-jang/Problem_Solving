import java.io.*;
import java.util.*;

public class p2965 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(stz.nextToken());
		int b = Integer.parseInt(stz.nextToken());
		int c = Integer.parseInt(stz.nextToken());
		
		int d1 = b - a;
		int d2 = c - b;
		
		if(d1 >= d2) 
			System.out.println(b-a-1);
		else
			System.out.println(c-b-1);
	}

}
