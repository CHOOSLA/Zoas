package zoas_5.DataClass;
import java.util.*;

import com.google.gson.annotations.*;
public class User {
	private String username;	//���̵�	
	private String password;	//��й�ȣ
	private String key;	//������ �ִ� ����� Ű
	private String classid;	//�Է¹��� ���� ȸ�� ���̵�
	private ArrayList<String> classidList=new ArrayList<String>();	//������ ȸ�� ����Ʈ	
	private ArrayList<NoteInfo> noteList=new ArrayList<NoteInfo>();
	
    public String getusername() { return username; }
    public void setusername(String value) { this.username = value; }
    
    public String getpassword() { return password; }
    public void setpassword(String value) { this.password = value; }
    
    public String getclassid() { return classid; }
    public void setclassid(String value) { this.classid = value; }
    
    public String getkey() { return key; }
    public void setkey(String value) { this.key = value; }

    public ArrayList<String> getclassidList() { return classidList; }
    public void setclassidList(ArrayList<String> value) { this.classidList = value; }
    
    public ArrayList<NoteInfo> getNoteList() { return noteList; }
    public void setNoteList(ArrayList<NoteInfo> value) { this.noteList = value; }
	

}
 