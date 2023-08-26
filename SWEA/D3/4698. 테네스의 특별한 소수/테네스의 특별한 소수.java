import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int d = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			boolean[]isPrimeNum = new boolean[b+1];
			Arrays.fill(isPrimeNum, true);
			
			isPrimeNum[0] = isPrimeNum[1] = false;
 			
			for(int i = 2; i*i<=b; i++) {
				if(isPrimeNum[i]==true) {
					for(int j=i*i; j<=b; j += i) {
						isPrimeNum[j] = false;
					}
				}
			}
			int result=0;
			for(int i = a; i<=b; i++) {
				if(isPrimeNum[i]) {
					String str = i+"";
					for(int j =0; j<str.length(); j++) {
						if(str.charAt(j) == (char)(d+'0')) {
							result++;
							break;
						}
					}
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}
}