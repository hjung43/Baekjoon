import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int[][] dots = new int[2][2];
			for (int i = 0; i < 2; i++) {
				int dot = sc.nextInt();
				int x = 1;
				int y = 1;
				int num = 1;
				int j = 1;
				while (num < dot) {
					if (y - 1 > 0) {
						y--;
						x++;
						num++;
					} else {
						y = ++j;
						x = 1;
						num++;
					}
				}
				dots[i][0] = x;
				dots[i][1] = y;
			}
			int nX = dots[0][0] + dots[1][0];
			int nY = dots[0][1] + dots[1][1];
			int i = 0;
			int j = 0;
			int r = 1;
			while(i<nY) {
				r += i;
				i++;
			}
			while(j<nX-1) {
				r += i+1+j;
				j++;
			}
			System.out.println("#"+t+" "+r);
		}
	}
}