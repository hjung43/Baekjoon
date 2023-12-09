import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int selection = 0;
		int[]cnt = new int[26];
		for(int i=0; i<n; i++) {
			cnt[br.readLine().charAt(0)-97]++;
		}
		for(int i=0; i<26; i++) {
			if(cnt[i]>=5) {
				System.out.print((char)(i+97));
				selection++;
			}
		}
		if(selection==0) {
			System.out.println("PREDAJA");
		}
	}
}