import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        LinkedList<Integer>list = new LinkedList<>();
        list.add(0);
        for(int i=0; i<n; i++){
            list.add(i+1);
        }
        int idx = 0;
        for(int i=0; i<n; i++) {
            int nIdx = idx + k;
            while (nIdx > (list.size() - 1)) {
                nIdx -= (list.size() - 1);
            }
            sb.append(list.get(nIdx));
            if(i<n-1)
                sb.append(", ");
            else
                sb.append(">");
            list.remove(nIdx);
            idx = nIdx - 1;
        }

        System.out.println(sb);


    }
}