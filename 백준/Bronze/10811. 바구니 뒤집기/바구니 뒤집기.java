import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] nums = new int[n];
		for(int i =0; i<n; i++) {
			nums[i] = i+1;
		}
		
		
		for(int a=0; a<m; a++) {
			int i = sc.nextInt()-1;
			int j = sc.nextInt()-1;
			int c = 0;
			int[] o = new int[j-i+1];
			for(int b=j; b>=i; b--) {
				o[c] = nums[b];
				c++;
			}
			for(int d=i,e=0; d<=j; d++,e++) {
				nums[d] = o[e];
			}
			
		} for(int i : nums)
			System.out.print(i+" ");
	}
}