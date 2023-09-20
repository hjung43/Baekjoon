import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Solution {
	static int[]p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int result = 0;
			int n = sc.nextInt();
			int m = sc.nextInt();
			p = new int[n+1];
			for(int i=0; i<n+1; i++) {
				p[i]=i;
			}
			
			for(int i =0; i<m; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				union(a,b);
			}
			int[]count = new int[n+2];
			for(int i=1; i<n+1; i++) {
				count[findset(p[i])]++;
			}
			for(int i=1; i<n+2; i++) {
				if(count[i] != 0) {
					result++;
					
				}
			}
			System.out.printf("#%d %d\n",t,result);
		}
	}
	
	static int findset(int x) {
		if(x!=p[x])
			p[x] = findset(p[x]);
		return p[x];
	}
	static  void union(int x, int y) {
		p[findset(y)] = findset(x);
	}
}
