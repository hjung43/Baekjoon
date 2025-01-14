import java.io.*;
import java.lang.*;
import java.util.*;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer>answer = new ArrayList<>(); //정답 저장할 리스트
        
        StringTokenizer st = new StringTokenizer(today,"."); //오늘 날짜 String으로 받은거 int로 쪼개기
        int ty = Integer.parseInt(st.nextToken()); //오늘 년
        int tm = Integer.parseInt(st.nextToken()); //오늘 월
        int td = Integer.parseInt(st.nextToken()); //오늘 일
        
        Map<String, Integer> termMap = new HashMap<String,Integer>(); //terms배열 옮길 Map
        //terms 크기 만큼 반복해서 옮기기
        for(int i=0; i<terms.length; i++){
            st = new StringTokenizer(terms[i]);
            String termStr = st.nextToken();
            int termInt = Integer.parseInt(st.nextToken());
            termMap.put(termStr, termInt); //key를 약관종류이름, value를 유효기간으로 저장
        }
        //privacies 크기 만큼 반복해서 요효기간 지났는지 확인하기
        for(int i=0; i<privacies.length; i++){
            st = new StringTokenizer(privacies[i],". "); //String으로 돼있는 수집 일자 년,월,일 int로 바꾸기
            
            //수집일자
            int cy = Integer.parseInt(st.nextToken()); //년
            int cm = Integer.parseInt(st.nextToken()); //월
            int cd = Integer.parseInt(st.nextToken()); //일
            String term = st.nextToken(); //약관종류
            
            int pMonth = termMap.get(term); //약관종류에 맞는 유효기간
            //개인정보 별 유효기간 날짜
            int ny =0; //년
            int nm =0; //월
            int nd =0; //일
            
            //수집일자 월에 유효기간 더했을 때에 년, 월 변경값 찾기
            if((cm+pMonth)>12){ //수집일자 월에 유효기간 더한 값이 12를 넘는다면
                if((cm+pMonth)%12==0){ //수집일자+유효기간이 12의 배수라면(딱 n년뒤라면)
                    ny = cy+(pMonth/12); //년만 추가 수집일자+유효기간/12한 몫을 수집일자에 더하기
                    nm = 12;
                    // nm = 12; //유효기간 월은 12월로 바꾸기
                }else{ //12넘는데 12배수가 아니라면
                    ny = cy+(cm+pMonth)/12; //년엔 수집월+유효기간/12 몫 더해주기
                    nm = (cm+pMonth)%12; //월엔 수집월+유효기간 12로 나눈 나머지 넣기
                }
            }else{ //12를 넘지 않는다면
                ny = cy; //년은 수집일자 그대로
                nm = cm+pMonth; //월은 수집일자+유효기간
            }
            
            //유효기간은 수집일자의 일보다 1작기 때문에 유효기간 월,일 변경값 찾기
            if(cd-1 <1){ //수집일-1이 1보다 작으면
                nd = 28; //전달28일
                if(cm-1<1){ //근데 전달이 1월이었다면
                    nm=12; //월은 12월로 바꾸고
                    ny--; //년도 1년 빼주고
                }else{ //전달이 1월이 아니라면
                    nm--; //그냥 1달 빼주기
                }
            }else{ //수집일-1이 0보다 크다면
                nd=cd-1; //그냥 수집일에 1빼기
            }
            
            
            //유효기간과 오늘날짜 비교하기
            if(ty>ny){ //오늘년보다 유효기간 년이 더 작으면
                answer.add(i+1); //유효기간 지났으니까 리스트에 개인정보번호(인덱스+1) 저장
            }else if(ty==ny){ //오늘년이랑 유효기간 년이 같으면
                //월 비교
                if(tm>nm){ //오늘월 보다 유효기간 월이 더 작으면
                    answer.add(i+1); //유효기간 지났으니까 리스트에 인덱스+1 저장
                }else if(tm==nm){ //오늘월이랑 유효기간 월 같으면
                    //일 비교
                    if(td>nd){ //오늘일보다 유효기간 일 작으면
                        answer.add(i+1);//유효기간 지났으니까 리스트에 인덱스+1 저장
                    }//같거나 크면 유효기간 지난거 아니니까 continue
                }
            }
        }
        return answer;
    }
}