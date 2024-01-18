import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] money = new int[n+1];
		int[] dp = new int [n+1];
		
		
		for(int i=1; i<n+1; i++) {
			int min = Integer.MAX_VALUE;
			
			if(i>=2) {
				if(money[i-2]+2==i && dp[i-2]+1<min) {
					min = dp[i-2]+1;
					money[i]=i;
				}
			}
			if(i>=5) {
				if(money[i-5]+5==i && dp[i-5]+1<min) {
					min = dp[i-5]+1;
					money[i]=i;
				}
			}
			dp[i] = min;
		}
		if(dp[n]==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {	
			System.out.println(dp[n]);
		}
		
	}
}