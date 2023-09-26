import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<int []> q = new LinkedList<>();
		
//		Set<Integer>set = new HashSet<>();
		int[] visited = new int[100001];
		
		q.add(new int[] {n,0});
		visited[n] = 1;
		
		int cnt = 0;
		int time = 0;
		
		while(!q.isEmpty()) {
			int[] t = q.poll();
			
			if(t[0]==k) {
				if(cnt == 0) {
					time = t[1];
				}
				if(time == t[1]) {
					cnt++;
				}
			}
			if(t[0]+1<=100000 && (visited[t[0]+1]==0 || visited[t[0]+1] == t[1]+1)) {
				q.add(new int[] {t[0]+1,t[1]+1});
				visited[t[0]+1] = t[1]+1;
			}
			if(t[0]-1>=0 && (visited[t[0]-1]==0 || visited[t[0]-1] == t[1]+1)) {
				q.add(new int[] {t[0]-1,t[1]+1});
				visited[t[0]-1] = t[1]+1;
			}
			if(t[0]*2<=100000 && (visited[t[0]*2]==0 || visited[t[0]*2] == t[1]+1)) {
				q.add(new int[] {t[0]*2,t[1]+1});
				visited[t[0]*2] = t[1]+1;
			}
		}
		System.out.println(time);
		System.out.println(cnt);
	}
}