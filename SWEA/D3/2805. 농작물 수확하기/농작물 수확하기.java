import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt(); //농장 크기 입력받기
			int[][]farm = new int[n][n];
			for(int i=0; i<n; i++) {
				String str = sc.next();
				for(int j=0; j<n; j++) {
					farm[i][j] = Integer.parseInt(str.charAt(j)+"");
				}
				
			}
			int c = n/2;
			int result = 0;
			for(int i=0; i<n; i++) {
				for(int j=c; j<=n-1-c; j++) {
					result += farm[i][j];
				}
				if(i+1<=n/2) {
					c--;
				}else
					c++;
			}
			System.out.println("#"+t+" "+result);
		}
	}
}