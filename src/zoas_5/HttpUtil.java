package zoas_5;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

import zoas_5.DataClass.JsonConverter;


public class HttpUtil {
	public static JsonConverter jsonConverter =new JsonConverter();
	
	public static  String postRequest(String strUrl,String jsonStr) {
		String responsestr="";	//응답 문자열
		try {
			URL url = new URL(strUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();	//url 객체에 대한 연결을 담당하는 URLConnection 객체 생성

			//요청 헤더 설정
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Allow","POST, OPTIONS");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Accept","application/json");	//**응답을 Json으로 받도록 설정
			connection.setRequestProperty("Vary","Accept");
			connection.setDoOutput(true);
			
			/*전송할 데이터 설정
			 * POST 요청을 할 때에는 OutputStream 객체로 데이터를 전송
			 * 1. 전송할 객체가 있다면 setDoOutput(true);
			 * 2. getOutputStream() 메소드를 통해 연결에 사용할 OutputStream 객체를 얻음
			 * 3. 전송할 데이터가 문자열일 경우는 OutputStream 클래스를 확장하는 DataOutputStream 클래스의 writebytes() 메소드를 활용
			 * ->생성자에 OutputStream 객체를 전달하여 생성 DataOutputStream(connection.getOutputStream());
			 * */
			DataOutputStream  outputStream  = new DataOutputStream(connection.getOutputStream());
			outputStream.writeBytes(jsonStr);
			outputStream.flush();
			outputStream.close();
            
            // 응답 코드 얻기
            int responseCode = connection.getResponseCode();
            System.out.println("responseCode::"+responseCode);

            /*응답 데이터 얻기
             * 1. getInputStream() 메소드를 통해 응답 데이터를 읽을 수 있는 InputStream객체를 얻음
             * 2. BufferedReader 객체를 이용하여 응답을 문자열로 받음 
             * */
            if (responseCode<300) {
                BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuffer stringBuffer = new StringBuffer();
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuffer.append(line);
                }
                bufferedReader.close(); 
                responsestr=stringBuffer.toString();              
                System.out.println("response::"+responsestr);  
            }
            else {	//응답코드가 정상이 아니면 Error! 리턴함
            	responsestr="Error!";
            }

		} catch (MalformedURLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responsestr;	
	}
	
	public static  int patchRequest(String strUrl,String jsonStr) throws URISyntaxException, IOException, InterruptedException {
		String responsestr="";	//응답 문자열
	
		URI uri = new URI(strUrl);
		HttpRequest request = HttpRequest.newBuilder(uri)
		          .header("Content-Type", "application/json")
		          .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOm51bGwsImlzcyI6IjEyMXVRWlVEU0JlRVU4UjBnZTZfb1EiLCJleHAiOjE2MzY4Njg4OTAsImlhdCI6MTYzNjI2NDA4OX0.6vPODXXpRvWsuq2pHzGUWC9SRB6Lk2hpY6MhfEvdnUM")
		          .method("PATCH", HttpRequest.BodyPublishers.ofString(jsonStr))
		          .build();
			
	
		HttpResponse response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.discarding());
		return response.statusCode();			
	}
			
}
