import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2751 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//        boolean[] a = new boolean[2000001];
		//        int n = Integer.parseInt(br.readLine());
		//
		//        for(int i=0; i<n; i++)
		//            a[Integer.parseInt(br.readLine()+1000000)] = true;
		boolean[] a = new boolean[2000001];
		int n = Integer.parseInt(br.readLine());

		for(int i=0; i<n; i++)
			a[Integer.parseInt(br.readLine()) + 1000000] = true;

		StringBuilder sb = new StringBuilder();

		for(int i=0; i<=2000000; i++)
			if(a[i])
				sb.append((i - 1000000) + "\n");

		System.out.print(sb);

	}
}
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        boolean[] a = new boolean[2000001];
//        int n = Integer.parseInt(br.readLine());
//
//        for(int i=0; i<n; i++)
//            a[Integer.parseInt(br.readLine()) + 1000000] = true;
//
//        StringBuilder sb = new StringBuilder();
//
//        for(int i=0; i<=2000000; i++)
//            if(a[i])
//                sb.append((i - 1000000) + "\n");
//
//        System.out.print(sb);
//
//    }
//}