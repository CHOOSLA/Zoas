package zoas_5.DataClass;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class stringTokenize {
	public void main(String str,ArrayList<String> tokenlist,String delim) {
        StringTokenizer st = new StringTokenizer(str, delim); // '\n'는 구분문자
 
        int count = st.countTokens(); // 구분 문자로 구분된 문자열(토큰)의 개수를 count
     
        for (int i = 0; i < count; i++) {
            String token = st.nextToken(); // 각 토큰 출력
            tokenlist.add(token);
        }
    }

}
