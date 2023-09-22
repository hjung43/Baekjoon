import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][]arr = new int[n][2];
			
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				arr[i][0] = Integer.parseInt(st1.nextToken()); //0에  x값 담기
			}
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				arr[i][1] = Integer.parseInt(st2.nextToken()); //1에 y값 담기
			}
			
			double e = Double.parseDouble(br.readLine());
			
			double[][]island = new double[n][n];
			
			for(int i=0; i<n; i++) {
				for(int j=i+1; j<n; j++) {
					island[i][j]=e*(Math.pow(arr[i][0]-arr[j][0], 2)+Math.pow(arr[i][1]-arr[j][1], 2));
					island[j][i]=e*(Math.pow(arr[i][0]-arr[j][0], 2)+Math.pow(arr[i][1]-arr[j][1], 2));
				}
			}
			
			
			boolean[]visited = new boolean[n];
			double[]dist = new double[n];
			
			for(int i=0; i<n; i++) {
				dist[i] = Double.MAX_VALUE;
			}
			
			dist[0]=0;
			double ans = 0;
			
			for(int i=0; i<n; i++) {
				double min = Double.MAX_VALUE;
				int idx = -1;
				
				for(int j=0; j<n; j++) {
					if(!visited[j] && dist[j]<min) {
						min = dist[j];
						idx = j;
					}
				}
				visited[idx] = true;
				ans += dist[idx];
				
				for(int j=0; j<n; j++) {
					if(!visited[j] && island[idx][j] !=0 && dist[j]>island[idx][j]) {
						dist[j] = island[idx][j];
					}
				}
			}
			System.out.println("#"+t+" "+Math.round(ans));
		}
	}
}