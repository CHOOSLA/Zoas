package zoas_4.DataClass;
import java.util.*;
public class User {
	private String id;
	private String pw;
	private ArrayList<NoteInfo> noteList=new ArrayList<NoteInfo>();
	
	public String getID() { return id; }
    public void setID(String value) { this.id = value; }

    public String getPW() { return pw; }
    public void setPW(String value) { this.pw = value; }

    public ArrayList<NoteInfo> getNoteList() { return noteList; }
    public void setNoteList(ArrayList<NoteInfo> value) { this.noteList = value; }

}
 