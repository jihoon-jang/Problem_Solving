
public class pm비밀지도 {

	public static void main(String[] args) {
		int arr1[] = {9,20,28,18,11};
		int arr2[] = {30,1,21,17,28};


		String s[] = solution(5, arr1, arr2) ;
		for(String a : s)
			System.out.println(a);
	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		int map1[][] = new int[n][n];
		int map2[][] = new int[n][n];
		makeMap(n, arr1, arr2, map1, map2);

		String[] answer = print(n, map1, map2);
		return answer;
	}

	public static void makeMap(int n, int[] arr1, int[] arr2, int map1[][], int map2[][]) {
		for(int i = 0; i < n; i++) {
			int value1 = arr1[i];
			int value2 = arr2[i];
			for(int j = n-1; j >= 0; j--) {
				if(value1 % 2 == 1) 
					map1[i][j] = 1;
				value1 /= 2;
				
				if(value2 % 2 == 1) 
					map2[i][j] = 1;
				value2 /= 2;
				
			}
		}
	}
	
	public static String[] print(int n, int map1[][], int map2[][]) {
		String answer[] = new String[n];
		
		for(int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < n; j++) {
				int value = map1[i][j] | map2[i][j];
				sb.append(value == 1 ? "#" : " ");
			}
			answer[i] = sb.toString();
		}
		
		return answer;
	}
	
}