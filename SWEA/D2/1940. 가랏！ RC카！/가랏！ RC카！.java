import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int m = 0;
			int f = 0;
			int n = sc.nextInt();
			for(int i=0; i<n; i++) {
				int c = sc.nextInt();
				if(c==1) {
					f += sc.nextInt();
				}else if(c==2) {
					int nf = sc.nextInt();
					if(f-nf>=0) {
						f -=nf;
					}else {
						f = 0;
					}
				}
				m += f;
			}
			System.out.printf("#%d %d\n",t,m);
		}
	}
}