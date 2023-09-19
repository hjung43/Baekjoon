import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, cnt;
	static List<Integer>[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st1.nextToken());
		m = Integer.parseInt(st1.nextToken());
		arr = new ArrayList[n+1];
		visited = new boolean[n+1];
		cnt = 0;
		for(int i=0; i<n+1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st2.nextToken());
			int v = Integer.parseInt(st2.nextToken());
			
			arr[u].add(v);
			arr[v].add(u);
		}
		for(int i=1; i<n+1; i++) {
			if(!visited[i]) {
				cnt++;
				dfs(i);
			}
		}
		System.out.println(cnt);
		
		
		
	}
	public static void dfs(int v) {
		visited[v] = true;
		for(int node : arr[v]) {
			if(!visited[node]) {
				dfs(node);
			}
		}
	}

}