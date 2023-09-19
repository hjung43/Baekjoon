import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n , cnt;
	static List<Integer>[]graph;
	static int[]visited;
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st1.nextToken());
		int m = Integer.parseInt(st1.nextToken());
		int r = Integer.parseInt(st1.nextToken());
		cnt = 1;
		graph = new ArrayList [n+1];
		visited = new int[n+1];
		
		for(int i=0; i<n+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st2.nextToken());
			int v = Integer.parseInt(st2.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		for(int i=0; i<n+1; i++) {
			Collections.sort(graph[i]);
		}
		dfs(r);
		for(int i=1; i<n+1; i++) {
			sb.append(visited[i]).append("\n");
		}
		System.out.println(sb);
		
    }
    
    public static void dfs(int v) {
    	visited[v] =cnt;
    	
    	for(int node : graph[v]) {
    		if(visited[node]==0) {
    			cnt++;
    			dfs(node);
    		}
    	}
    }
	
}