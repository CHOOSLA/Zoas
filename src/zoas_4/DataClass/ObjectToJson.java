package zoas_4.DataClass;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class ObjectToJson {
	public void userOb(){
		
		
	}
	public static void main(String[] args) {
		// PrettyPrinting �ɼ��� �߰��Ͽ� Gson ��ü ����
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				
				//user ��ü ����
				User user=new User();
				user.setID("oppsla");
				user.setPW("oppsla");
				
				// JsonObject�� Json ���ڿ��� ��ȯ
				String jsonStr = gson.toJson(user);
				jsonStr = gson.toJson(user);
				
				// ������ Json ���ڿ� ���
				System.out.println(jsonStr); 
	}
	
}
