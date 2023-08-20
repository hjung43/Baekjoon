import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] month = {0,31,59,90,120,151,181,212,243,273,304,334,365};
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int m1 = sc.nextInt();
			int d1 = sc.nextInt();
			int m2 = sc.nextInt();
			int d2 = sc.nextInt();
			int result = month[m2-1] - month[m1-1] + d2 - d1 +1;
			System.out.printf("#%d %d\n",t, result);
		}
	}
}