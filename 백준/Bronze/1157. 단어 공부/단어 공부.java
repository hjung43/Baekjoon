import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int[]alphabet = new int[27];
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c<=90) {
				alphabet[c-'A']++;
			}else {
				alphabet[c-'a']++;
			}
			
		}
		int max = -1;
		char result = 0;
		for(int i=0; i<27; i++) {
			if(max<alphabet[i]) {
				max = alphabet[i];
				result = (char)(i+'A');
			}else if(max==alphabet[i]) {
				result = '?';
			}
		}
		System.out.println(result);
		
	}
}