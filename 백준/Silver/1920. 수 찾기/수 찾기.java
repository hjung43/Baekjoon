import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[]nums = new int [n];
		for(int i=0; i<n; i++) {
			nums[i]=sc.nextInt();
		}
		Arrays.sort(nums);
		int m =sc.nextInt();
		for(int i=0; i<m; i++) {
			int find=sc.nextInt();
			int result = 0;
			int st = 0;
			int ed = nums.length-1;
			while(st<=ed) {
				int mid = (st+ed)/2;
				if(find==nums[mid]) {
					result++;
					System.out.println(result);
					break;
				} else if(find>nums[mid])
					st = mid+1;
				else
					ed = mid-1;
			}
			if(result == 0)
				System.out.println(result);
		}
	}
}