import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == (s.charAt(s.length() - i - 1))) {
				result++;
			} 
		} if(result == s.length())
			System.out.println(1);
		else
			System.out.println(0);
	}
}