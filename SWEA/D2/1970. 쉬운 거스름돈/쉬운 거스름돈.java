import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] money = { 0, 1, 5, 10, 50, 100, 500, 1000, 5000 };
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine()) / 10;
			int[][] dp = new int[n+1][9]; // 1=10,2=50,3=100,4=500,5=1000,6=5000,7=10000,8=50000

			for (int i = 1; i <= n; i++) {
				int min = Integer.MAX_VALUE;
				for (int k = 1; k <=8; k++) {
					int m = money[k];
					if (i >= m) {
						if (dp[i - m][0] + 1 < min) {
							min = dp[i-m][0]+1;
							for (int j = 1; j <= 8; j++) {
								dp[i][j] = dp[i - m][j];
							}
							dp[i][k]++;
						}
					}
				}
				dp[i][0] = min;
			}
			System.out.println("#"+t);
			for(int i=8; i>=1; i--) {
				System.out.print(dp[n][i]+" ");
			}
			System.out.println();
		}
	}
}