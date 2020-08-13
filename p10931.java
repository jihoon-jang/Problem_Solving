import java.io.*;
import java.security.MessageDigest;

public class p10931 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		MessageDigest md = MessageDigest.getInstance("SHA-384");
		md.update(s.getBytes());
		
		byte data[] = md.digest();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < data.length; i++)
			sb.append(Integer.toString((data[i] & 0xff) + 0x100, 16).substring(1));
		
		System.out.println(sb.toString());
	}

}
