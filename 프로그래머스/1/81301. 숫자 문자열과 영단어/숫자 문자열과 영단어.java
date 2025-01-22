import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int solution(String s) {

        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            char nWord = s.charAt(i);
            if(nWord == 'z'){
                sb.append(0);
                i += 3;
            }else if(nWord == 'o'){
                sb.append(1);
                i += 2;
            }else if(nWord == 't' && s.charAt(i+1)=='w'){
                sb.append(2);
                i += 2;
            }else if(nWord == 't'){
                sb.append(3);
                i += 4;
            }else if(nWord == 'f' && s.charAt(i+1) == 'o'){
                sb.append(4);
                i += 3;
            }else if(nWord == 'f'){
                sb.append(5);
                i += 3;
            }else if(nWord == 's' && s.charAt(i+1) == 'i'){
                sb.append(6);
                i += 2;
            }else if(nWord == 's'){
                sb.append(7);
                i += 4;
            }else if(nWord == 'e'){
                sb.append(8);
                i += 4;
            }else if(nWord == 'n'){
                sb.append(9);
                i += 3;
            }else{
                sb.append(nWord);
            }
        }
        String answerStr = sb.toString();
        int answer = Integer.parseInt(answerStr);
        
        return answer;
    }
}