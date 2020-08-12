import java.io.*;

public class p1248 {
	static int n, array[];
	static char map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		array = new int[n];
		map = new char[n][n];

		int sIndex = 0;
		for(int i = 0; i < n; i++) 
			for(int j = i; j < n; j++) 
				map[i][j] = s.charAt(sIndex++);

		solve(0);
	}

	public static void solve(int index) {
		if(index == n) {
			for(int i : array)
				System.out.print(i+" ");
			System.exit(0);
		}

		for(int i = -10; i <= 10; i++) {
			array[index] = i;
			if(check(index))
				solve(index+1);
		}

	}

	public static boolean check(int index) {
		int sum;

		for(int i = 0; i <= index; i++) {
			sum = 0;
			for(int j = 0; j+i <= index; j++) {
				sum += array[j+i];
				if(sum < 0 && map[i][j+i] != '-') 
						return false;
				else if(sum == 0 && map[i][j+i] != '0') 
						return false;
				else if(sum > 0 && map[i][j+i] != '+')
						return false;
			}
		}

		return true;
	}

}
