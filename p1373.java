import java.io.*;

public class p1373 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();

		int index = s.length() % 3;
		if(index != 0)
			sb.append(Integer.toOctalString(Integer.parseInt(s.substring(0, index), 2)));

		for(int i = 0; (i)*3+index < s.length(); i++) {
			sb.append(Integer.toOctalString(Integer.parseInt(s.substring(i*3+index, (i+1)*3+index), 2)));
		}

		System.out.println(sb.toString());
	}

}
