import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class p10757 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		BigDecimal n1 = new BigDecimal(s[0]);
		BigDecimal n2 = new BigDecimal(s[1]);
		
		System.out.println(n1.add(n2));
	}

}
