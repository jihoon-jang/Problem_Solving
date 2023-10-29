import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class p22233 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] splittedSize = br.readLine().split(" ");
		int n = Integer.parseInt(splittedSize[0]);
		int m = Integer.parseInt(splittedSize[1]);

		Set<String> keywords = new HashSet<>(n);
		while (n-- > 0) {
			keywords.add(br.readLine());
		}

		StringBuilder sb = new StringBuilder();
		while (m-- > 0) {
			String memo = br.readLine();
			String[] memoKeywords = memo.split(",");
			for (String memoKeyword : memoKeywords) {
				keywords.remove(memoKeyword);
			}
			sb.append(keywords.size() + "\n");
		}

		System.out.println(sb);
	}
}
