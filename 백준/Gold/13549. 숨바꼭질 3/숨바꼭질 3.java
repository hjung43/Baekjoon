import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<int []> q = new LinkedList<>();
		
		int[] visited = new int[100001];
		
		q.add(new int[] {n,0});
		visited[n] = 1;
		int newN = n*2;
		
		while(newN!=0 && newN<=100000) {
			q.add(new int[] {newN,0});
			visited[newN] = 0;
			newN *= 2;
		}
		
//		int cnt = 0;
//		int time = 0;
		
		while(!q.isEmpty()) {
			int[] t = q.poll();
			
			if(t[0]==k) {
				System.out.println(t[1]);
				break;
			}
			if(t[0]+1<=100000 && (visited[t[0]+1]==0 || visited[t[0]+1] == t[1]+1)) {
				q.add(new int[] {t[0]+1,t[1]+1});
				visited[t[0]+1] = t[1]+1;
				int nowN = (t[0]+1) * 2;
				int nowT = t[1]+1;
				while(nowN!=0 && nowN<=100000) {
					q.add(new int[] {nowN,nowT});
					visited[nowN] = nowT;
					nowN *= 2;
				}
			}
			if(t[0]-1>=0 && (visited[t[0]-1]==0 || visited[t[0]-1] == t[1]+1)) {
				q.add(new int[] {t[0]-1,t[1]+1});
				visited[t[0]-1] = t[1]+1;
				int nowN = (t[0]-1) * 2;
				int nowT = t[1]+1;
				while(nowN!=0 && nowN<=100000) {
					q.add(new int[] {nowN,nowT});
					visited[nowN] = nowT;
					nowN *= 2;
				}
			}
		}
//		System.out.println(time);
//		System.out.println(cnt);
	}
}