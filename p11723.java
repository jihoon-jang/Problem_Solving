import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class p11723 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		boolean a[] = new boolean[21];
		
		for(int i = 0; i < n; i++) {
			String s[] = br.readLine().split(" ");
			
			switch(s[0]) {
			case "add" : int num = Integer.parseInt(s[1]); a[num] = true; break;
			case "remove" : num = Integer.parseInt(s[1]); a[num] = false; break;
			case "check" : num = Integer.parseInt(s[1]); bw.write(a[num] ? "1\n" : "0\n"); break;
			case "toggle" : num = Integer.parseInt(s[1]); if(a[num]) a[num] = false; else a[num] = true; break;
			case "all" : Arrays.fill(a, true); break;
			case "empty" : Arrays.fill(a, false); break;
			}
		}
		bw.flush();
	}

}
