import java.util.Scanner;

public class p1436 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		//숫자에 666이 들어가야 하므로 666부터 시작
		for(int i = 666; ; i++) {
			//정수 i를 String으로 변환해서 666이 있는지 확인하고 있다면 n을 감소
			if(String.valueOf(i).contains("666"))
				n--;
			//감소한 n이 0이 된다면 그 값을 출력한다.
			if(n == 0) {
				System.out.println(i);
				return;
			}
		}

	}

}
