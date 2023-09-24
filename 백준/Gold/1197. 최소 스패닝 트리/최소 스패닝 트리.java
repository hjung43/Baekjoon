import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int[][]edges = new int [e][3];
		
		for(int i=0; i<e; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st1.nextToken());
			edges[i][1] = Integer.parseInt(st1.nextToken());
			edges[i][2] = Integer.parseInt(st1.nextToken());
		}
		
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		
		p = new int[v+1];
		
		for(int i=0; i<v+1; i++) {
			p[i] = i;
		}
		
		int ans = 0;
		int pick = 0;
		
		for(int i=0; i<e; i++) {
			int x = edges[i][0];
			int y = edges[i][1];
			
			if(findset(x) != findset(y)) {
				union(x,y);
				ans += edges[i][2];
				pick++;
			}
			if(pick == v-1) break;
		}
		System.out.println(ans);
	}
	static void union(int x, int y) {
		p[findset(y)] = findset(x);
	}
	static int findset(int x) {
		if(x != p[x]) {
			p[x] = findset(p[x]);
		}
		return p[x];
	}
}