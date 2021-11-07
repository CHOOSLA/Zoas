package zoas_4.DataClass;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class ObjectToJson {
	public void userOb(){
		
		
	}
	public static void main(String[] args) {
		// PrettyPrinting 옵션을 추가하여 Gson 객체 생성
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				
				//user 객체 생성
				User user=new User();
				user.setID("oppsla");
				user.setPW("oppsla");
				
				// JsonObject를 Json 문자열로 변환
				String jsonStr = gson.toJson(user);
				jsonStr = gson.toJson(user);
				
				// 생성된 Json 문자열 출력
				System.out.println(jsonStr); 
	}
	
}
