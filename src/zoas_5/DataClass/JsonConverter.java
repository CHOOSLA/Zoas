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

	//로그인 요청을 위한 JSON 문자열 생성
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
	
	//회원가입 요청을 위한 JSON 문자열 생성
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
	
	//줌 연결 요청문
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
		
	//participation 참여한 강의 아이디? 요청문
	public static String particiJsonstr(User user) {
		JsonObject jsonObject = new JsonObject ();
		System.out.println(user.getusername());
		jsonObject.addProperty("username",user.getusername() );	//아이디 보냄
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonStr = gson.toJson(jsonObject);
		return jsonStr;
	}
	
	//stt 파일 요청문 생성
	public static String SttviewJsonstr(User user) {
		JsonObject jsonObject = new JsonObject ();
		jsonObject.addProperty("Class id", "");	//클래스 아이디 미정
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonStr = gson.toJson(jsonObject);
		return jsonStr;
	}
	
	//summary 파일 요청문 생성
	public static String SummaryviewJsonstr(User user) {
		JsonObject jsonObject = new JsonObject ();
		jsonObject.addProperty("Class id", "");	//클래스 아이디 미정
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonStr = gson.toJson(jsonObject);
		return jsonStr;
	}
	
	//오브젝트->JSON
	public static void ObjectToJson(User user) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		//Object를 Json 문자열로 변환
		String jsonStr = gson.toJson(user);

		
		//System.out.println(jsonStr); 
	
	}
	
	//JSON->오브젝트
	public static User parseJsonData(String json) {
		json = "{\r\n"
				+ "  \"username\": \"oppsla\",\r\n"
				+ "  \"email\": \"\",\r\n"
				+ "  \"password\": \"oppslaoppsla\",\r\n"
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
	
	//??
	public static JsonObject JsonStringParse(String jsonstr){
		// 문자열 parsing
		JsonElement element = JsonParser.parseString(jsonstr);
		// element가 Object 타입인 경우 JsonObject 타입으로 변환
		JsonObject object = element.getAsJsonObject();
		
		//object 리턴받아서 object.getAsJsonObject().get("key").getAsString() 이런식으로 사용
		return object;
	}	
}