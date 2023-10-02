import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[]weight = new int[n+1];
		int[]cost = new int[n+1];
		
		int[][]result = new int[n+1][k+1];
		
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=k; j++) {
				if(weight[i]<=j) {
					result[i][j] = Math.max(result[i-1][j], result[i-1][j-weight[i]]+cost[i]);
				}else {
					result[i][j] = result[i-1][j];
				}
			}
		}
		
		System.out.println(result[n][k]);
		
		
	}
}