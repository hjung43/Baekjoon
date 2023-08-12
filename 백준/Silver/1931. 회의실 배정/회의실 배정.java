import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] time = new int[n][2];
		for(int i=0; i<n; i++) {
			time[i][0] = sc.nextInt();
			time[i][1] = sc.nextInt();
		}
		
		Arrays.sort(time, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1])
					return o1[0]- o2[0];
				return o1[1]-o2[1];
			}
		});	
		
//		int[]sTime = new int[n];
//		int[]eTime = new int[n];
//		for(int i=0, j=0; i<n; i++,j++) {
//			sTime[i] = sc.nextInt();
//			eTime[j] = sc.nextInt();
//		}

//		for(int i=0; i<n-1; i++) {
//			for(int j=i+1; j<n; j++){
//				if(eTime[i]>eTime[j] ) {
//					int tmp1 = eTime[i];
//					eTime[i] = eTime[j];
//					eTime[j] = tmp1;
//					
//					int tmp2 = sTime[i];
//					sTime[i] = sTime[j];
//					sTime[j] = tmp2;
//				}
//			}
//			
//		}
		int cnt = 0;
		int ed = -1;
		for(int i = 0; i<n; i++) {
			if(time[i][0] >= ed) {
				ed = time[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}