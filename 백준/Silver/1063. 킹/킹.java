import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		String kL = st.nextToken();
		int kX = kL.charAt(0);
		int kY = kL.charAt(1)-'0';
		String rL = st.nextToken();
		int rX = rL.charAt(0);
		int rY = rL.charAt(1)-'0';
		int n = Integer.parseInt(st.nextToken());
		for(int i=0; i<n; i++) {
			String move = br.readLine();
			switch (move) {
			case "R": {
				if(kX+1<'I') {
					if(rX==kX+1 && rY==kY && rX+1<'I') {
						rX++;
						kX++;
					}else if(rX!=kX+1 || rY!=kY) {
						kX++;
					}
				}
				break;
			}case "L": {
				if(kX-1>='A') {
					if(rX==kX-1 && rY==kY && rX-1>='A') {
						rX--;
						kX--;
					}else if(rX!=kX-1 || rY!=kY) {
						kX--;
					}
				}
				break;
			}case "B": {
				if(kY-1>0) {
					if(rY==kY-1 && rX==kX && rY-1>0) {
						rY--;
						kY--;
					}else if(rY!=kY-1 || rX!=kX) {
						kY--;
					}
				}
				break;
			}case "T": {
				if(kY+1<9) {
					if(rY==kY+1 && rX==kX && rY+1<9) {
						rY++;
						kY++;
					}else if(rY!=kY+1 || rX!=kX) {
						kY++;
					}
				}
				break;
			}case "RT": {
				if(kX+1<'I' && kY+1<9) {
					if(rX==kX+1 && rY==kY+1 && rX+1<'I' && rY+1<9) {
						rX++;
						rY++;
						kY++;
						kX++;
					}else if(rX!=kX+1 || rY!=kY+1 ) {
						kX++;
						kY++;
					}
				}
				break;
			}case "LT": {
				if(kX-1>='A' && kY+1<9) {
					if(rX==kX-1 && rY==kY+1 && rX-1>='A' && rY+1<9) {
						rX--;
						kX--;
						rY++;
						kY++;
					}else if(rX!=kX-1 || rY!=kY+1) {
						kX--;
						kY++;
					}
				}
				break;
			}case "RB": {
				if(kX+1<'I' && kY-1>0) {
					if(rX==kX+1 && rY==kY-1 && rX+1<'I' && rY-1>0) {
						rX++;
						kX++;
						rY--;
						kY--;
					}else if(rX!=kX+1 || rY!=kY-1  ) {
						kX++;
						kY--;
					}
				}
				break;
			}case "LB": {
				if(kX-1>='A' && kY-1>0) {
					if(rX==kX-1 && rY==kY-1 && rX-1>='A' && rY-1>0) {
						rX--;
						kX--;
						rY--;
						kY--;
					}else if(rX!=kX-1 || rY!=kY-1  ) {
						kX--;
						kY--;
					}
				}
				break;
			}
			}
		}
		System.out.println((char)kX+""+kY);
		System.out.println((char)rX+""+rY);
	}
}