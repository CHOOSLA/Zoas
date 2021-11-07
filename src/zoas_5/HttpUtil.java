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
		String responsestr="";	//���� ���ڿ�
		try {
			URL url = new URL(strUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();	//url ��ü�� ���� ������ ����ϴ� URLConnection ��ü ����

			//��û ��� ����
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Allow","POST, OPTIONS");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Accept","application/json");	//**������ Json���� �޵��� ����
			connection.setRequestProperty("Vary","Accept");
			connection.setDoOutput(true);
			
			/*������ ������ ����
			 * POST ��û�� �� ������ OutputStream ��ü�� �����͸� ����
			 * 1. ������ ��ü�� �ִٸ� setDoOutput(true);
			 * 2. getOutputStream() �޼ҵ带 ���� ���ῡ ����� OutputStream ��ü�� ����
			 * 3. ������ �����Ͱ� ���ڿ��� ���� OutputStream Ŭ������ Ȯ���ϴ� DataOutputStream Ŭ������ writebytes() �޼ҵ带 Ȱ��
			 * ->�����ڿ� OutputStream ��ü�� �����Ͽ� ���� DataOutputStream(connection.getOutputStream());
			 * */
			DataOutputStream  outputStream  = new DataOutputStream(connection.getOutputStream());
			outputStream.writeBytes(jsonStr);
			outputStream.flush();
			outputStream.close();
            
            // ���� �ڵ� ���
            int responseCode = connection.getResponseCode();
            System.out.println("responseCode::"+responseCode);

            /*���� ������ ���
             * 1. getInputStream() �޼ҵ带 ���� ���� �����͸� ���� �� �ִ� InputStream��ü�� ����
             * 2. BufferedReader ��ü�� �̿��Ͽ� ������ ���ڿ��� ���� 
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
            else {	//�����ڵ尡 ������ �ƴϸ� Error! ������
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
		String responsestr="";	//���� ���ڿ�
	
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
