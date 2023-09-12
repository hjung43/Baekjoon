
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static int[]arr;
	static int[]sel;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		while(!str.equals("0")) {
			StringTokenizer st = new StringTokenizer(str);
			k = Integer.parseInt(st.nextToken());
			arr = new int[k];
			sel = new int[6];
			for(int i=0; i<k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(0,0);
			System.out.println();
			str = br.readLine();
			}
		}


	//k개에서 6개 뽑는 조합
	public static void comb(int idx, int sidx) {
		if(sidx == 6) {
			for(int i=0; i<6; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		if(idx == arr.length) {
			return;
		}
		
		sel[sidx]=arr[idx];
		comb(idx+1, sidx+1);
		comb(idx+1,sidx);
		
	}

}
