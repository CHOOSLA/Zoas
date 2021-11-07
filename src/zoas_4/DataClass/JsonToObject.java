package zoas_4.DataClass;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonToObject {
	public static void main(String[] args) {
		 String json = "{\r\n"
		 		+ "  \"id\": \"oppsla\",\r\n"
		 		+ "  \"pw\": \"oppslaoppsla\",\r\n"
		 		+ "  \"noteList\": [\r\n"
		 		+ "    {\r\n"
		 		+ "        \"name\":\"노트1\",\r\n"
		 		+ "        \"creatDate\":\"생성날짜\",\r\n"
		 		+ "        \"editDate\":\"수정날짜\",\r\n"
		 		+ "        \"recordText\":\"음성 기록\",\r\n"
		 		+ "        \"summaryTest\":\"요약 기록\"\r\n"
		 		+ "    },\r\n"
		 		+ "    {\r\n"
		 		+ "        \"name\":\"노트2\",\r\n"
		 		+ "        \"creatDate\":\"생성날짜\",\r\n"
		 		+ "        \"editDate\":\"수정날짜\",\r\n"
		 		+ "        \"recordText\":\"음성 기록\",\r\n"
		 		+ "        \"summaryTest\":\"요약 기록\"\r\n"
		 		+ "    }\r\n"
		 		+ "  ]\r\n"
		 		+ "}";

		 Gson gson = new GsonBuilder().setPrettyPrinting().create();

		 User user= gson.fromJson(json,User.class);
		 
		 System.out.println(user.getID());
		 System.out.println(user.getPW());
	}
}
