package zoas_5.DataClass;

import com.google.gson.annotations.Expose;

public class NoteInfo {
	private String class_id;	//class_id
    //private String creatDate;
    //private String editDate;
    private String stt;
    private String summary;
    private String keywords;
    private String timestamps;
    

    public String getclass_id() { return class_id; }
    public void setclass_id(String value) { this.class_id = value; }

//    public String getCreatDate() { return creatDate; }
//    public void setCreatDate(String value) { this.creatDate = value; }
//
//    public String getEditDate() { return editDate; }
//    public void setEditDate(String value) { this.editDate = value; }

    public String getstt() { return stt; }
    public void setstt(String value) { this.stt = value; }

    public String getsummary() { return summary; }
    public void setsummary(String value) { this.summary = value; }
    
    public String getkeywords() { return keywords; }
    public void setkeywords(String value) { this.keywords = value; }

    public String gettimestamps() { return timestamps; }
    public void settimestamps(String value) { this.timestamps = value; }

}
