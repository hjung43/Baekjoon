import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Solution {
	static int[]p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			System.out.print("#"+t+" ");
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][]edges = new int[m][3];
			p = new int[n+1];
			for(int i=0; i<n; i++) {
				p[i]=i;
			}
			
			for(int i =0; i<m; i++) {
				int c = sc.nextInt();
				if(c==0) {
					union(sc.nextInt(),sc.nextInt());
				}else {
					int a = sc.nextInt();
					int b = sc.nextInt();
					if(findset(a)==findset(b)) {
						System.out.print(1);
					}else
						System.out.print(0);
				}
			}
		System.out.println();
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
