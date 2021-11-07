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
		// PrettyPrinting �ɼ��� �߰��Ͽ� Gson ��ü ����
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		// JsonObject�� Json ���ڿ��� ��ȯ
		String jsonStr = gson.toJson(user);

		
		System.out.println(jsonStr); 
		//������??
	}
	public static User parseJsonData(String json) {
		json = "{\r\n"
				+ "  \"id\": \"oppsla\",\r\n"
				+ "  \"pw\": \"oppslaoppsla\",\r\n"
				+ "  \"noteList\": [\r\n"
				+ "    {\r\n"
				+ "        \"name\":\"��Ʈ1\",\r\n"
				+ "        \"creatDate\":\"2021-10-26 ���� 7�� 38��\",\r\n"
				+ "        \"editDate\":\"2021-10-30 ���� 2�� 10��\",\r\n"
				+ "        \"recordText\":\"���� ���\",\r\n"
				+ "        \"summaryTest\":\"��� ���\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "        \"name\":\"��Ʈ2\",\r\n"
				+ "        \"creatDate\":\"2021-10-26 ���� 7�� 38��\",\r\n"
				+ "        \"editDate\":\"2021-10-30 ���� 2�� 10��\",\r\n"
				+ "        \"recordText\":\"���� ���\",\r\n"
				+ "        \"summaryTest\":\"��� ���\"\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
		
		

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

			 
		User user= gson.fromJson(json,User.class);
		return user;
	}
	
}
