package zoas_4.DataClass;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



public class JsonConverter {
	//User user=new User();
	
	public static void createJsonData(User user) {
		// PrettyPrinting 옵션을 추가하여 Gson 객체 생성
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		// JsonObject를 Json 문자열로 변환
		String jsonStr = gson.toJson(user);

		
		System.out.println(jsonStr); 
		//보내기??
	}
	public static User parseJsonData(String json) {
		json = "{\r\n"
				+ "  \"id\": \"oppsla\",\r\n"
				+ "  \"pw\": \"oppslaoppsla\",\r\n"
				+ "  \"noteList\": [\r\n"
				+ "    {\r\n"
				+ "        \"name\":\"노트1\",\r\n"
				+ "        \"creatDate\":\"2021-10-26 오후 7시 38분\",\r\n"
				+ "        \"editDate\":\"2021-10-30 오전 2시 10분\",\r\n"
				+ "        \"recordText\":\"음성 기록\",\r\n"
				+ "        \"summaryTest\":\"요약 기록\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "        \"name\":\"노트2\",\r\n"
				+ "        \"creatDate\":\"2021-10-26 오후 7시 38분\",\r\n"
				+ "        \"editDate\":\"2021-10-30 오전 2시 10분\",\r\n"
				+ "        \"recordText\":\"음성 기록\",\r\n"
				+ "        \"summaryTest\":\"요약 기록\"\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
		
		

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

			 
		User user= gson.fromJson(json,User.class);
		return user;
	}
	
}
