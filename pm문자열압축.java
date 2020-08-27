
public class pm문자열압축 {

	public static void main(String[] args) {
		System.out.println(solution("xababcdcdababcdcd"));

	}

	public static int solution(String s) {
		int min = s.length();
		
		for(int i = 1; i <= s.length()/2; i++) {
			StringBuilder sb = new StringBuilder();
			String temp = "";
			int count = 1;
			
			for(int j = 0; j < Math.ceil((double)s.length()/i); j++) {
				String now = s.substring(j*i, i*(j+1) >= s.length() ? s.length() : i*(j+1));
				if(!temp.equals(now)) {
					if(count != 1) {
						sb.append(count);
						count = 1;
					}
					sb.append(temp);
					temp = now;
				}
				else
					count++;
			}
			if(count != 1)
				sb.append(count);
			sb.append(temp);
			
			min = Math.min(min, sb.toString().length());
		}
		
		return min;
	}
}