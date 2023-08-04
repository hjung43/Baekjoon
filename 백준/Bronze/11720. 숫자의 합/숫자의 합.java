import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		int sum = 0;
		char[] c = s.toCharArray();
		
		for(int i=0; i<n; i++) {
			sum += c[i]-'0';
		}
		System.out.println(sum);
	}
}