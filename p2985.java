import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2985 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(stz.nextToken());
        int b = Integer.parseInt(stz.nextToken());
        int c = Integer.parseInt(stz.nextToken());
        
        if(a + b == c) {
            System.out.printf("%d+%d=%d",a,b,c);
        }
        else if(a - b == c) {
            System.out.printf("%d-%d=%d",a,b,c);
        }
        else if(a * b == c) {
                System.out.printf("%d*%d=%d",a,b,c);
            }
            else if(a / b == c) {
                    System.out.printf("%d/%d=%d",a,b,c);
                }
                else if(c + b == a) {
                        System.out.printf("%d=%d+%d",a,b,c);
                    }
                    else if(b-c == a) {
                            System.out.printf("%d=%d-%d",a,b,c);
                        }
                        else if(b*c == a) {
                                System.out.printf("%d=%d*%d",a,b,c);
                            }
                            else if(b/c == a) {
                                    System.out.printf("%d=%d/%d",a,b,c);
                                }
    }
}
