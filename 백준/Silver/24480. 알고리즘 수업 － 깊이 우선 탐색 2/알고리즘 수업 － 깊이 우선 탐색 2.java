import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, cnt;
	static List<Integer>[]arr;
	static int[]visited;
	

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st1.nextToken()); 
		m = Integer.parseInt(st1.nextToken()); 
		int r = Integer.parseInt(st1.nextToken()); 
		arr = new ArrayList[n+1];
		visited=new int[n+1];
		cnt = 1;
		
		for(int i=0; i<n+1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			arr[u].add(v);
			arr[v].add(u);
			
		}
		for(int i=0; i<n+1; i++) {
			Collections.sort(arr[i],Collections.reverseOrder());
		}
		
		
		dfs(r);
		for(int i=1; i<n+1; i++) {
			sb.append(visited[i]).append("\n");
		}
		System.out.println(sb);
		
	}
	public static void dfs(int v) {
		visited[v] = cnt;
		
		for(int node : arr[v]) {
			if(visited[node]==0) {
				cnt++;
				dfs(node);
			}
		}
	}


}