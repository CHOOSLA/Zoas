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
		 		+ "        \"name\":\"��Ʈ1\",\r\n"
		 		+ "        \"creatDate\":\"������¥\",\r\n"
		 		+ "        \"editDate\":\"������¥\",\r\n"
		 		+ "        \"recordText\":\"���� ���\",\r\n"
		 		+ "        \"summaryTest\":\"��� ���\"\r\n"
		 		+ "    },\r\n"
		 		+ "    {\r\n"
		 		+ "        \"name\":\"��Ʈ2\",\r\n"
		 		+ "        \"creatDate\":\"������¥\",\r\n"
		 		+ "        \"editDate\":\"������¥\",\r\n"
		 		+ "        \"recordText\":\"���� ���\",\r\n"
		 		+ "        \"summaryTest\":\"��� ���\"\r\n"
		 		+ "    }\r\n"
		 		+ "  ]\r\n"
		 		+ "}";

		 Gson gson = new GsonBuilder().setPrettyPrinting().create();

		 User user= gson.fromJson(json,User.class);
		 
		 System.out.println(user.getID());
		 System.out.println(user.getPW());
	}
}
