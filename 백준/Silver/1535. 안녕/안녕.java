import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] L = new int[n+1];
		int[] J = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());	
		for(int i=1; i<n+1; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<n+1; i++) {
			J[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[n+1][100];
		
		for(int i=1; i<n+1; i++) {
			//임시 채력
			for(int j=0; j<100; j++) {
				if(L[i]<=j) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-L[i]]+J[i]);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[n][99]);
	}
}