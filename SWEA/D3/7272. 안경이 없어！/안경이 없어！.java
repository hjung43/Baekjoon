import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			String str1 = sc.next();
			String str2 = sc.next();
			
			if(str1.length() != str2.length()) {
				System.out.println("#"+t+" DIFF");
				continue;
			}
			
			String result = "SAME";
			for(int i=0; i<str1.length(); i++) {
				char c1 = str1.charAt(i);
				char c2 = str2.charAt(i);
				if(c1=='B') {
					if(c2 != 'B') {
						result = "DIFF";
						break;
					}else
						continue;
				}else if(c1 == 'A' || c1=='D' || c1 == 'O' || c1 == 'P'|| c1 == 'Q' || c1=='R') {
					if(c2 != 'A' && c2 !='D' && c2 != 'O' && c2 != 'P' && c2 != 'Q' && c2!='R') {
						result = "DIFF";
						break;
					}else
						continue;
				}else {
					if(c2 == 'B'|| c2 == 'A' || c2=='D' || c2 == 'O' || c2 == 'P'|| c2 == 'Q' || c2=='R') {
					result = "DIFF";
					break;
					}else
						continue;
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}
}


