import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n ,m;
	static int[]arr;
	static int[]sel;
	static boolean[]visit;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		arr = new int[n];
		sel = new int[m];
		visit = new boolean[n];
		for(int i=0; i<n; i++) {
			arr[i] = i+1;
		}
		comb(0,0);
		System.out.println(sb);
	}
	//조합 (재귀 인덱스 바꾸기)
	public static void comb(int idx, int sidx) {
		if(sidx == m) {
			for(int i=0; i<m; i++) {
				sb.append(sel[i]+" ");
			}
			sb.append("\n");
			return;
		}
		if(idx==n) {
			return;
		}
		sel[sidx]=arr[idx];
		comb(idx,sidx+1);
		comb(idx+1, sidx);
	}
}