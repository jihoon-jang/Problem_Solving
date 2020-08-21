
public class pmn진수게임 {

	public static void main(String[] args) {
		System.out.println(solution(16,16,2,2));
	}
	
	public static String solution(int n, int t, int m, int p) {
		StringBuilder sb = new StringBuilder();
		sb.append(0);
		int index = 1;
		while(sb.toString().length() < t*m) 
			sb.append(convert(index++, n));

		StringBuilder answer = new StringBuilder();
		while(answer.length() < t) {
			answer.append(sb.toString().charAt(answer.length()*m+p-1));
		}
		return answer.toString();
	}
	
	public static String convert(int number, int n) {
		StringBuilder sb = new StringBuilder();
		
		while(number != 0) {
			if(n > 10 && number % n >= 10)
				sb.append((char)(number % n + 'A'-10));
			else
				sb.append(number % n);
			number /= n;
		}
		
		return sb.reverse().toString();
	}
}