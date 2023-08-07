import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		
		for(int t=0; t<10; t++) {
			
			int result = 0;
			int n = sc.nextInt();
			int[]nums = new int[n];
			for(int i=0; i<n; i++) {
				nums[i] = sc.nextInt();
			}
			for(int i=2; i<n-2; i++) {
				int h = 255;
				for(int j=i-2; j<=i+2; j++) {
					if(j==i)
						continue;
					else if (nums[i]-nums[j]<0) {
						h=0;
						break;
					}else if(nums[i]-nums[j]<h) {
						h = nums[i]-nums[j];
					}
				} result += h;
			}System.out.printf("#%d %d\n",(t+1),result);
		}
	}
}