package zoas_5.DataClass;
import java.util.*;

import com.google.gson.annotations.*;
public class User {
	private String username;	//아이디	
	private String password;	//비밀번호
	private String key;	//서버가 주는 사용자 키
	private String classid;	//입력받은 현재 회의 아이디
	private String noteclassid;	//선택한 노트 회의 아이디
	private ArrayList<String> classidList=new ArrayList<String>();	//참여한 회의 리스트	
	private ArrayList<NoteInfo> noteList=new ArrayList<NoteInfo>();
	
    public String getusername() { return username; }
    public void setusername(String value) { this.username = value; }
    
    public String getpassword() { return password; }
    public void setpassword(String value) { this.password = value; }
    
    public String getnoteclassid() { return classid; }
    public void setnoteclassid(String value) { this.classid = value; }
    
    public String getclassid() { return noteclassid; }
    public void setclassid(String value) { this.noteclassid = value; }
    
    public String getkey() { return key; }
    public void setkey(String value) { this.key = value; }

    public ArrayList<String> getclassidList() { return classidList; }
    public void setclassidList(ArrayList<String> value) { this.classidList = value; }
    
    public ArrayList<NoteInfo> getNoteList() { return noteList; }
    public void setNoteList(ArrayList<NoteInfo> value) { this.noteList = value; }
	

}
 