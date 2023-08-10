import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int n = str.length();
		int[]nums = new int[n];
		for(int i=0; i<n; i++) {
			nums[i]= str.charAt(i)-'0';
		}
		for(int i=0; i<n-1; i++) {
			int mIdx = i;
			for(int j=i+1; j<n; j++) {
				if(nums[j]>nums[mIdx]) {
					mIdx = j;
				}
			}int tmp = nums[i];
			nums[i] = nums[mIdx];
			nums[mIdx] = tmp;
		}
	
		for(int i : nums )
			System.out.print(i);
	}
}