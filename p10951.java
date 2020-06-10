import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class p10951 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s = br.readLine()) != null) {
			int a = s.charAt(0)-'0';
			int b = s.charAt(2)-'0';
			System.out.println(a+b);
		}
	}

}
