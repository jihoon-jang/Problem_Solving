import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p5525 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int answer = 0;
		
		int cnt = 0;
		for(int i = 1; i <= n-2; i++) {
			if(s.charAt(i-1) == 'I' && s.charAt(i) == 'O' && s.charAt(i+1) == 'I') {
				cnt++;
				i++;
			}
			else
				cnt = 0;
			
			if(cnt == len) {
				answer ++;
				cnt --;
			}
		}
		
		System.out.println(answer);
		
	}

}
