import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, cnt;
	static List<Integer>[]com;
	static boolean[]visited;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); //컴퓨터 수 (노드수)
		m = Integer.parseInt(br.readLine()); //네트워크 연결 수(간선수)
		com = new ArrayList[n+1];
		visited=new boolean[n+1];
		cnt = 0;
		
		for(int i=0; i<n+1; i++) {
			com[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			com[u].add(v);
			com[v].add(u);
			
		}
		dfs(1);
		System.out.println(cnt);
		
	}
	public static void dfs(int v) {
		visited[v] = true;
		
		for(int node : com[v]) {
			if(!visited[node]) {
				cnt++;
				dfs(node);
			}
		}
	}


}