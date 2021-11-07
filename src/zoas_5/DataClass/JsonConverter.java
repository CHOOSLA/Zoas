package zoas_5.DataClass;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import zoas_5.Zoas;
import zoas_5.DataClass.User;


public class JsonConverter {

	//�α��� ��û�� ���� JSON ���ڿ� ����
	public static String loginJsonstr(User user) {
		JsonObject jsonObject = new JsonObject ();
		jsonObject.addProperty("username", user.getusername());
		//jsonObject.addProperty("email", user.getemail());
		jsonObject.addProperty("password", user.getpassword());
	
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonStr = gson.toJson(jsonObject);
		System.out.println(jsonStr);
		return jsonStr; 
	}
	
	//ȸ������ ��û�� ���� JSON ���ڿ� ����
	public static String signupJsonstr(User user) {
		JsonObject jsonObject = new JsonObject ();
		jsonObject.addProperty("username", user.getusername());
		jsonObject.addProperty("password1", user.getpassword());
		jsonObject.addProperty("password2", user.getpassword());
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonStr = gson.toJson(jsonObject);
		System.out.println(jsonStr);
		return jsonStr; 
	}
	
	//�� ���� ��û��
	public static String zoomliveJsonStr(String classid,String streamUrl, String pageUrl) {
		JsonObject jsonObject = new JsonObject ();
		jsonObject.addProperty("stream_url", streamUrl);
		jsonObject.addProperty("stream_key", classid);
		jsonObject.addProperty("page_url", pageUrl);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonStr = gson.toJson(jsonObject);
		return jsonStr;
	}
	public static String zoomlivestatusJsonStr() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		JsonObject jsonObject = new JsonObject ();
		JsonObject settingObject = new JsonObject ();
		settingObject.addProperty("active_speaker_name","false");
		settingObject.addProperty("display_name","inc");
		
		jsonObject.addProperty("action", "start");
		jsonObject.add("settings",settingObject);
		
		String jsonStr = gson.toJson(jsonObject);
		return jsonStr;
	}
		
	//participation ������ ���� ���̵�? ��û��
	public static String particiJsonstr(User user) {
		JsonObject jsonObject = new JsonObject ();
		System.out.println(user.getusername());
		jsonObject.addProperty("username",user.getusername() );	//���̵� ����
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonStr = gson.toJson(jsonObject);
		return jsonStr;
	}
	
	//stt ���� ��û�� ����
	public static String SttviewJsonstr(User user) {
		JsonObject jsonObject = new JsonObject ();
		jsonObject.addProperty("Class id", "");	//Ŭ���� ���̵� ����
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonStr = gson.toJson(jsonObject);
		return jsonStr;
	}
	
	//summary ���� ��û�� ����
	public static String SummaryviewJsonstr(User user) {
		JsonObject jsonObject = new JsonObject ();
		jsonObject.addProperty("Class id", "");	//Ŭ���� ���̵� ����
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonStr = gson.toJson(jsonObject);
		return jsonStr;
	}
	
	//������Ʈ->JSON
	public static void ObjectToJson(User user) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		//Object�� Json ���ڿ��� ��ȯ
		String jsonStr = gson.toJson(user);

		
		//System.out.println(jsonStr); 
	
	}
	
	//JSON->������Ʈ
	public static User parseJsonData(String json) {
		json = "{\r\n"
				+ "  \"username\": \"oppsla\",\r\n"
				+ "  \"email\": \"\",\r\n"
				+ "  \"password\": \"oppslaoppsla\",\r\n"
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
	
	//??
	public static JsonObject JsonStringParse(String jsonstr){
		// ���ڿ� parsing
		JsonElement element = JsonParser.parseString(jsonstr);
		// element�� Object Ÿ���� ��� JsonObject Ÿ������ ��ȯ
		JsonObject object = element.getAsJsonObject();
		
		//object ���Ϲ޾Ƽ� object.getAsJsonObject().get("key").getAsString() �̷������� ���
		return object;
	}	
}