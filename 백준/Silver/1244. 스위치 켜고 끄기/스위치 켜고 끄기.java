import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //스위치 개수
		int[] s = new int[n];
		for(int i=0; i<n; i++) {
			s[i] = sc.nextInt();
		}
		int student = sc.nextInt();
		for(int i=0; i<student; i++) {
			int g = sc.nextInt();
			int num = sc.nextInt();
			if(g==1) {
				for(int j =1; j<=n; j++) {
					if(j%num==0 && s[j-1]==1) {
						s[j-1] = 0;
					}else if(j%num==0 && s[j-1]==0)
						s[j-1]=1;
				}
			}else{
				int j = num-1;
				if(s[j]==0) {
					s[j] =1;
				}else if(s[j]==1)
					s[j] = 0;
				int k = 1;
				while(j+k<n && j-k>=0 && s[j+k]==s[j-k]) {
					if(s[j+k]==0) {
						s[j+k] = s[j-k] = 1;
					}else
						s[j+k] = s[j-k] = 0;
					k++;
				}
			}
		}
		for(int i=0; i<n; i++) {
			if(i%20==0 && i!=0) {
				System.out.println();
				System.out.print(s[i]+" ");
			}else
				System.out.print(s[i]+" ");
		}
	}
}