import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p3053 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int r = Integer.parseInt(br.readLine());
		System.out.printf("%.6f\n",r*r*Math.PI);
		System.out.printf("%.6f\n",(double)2*r*r);
	}

}
